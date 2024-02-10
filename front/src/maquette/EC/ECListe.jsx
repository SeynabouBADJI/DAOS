import React,{useState, useEffect} from "react";
import { DataGrid } from "@mui/x-data-grid";
import AjouterEC from "./AjouterEC";
import { Stack } from "@mui/material";
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import Snackbar from '@mui/material/Snackbar';
import ModifierEC from "./ModifierEC";
function ECListe(){
    const [ecListe, setEcListe] = useState([])
    const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);

    useEffect(() => {
        fetch("http://localhost:8084/maquette/ec")
          .then(response => response.json())
          .then(data => setEcListe(data));
      }, []);

      const updateEC = (ecListe, link) => {
        fetch( link, {
          method :"PUT",
          headers : {"content-Type" : "application/json"},
          body : JSON.stringify(ecListe),
        })
        .then(response => {
          if (response.ok) {
            fetchEC();
          } else {
            alert("Quelque chose ne va pas");
          }
        })
        .catch(err => console.error(err));
      }

      const onDelClick = id => {
        if (window.confirm("Êtes-vous sûr de supprimer?")) {
          const url = `http://localhost:8084/maquette/ec/${id}`;
          fetch(url, { method: "DELETE" })
            .then(response => {
              if (response.ok) {
                fetch("http://localhost:8084/maquette/ec")
                  .then(response => response.json())
                  .then(data => setEcListe(data))
                  .catch(err => console.error(err));
                setDeleteSnackbarOpen(true);
              } else {
                console.error("La suppression a échoué.");
              }
            })
          .catch(err => console.error(err));
        }
      };
    
    const columns = [
      { field: 'libelle', headerName: 'Libellé', flex: 1},
      { field: 'code', headerName: 'code', flex: 1},
      { field: 'cm', headerName: 'cm', flex: 1},
      { field: 'td', headerName: 'td', flex: 1},
      { field: 'tp', headerName: 'tp', flex: 1},
      { field: 'tpe', headerName: 'tpe', flex: 1},
      { field: 'coefficient', headerName: 'coefficient', flex: 1},
      { field: 'description', headerName: 'description', flex: 1},
      {
        field : "_links.ue.href",
          headerName : "Modifier",
          renderCell : row => (
            <IconButton
              variant="contained"
              color="primary"
              onClick={() => <ModifierEC data={row} updateEC={updateEC} />}
            > 
            <EditIcon/>
            </IconButton>
          )
      }, 
      {
        field : "_links.self.href",
          headerName : "supprimer",
          renderCell : row => (
            <IconButton
              onClick={() => onDelClick(row.id)}
              variant="contained"
            >
            <DeleteIcon color="error"/>
            </IconButton>
          )
      },
    ]
    const fetchEC = () => {
      fetch("http://localhost:8084/maquette/ec")
        .then(response => response.json())
        .then(data => setEcListe(data))
        .catch(err => console.error(err));
    } 
    const ajouterEC = ecListe => {
      fetch("http://localhost:8084/maquette/ec", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(ecListe),
      })
      .then(response => {
        if (response.ok) {
          fetchEC();
        } else {
            alert("Quelque chose ne va pas");
        }
      })
      .catch(err => console.error(err));
    }
    
    return (
      <>
        <Stack mt={2} mb={2}>
          <AjouterEC ajouterEC={ajouterEC} />
        </Stack>
        <div style={{ height: 600, width: '100%' }}>
          <DataGrid
            rows={ecListe}
            columns={columns}
            pageSize={5}
            disableRowSelectionOnClick={true}
          />
          <Snackbar
            open={deleteSnackbarOpen}
            autoHideDuration={3000}
            onClose={() => setDeleteSnackbarOpen(false)}
            message="UE Supprimer"
          />
       
        </div>
      </>
    )
}
export default ECListe;