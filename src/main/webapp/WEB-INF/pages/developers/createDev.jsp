<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery dev</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<div id="allDevelopers"></div>

<button id="addDeveloper" type="button">ADD DEVELOPER</button>
<label for="developerName">Dev name: </label><input type="text" id="developerName">

<script>

    var urlGet = "http://localhost:8080/springdemo_war_exploded/developer/";

    $.ajax({
        url: urlGet,
        method: "GET",
        success: function (resp) {
            console.log("Get all developers response: " + resp);
            drawDevelopers(resp);
        },
        error: function(err) {
            console.log("Get all developers response ERROR: " + err)
        },
        dataType: "json"
    });

    function drawDevelopers(develepers) {
        for (var i = 0; i < develepers.length; i++) {
            var divChild = $("<div>\n" +
                "    <label >" + develepers[i].id + "</label >" +
                "    <label > </label >" +
                "    <label >" + develepers[i].name + "</label >\n" +
                "</div>\n");
            $("#allDevelopers").append(divChild);
        }
    }

    $("#addDeveloper").click(onDeveloperAddClick);

    function onDeveloperAddClick() {
        alert("click");
        var urlGet = "http://localhost:8080/springdemo_war_exploded/developer/allDev";
        var developerCreateInput = {
            "name": $("#developerName").val()
        };

        $.ajax({
            url: urlGet,
            method: "POST",
            data: JSON.stringify(developerCreateInput),
            success: function (resp) {
                console.log("Get all developers response: " + resp);
                drawDevelopers(resp);
            },
            error: function(err) {
                console.log("Get all developers response ERROR: " + err)
            },
            contentType: "application/json",
            dataType: "json"
        });
    }

</script>
</body>
</html>
