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
			        <th>Matchup</th>
			        <th>Score</th>
			        <th>Arena</th>
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${games}" var="game">
                			<tr>
                                <td>${game.gameDate}</td>
                                <td>${game.gameTime}</td>
                                <td>
                                    <span class="${game.visitor.teamId == highlightedTeam ? 'bg-primary' : ''}">${game.visitor.teamName}</span>
                                    @
                                    <span class="${game.home.teamId == highlightedTeam ? 'bg-primary' : ''}">${game.home.teamName}</span>
                               </td>
                               <td>
                               		<c:choose>
                               			<c:when test="${game.visitorScore == null && g.homescore == null}">
                               				<a href="addscore?gameid=${game.gameId}&teamid=${highlightedTeam}">Add Score</a>
                               			</c:when>                          			
                               			<c:otherwise>
                               				${game.visitorScore} - ${game.homeScore}
                               			</c:otherwise>
                               		</c:choose>

                					<c:choose>
										<c:when test="${game.SO =='Y'}">
											SO
										</c:when>
										<c:when test="${(game.SO =='N') && (game.OT == 'Y')}">
											OT
										</c:when>
                					</c:choose> 
                				
                				</td>
                				<td>${game.arena.arenaName}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>