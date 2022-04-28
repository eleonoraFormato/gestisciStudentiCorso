$(document).ready(function () {
  $("#btnGet").click(function () {
    $.ajax({
      url: "http://localhost:8080/utente/get",
      method: "get",
      success: function (data) {
        let lista =
          "<thead><tr><th>ID</th><th>E-Mail</th><th>Password</th><th>Tipo Utente</th><th>ID Anagrafica</th><th>Azioni Disponibili</th></tr></thead>";
        let numeroPersone = data.data.length;
        let i = 0;
        let utente;
        for (utente of data.data) {
          i++;
          lista += `<tr>
                        <td>${utente.id}</td>
                        <td>${utente.eMail}</td>
                        <td>${utente.password}</td>
                        <td>${utente.tipoUtente}</td>
                        <td>${utente.idAnagrafica}</td>
                        <td>
                            <button onclick="modifica('${utente.id}', '${utente.eMail}', '${utente.password}', '${utente.tipoUtente}', '${utente.idAnagrafica}' )" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button onclick="elimina('${utente.id}')" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
        }
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblUtente").html(lista);
      },
      error: function () {
        console.log("Errore" + e);
      },
    });
  });

  $("#btnAdd").click(function () {
    let rec = JSON.stringify({
      eMail: $("#eMail").val(),
      password: $("#password").val(),
      idAnagrafica: $("#idAnagrafica").val(),
      tipoUtente: $("#tipoUtente").val(),
    });
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/utente/save",
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
function modifica(id, eMail, password, idAnagrafica, tipoUtente) {
  let button = `<button id="btnMod" class="btn btn-primary">Modifica Questa Anagrafica</button>`;
  $("#button").append(button);
  $("#eMail").val(eMail);
  $("#password").val(password);
  $("#idAnagrafica").val(idAnagrafica);
  $("#tipoUtente").val(tipoUtente);

  $("#btnMod").click(function () {
    let rec = JSON.stringify({
      id: id,
      eMail: $("#eMail").val(),
      password: $("#password").val(),
      idAnagrafica: $("#idAnagrafica").val(),
      tipoUtente: $("#tipoUtente").val(),
    });
    console.log(rec);
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/utente/save",
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
    url: "http://localhost:8080/utente/delete/" + id,
    type: "DELETE",
    success: function (data) {
      let messaggio = data.msg;
      $("#esito").text(messaggio);
    },
  });
}
