$(document).ready(function () {
  $("#btnGet").click(function () {
    $.ajax({
      url: "http://localhost:8080/studente/get",
      method: "get",
      success: function (data) {
        let lista =
          "<thead><tr><th>ID</th><th>Data Iscrizione</th><th>ID Corso</th><th>ID Stato Pagamento</th><th>ID Anagrafica</th><th>Azioni Disponibili</th></tr></thead>";
        let numeroPersone = data.data.length;
        let i = 0;
        let studente;
        for (studente of data.data) {
          i++;
          lista += `<tr>
                        <td>${studente.id}</td>
                        <td>${studente.dataIscrizione}</td>
                        <td>${studente.idCorso}</td>
                        <td>${studente.idStatoPagamento}</td>
                        <td>${studente.idAnagrafica}</td>
                        <td>
                            <button onclick="modifica('${studente.id}', '${studente.dataIscrizione}', '${studente.idCorso}', '${studente.idStatoPagamento}', '${studente.idAnagrafica}' )" class="btn btn-outline-dark btn-sm">Modifica</button>
                            <button onclick="elimina('${studente.id}')" class="btn btn-outline-dark btn-sm">Elimina</button>
                        </td>
                    </tr>`;
        }
        if (i == numeroPersone) lista += "</tbody>";
        $("#tblStudente").html(lista);
      },
      error: function () {
        console.log("Errore" + e);
      },
    });
  });
  $("#btnAdd").click(function () {
    let rec = JSON.stringify({
      dataIscrizione: $("#dataIscrizione").val(),
      idCorso: $("#idCorso").val(),
      idAnagrafica: $("#idAnagrafica").val(),
      statoPagamento: $("#statoPagamento").val(),
    });
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/corso/save",
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
function modifica(id, dataIscrizione, idCorso, idAnagrafica, statoPagamento) {
  let button = `<button id="btnMod" class="btn btn-primary">Modifica Questa Anagrafica</button>`;
  $("#button").append(button);
  $("#dataIscrizione").val(dataIscrizione);
  $("#idCorso").val(idCorso);
  $("#idAnagrafica").val(idAnagrafica);
  $("#statoPagamento").val(statoPagamento);

  $("#btnMod").click(function () {
    let rec = JSON.stringify({
      id: id,
      dataIscrizione: $("#dataIscrizione").val(),
      idCorso: $("#idCorso").val(),
      dob: $("#idAnagrafica").val(),
      statoPagamento: $("#statoPagamento").val(),
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
    url: "http://localhost:8080/studente/delete/" + id,
    type: "DELETE",
    success: function (data) {
      let messaggio = data.msg;
      $("#esito").text(messaggio);
    },
  });
}
