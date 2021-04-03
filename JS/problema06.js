function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function Calcular(){
    if(formulario6.anoact.value.length == 0 || formulario6.anoact.value.length > 4|| formulario6.anoact.value < 1900) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario6.mesact.value.length == 0 || formulario6.mesact.value.length > 2 || formulario6.mesact.value > 12) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario6.anonac.value.length == 0 || formulario6.anonac.value.length > 4 || formulario6.anonac.value < 1900) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario6.mesnac.value.length == 0 || formulario6.mesnac.value.length > 2 || formulario6.mesnac.value > 12) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario6.anoact.value < formulario6.anonac.value){
        alert('La fecha actual no puede ser menor a la fecha de nacimiento a caso ¿vienes del futuro?')
        return;
    }
    var ano1=document.formulario6.anoact.value;
    var intano1=parseInt(ano1).toFixed(0);


    var mes1=document.formulario6.mesact.value;
    var intmes1=parseInt(mes1).toFixed(0);


    var ano2=document.formulario6.anonac.value;
    var intano2=parseInt(ano2).toFixed(0);


    var mes2=document.formulario6.mesnac.value;
    var intmes2=parseInt(mes2).toFixed(0);

    var sumaanos=(((intano1*12+intmes1)/12)-((intano2*12+intmes2)/12))/10-1;
    var anostotales=intano1-intano2-1;
    var sumames=12+((sumaanos-sumaanos.toFixed(0))*120);


  

    document.formulario6.edadfin.value=anostotales;
    document.formulario6.mesesfin.value=sumames.toFixed(2);



}
function borrar(){
    document.formulario6.anoact.value="";
    document.formulario6.anonac.value="";
    document.formulario6.mesact.value="";
    document.formulario6.mesnac.value="";
    document.formulario6.edadfin.value="";
    document.formulario6.mesesfin.value="";
   


}