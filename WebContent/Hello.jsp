<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp"></jsp:include>
<center>To start the game, enter your name and press the Start button!
<form action="<c:url value="/Game"/>">Your name: <input type="text" name="name" /> <input type="submit" value="Start the game"></form></center>
<jsp:include page="Footer.jsp"></jsp:include>
