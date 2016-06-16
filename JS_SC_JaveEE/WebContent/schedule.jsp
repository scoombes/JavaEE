<%-- 
    schedule.jsp
	Created On: June 15th 23016
    Sean Coombes & John Steel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:bootstrappage>
    <jsp:attribute name="menu">
<style>

    body {
        margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size: 14px;
    }

    #calendar {
        max-width: 900px;
        margin: 0 auto;
    }

</style>

<script type="text/javascript" >
	      window.onload = function(){
	        var $calendar = $("#calendar");
	        if ($calendar[0]) {
	           $calendar.fullCalendar({            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            defaultDate: '2016-05-12',
            editable: true,
            eventLimit: true, // allow "more" link when too many events
});
	           $('#shedule tr').each(function(id, row) {
	               console.log($(row).find('td:eq(1)').text());
	               $calendar.fullCalendar( 'addEventSource', {
	                   title: $(row).find('td:eq(1)').text(),
	                   start: '2015-02-06'
	               });
	           });
	           $calendar.fullCalendar( 'addEventSource', {
    events: [
        {
            title: 'Event1',
            start: '2011-04-04'
        },
        { 
            title: 'Event2',
            start: '2011-05-05'
        }
        // etc...
    ],
    color: 'yellow',   // an option!
    textColor: 'black' // an option!
} );
	        }
	      }
</script>

      <jsp:include page="_menu.jsp" />
    </jsp:attribute>
    <jsp:attribute name="footer">
      <jsp:include page="_footer.jsp" />
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12 text-center">
            	<h1>Scheduled Games</h1>
            	<div id='calendar'></div>
                <table id='shedule' class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Date</th>
			        <th>Matchup</th>
			        <th>Arena</th>
			      </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${upcoming}" var="game">
                			<tr>
                				<td>${game.gamedate}</td>
                				<td>${game.visitor} @ ${game.home}</td>
                				<td>${game.arena}</td>
                			</tr>
                		</c:forEach>
			    </tbody>
			  </table>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>