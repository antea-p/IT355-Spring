<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select a Car and Enter Information</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>" type="text/css">
</head>
<body>

<div>
    <form:form action="${pageContext.request.contextPath}/rent" method="post" modelAttribute="rental">

        <h2>Renter Information</h2>

        <form:errors path="*" cssClass="error"/>

        <div>
            <label for="carSelect">Select a Car</label>
            <form:select path="car.id" id="carSelect">
                <form:option value="">--Select a Car--</form:option>
                <c:forEach items="${cars}" var="car">
                    <form:option value="${car.id}">${car.make} ${car.model} (${car.year})</form:option>
                </c:forEach>
            </form:select>
            <br>
            <form:errors path="car.id" cssClass="error"/>
        </div>

        <div>
            <label>Full Name</label>
            <form:input path="user.fullName"/>
            <br>
            <form:errors path="user.fullName" cssClass="error"/>
        </div>
        <div>
            <label>Email</label>
            <form:input path="user.email"/>
            <br>
            <form:errors path="user.email" cssClass="error"/>
        </div>
        <div>
            <label>License Number</label>
            <form:input path="user.licenseNumber"/>
            <br>
            <form:errors path="user.licenseNumber" cssClass="error"/>
        </div>
        <button type="submit">Submit</button>
    </form:form>
</div>

</body>
</html>
