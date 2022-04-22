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
                            <button onclick="modifica(${anagrafica.id}.val())" class="btn btn-outline-dark btn-sm" >Modifica</button>
                            <button type="button" class="btn btn-outline-dark btn-sm btnDel">Elimina</button>
                        </td>
                    </tr>`;
        }
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblAnagrafica").html(lista);
        
        
        // $(".btnDel").click(function () {
        //   let testo = "sono in cancella. id: " + $("#idAna").val();
        //   $("#esito").html(testo);
          //     $.ajax({
          //         url: 'test.html',
          //         type: 'DELETE',
          //         success: function (result) {
          //             // Do something with the result
          //         }
          //     });
        // });
        $(".btnMod").click(function () {
            let testo = "sono in modifica. id: " + $("#idAna").val();
          $("#esito").html(testo);
          // $.ajax({url: "http://localhost:8080/anagrafica/get",
          // method: 'get',
          // success: function (data){},
          // error: function (){
          //     console.log('Errore'+e);
          // }})
        });
      },
      error: function () {
        console.log("Errore" + e);
      },
    });
  });
  $("#btnAdd").click(function () {
    let rec = JSON.stringify({
      nome: $("#nome").val(),
      cognome: $("#cognome").val(),
      dob: $("#dob").val(),
      codiceFiscale: $("#codiceFiscale").val(),
    });
    console.log(rec);
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/anagrafica/save",
      data: rec,
      success: function (data) {
        let messaggio = data.msg;
        $("#esito").text(messaggio);
      },
      error: function () {
        console.log("Errore" + e);
      },
      contentType: "application/json",
    });
  });
});
function modifica (id) {
    let testo = "sono in cancella. id: " + id;
$("#esito").html(testo);
}