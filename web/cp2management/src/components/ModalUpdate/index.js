import './modal.css';
import { useContext, useState, useEffect } from 'react';
import { FiCheck, FiX } from 'react-icons/fi';

import {deleteProject, updateProject} from '../../services/api/project/project';

import { toast } from 'react-toastify';
import getData from '../../services/api/get';

export default function ModalUpdate({conteudo, close}){
    const [membros, setMembros] = useState([]);
    const [membroSelected, setMembroSelected] = useState('');

    const [status, setStatus] = useState('Em Progresso');

    const url = 'membros'

    useEffect(() => {
      getData(setMembros, url);
    }, []);

    function handleChangeMembers(e){
        setMembroSelected(e.target.value);
    }

    async function atualizaProjeto(idProjeto){
        updateProject(idProjeto, membroSelected, status);
        toast.success('Projeto atualizado!')
        close();
    }

    function handleOptionChange(e){
        setStatus(e.target.value);
    }
    
    return(
        <div className='modal'>
            <div className='container'>
                <button className='close' onClick={close}>
                    <FiX size={23} color="#FFF"/>
                    Voltar
                </button>

                <div>
                    <h2>
                        Editar Projeto
                    </h2>

                    <div className='row'>
                        <span>
                            Nome: <i>{conteudo.nome}</i>
                        </span>
                    </div>

                    <div className='row'>
                        <span>
                            Preço: <i>R$ {conteudo.preco}</i>
                        </span>
                    </div>
                    
                    <div className='row'>
                        <span>
                            Cliente: <i>{conteudo.cliente.nomeEmpresa}</i>
                        </span>
                    </div>

                    <div className='row'>
                        <span>
                            <label>Status</label>
                            <div className='status'>
                                <input type="radio"
                                    name="radio" 
                                    value="Em Espera"
                                    onChange={handleOptionChange} 
                                    checked={status === 'Em Espera'}
                                />
                                <span>Em Espera</span>

                                <input type="radio"
                                    name="radio" 
                                    value="Em Progresso" 
                                    onChange={handleOptionChange} 
                                    checked={status === 'Em Progresso'}
                                />
                                <span>Em Progresso</span>

                                <input type="radio"
                                    name="radio" 
                                    value="Concluído" 
                                    onChange={handleOptionChange}
                                    checked={status === 'Concluído'} 
                                />
                                <span>Concluído</span>
                            </div>
                        </span>
                    </div>


                    <label>Adicionar membro</label>
                        <select value={membroSelected} onChange={handleChangeMembers}>
                            {membros.map((membro, index) => {
                                return(
                                    <option key={membro.id} value={membro.id}>
                                        {membro.nome}
                                    </option>
                                )
                            })}
                    </select>

                    <button className='update' onClick={() => atualizaProjeto(conteudo.id)}>
                    <FiCheck size={23} color="#FFF"/>
                    Atualizar Projeto
                    </button>

                    {/* <div className='row'>
                        <span>
                            Status: <i 
                            style={{color: '#FFF', backgroundColor: conteudo.status === 'Atendido' ? '#5cb85c' : '#999'}}>
                            {conteudo.status}</i>
                        </span>
                    </div>

                    {conteudo.complemento !== '' && (
                        <>
                            <h3>Complemento</h3>
                            <p>
                                {conteudo.complemento}
                            </p>
                        </>
                    )} */}
                </div>
            </div>
        </div>
    )
}