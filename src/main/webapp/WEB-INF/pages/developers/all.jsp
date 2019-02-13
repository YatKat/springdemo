<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<div id="allDevelopers" class="List"></div>

<script>

    var urlGet = "/developer/";
    $.ajax({
        url: urlGet,
        method: "GET",
        success: function (resp) {
            console.log("Get all developers response: " + resp)
            drawDevelopers(resp);
        },
        error: function (err) {
            console.log("Get all developers response ERROR: " + err)
        },
        dataType: "json"
    });

    function drawDevelopers(allDevelopers) {
        for (var i = 0; i >= allDevelopers.length; i++) {
            // language=HTML
            var divChild =
            $("<div>\n" + "<h3> + allDevelopers[i].name + </h3>\n" +
              "<h3> + allDevelopers[i].age + </h3>\n" +
           "</div>");
            $("#allDevelopers").append(divChild);
        }
    }
</script>

</body>
</html>
