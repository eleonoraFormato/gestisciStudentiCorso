$(document).ready(function () {
  $("#btnGet").click(function () {
    $.ajax({
      url: "http://localhost:8080/esame/get",
      method: "get",
      success: function (data) {
        let lista =
          "<thead><tr><th>ID</th><th>Voto</th><th>ID Studente</th><th>ID Materia</th><th>ID Corso</th><th>Azioni Disponibili</th></tr></thead>";
        let numeroPersone = data.data.length;
        let i = 0;
        let esame;
        for (esame of data.data) {
          i++;
          lista += `<tr>
                    <td>${esame.id}</td>
                    <td>${esame.voto}</td>
                    <td>${esame.idStudente}</td>
                    <td>${esame.idMateria}</td>
                    <td>${esame.idCorso}</td>
                    <td>
                        <button onclick="modifica('${esame.id}', '${esame.voto}', '${esame.idStudente}', '${esame.idMateria}', '${esame.idCorso}' )" class="btn btn-outline-dark btn-sm">Modifica</button>
                        <button onclick="elimina('${esame.id}')" class="btn btn-outline-dark btn-sm">Elimina</button>
                    </td>
                    </tr>`;
        }
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblEsame").html(lista);
      },
      error: function () {
        console.log("Errore" + e);
      },
    });
  });
  $("#btnAdd").click(function () {
    let rec = JSON.stringify({
      voto: $("#voto").val(),
      idStudente: $("#idStudente").val(),
      idMateria: $("#idMateria").val(),
      idCorso: $("#idCorso").val(),
    });
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/esame/save",
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
function modifica(id, voto, idStudente, idMateria, idCorso) {
  let button = `<button id="btnMod" class="btn btn-primary">Modifica Questa Anagrafica</button>`;
  $("#button").append(button);
  $("#voto").val(voto);
  $("#idStudente").val(idStudente);
  $("#idMateria").val(idMateria);
  $("#idCorso").val(idCorso);

  $("#btnMod").click(function () {
    let rec = JSON.stringify({
      id: id,
      voto: $("#voto").val(),
      idStudente: $("#idStudente").val(),
      idMateria: $("#idMateria").val(),
      idCorso: $("#idCorso").val(),
    });
    console.log(rec);
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/esame/save",
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
    url: "http://localhost:8080/esame/delete/" + id,
    type: "DELETE",
    success: function (data) {
      let messaggio = data.msg;
      $("#esito").text(messaggio);
    },
  });
}
