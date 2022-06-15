import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter } from 'react-router-dom';
import Routes from './routes';
import { ToastContainer } from 'react-toastify';

function App() {
  return (
      <BrowserRouter>
        <ToastContainer autoClose={3000} />
        <Routes/>
      </BrowserRouter>
  );
}

export default App;
