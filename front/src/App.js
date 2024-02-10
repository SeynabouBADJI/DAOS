import React from 'react';
import { AppBar, Toolbar, Typography } from '@mui/material';
import UE from './maquette/UE';
import ECListe from './maquette/EC/ECListe';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6">La Liste Des UE</Typography>
          </Toolbar>
        </AppBar>

        <Switch>
          <Route path="/ec-liste" component={ECListe} />
          <Route path="/" component={UE} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
