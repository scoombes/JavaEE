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
            <div class="col-lg-4"></div>
            <div class="col-lg-4 col-md-12 text-center">
                <table class="table table-striped">
                	<tbody>
                        <tr>
                            <th>Jersey</th>
                            <td>${rosterPlayer.jersey}</td>
                        </tr>
               			<tr>
                            <th>Last Name</th>
       						<td>${rosterPlayer.player.lastName}</td>
       					</tr>
                        <tr>
                            <th>First Name</th>
                            <td>${rosterPlayer.player.firstName}</td>
                        </tr>
                        <tr>
                            <th>Position</th>
                            <td>${rosterPlayer.position}</td>
                        </tr>
                        <tr>
                            <th>Height</th>
                            <td>${rosterPlayer.player.height}</td>
                        </tr>
                        <tr>
                            <th>Weight</th>
                            <td>${rosterPlayer.player.weight}</td>
                        </tr>
                        <tr>
                            <th>Hometown</th>
                            <td>${rosterPlayer.player.city}</td>
                        </tr>
                        <tr>
                            <th>Province/State</th>
                            <td>${rosterPlayer.player.state_province}</td>
                        </tr>
                        <tr>
                            <th>School</th>
                            <td>${rosterPlayer.player.school}</td>
                        </tr>
                	</tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>