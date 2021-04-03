function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function Calcular(){
    if(formulario8.numero1.value.length == 0 || formulario8.numero1.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario8.numero2.value.length == 0 || formulario8.numero2.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;}
        if(formulario8.numero3.value.length == 0 || formulario8.numero3.value.length > 10) {
            alert('Escribe una cantidad valida');
            return;}
    var valor1= document.formulario8.numero1.value;
    var valor2= document.formulario8.numero2.value;
    var valor3= document.formulario8.numero3.value;
    var intvalor1=parseInt(valor1);
    var intvalor2=parseInt(valor2);
    var intvalor3=parseInt(valor3);
    if(intvalor1>intvalor2 && intvalor1>intvalor3){
        document.formulario8.total.value=intvalor1;
    }else
    if(intvalor2>intvalor1 && intvalor2>intvalor3){
        document.formulario8.total.value=intvalor2;
    }else
    if(intvalor3>intvalor1 && intvalor3>intvalor2){
        document.formulario8.total.value=intvalor3;
    }
    if (intvalor1== intvalor2 && intvalor3==intvalor1) {
        document.formulario8.total.value=intvalor1;
    } else 
    if (intvalor1==intvalor2 && intvalor1>intvalor3) {
        document.formulario8.total.value=intvalor1;
    } else 
    if (intvalor2==intvalor3 && intvalor2>intvalor1) {
        document.formulario8.total.value=intvalor2;
    } else 
    if (intvalor3==intvalor1 && intvalor3>intvalor2) {
        document.formulario8.total.value=intvalor3;
    }
    
}   
    function borrar(){

        document.formulario8.numero1.value="";
        document.formulario8.numero2.value="";
        document.formulario8.numero3.value="";
        document.formulario8.total.value="";
    }