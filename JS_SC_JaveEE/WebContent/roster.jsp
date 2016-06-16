<%-- 
    roster.jsp
	Created On: June 15th 23016
    Sean Coombes & John Steel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
                <h1>Roster of the ${teamName}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Player Id</th>
                			<th>First Name</th>
                			<th>Last Name</th>
                		</tr>             		
                	</thead>
                	<tbody>
                		<c:forEach items="${roster}" var="player">
                			<tr>
                				<td>${player.playerName}</td>
                				<td>${player.position}</td>
                				<td>${player.jersey}</td>
                			</tr>
                		</c:forEach>
                	</tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>