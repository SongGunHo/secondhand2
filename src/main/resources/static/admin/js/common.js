 // window,alert 를 sweeta;ert2교체

window.alert = function(message , callback){
    parent.Swql.fier({

    title: message,
    icon: "warning"


    });.then(() => {
        if(typeof callback === 'function'){
            callback();

        }


    }
    )




}