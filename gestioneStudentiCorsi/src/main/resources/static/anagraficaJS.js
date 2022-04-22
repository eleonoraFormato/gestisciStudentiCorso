$(document).ready(function () {
  $("#btnGet").click(function () {
    $.ajax({
      url: "http://localhost:8080/anagrafica/get",
      method: "get",
      success: function (data) {
        let lista =
          "<thead><tr><th>ID</th><th>Nome</th><th>Cognome</th><th>Data Di Nascita</th><th>Codice Fiscale</th><th>Azioni Disponibili</th></tr></thead>";
        let numeroPersone = data.data.length;
        let i = 0;
        let anagrafica;
        for (anagrafica of data.data) {
          i++;
          lista += `<tr>
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
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblAnagrafica").html(lista);
        // $("#btnDel").click(function () {
        //   let testo = "sono in cancella";
        //   $("#esito").html(testo);
        // });
      },
      error: function () {
        console.log("Errore" + e);
      },
    });
  });  
  $("#btnAdd").click(function () {
    let messaggio = "sono entrato nel btn. nome: " + $('#nome').val() + " cognome: " + $('#cognome').val() + " dob: " + $('#dob').val() + " codice Fiscale: " +  $('#codiceFiscale').val();
    $("#esito").text(messaggio);
    $.ajax({
        type:"POST",
        url: "http://localhost:8080/anagrafica/save",
    //   method: "post",
      
      data: {
        nome: $('#nome').val(),
        cognome: $('#cognome').val(),
        dob: $('#dob').val(),
        codiceFiscale: $('#codiceFiscale').val(),
      },
      
      success: function (data) {
        let messaggio = data.msg;
        $("#esito").text(messaggio);
      },
      error: function () {
        console.log("Errore" + e);
      },
      dataType: "application/json"
    });
  });

  })
//   $("#btnAdd").click(function(){
//     let messaggio = "sono entrato nel btn. nome: " + $('#nome').val() + " cognome: " + $('#cognome').val() + " dob: " + $('#dob').val() + " codice Fiscale: " +  $('#codiceFiscale').val();
//     $("#esito").text(messaggio);
//     let nome=$('#nome').val();
//     let cognome= $('#cognome').val();
//     let dob=$('#dob').val();
//     let cf=$('#codiceFiscale').val();
//     $.post('http://localhost:8080/anagrafica/save',   
// 			   {
//                    nome: nome,
//                    cognome: cognome,
//                    dob: dob,
//                    codiceFiscale: cf ,
//                    dataType: JSON, 
//                 },
//                    // data to be submit
// 			       function(data, status, jqXHR) {// success callback
// 						$('#esito').append('status: ' + status + ', data: ' + data.msg);
// 				});
// 			});
//   $("#btnAdd").click(function () {
//     let messaggio = "sono entrato nel btn";
//     $("#esito").text(messaggio);
//     $.ajax({
//       type: "POST",
//       url: "http://localhost:8080/anagrafica/save",
//       data: {
//         nome: $("#nome").val(),
//         cognome: $("#cognome").val(),
//         dob: $("#dob").val,
//         codiceFiscale: $("#codiceFiscale").val(),
//       },
//       success: function (data) {
//         let messaggio = JSON.stringify(data.msg);
//         $("#esito").text(messaggio);
//       },
//       error: function () {
//         console.log("Errore" + e);
//       },
//     });
//   });


// $.ajax({
//     type: 'POST',
//     url: 'http://localhost:8080/anagrafica/save',
//     data:{
//         "nome" : $('#nome'),
//         "cognome" : $('#cognome').val(),
//         "dob" : $('#dob'),
//         "codiceFiscale" : $('#codiceFiscale')
//     },
//     success: function (data){
//         let messaggio = JSON.stringify(data.msg);
//         $('#esito').text(messaggio);
//     },
//     error: function (){
//         console.log('Errore'+e);
//   }})

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
