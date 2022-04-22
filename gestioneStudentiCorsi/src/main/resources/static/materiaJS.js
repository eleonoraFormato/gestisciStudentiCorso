$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/materia/get",
        method: 'get',
        success: function (data){
            let lista = '<thead><tr><th>ID</th><th>Nome</th><th>Descrizione</th><th>Azioni Disponibili</th></tr></thead>';
                let numeroPersone= data.data.length;
                let i=0;
                let materia;
                for (materia of data.data)
                   { i++;
                    lista += 
                    `<tr>
                        <td>${materia.id}</td>
                        <td>${materia.nome}</td>
                        <td>${materia.descrizione}</td>
                        <td>
                            <button id="btnMod" type="button" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button id="btnDel" type="button" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
                }
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblMateria').html(lista);
        },
        error: function (){
            console.log('Errore'+e);
        }
     })

    });
    // $('#btnMod').click(function () {
    //     $.ajax({url: "http://localhost:8080/materia/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});

    // $('#btnDel').click(function () {
    //     $.ajax({url: "http://localhost:8080/materia/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //          console.log('Errore'+e);
    //     }})});

    $("#btnAdd").click(function () {
        let rec = JSON.stringify({
            nome: $('#nome').val(),
            descrizione: $('#descrizione').val()});
        $.ajax({
            type:"POST",
            url: "http://localhost:8080/materia/save",
          data: rec,
          success: function (data) {
            let messaggio = data.msg;
            $("#esito").text(messaggio);
          },
          error: function () {
            console.log("Errore" + e);
          },
          contentType: "application/json"
        });
      });
})