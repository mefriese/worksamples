<%@include file="htmlheader.jsp" %>
<div class="row">
    <h2>Hero Detailed View:</h2>
    <h1 id="selhero">${selected.name}</h1>
</div>

<div class="row">
    <h4>Real Name: ${selected.realname}</h4>
    <h4>Overview: ${selected.description}</h4>
    <h4>Moral Alignment: ${selected.morality}</h4>
    <h4>Known Powers:</h4>
    <ul>
        <c:forEach items="${selected.powers}" var="powah"><li><a href="${pageContext.request.contextPath}/power?selected=${powah}">${powah}</li></a></c:forEach>
        <c:if test="${empty selected.powers}"><li>None Known</li></c:if>
        </ul>
        <h4>Known Affiliations:</h4>
        <ul>
        <c:forEach items="${selected.orgs}" var="powah"><li>${powah}</li></c:forEach>
        <c:if test="${empty selected.orgs}"><li>None Known</li></c:if>
        </ul>
        <h4>Instances of Sighting:</h4>
        <ul>
        <c:forEach items="${selected.sightings}" var="powah"><li>Sighting #${powah}</li></c:forEach>
        <c:if test="${empty selected.sightings}"><li>None Recorded</li></c:if>
        </ul>

        <p><br><br>Edit this Entry</p>
        
    </div>


<%@include file="htmlfooter.jsp" %>