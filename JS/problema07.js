function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function Calcular(){
    if(formulario7.numero1.value.length == 0 || formulario7.numero1.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario7.numero2.value.length == 0 || formulario7.numero2.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;}
    var valor1= document.formulario7.numero1.value;
    var valor2= document.formulario7.numero2.value;
    var intvalor1=parseInt(valor1);
    var intvalor2=parseInt(valor2);
        if(intvalor1<intvalor2){
            document.formulario7.total.value=intvalor1+intvalor2;
            document.formulario7.operacion.value='Suma';
        }else
        if(intvalor1==intvalor2){
            document.formulario7.total.value=intvalor1*intvalor2;
            document.formulario7.operacion.value='Multiplicacion';
        }else
        if(intvalor1>intvalor2){
            document.formulario7.total.value=intvalor1-intvalor2;
            document.formulario7.operacion.value='Resta';
        }
    }
    function borrar(){

        document.formulario7.numero1.value="";
        document.formulario7.numero2.value="";
        document.formulario7.total.value="";
        document.formulario7.operacion.value="";
    }





