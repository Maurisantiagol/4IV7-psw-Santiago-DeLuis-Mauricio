function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function contar(){
    if(formulario5.cantmujeres.value.length == 0 || formulario5.cantmujeres.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario5.canthombres.value.length == 0 || formulario5.canthombres.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    
   

    var valor = document.formulario5.cantmujeres.value;
    var muj = parseInt(valor);
    
    var valor2 = document.formulario5.canthombres.value;
    var hom = parseInt(valor2);
    

    var total =muj+hom;
    var totmujeres=muj*100/total;
    var tothombres=hom*100/total;
    
    document.formulario5.pormujeres.value=totmujeres;
    document.formulario5.porhombres.value=tothombres;
}

function borrar(){

    document.formulario5.pormujeres.value="";
    document.formulario5.porhombres.value="";
    document.formulario5.cantmujeres.value="";
    document.formulario5.canthombres.value="";
}