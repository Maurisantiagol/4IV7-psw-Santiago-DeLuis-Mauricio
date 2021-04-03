function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function Calcular(){
    var mesesflo = parseInt(document.formulario10.meses.value);
    var pagflo = parseFloat(document.formulario10.pago.value);
    var resultado = 0;
    if(mesesflo < 12){
        resultado = pagflo * 0.05*mesesflo;
    }
    if(mesesflo >= 12 && mesesflo < 24){
        resultado = pagflo * 0.07*mesesflo;
    }
    if(mesesflo >= 24 && mesesflo < 60){
        resultado = pagflo * 0.1*mesesflo;
    }
    if(mesesflo >= 60 && mesesflo < 120){
        resultado = pagflo * 0.15*mesesflo;
    }
    if(mesesflo >= 120){
        resultado = pagflo * 0.2*mesesflo;
    }
    document.formulario10.total.value = "$" + resultado.toFixed(0);
}
function borrar(){

    document.formulario10.pago.value="";
    document.formulario10.total.value="";
    document.formulario10.meses.value="";
    
}
