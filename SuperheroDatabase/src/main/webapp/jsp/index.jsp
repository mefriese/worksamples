<%@include file="htmlheader.jsp" %>
<div class="row">
    <h1>Home - Superhero Database</h1>
</row>
<div class="row">
    <div class="datablock col-xs-4">
        <h3><a href="${pageContext.request.contextPath}/heroes">Known Heroes:</a></h3>
        <ul>
            <c:forEach items="${herolist}" var="item">
                <li><a href="${pageContext.request.contextPath}/hero?selected=${item}">${item}</a></li>
                </c:forEach>
                <c:if test="${empty herolist}"><li>No Registered Heroes</li></c:if>
        </ul>
    </div>

    <div class="datablock col-xs-4">
        <h3><a href="${pageContext.request.contextPath}/powers">Powers</a></h3>
        <ul>
            <c:forEach items="${powerlist}" var="item">
                <li><a href="${pageContext.request.contextPath}/power?selected=${item}">${item}</a></li>
            </c:forEach>
                    <c:if test="${empty powerlist}"><li>No Registered Powers</li></c:if>
        </ul>
    </div>

    <div class="datablock col-xs-4">
        <h3><a href="${pageContext.request.contextPath}/orgs">Locations of Interest</a></h3>
        <ul>
            <c:forEach items="${loclist}" var="item">
                <li>${item}</li>
            </c:forEach>
                <c:if test="${empty loclist}"><li>No Registered Locations</li></c:if>
        </ul>
    </div>


</div>

<div class="row">
    <div class="datablock col-xs-4">
        <h3><a href="${pageContext.request.contextPath}/orgs">Organizations</a></h3>
        <ul>
            <c:forEach items="${orglist}" var="item">
                <li>${item}</li>
            </c:forEach>
                <c:if test="${empty orglist}"><li>No Registered Organizations</li></c:if>
        </ul>
    </div>

    <div class="datablock col-xs-4">
        <h3><a href="${pageContext.request.contextPath}/sightings">Sightings</a></h3>
        <ul>
            <c:forEach items="${sightlist}" var="item">
                <li>${item}</li>
            </c:forEach>
            <c:if test="${empty sightlist}"><li>No Recorded Sightings</li></c:if>
        </ul>
    </div>

    <div class="datablock col-xs-4">
        <h3>Additional Resources</h3>
        <ul>
            <li>Search</li>
            <li>Provide Information</li>
            <li>Civilians</li>
        </ul>
    </div>
</div>
<%@include file="htmlfooter.jsp" %>

