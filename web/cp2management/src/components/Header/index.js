import './header.css';
import avatar from '../../assets/avatar.jpeg';

import { Link } from 'react-router-dom';
import {FiUser} from "react-icons/fi";
import { DiCodeBadge } from "react-icons/di";
import { AiOutlineTeam } from "react-icons/ai"


export default function Header(){

  return(
    <div className="sidebar">
      <div>
        <img src={avatar} alt="Foto avatar" />
      </div>

      <Link to="/dashboard">
        <DiCodeBadge color="#FFF" size={24} />
        Projetos
      </Link>

      <Link to="/members">
        <FiUser color="#FFF" size={24} />
        Membros 
      </Link>    
      
      <Link to="/clientes">
        <FiUser color="#FFF" size={24} />
        Clientes
      </Link>

      <Link to="/nucleos">
        <AiOutlineTeam color="#FFF" size={24} />
        Nucleos
      </Link>             
    </div>
  )
}