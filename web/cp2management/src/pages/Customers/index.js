import '../Dashboard/dashboard.css';

import { useContext, useState, useEffect } from 'react';

import Header from '../../components/Header';
import Title from '../../components/Title';
import { FiEdit2, FiMessageSquare, FiPlus, FiSearch } from 'react-icons/fi';
import { DiCodeBadge } from "react-icons/di";

import getData from '../../services/api/get';

import { Link } from 'react-router-dom';

import Modal from '../../components/Modal';


export default function Customers(){
  const [clientes, setClientes] = useState([]);
  const url = 'clientes'

  useEffect(() => {
    getData(setClientes, url);
  }, []);

  return(
    <div>
      <Header/>
      
      <div className='content'>
        <Title name="Clientes">
          <DiCodeBadge size={25}/>
        </Title>

        <>
            <table>
              <thead>
                <tr>
                  <th scope='col'>Empresa</th>
                  <th scope='col'>Responsável</th>
                  <th scope='col'>Email</th>
                  <th scope='col'>Telefone</th>
                  <th scope='col'>CNPJ</th>
                  <th scope='col'>#</th>
                </tr>
              </thead>
              <tbody>
                {clientes.map((cliente, index) => {
                  return(
                    <tr>
                    <td data-label="Nome"> {cliente.nomeEmpresa} </td>
                    <td data-label="Responsavel"> {cliente.responsavel} </td>
                    <td data-label="Email"> {cliente.email} </td>
                    <td data-label="Telefone"> {cliente.telefone} </td>
                    <td data-label="Cnpj"> {cliente.cnpj} </td>
                    <td data-label="#">
                      <button className='action' style={{backgroundColor: '#3583f6'}} onClick={() => {}}>
                        <FiSearch color='#FFF' size={17}/>
                      </button>

                      <Link className='action' style={{backgroundColor: '#F6A935'}}>
                        <FiEdit2 color='#FFF' size={17}/>
                      </Link>
                    </td>
                  </tr>
                  )
                })}                   
              </tbody>
            </table>
          </>


      </div>

      {/* {showPostModal && (
        <Modal
          conteudo={detail}
          close={togglePostModal}
        />
      )} */}
    </div>
  )
}