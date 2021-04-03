function borrar(){

    document.formulario9.pagohora.value="";
    document.formulario9.total.value="";
    document.formulario9.horas.value="";
    
}
function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;

    if(teclado == 8) return true;//esto es para que se pueda usar la tecla de borrar

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);

    return patron.test(prueba);
}
function Calcular(){
    if(formulario9.horas.value.length == 0 || formulario9.horas.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;
    }
    if(formulario9.pagohora.value.length == 0 || formulario9.pagohora.value.length > 10) {
        alert('Escribe una cantidad valida');
        return;}
    var hor = document.formulario9.horas.value;  
    var inthor = parseInt(hor);
    var pag = document.formulario9.pagohora.value;  
    var intpag = parseInt(pag);
    
    if(inthor <= 40) {
        var totpag = inthor*intpag;
        document.formulario9.total.value= totpag;
        return;
    }

    
    if(inthor > 40) {
        if(inthor <= 48){
            var pagodob = (inthor - 40) * intpag * 2;
            var extra = intpag * 40; 
            
            var totpag2 =  pagodob+extra ;
            document.formulario9.total.value= totpag2;
        return;
	} else{
            var tot1= intpag * 40 ;
            var tot2= intpag * 8 * 2;
            var tot3= (inthor-48)* intpag * 3;
             var total3 =tot1+tot2+tot3;
            document.formulario9.total.value= total3;
        return;
        }
    }
    






    }