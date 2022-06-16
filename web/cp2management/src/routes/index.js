import { Switch } from 'react-router-dom';
import Route from './Route';
import Dashboard from '../pages/Dashboard';
import Members from '../pages/Members';
import Customers from '../pages/Customers';
import Cores from '../pages/Cores';
import NewProject from '../pages/NewProject';

export default function Routes(){
  return(
    <Switch>
      <Route exact path="/" component={Dashboard} />

      <Route exact path="/dashboard" component={Dashboard} />
      <Route exact path="/members" component={Members} />
      <Route exact path="/clientes" component={Customers} />
      <Route exact path="/nucleos" component={Cores} />
      <Route exact path="/novo-projeto" component={NewProject} />
    </Switch>
  )
}