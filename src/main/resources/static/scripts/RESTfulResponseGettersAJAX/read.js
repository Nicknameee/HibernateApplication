$(document).ready(function () {

    $("#readRequestForm").submit(function (event)
    {
        event.preventDefault();
        $.ajax({
            url: "/application/readGET",
            type: "GET",
            data:
                {
                    login: $("#requestLoginValue").val()
                }
            ,
            success:
                function (data)
                {
                    if (data.login === undefined)
                    {
                        let response = "<p>No Users Were Found By That Credentials</p></br><a href=\"/application/home\">Home</a>"
                        show(response)
                    }
                    else
                    {
                        let response = "<p>Login:" + data.login + "</p>" + "</br>" + "<p>Password:" + data.password + "</p>"
                            + "</br>" + "<p>Id:" + data.id + "</p></br><a href=\"/application/home\">Home</a>"
                        show(response)
                    }
                }
            ,
            error:
                function (data)
                {
                    let response = "<p>No Users Were Found By That Credentials</p>"
                    show(response)
                }
        });

    });
});

function show(response)
{
    $("#responseFromServer").html(response)
}