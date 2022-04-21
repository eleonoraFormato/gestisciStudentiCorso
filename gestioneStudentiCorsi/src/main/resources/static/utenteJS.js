$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/utente/get",
        method: 'get',
        success: function (data){
            let lista = '<thead><tr><th>ID</th><th>E-Mail</th><th>Password</th><th>Tipo Utente</th><th>ID Anagrafica</th><th>Azioni Disponibili</th></tr></thead>';
                let numeroPersone= data.data.length;
                let i=0;
                let utente;
                for (utente of data.data)
                   { i++;
                    lista += 
                    `<tr>
                        <td>${utente.id}</td>
                        <td>${utente.eMail}</td>
                        <td>${utente.password}</td>
                        <td>${utente.tipoUtente}</td>
                        <td>${utente.idAnagrafica}</td>
                        <td>
                            <button id="btnMod" type="button" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button id="btnDel" type="button" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
                }
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblUtente').html(lista);
        },
        error: function (){
            console.log('Errore'+ e);
        }
     })

    });
    $('#btnMod').click(function () {
        $.ajax({url: "http://localhost:8080/utente/get",
        method: 'get',
        success: function (data){},
        error: function (){
            console.log('Errore'+e);
        }})});

    $('#btnDel').click(function () {
        $.ajax({url: "http://localhost:8080/utente/get",
        method: 'get',
        success: function (data){},
        error: function (){
             console.log('Errore'+e);
        }})});

    $('#btnNew').click(function () {
        $.ajax({url: "http://localhost:8080/utente/get",
        method: 'get',
        success: function (data){},
        error: function (){
            console.log('Errore'+e);
        }})});
})