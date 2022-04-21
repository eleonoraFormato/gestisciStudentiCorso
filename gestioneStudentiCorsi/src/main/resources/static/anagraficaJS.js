$(document).ready(function() {
    $('#btnGet').click(function () {
    $.ajax({
        url: "http://localhost:8080/anagrafica/get",
        method: 'get',
        success: function (data){
            let lista = '<thead><tr><th>ID</th><th>Nome</th><th>Cognome</th><th>Data Di Nascita</th><th>Codice Fiscale</th><th>Azioni Disponibili</th></tr></thead>';
                let numeroPersone= data.data.length;
                let i=0;
                let anagrafica;
                for (anagrafica of data.data)
                   { i++;
                    lista +=
                    `<tr>
                        <td>${anagrafica.id}</td>
                        <td>${anagrafica.nome}</td>
                        <td>${anagrafica.cognome}</td>
                        <td>${anagrafica.dob}</td>
                        <td>${anagrafica.codiceFiscale}</td>
                        <td>
                            <button id="btnMod" type="button" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button id="btnDel" type="button" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
                }
                    if(i==numeroPersone)
                        lista+='</tbody>';
                    $('#tblAnagrafica').html(lista);  
                    $('#btnDel').click(function () {let testo = "sono in cancella";
            $('#esito').html(testo);
        });    
        },
        error: function (){
            console.log('Errore'+e);
        }
     })
            
        });    
})

// $('#btnAdd').click(function () {
//     $.ajax({
//         type: 'POST',
//         url: 'http://localhost:8080/anagrafica/save',
//         data:{
//             "nome" : $('#nome'),
//             "cognome" : $('#cognome'),
//             "dob" : $('#dob'),
//             "codiceFiscale" : $('#codiceFiscale')
//         },
//         success: function (data){
//             let messaggio = JSON.stringify(data.msg);
//             $('#esito').text(messaggio);
//         },
//         error: function (){
//             console.log('Errore'+e);
//     }})});

    // $('#btnMod').click(function () {
    //     $.ajax({url: "http://localhost:8080/anagrafica/get",
    //     method: 'get',
    //     success: function (data){},
    //     error: function (){
    //         console.log('Errore'+e);
    //     }})});

    // let id = data.data.id;
            // $.ajax({
            //     url: "http://localhost:8080/anagrafica/del/" + id,
            //     method: 'delete',
            //     success: function (data){
            //         $('#esito').html(data.msg);
            //     },
            //     error: function (){
            //     console.log('Errore'+e);
            // }})

   
    