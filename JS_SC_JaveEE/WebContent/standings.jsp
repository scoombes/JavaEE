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
                <h1>Standings!</h1>
                <p>Okay!</p>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>