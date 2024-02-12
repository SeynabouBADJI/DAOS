import React from 'react';
import { AppBar, Toolbar, Typography } from '@mui/material';
import UE from './maquette/UE';
import ECListe from './maquette/EC/ECListe';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Modules from './maquette/Module/Modules';

function App() {
  return (
    <Router>
      <div className="AppContainer">
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6">Bienvenue ! </Typography>
          </Toolbar>
        </AppBar>

        <Switch>
          <Route path="/ec-liste" component={ECListe} />
          <Route path="/modules" component={Modules} />

          <Route path="/" component={UE} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
