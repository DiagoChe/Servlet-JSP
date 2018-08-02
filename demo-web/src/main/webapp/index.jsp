<html>
<body>
<h2>${user.id}</h2>
<h2>${user.name}</h2>


<form method="post" action="${pageContext.request.contextPath}/update">
    <input type="hidden" value="${user.id}" name="id">
    <input type="text" name="name">

    <input type="submit">
</form>
</body>
</html>
