<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Rentals</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>" type="text/css">
</head>
<body>
<h2>List of Successful Rentals</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Car</th>
        <th>Rental Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${rentals}" var="rental">
        <tr>
            <td>${rental.id}</td>
            <td>${rental.user.fullName} (${rental.user.email})</td>
            <td>${rental.car.make} ${rental.car.model} (${rental.car.year})</td>
            <td>${rental.rentalDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
