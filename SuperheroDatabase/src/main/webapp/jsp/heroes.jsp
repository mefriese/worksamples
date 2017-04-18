<%@include file="htmlheader.jsp" %>


<div class="col-xs-8">
    <h1>Heroes Overview:</h1>
<c:forEach items="${herolist}" var="item">
    <div class="datapagepanel">
        <div class="row">
            <div class="col-xs-12">
                <h3><a href="${pageContext.request.contextPath}/hero?selected=${item.name}">${item.name}</a></h3>
            <p><i>${item.description}</i></p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <h4>Known Powers:</h4>
                <ul>
                    <c:forEach items="${item.powers}" var="powah"><li><a href="${pageContext.request.contextPath}/power?selected=${powah}">${powah}</a></li></c:forEach>
                    <c:if test="${empty item.powers}"><li>None Known</li></c:if>
                </ul>
            </div>
            <div class="col-xs-6">
                <h4>Organizations:</h4>
                <ul>
                    <c:forEach items="${item.orgs}" var="powah"><li><a href="${pageContext.request.contextPath}/org?selected=${powah}">${powah}</a></li></c:forEach>
                    <c:if test="${empty item.orgs}"><li>None Known</li></c:if>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <h4>Sightings:</h4>
                <ul>
                <c:forEach items="${item.sightings}" var="powah"><li><a href="${pageContext.request.contextPath}/sighting?selected=${powah}">Sighting #${powah}</a></li></c:forEach>
                    <c:if test="${empty item.sightings}"><li>None Recorded</li></c:if>
                </ul>
            </div>
            <div class="col-xs-6">
                <h4>Notes:</h4>
                <ul>
                    <li>Real Name: ${item.realname}</li>
                    <li>Moral Alignment: ${item.morality}</li>
                </ul>
            </div>
        </div>
    </div>
</c:forEach>
</div>
<div class="col-xs-4">
    <h1>Civilians</h1>
    <c:forEach items="${civillist}" var="item">
        <div class="datapagepanel">
        <div class="row">
            <div class="col-xs-12">
                <h4><a href="${pageContext.request.contextPath}/civilian?selected=${item.name}">${item.name}</a></h4>
                <h5>Known Organization Affiliations:</h5>
                <ul>
                    <c:forEach items="${item.orgs}" var="civorgs">
                        <li><a href="${pageContext.request.contextPath}/org?selected=${civorgs}">${civorgs}</a></li>
                    </c:forEach>
                        <c:if test="${empty item.orgs}"><li>None Known - why is this person even listed if they're neither a superhero or affiliated with any super-organizations?</li></c:if>
                </ul>
                <p><b>Description:</b> ${item.description}</p>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="htmlfooter.jsp" %>