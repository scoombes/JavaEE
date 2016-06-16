<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            	<h1>Completed Games</h1>
               <table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Date</th>
			        <th>Matchup</th>
			        <th>Score</th>
			        <th>OverTime</th>
			        <th>Shoot Out</th>
			        <th>Arena</th>
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${upcoming}" var="game">
                			<tr>
                				<td>${game.gamedate}</td>
                				<td>${game.visitor} @ ${game.home}</td>
                				<td>${game.visitorscore} - ${game.homescore}</td>
                				<td>${game.ot}</td>
                				<td>${game.so}</td>
                				<td>${game.arena}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>