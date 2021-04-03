function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function descuento(){
    if(formulario3.cantidad.value.length == 0 || formulario3.cantidad.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    
   

    var valor = document.formulario3.cantidad.value;
    var resultado = parseInt(valor);
    var porcentaje = resultado*0.15;
    var total = valor - porcentaje;

    document.formulario3.Total.value="$"+total;
}

function borrar(){

    document.formulario3.cantidad.value="";
    document.formulario3.Total.value="";
}