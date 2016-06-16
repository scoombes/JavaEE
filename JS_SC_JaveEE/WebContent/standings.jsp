<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                <h1>Standings!</h1>
                <p>Okay!</p>
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
                                <td><a href="/JS_SC_JavaEE/roster?teamid=${team.teamid}">${team.teamname}</a></td>
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