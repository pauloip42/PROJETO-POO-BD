export async function postProject(project){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
        body: project
    };
    await fetch('http://localhost:8080/projetos', requestOptions)
        .then((response) => {
            return response.json();
        });
}

export async function deleteProject(id){
    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
        body: ''
    };
    await fetch(`http://localhost:8080/projetos/${id}`, requestOptions)
        .then((response) => {
            return response.json();
        });
}

export async function updateProject(idProjeto, idMembro, status){
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
        body: status
    };
    await fetch(`http://localhost:8080/projetos/${idProjeto}/membros/${idMembro}`, requestOptions)
        .then((response) => {
            console.log(response.json());
            return response.json();
        });
}