<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buy T-Shirt</title>
</head>
<body>
    <h1>Buy a T-Shirt</h1>
    <form action="tdetails" method="post">
        <h3>Select Accessories:</h3>
        <input type="checkbox" name="accessory" value="belt"> Belt<br>
        <input type="checkbox" name="accessory" value="cap"> Cap<br>
        <input type="checkbox" name="accessory" value="hairband"> Hair-band<br>
        
        <h3>Enter T-Shirt Tag-line:</h3>
        <input type="text" name="tagline"><br><br>

        <h3>Choose Pocket Option:</h3>
        <input type="radio" name="pocket" value="with"> With Chest Pocket<br>
        <input type="radio" name="pocket" value="without"> Without Chest Pocket<br><br>
        
        <h3>Choose T-Shirt Color:</h3>
        <select name="color">
            <option value="red">Red</option>
            <option value="blue">Blue</option>
            <option value="green">Green</option>
            <option value="black">Black</option>
            <option value="white">White</option>
        </select><br><br>
        
        <button type="submit">Click Me</button>
    </form>
    <table border='1'><tr><th>OrderNo</th><th>Accessories</th><th>Tagline</th><th>Pocket</th><th>Color</th></tr>
</body>
</html>