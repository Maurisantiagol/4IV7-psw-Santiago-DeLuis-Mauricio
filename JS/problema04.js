
function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function calificar(){
    if(formulario4.parcial1.value.length == 0 || formulario4.parcial1.value.length > 2) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario4.parcial2.value.length == 0 || formulario4.parcial2.value.length > 2) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario4.parcial3.value.length == 0 || formulario4.parcial3.value.length > 2) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario4.examenfinal.value.length == 0 || formulario4.examenfinal.value.length > 2) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario4.trabajofinal.value.length == 0 || formulario4.trabajofinal.value.length > 2) {
        alert('Escribe una cantidad valida');
        return;
    }

    var valor1 = document.formulario4.parcial1.value;
    var resultado1 = parseInt(valor1);
    
    var valor2 = document.formulario4.parcial2.value;
    var resultado2 = parseInt(valor2);

    var valor3 = document.formulario4.parcial3.value;
    var resultado3 = parseInt(valor3);
    
var promcalf=(resultado1+resultado2+resultado3)/3;


    var valor4 = document.formulario4.examenfinal.value;
    var resultado4 = parseInt(valor4);
   
    
    
    var valor5 = document.formulario4.trabajofinal.value;
    var resultado5 = parseInt(valor5);
    

    var calfFin =(promcalf*.55)+(resultado4*.3)+(resultado5*.15)

    

    document.formulario4.calificacionfinal.value=calfFin;
}

function borrar(){

    document.formulario4.parcial1.value="";
    document.formulario4.parcial2.value="";
    document.formulario4.parcial3.value="";
    document.formulario4.examenfinal.value="";
    document.formulario4.trabajofinal.value="";

    document.formulario4.comisionti.value="";
    
    
}