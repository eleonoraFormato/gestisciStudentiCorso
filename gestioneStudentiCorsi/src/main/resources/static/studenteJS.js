$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/studente/get",
        method: 'get',
        success: function (data){
            let lista = '<thead><tr><th>ID</th><th>Data Iscrizione</th><th>ID Corso</th><th>ID Stato Pagamento</th><th>ID Anagrafica</th><th>Azioni Disponibili</th></tr></thead>';
                let numeroPersone= data.data.length;
                let i=0;
                let studente;
                for (studente of data.data)
                   { i++;
                    lista +=
                    `<tr>
                        <td>${studente.id}</td>
                        <td>${studente.dataIscrizione}</td>
                        <td>${studente.idCorso}</td>
                        <td>${studente.idStatoPagamento}</td>
                        <td>${studente.idAnagrafica}</td>
                        <td>
                            <button id="btnMod" type="button" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button id="btnDel" type="button" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
                }
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblStudente').html(lista);
        },
        error: function (){
            console.log('Errore'+e);
        }
     })

    });
    // $('#btnMod').click(function () {
    //     $.ajax({url: "http://localhost:8080/studente/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});

    // $('#btnDel').click(function () {
    //     $.ajax({url: "http://localhost:8080/studente/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //          console.log('Errore'+e);
    //     }})});

    // $('#btnNew').click(function () {
    //     $.ajax({url: "http://localhost:8080/studente/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});
    })