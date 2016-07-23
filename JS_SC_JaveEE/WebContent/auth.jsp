<%-- 
    auth.jsp
	Created On: July 26, 2016
    Sean Coombes & John Steel
--%>
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
                <h1>Auth page</h1>
                <p class="lead">You had better auth!</p>
                <p style="color:red">${message}</p>
                <form method='post'>
                 <label>
                        Username
                        <input type='text' id="username" name="username" />
                    </label>
                    <br>
                    <label>
                        Password
                        <input type='password' id="password" name="password" />
                    </label>
                    <br>
                    <button>Go and do the thing</button>
                </form>
            </div>
        </div>
    </jsp:body>
</t:bootstrappage>