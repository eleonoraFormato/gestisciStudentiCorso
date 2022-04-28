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
                            <button onclick="modifica('${anagrafica.id}', '${anagrafica.nome}', '${anagrafica.cognome}', '${anagrafica.dob}', '${anagrafica.codiceFiscale}' )" class="btn btn-outline-dark btn-sm" >Modifica</button>
                            <button onclick="elimina('${anagrafica.id}')" class="btn btn-outline-dark btn-sm ">Elimina</button>
                        </td>
                    </tr>`;
        }
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblAnagrafica").html(lista);
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
function modifica(id, nome, cognome, dob, cf) {
  let button = `<button id="btnMod" class="btn btn-primary">Modifica Questa Anagrafica</button>`;
  $("#button").append(button);
  $("#nome").val(nome);
  $("#cognome").val(cognome);
  $("#dob").val(dob);
  $("#codiceFiscale").val(cf);

  $("#btnMod").click(function () {
    $("#esito").text(id);
    let rec = JSON.stringify({
      id: id,
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
}

function elimina(id) {
  $("#esito").html(testo);
  $.ajax({
    url: "http://localhost:8080/anagrafica/delete/" + id,
    type: "DELETE",
    success: function (data) {
      let messaggio = data.msg;
      $("#esito").text(messaggio);
    },
  });
}
