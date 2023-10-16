<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Complaint</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #013329;">
    <div>
        <div class="container">
            <br>
            <button class="btn btn-primary" type="button" style="background-color:#013329;color: white;"><a
                    href="menu.jsp" class="link-offset-2 link-underline link-underline-opacity-0 link-light">
                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"/></svg></a></button>
            <img src="./images/whitelogo2.png">
            <br><br><br>
        </div>
        <div class="container" style="background-color: #ebe5dc;">
            <br>
            <h1 style="text-align: center;">Add Complaint</h1>
            <form method="post" action="addcomplaint" style="color: black;">
                <div class="mb-3">
                    <label class="form-label">Department Name</label>
                    <input type="text" name="dept" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Parent Name</label>
                    <input type="text" name="parent" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Section Name</label>
                    <input type="text" name="section" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Category Name</label>
                    <input type="text" name="category" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Issue</label>
                    <textarea class="form-control" name="issue" rows="3"></textarea>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary" type="submit" style="background-color:#98B545; color:black">
                        Submit
                    </button>
                </div>
            </form>
            <br><br>
        </div>
    </div>
</body>

</html>