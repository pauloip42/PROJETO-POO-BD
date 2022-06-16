import './modal.css';

import { FiX } from 'react-icons/fi';

import {deleteProject} from '../../services/api/project/project';

import { toast } from 'react-toastify';

export default function Modal({conteudo, close}){
    function deletaProjeto(id){
        deleteProject(id);
        toast.success('Projeto deletado!')
        close();
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
                        Detalhes do Projeto
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
                            Status: <i style={{color: '#FFF', backgroundColor: conteudo.status === 'Concluído' ? '#5cb85c' : '#999'}}>{conteudo.status}</i>
                        </span>
                    </div>

                    <div className='row'>
                        <span>
                            Cliente: <i>{conteudo.cliente.nomeEmpresa}</i>
                        </span>
                    </div>

                    <button className='delete' onClick={() => deletaProjeto(conteudo.id)}>
                    <FiX size={23} color="#FFF"/>
                    Excluir Projeto
                    </button>
                </div>
            </div>
        </div>
    )
}