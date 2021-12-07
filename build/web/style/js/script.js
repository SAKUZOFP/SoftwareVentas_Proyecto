
$(document).ready(function(){

    $('#login-form').submit(function(event){
        $('#loader').fadeIn(1000).html(
                '<span class="loader-08"></span>');
        $('#mensaje').html('');
        
        $.ajax({
            type: 'POST',
            url: $(this).attr("action"),
            data: $("#login-form").serialize(),
            success: function(res){
                if(res === 'ok'){
                    $('#loader').fadeOut(750,function(){
                       location.href='index.jsp'; 
                    });
                }else{
                    $('#loader').fadeToggle(200,function(){
                        $('#mensaje').fadeIn(1000).html(
                                "<div class='alert alert-error'>\n\
                                 <button type='button' class='close' data-dismiss='alert'>x\n\
                                 </button><h4><i class='icon-remove-sign'></i>Error!</h4> " + res + "</div>")
                    $('#claveInput').val('');
                    });
                }
            },
            error:function(error){
                alert('error al iniciar sesion.... Intente nuevamnete');
            }
        });
       event.preventDefault(); 
    });
});