const API_URL = 'http://localhost:9000/api/v1/personas/';
const buttonCrear = document.querySelector("crearB");
const formCrear = document.querySelector("form");
const submitForm = document.querySelector("submitForm");
let persona = {
  "nombre":"",
  "apellido":"",
  "dni": ""
}


function obtenerPersonas(){
  fetch(API_URL)
  .then((respuesta) => respuesta.json())
  .then((data) => {
    const HTMLResponse = document.querySelector("#app");
    const tpl = data.map(persona => `
    <div class="card">
      <div class="card-header">
        Codigo de persona: ${persona.codPersona}
      </div>
      <div class="card-body">
        <h5 class="card-title">Nombre: ${persona.nombre} ${persona.apellido}</h5>
        <p class="card-text">DNI: ${persona.dni}</p>
        <button onclick="eliminarPersona(${persona.codPersona})" class="btn btn-danger">Eliminar
          <ion-icon name="close-circle-outline"></ion-icon>
        </button>
        </div>
    </div>`);
    HTMLResponse.innerHTML = `${tpl}`;
  });
}

function eliminarPersona(cod){
  fetch(`http://localhost:9000/api/v1/personas/${cod}`, { method: 'DELETE' })
  .then(() => console.log("ok"));
  location.reload();
}

function mostrarCrearPersona(){
  formCrear.style.display = "block";
}

function crearPersona(){
  var data = new FormData();
  data.append("nombre", document.getElementById("nombre").value);
  data.append("apellido", document.getElementById("apellido").value);
  data.append("dni", document.getElementById("dni").value);
  for (let [k, v] of data.entries()) {
    persona[k] = v;
  }
  fetch(API_URL, {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    redirect: 'follow', // manual, *follow, error
    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(persona)
  })
  return true;
}

function obtenerPersona(){
  
}

obtenerPersonas();