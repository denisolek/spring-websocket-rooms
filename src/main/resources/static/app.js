var stompClient = null;
var currentRoomName = null;

function setConnected(connected) {
    if (connected) {
        $("#conversation").show();
        $("#connection-status").removeClass("alert-danger").addClass("alert-success");
        $("#connection-status").html("Connected to <strong>" + currentRoomName + "</strong>");
        $("#disconnect").prop("disabled", false);
    }
    else {
        $("#conversation").hide();
        $("#connection-status").removeClass("alert-success").addClass("alert-danger");
        $("#connection-status").html("<strong>Not connected</strong>");
        $("#disconnect").prop("disabled", true);
        resetDisabled();
    }
    $("#chatroom").html("");
}

function resetDisabled() {
  $("#roomOne").prop("disabled", false)
  $("#roomTwo").prop("disabled", false)
  $("#roomThree").prop("disabled", false)
}

function connect(roomName) {
    var socket = new SockJS('http://192.27.3.124:8080/websocket-chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);

        stompClient.subscribe('/rooms/' + roomName, function (message) {
            showMessage(JSON.parse(message.body).content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
  if (currentRoomName != null) {
    stompClient.send("/app/chat/" + currentRoomName, {}, JSON.stringify({'message': $("#message").val()}));
  }
}

function showMessage(message) {
    $("#chatroom").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("#conversation").hide();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() {
      sendMessage();
    });
    $( "#roomOne" ).click(function() {
      resetDisabled();
      $("#roomOne").prop("disabled", true)
      // disconnect();
      connect('project-1')
      currentRoomName = 'project-1';
    });
    $( "#roomTwo" ).click(function() {
      resetDisabled();
      $("#roomTwo").prop("disabled", true)
      // disconnect();
      connect('project-2')
      currentRoomName = 'project-2';
    });
    $( "#roomThree" ).click(function() {
      resetDisabled();
      $("#roomThree").prop("disabled", true)
      // disconnect();
      connect('project-3')
      currentRoomName = 'project-3';
    });
});
