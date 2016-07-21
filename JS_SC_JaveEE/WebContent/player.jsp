<%-- 
    player.jsp
	Created On: July 21st 2016
    Sean Coombes & John Steel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

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
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Jersey</th>
                			<th>Last Name</th>
                			<th>First Name</th>
                			<th>Position</th>
                			<th>Height</th>
                			<th>Weight</th>
                			<th>Hometown</th>
                			<th>Province/State</th>
                			<th>School</th>
                		</tr>             		
                	</thead>
                	<tbody>
               			<tr>
       						<td>${rosterPlayer.jersey}</td>
       						<td>${rosterPlayer.player.lastName}</td>
       						<td>${rosterPlayer.player.firstName}</td>
       						<td>${rosterPlayer.position}</td>
       						<td>${rosterPlayer.player.height}</td>
       						<td>${rosterPlayer.player.weight}</td>
       						<td>${rosterPlayer.player.city}</td>
       						<td>${rosterPlayer.player.state_province}</td>
       						<td>${rosterPlayer.player.school}</td>
       					</tr>
                	</tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>