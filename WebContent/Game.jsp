<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp"></jsp:include>
<center>
	<h2>Player: ${sessionScope.name } (${sessionScope.board.moves }
		moves)</h2>
	<br /> <a href="<c:url value = "/Game?new=1" />">New Game</a> | <a
		href="<c:url value="/Hello" />">Not you?</a><br />
	<hr />
	<c:choose>

		<c:when test="${sessionScope.board.finished}">
      <h2>Congratulations! You have won!</h2>
		</c:when>
		<c:otherwise>

			<table id="board">
				<c:forEach var="i" begin="0" end="3">
					<tr>
						<c:forEach var="j" begin="0" end="3">
							<td class="tile <c:if test="${sessionScope.board.board[i * 4 + j].v != 0}">tilenumber</c:if>">
								<c:if test="${sessionScope.board.board[i * 4 + j].canmove}">
									<a href="<c:url value="?move=${sessionScope.board.board[i * 4 + j].v}" />">
								</c:if> <c:if test="${sessionScope.board.board[i * 4 + j].v != 0}">${sessionScope.board.board[i * 4 + j].v}</c:if>
								<c:if test="${sessionScope.board.board[i * 4 + j].canmove}">
									</a>
								</c:if>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
			<br />
		</c:otherwise>
	</c:choose>
</center>
<jsp:include page="Footer.jsp"></jsp:include>
