function ValidarRegistro(){

    if(formulario.nombre.value.length == 0) {
        alert('LLena el campo Nombre');
        return;
    }
    
    if(formulario.nombre.value.length > 20) {
        alert('Escribe un nombre de usuario mas pequeño');
        return;
    }
    if(formulario.appat.value.length == 0) {
        alert('No has escrito nada en apellido paterno');
        return;
    }
    
    if(formulario.appat.value.length > 20) {
        alert('Escribe un apellido paterno mas pequeño');
        return;
    }
    if(formulario.appmat.value.length == 0) {
        alert('No has escrito nada en apellido materno');
        return;
    }
    
    if(formulario.appmat.value.length > 20) {
        alert('Escribe un apellido materno mas pequeño');
        return;
    }
    if(formulario.edad.value.length == 0) {
        alert('No has escrito nada en edad');
        return;
    }
    
    if(formulario.edad.value > 99) {
        alert('Escribe una Edad que no sea mayor a 99');
        return;
    }
     if(formulario.edad.value < 0) {
        alert('Escribe una Edad que no sea negativa');
        return;
    }
    if(formulario.email.value.length > 20) {
        alert('Escribe un email mas corto');
        return;
    }
    if(formulario.email.value.length == 0) {
        alert('No has escrito nada en email');
        return;
    }

}
function ValidarEditar(){
    if(formulario2.ideditar.value.legth==0)
        alert('Escribe un id')
    if(formulario2.nombree.value.length == 0) {
        alert('No has escrito nada en nombre');
        return;
    }
    if(formulario2.nombree.value.length == 0) {
        alert('No has escrito nada en nombre');
        return;
    }
    
    if(formulario2.nombree.value.length > 20) {
        alert('Escribe un nombre de usuario mas pequeño');
        return;
    }
    if(formulario2.appate.value.length == 0) {
        alert('No has escrito nada en apellido paterno');
        return;
    }
    
    if(formulario2.appate.value.length > 20) {
        alert('Escribe un apellido paterno mas pequeño');
        return;
    }
    if(formulario2.appmate.value.length == 0) {
        alert('No has escrito nada en apellido materno');
        return;
    }
    
    if(formulario2.appmate.value.length > 20) {
        alert('Escribe un apellido materno mas pequeño');
        return;
    }
    if(formulario2.edade.value.length == 0) {
        alert('No has escrito nada en edad');
        return;
    }
    
    if(formulario2.edade.value > 99) {
        alert('Escribe una Edad que no sea mayor a 99');
        return;
    }
     if(formulario2.edade.value < 0) {
        alert('Escribe una Edad que no sea negativa');
        return;
    }
    if(formulario2.emaile.value.length > 20) {
        alert('Escribe un email mas corto');
        return;
    }
    if(formulario2.emaile.value.length == 0) {
        alert('No has escrito nada en email');
        return;
    }

}
function ValidarEliminar(){
    if(formularioeliminar.ideliminar.value.legth==0)
        alert('Escribe un id')
    return;
}

