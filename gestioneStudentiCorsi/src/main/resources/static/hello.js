$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/materia/get",
        method: 'get',
        success: function (risultato){
            let lista = '<thead><tr><th>ID</th><th>Nome</th><th>Descrizione</th></tr></thead>';
                let numeroPersone= risultato.data.length;
                let i=0;
                for (let materia of data)
                    i++;
                    lista += `<tr><td>${risultato.data.id}</td><td>${data.nome}</td><td>${data.descrizione}</td></tr>`;
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblMateria').html(lista);
        },
        error: function (){
            console.log('Errore'+e);
        }
     })

    });})
