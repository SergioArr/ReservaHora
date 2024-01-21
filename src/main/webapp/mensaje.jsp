<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reserva de hora Pet Smile</title>
</head>
<body>
    <h2><%= request.getAttribute("mensaje") %></h2>

    <form action="ValidadorServlet" method="post">
        <label for="mascota">Mascota:</label>
        <select name="mascota" id="mascota">
            <option value="1">Mery / Perro</option>
            <option value="2">Benita / gato</option>
        </select>
        <br>

        <label for="dueno">Dueño:</label>
        <select name="dueno" id="dueno">
            <option value="1">Dueño 1</option>
            <option value="2">Dueño 2</option>
        </select>
        <br>

        <label for="fecha">Fecha de Reserva:</label>
        <input type="date" name="fecha" id="fecha" required>
        <br>

        <label for="hora">Hora de Reserva:</label>
        <input type="time" name="hora" id="hora" required>
        <br>

        <input type="submit" value="Reservar">
    </form>
</body>
</html>