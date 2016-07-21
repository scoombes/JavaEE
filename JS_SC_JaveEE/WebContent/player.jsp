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
                	</tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>