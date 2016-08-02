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
            	<h1>${rosterPlayer.player.firstName} ${rosterPlayer.player.lastName}</h1>
            </div>
            <div class="col-lg-12 col-md-12 text-center">
	            <div class="col-lg-6 col-md-6 text-center">
	                <h2>Details</h2>
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
	            <div class="col-lg-6 col-md-6 text-center">
	                <h2>Player Stats</h2>
	                <table class="table table-striped">
	                	<tbody>
	                        <tr>
	                            <th>Games Played</th>
	                            <td>${playerStats.gp}</td>
	                        </tr>
	               			<tr>
	                            <th>Goals</th>
	       						<td>${playerStats.goals}</td>
	       					</tr>
	                        <tr>
	                            <th>Assists</th>
	                            <td>${playerStats.assists}</td>
	                        </tr>
	                        <tr>
	                            <th>Plus/Minus</th>
	                            <td>${playerStats.plusMinus}</td>
	                        </tr>
	                        <tr>
	                            <th>Penalty Minutes</th>
	                            <td>${playerStats.pim}</td>
	                        </tr>
	                        <tr>
	                            <th>Power Play Goals</th>
	                            <td>${playerStats.pp}</td>
	                        </tr>
	                        <tr>
	                            <th>Short Handed Goals</th>
	                            <td>${playerStats.sh}</td>
	                        </tr>
	                        <tr>
	                            <th>Shoot Out Goals Goals</th>
	                            <td>${playerStats.so}</td>
	                        </tr>
	                        <tr>
	                            <th>Game Winning Goals</th>
	                            <td>${playerStats.gwg}</td>
	                        </tr>
	                        <tr>
	                            <th>Shots</th>
	                            <td>${playerStats.shots}</td>
	                        </tr>
	                        <tr>
	                            <th>Shot Percentage</th>
	                            <td>${playerStats.shotpct}</td>
	                        </tr>
	                        <tr>
	                            <th>Suspensions</th>
	                            <td>${playerStats.suspensions}</td>
	                        </tr>
	                        <tr>
	                            <th>Goals Against Average</th>
	                            <td>${playerStats.gaa}</td>
	                        </tr>    
	                	</tbody>
	                </table>
	            </div>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>