<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Klik kafe</title>
        <meta charset="UTF-8">
        <link rel="icon" href="images/coffee-icon.ico">
    </head>
    <body>
        <h1>Pozdravljeni na portali Klik kafe</h1>
        <form name="izberi_kavarno" method="post" action="/naloga1/TestSBServlet">
            <select name="kavarna">
                <option>Marjetica</option>
                <option>Beli Konj</option>
                <option>Gostilna Pri Inotu</option>
            </select>
            <p>
                <input type="checkbox" name="napitek" value="cappuccino">
                cappuccino
            </p>
            <p>
                <input type="checkbox" name="napitek" value="espresso">
                espresso
            </p>
            <p>
                <input type="checkbox" name="napitek" value="irish coffee">
                irish coffee
            </p>
            <p>
                <input type="checkbox" name="napitek" value="macchiato">
                macchiato
            </p>
            <p> 
                <input type="radio" name="size" value="small">
                small
            </p>
            <p> 
                <input type="radio" name="size" value="medium">
                medium
            </p>
            <p> 
                <input type="radio" name="size" value="large">
                large
            </p>
            <p>
                <label for="username">username</label>
                <input type="text" name="username" required>
            </p>
            <input type="submit" name="submit" value="submit">
        </form>
        <p>${message}</p>
    </body>
</html>