import { useState, useEffect, useContext } from 'react';
import { useHistory } from 'react-router-dom'

import { FiPlusCircle } from 'react-icons/fi';
import Header from '../../components/Header';
import Title from '../../components/Title';
import { toast } from 'react-toastify';

import './new.css';
import getData from '../../services/api/get';
import {postProject} from '../../services/api/project/project';

export default function NewProject() {    
    const history = useHistory();

    const [clientes, setClientes] = useState([]);
    const [membros, setMembros] = useState([]);

    const [status, setStatus] = useState('Em Progresso');
    const [preco, setPreco] = useState(1000);
    const [nome, setNome] = useState('');
    const [membroSelected, setMembroSelected] = useState('');
    const [clienteSelected, setClienteSelected] = useState('');

    const urlClientes = 'clientes';
    const urlMembros = 'membros';

    useEffect(() => {
        getData(setClientes, urlClientes);
        getData(setMembros, urlMembros);
    }, []);

    function handleChangeCustomers(e){
        setClienteSelected(e.target.value);
    }

    function handleChangeMembers(e){
        setMembroSelected(e.target.value);
    }

    function handleOptionChange(e){
        setStatus(e.target.value);
    }

    async function handleRegister(e){
        e.preventDefault();

        var doublePreco = parseFloat(preco);
        var intCliente = parseInt(clienteSelected);
        var intMembro = parseInt(membroSelected);

        if(nome !== '' && preco !== '' && clienteSelected !== ''&& membroSelected !== ''){
            let project = {
                nome: nome,
                status: status,
                preco: doublePreco,
                cliente: intCliente,
                membro: intMembro,
            }
            const parseProject = JSON.stringify(project);
            await postProject(parseProject);
            toast.success('Projeto Cadastrado!');
            history.push('/dashboard');
            return;
        }

        toast.error('Você deve preencher todos os campos')
    }

    return(
        <div>
            <Header />

            <div className='content'>
                <Title name="Novo Projeto">
                    <FiPlusCircle size={25}/>
                </Title>

                <div className='container'>
                    <form className='form-profile' onSubmit={handleRegister}>
                        <label>Nome</label>
                        <textarea type="text" className='name'
                            placeholder='Nome do projeto'
                            value={nome}
                            onChange={ (e) => setNome(e.target.value) }
                        />

                        <label>Cliente</label>
                        <select value={clienteSelected} onChange={handleChangeCustomers} className='customer'>
                            {clientes.map((cliente, index) => {
                                return(
                                    <option key={cliente.id} value={cliente.id}>
                                        {cliente.nomeEmpresa}
                                    </option>
                                )
                            })}
                        </select>

                        <label>Membro Responsável</label>
                        <select value={membroSelected} onChange={handleChangeMembers}>
                            {membros.map((membro, index) => {
                                return(
                                    <option key={membro.id} value={membro.id}>
                                        {membro.nome}
                                    </option>
                                )
                            })}
                        </select>

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
                            <span>Progresso</span>

                            <input type="radio"
                            name="radio" 
                            value="Concluído" 
                            onChange={handleOptionChange}
                            checked={status === 'Concluído'} 
                            />
                            <span>Concluído</span>
                        </div>

                        <label>Preço (R$)</label>
                        <textarea type="number"
                            placeholder='Preço'
                            value={preco}
                            onChange={ (e) => setPreco(e.target.value) }
                        />

                        <button type='submit'>Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    );
}