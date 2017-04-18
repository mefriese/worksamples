<%@include file="htmlheader.jsp" %>

<h1>Powers Overview:</h1>

<c:forEach items="${powerlist}" var="item">
    <div class="datapagepanel">
        <div class="row">
            <h3><a href="${pageContext.request.contextPath}/power?selected=${item.name}">${item.name}</a></h3>
        </div>
        <div class="row">
            <div class="col-xs-3">
                    <h4>Description:</h4>
                    <p>${item.desc}</p>
            </div>
            <div class="col-xs-4">
                    <ul><b>Role:</b> ${item.role}</ul>
                    <ul><b>Usefulness Rating:</b> ${item.usefulnessRating}</ul>
                    <ul><b>Coolness Rating:</b> ${item.coolnessRating}</ul>
            </div>
            <div class="col-xs-5">
                <p><b>Heroes known to possess this power:</b></p>
                <ul>
                    <c:forEach items="${item.heroesWith}" var="herowith">
                        <li><a href="${pageContext.request.contextPath}/hero?selected=${herowith}">${herowith}</a></li>
                        </c:forEach>
                </ul>    
            </div>
        </div>
    </div>
</c:forEach>

<%@include file="htmlfooter.jsp" %>