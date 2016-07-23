<%-- 
    arenas.jsp
	Created On: July 26, 2016
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
                <h1>Arenas</h1>
                  <table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Arena</th>
			        <th>Address</th>
			        
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${arenas}" var="arena">
                			<tr>
                				<td>${arena.arenaName}</td>
                				<td>${arena.streetAddress}, ${arena.city}, ${arena.state_province}, ${arena.country}, ${arena.postalCode}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>