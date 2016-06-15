<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Teams!</h1>
                <p class="lead">This page will have some teams from a database! Right now they are hard coded.</p>
                  <table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Team</th>
			        <th>Location</th>
			        <th>Arena</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>Montreal Canadiens</td>
			        <td>Montreal, QC</td>
			        <td>Bell Centre</td>
			      </tr>
			      <tr>
			        <td>Ottawa Senators</td>
			        <td>Ottawa, ON</td>
			        <td>Canadian Tire Centre</td>
			      </tr>
			      <tr>
			        <td>Winnipeg Jets</td>
			        <td>Winnipeg, MB</td>
			        <td>MTS Centre</td>
			      </tr>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>