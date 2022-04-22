$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/corso/get",
        method: 'get',
        success: function (data){
            let lista = '<thead><tr><th>ID</th><th>Nome</th><th>Descrizione</th><th>Data Inizio</th><th>Numero Esami</th><th>Azioni Disponibili</th></tr></thead>';
                let numeroPersone= data.data.length;
                let i=0;
                let corso;
                for (corso of data.data)
                   { i++;
                    lista += 
                    `<tr>
                        <td>${corso.id}</td>
                        <td>${corso.nome}</td>
                        <td>${corso.descrizione}</td>
                        <td>${corso.dataInizio}</td>
                        <td>${corso.numeroEsami}</td>
                        <td>
                            <button id="btnMod" type="button" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button id="btnDel" type="button" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
                }
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblCorso').html(lista);
        },
        error: function (){
            console.log('Errore'+e);
        }
     })

     });

    // $('#btnMod').click(function () {
    //     $.ajax({url: "http://localhost:8080/corso/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});

    // $('#btnDel').click(function () {
    //     $.ajax({url: "http://localhost:8080/corso/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //          console.log('Errore'+e);
    //     }})});

    $("#btnAdd").click(function () {
        let rec = JSON.stringify({
            nome: $('#nome').val(),
            descrizione: $('#descrizione').val(),
            dataInizio: $('#dataInizio').val(),
            numeroEsami: $('#numeroEsami').val()});
        $.ajax({
            type:"POST",
            url: "http://localhost:8080/corso/save",
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