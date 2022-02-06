$(document).ready(function () {

    $("#deleteRequestForm").submit(function (event)
    {
        event.preventDefault();
        $.ajax({
            url: "/application/deleteDELETE",
            type: "DELETE",
            data:
                {
                    login: $("#login").val(),
                }
            ,
            success:
                function (data)
                {
                    if (data.login === undefined)
                    {
                        let response = "<p>Unknown User With That Credentials!</p></br><a href=\"/application/home\">Home</a>"
                        show(response)
                    }
                    else
                    {
                        let response = "<p>User With Login " + data.login + " Deleted Successfully!</p></br><a href=\"/application/home\">Home</a>"
                        show(response)
                    }
                }
            ,
            error:
                function (data)
                {
                    let response = "<p>Error Occurs While Deleting User</p>"
                    show(response)
                }
        });

    });
});

function show(response)
{
    $("#responseFromServer").html(response)
}