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

    // $('#btnNew').click(function () {
    //     $.ajax({url: "http://localhost:8080/corso/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});
})