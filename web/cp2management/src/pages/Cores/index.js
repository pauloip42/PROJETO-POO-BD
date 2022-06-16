import '../Dashboard/dashboard.css';

import { useState, useEffect } from 'react';

import Header from '../../components/Header';
import Title from '../../components/Title';
import { FiEdit2, FiSearch } from 'react-icons/fi';
import { DiCodeBadge } from "react-icons/di";

import getData from '../../services/api/get';

import { Link } from 'react-router-dom';

export default function Cores(){
  const [nucleos, setNucleos] = useState([]);
  const url = 'nucleos'

  useEffect(() => {
    getData(setNucleos, url);
  }, []);

  return(
    <div>
      <Header/>
      
      <div className='content'>
        <Title name="Núcleos">
          <DiCodeBadge size={25}/>
        </Title>

        <>
            <table>
              <thead>
                <tr>
                  <th scope='col'>Nome</th>
                  <th scope='col'>Sigla</th>
                  <th scope='col'>Area</th>
                  <th scope='col'>#</th>
                </tr>
              </thead>
              <tbody>
                {nucleos.map((nucleo, index) => {
                  return(
                    <tr>
                    <td data-label="Nome"> {nucleo.nome} </td>
                    <td data-label="Sigla"> {nucleo.sigla} </td>
                    <td data-label="Area"> {nucleo.area} </td>
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