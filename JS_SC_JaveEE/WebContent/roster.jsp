<%-- 
    roster.jsp
	Created On: June 15th 23016
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
            	<c:choose>
            		<c:when test="${teamName == ''}">
            			<h1 style="color: red">No team found</h1>
            		</c:when>
            		<c:otherwise>
            		<h1>Roster of the ${teamName}</h1>
            		</c:otherwise>
            	</c:choose>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h3>Staff</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Title</th>
                			<th>Last Name</th>
                			<th>First Name</th>
                		</tr>             		
                	</thead>
                	<tbody>
               			<tr>     
               				<td>Head Coach</td>
               				<td>${headCoach.lastName}</td>
               				<td>${headCoach.firstName}</td>          				
               			</tr>
               			<tr>     
               				<td>Assistant Coach</td>
               				<td>${asstCoach.lastName}</td>
               				<td>${asstCoach.firstName}</td>
               			</tr>
               			<tr>     
               				<td>Head Trainer</td>
               				<td>${trainer.lastName}</td>
               				<td>${trainer.firstName}</td>
               			</tr>
               			<tr>     
               				<td>General Manager</td>
               				<td>${manager.lastName}</td>
               				<td>${manager.firstName}</td>
               			</tr>
                	</tbody>
                </table>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h3>Forwards</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Jersey Number</th>
                			<th>Last Name</th>
                			<th>First Name</th>
                			<th>Position</th>
                			<th>Height</th>
                			<th>Weight</th>
                			<th></th>
                			
                		</tr>             		
                	</thead>
                	<tbody>
                		<c:forEach items="${forward}" var="rosterPlayer">
                			<tr>     
                				<td>${rosterPlayer.jersey}</td>
                				<td>${rosterPlayer.player.lastName}</td>
                				<td>${rosterPlayer.player.firstName}</td>
                				<td>${rosterPlayer.position}</td>
                				<td>${rosterPlayer.player.height}</td>
                				<td>${rosterPlayer.player.weight}</td>
                				<td><a href="player?playerid=${rosterPlayer.player.playerId}">See Player</a></td>
                			</tr>
                		</c:forEach>
                	</tbody>
                </table>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h3>Defence</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Jersey Number</th>
                			<th>Last Name</th>
                			<th>First Name</th>
                			<th>Position</th>
                			<th>Height</th>
                			<th>Weight</th>
                			<th></th>
                		</tr>             		
                	</thead>
                	<tbody>
                		<c:forEach items="${defence}" var="rosterPlayer">
                			<tr>     
                				<td>${rosterPlayer.jersey}</td>
                				<td>${rosterPlayer.player.lastName}</td>
                				<td>${rosterPlayer.player.firstName}</td>
                				<td>${rosterPlayer.position}</td>
                				<td>${rosterPlayer.player.height}</td>
                				<td>${rosterPlayer.player.weight}</td>
                				<td><a href="player?playerid=${rosterPlayer.player.playerId}">See Player</a></td>
                			</tr>
                		</c:forEach>
                	</tbody>
                </table>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h3>Goal Tending</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <table class="table table-striped">
                	<thead>
                		<tr>
                			<th>Jersey Number</th>
                			<th>Last Name</th>
                			<th>First Name</th>
                			<th>Position</th>
                			<th>Height</th>
                			<th>Weight</th>
                			<th></th>
                		</tr>             		
                	</thead>
                	<tbody>
                		<c:forEach items="${goalie}" var="rosterPlayer">
                			<tr>     
                				<td>${rosterPlayer.jersey}</td>
                				<td>${rosterPlayer.player.lastName}</td>
                				<td>${rosterPlayer.player.firstName}</td>
                				<td>${rosterPlayer.position}</td>
                				<td>${rosterPlayer.player.height}</td>
                				<td>${rosterPlayer.player.weight}</td>
                				<td><a href="player?playerid=${rosterPlayer.player.playerId}">See Player</a></td>
                			</tr>
                		</c:forEach>
                	</tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>