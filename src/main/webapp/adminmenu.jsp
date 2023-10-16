<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #98B545 ;">
    <div class="container mx-3">
        <br>
        <button type="button" class="btn-close" aria-label="Close" onclick="window.location.href = 'adminhome.jsp';"></button>
    </div>
    <div class="container" style="text-align: center; color: white;">
        <br><br><br><br><br>
        <h1 style="font-size: 100px;" ><a href="adminhome" class="link-offset-2 link-underline link-underline-opacity-0 link-light">Dashboard</a></h1>
        <h1 style="font-size: 100px;" onclick="window.location.href = 'adduser.jsp';">Add User</h1>
        <h1 style="font-size: 100px;"><a href="viewallusers" class="link-offset-2 link-underline link-underline-opacity-0 link-light">Users</a></h1>
        <h1 style="font-size: 100px;" ><a href="viewcomplaints" class="link-offset-2 link-underline link-underline-opacity-0 link-light">Complaints</a></h1>
        <h1 style="font-size: 100px;"><a href="adminhome" class="link-offset-2 link-underline link-underline-opacity-0 link-light">Profile</a></h1>
    </div>
</body>
</html>