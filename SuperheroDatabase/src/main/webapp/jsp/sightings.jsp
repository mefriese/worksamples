<%@include file="htmlheader.jsp" %>
<h1>List of Sightings</h1>
<c:forEach items="${allsightings}" var="item">
    <div class="datapagepanel">
        <div class="row">
            <div class="col-xs-12">
                <h3>Sighting #${item.index}</h3>
                <h4>Date: ${item.date}</h4>
                <h4>Description:</h4>
                <p>${item.description}</p>
                <h4>Heroes Seen</h4>
                <ul>
                <c:forEach items="${item.heroesAt}" var="present"><li><a href="${pageContext.request.contextPath}/hero?selected=${present}">${present}</a></li></c:forEach>
                <c:if test="${empty item.heroesAt}"><li>None Recorded</li></c:if>
                </ul>
            </div>
        </div>
    </div>
</c:forEach>

<%@include file="htmlfooter.jsp" %>