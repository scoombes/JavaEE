<%-- 
    games.jsp
	Created On: June 15th 23016
    Sean Coombes & John Steel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:bootstrappage>
	<jsp:attribute name="menu">
      <jsp:include page="_menu.jsp" />
    </jsp:attribute>
	<jsp:attribute name="footer">
      <jsp:include page="_footer.jsp" />
    </jsp:attribute>
	<jsp:body>
		<div class="container">		
			<form class="form-horizontal" role="form" method="post">
			
				<div class="form-group">
					<label class="control-label col-sm-2" for="visitorScore">${game.visitor.teamName} Goals:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="visitorScore" name="visitorScore">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="homeScore">${game.home.teamName} Goals:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="homeScore" name="homeScore">
					</div>
				</div>
									
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox" name="OT">OverTime Required:</label>
						</div>
					</div>
				</div>
						
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox" name="SO">Shoot Out Required:</label>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
				<!-- Hidden values -->
				<input type="hidden" value="${teamId}" name="teamId"/>
				<input type="hidden" value="${game.gameId}" name="gameId"/>
	
			</form>
		</div>
    </jsp:body>
</t:bootstrappage>