import './dashboard.css'
import { useState, useEffect } from 'react';

import Header from '../../components/Header';
import Title from '../../components/Title';
import { FiEdit2, FiPlus, FiSearch } from 'react-icons/fi';
import { DiCodeBadge } from "react-icons/di";

import getData from '../../services/api/get';

import { Link } from 'react-router-dom';

import Modal from '../../components/Modal';
import ModalUpdate from '../../components/ModalUpdate';


export default function Dashboard(){
  const [projetos, setProjetos] = useState([]);
  const [showPostModal, setShowPostModal] = useState(false);
  const [showPostModalUp, setShowPostModalUp] = useState(false);
  const [detail, setDetail] = useState(false);
  const [detailUp, setDetailUp] = useState(false);

  const url = 'projetos'

  useEffect(() => {
    getData(setProjetos, url);
  }, []);

  function togglePostModal(item){
    setShowPostModal(!showPostModal); // trocando de true para false
    setDetail(item);
  }

  function togglePostModalUp(item){
    setShowPostModalUp(!showPostModalUp); // trocando de true para false
    setDetailUp(item);
  }

  return(
    <div>
      <Header/>
      
      <div className='content'>
        <Title name="Projetos">
          <DiCodeBadge size={25}/>
        </Title>

        <>
            <Link to="/novo-projeto" className='new'>
              <FiPlus size={25} color="#FFF"/>
              Novo Projeto
            </Link>
            <table>
              <thead>
                <tr>
                  <th scope='col'>Nome</th>
                  <th scope='col'>Preço</th>
                  <th scope='col'>Status</th>
                  <th scope='col'>Cliente</th>
                  <th scope='col'>#</th>
                </tr>
              </thead>
              <tbody>
                {projetos.map((projeto, index) => {
                  return(
                    <tr>
                    <td data-label="Nome"> {projeto.nome} </td>
                    <td data-label="Preço"> {projeto.preco} </td>
                    <td data-label="Status">
                      <span className='badge' style={{color: '#FFF', backgroundColor: projeto.status === 'Concluído' ? '#5cb85c' : '#3583f6'}}>{projeto.status}</span>
                    </td>
                    <td data-label="Cliente">{projeto.cliente.nomeEmpresa}</td>
                    <td data-label="#">
                      <button className='action' style={{backgroundColor: '#3583f6'}} onClick={() => togglePostModal(projeto)}>
                        <FiSearch color='#FFF' size={17}/>
                      </button>

                      <Link className='action' style={{backgroundColor: '#F6A935'}} onClick={() => togglePostModalUp(projeto)}>
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

      {showPostModal && (
        <Modal
          conteudo={detail}
          close={togglePostModal}
        />
      )}

      {showPostModalUp && (
        <ModalUpdate
          conteudo={detailUp}
          close={togglePostModalUp}
        />
      )}
    </div>
  )
}