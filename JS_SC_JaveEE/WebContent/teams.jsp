<%-- 
    teams.jsp
	Created On: June 15th 23016
    Sean Coombes & John Steel
--%>

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
                <h1>Teams</h1>
                  <table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Team</th>
			        <th>Head Coach</th>
			        <th>Assistant Coach</th>
			        <th>Fitness Trainer</th>
			        <th>Manager</th>
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${teams}" var="team">
                			<tr>
                				<td><a href="roster?teamid=${team.teamid}">${team.teamname}</a></td>
                				<td>${team.headcoach}</td>
                				<td>${team.asstcoach}</td>
                				<td>${team.trainer}</td>
                				<td>${team.manager}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>