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
                <option>Beli konj</option>
                <option>Gostilna pri Inotu</option>
            </select>
            <input type="submit" name="submit" value="submit">
        </form>
        <!-- <form name="izberi_napitek" method="post" action="/naloga1/TestSBServlet">
            <p>
                <label for="kavarna">izberi kavarno</label>
                <input type="text" name="kavarna" required>
            </p>
            <p>
                <input type="submit" name="submit" value="submit">
            </p>
        </form> -->
    </body>
</html>