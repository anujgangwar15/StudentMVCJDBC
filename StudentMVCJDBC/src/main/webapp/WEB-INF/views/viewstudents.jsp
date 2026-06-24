<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>Student List</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Course</th>
</tr>

<c:forEach var="s"
           items="${students}">

<tr>
    <td>${s.id}</td>
    <td>${s.name}</td>
    <td>${s.course}</td>
</tr>

</c:forEach>

</table>

<br>

<a href="register">Add Student</a>

</body>
</html>
