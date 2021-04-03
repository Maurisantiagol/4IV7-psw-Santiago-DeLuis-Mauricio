
function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function ventas(){
    if(formulario2.cantidad1.value.length == 0 || formulario2.cantidad1.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario2.cantidad2.value.length == 0 || formulario2.cantidad2.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario2.cantidad3.value.length == 0 || formulario2.cantidad3.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }

    var valor1 = document.formulario2.cantidad1.value;
    var resultado1 = parseInt(valor1);
    var comision1 = resultado1*0.1;
    
    
    var valor2 = document.formulario2.cantidad2.value;
    var resultado2 = parseInt(valor2);
    var comision2 = resultado2*0.1;
    
    
    var valor3 = document.formulario2.cantidad3.value;
    var resultado3 = parseInt(valor3);
    var comision3 = resultado3*0.1;

    var comisionfinal=comision1+comision2+comision3;
   
    var sueldo1 =document.formulario2.cantidadsueldo.value;
    var intsueldo = parseInt(sueldo1);
    var sueldofinal= intsueldo+ comisionfinal;
    document.formulario2.sueldoti.value="$"+sueldofinal;

    document.formulario2.comisionti.value="$"+comisionfinal;
}

function borrar(){

    document.formulario2.cantidad1.value="";
    document.formulario2.cantidad2.value="";
    document.formulario2.cantidad3.value="";
    document.formulario2.cantidadsueldo.value="";

    document.formulario2.comisionti.value="";
    document.formulario2.sueldoti.value="";
    
}