<%-- 
    games.jsp
	Created On: July 26, 2016
    Sean Coombes & John Steel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:bootstrappage>
	<jsp:attribute name="menu">
      <jsp:include page="_menu.jsp" />
    </jsp:attribute>
	<jsp:attribute name="footer">
      <jsp:include page="_footer.jsp" />
    </jsp:attribute>
	<jsp:body>
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h1>${title}</h1>
               <table class="table table-bordered">
			    <thead>
			      <tr>
                    <th>Date</th>
                    <th>Time</th>
			        <th>Opponent</th>
			        <th>Score</th>
			        <th>Arena</th>
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${games}" var="game">
                			<tr>
                                <td>${game.gameDate}</td>
                                <td>${game.gameTime}</td>
                                <td>${game.visitorTeam}</td>
                               	<td>
                               		<c:choose>
                               			<c:when test="${empty game.score}">
                               				<a href="addscore?gameid=${game.gameId}&teamid=${game.teamId}">Add Score</a>
                               			</c:when>                          			
                               			<c:otherwise>
                               				${game.score}
                               			</c:otherwise>
                               		</c:choose>         				
                				</td>
                				<td>${game.arena}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>