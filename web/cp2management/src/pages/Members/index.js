import '../Dashboard/dashboard.css';

import { useState, useEffect } from 'react';

import Header from '../../components/Header';
import Title from '../../components/Title';
import { FiEdit2, FiSearch } from 'react-icons/fi';
import { DiCodeBadge } from "react-icons/di";

import getData from '../../services/api/get';

import { Link } from 'react-router-dom';


export default function Members(){
  const [membros, setMembros] = useState([]);
  const url = 'membros'

  useEffect(() => {
    getData(setMembros, url);
  }, []);

  return(
    <div>
      <Header/>
      
      <div className='content'>
        <Title name="Membros">
          <DiCodeBadge size={25}/>
        </Title>

        <>
            <table>
              <thead>
                <tr>
                  <th scope='col'>Nome</th>
                  <th scope='col'>Email</th>
                  <th scope='col'>Curso</th>
                  <th scope='col'>Cargo</th>
                  <th scope='col'>Núcleo</th>
                  <th scope='col'>#</th>
                </tr>
              </thead>
              <tbody>
                {membros.map((membro, index) => {
                  return(
                    <tr>
                    <td data-label="Nome"> {membro.nome} </td>
                    <td data-label="Email"> {membro.email} </td>
                    <td data-label="Curso"> {membro.curso} </td>
                    <td data-label="Cargo"> {membro.cargo} </td>
                    <td data-label="Nucleo"> {membro.nucleo.sigla} </td>
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
    </div>
  )
}