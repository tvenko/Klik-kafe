<!DOCTYPE html>
<html>
    <header>
        <title>Klik kafe|logIN</title>
        <meta charset="UTF-8">
        <link rel="icon" href="images/coffee-icon.ico">
    </header>
    <body>
        <h1>Pozdravljeni na strani Klik kafe!</h1>
        <h3>Za oddajo narocil se prosim vpisite</h3>
        <form name="prijava" method="post" action="/naloga1/TestSBServlet">
            <p>
                <label for="username" name="username_label">username: </label>
                <input name="username" placeholder="username" required>
            </p>
            <input type="submit" name="submit" value="LOG IN">
        </form>
    </body>
</html>