export default function getData(setSomething, endpoint){
    let url = `http://localhost:8080/${endpoint}`;
    fetch(url)
    .then((r)=> r.json())
    .then((json)=> {
        setSomething(json);
    })
}