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
                <h1>Teams!</h1>
                <p class="lead">This page will have some teams from a database! Right now they are hard coded.</p>
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
                				<td>${team.teamname}</td>
                				<td>${team.headcoach}</td>
                				<td>${team.asstcoach}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>