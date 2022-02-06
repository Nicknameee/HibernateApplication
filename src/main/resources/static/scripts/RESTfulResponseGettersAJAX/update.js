$(document).ready(function () {

    $("#putRequestForm").submit(function (event)
    {
        event.preventDefault();
        $.ajax({
            url: "/application/updatePUT",
            type: "PUT",
            data:
                {
                    login: $("#login").val(),
                    password: $("#password").val()
                }
            ,
            success:
                function (data)
                {
                    let response = "<p>User Updated Successfully!</p></br>" + "<p>Login:" + data.login + "</p>" + "</br>" + "<p>Password:" + data.password + "</p>"
                        + "</br>" + "<p>Id:" + data.id + "</p></br><a href=\"/application/home\">Home</a>"
                    show(response)
                }
            ,
            error:
                function (data)
                {
                    let response = "<p>Error Occurs While Updating User</p></br><a href=\"/application/home\">Home</a>"
                    show(response)
                }
        });

    });
});

function show(response)
{
    $("#responseFromServer").html(response)
}