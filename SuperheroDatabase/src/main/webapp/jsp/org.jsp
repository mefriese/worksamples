<%@include file="htmlheader.jsp" %>
<div class="row">
    <h2>Organization Detailed View:</h2>
    <h1 id="selhero">${selected.name}</h1>
</div>

<div class="row">
    <h4>Mission Statement: ${selected.description}</h4>
    <h4>Description:</h4>
    <p>${selected.description}</p>
    <h4>Headquarters: ${selected.headquarters}</h4>
    <h4>Hero Members:</h4>
    <ul>
        <c:forEach items="${selected.heroesIn}" var="powah"><li><a href="${pageContext.request.contextPath}/hero?selected=${powah}">${powah}</li></a></c:forEach>
        <c:if test="${empty selected.heroesIn}"><li>None Known</li></c:if>
        </ul>
        <h4>Civilian Members:</h4>
    <ul>
        <c:forEach items="${selected.civsIn}" var="powah"><li><a href="${pageContext.request.contextPath}/civilian?selected=${powah}">${powah}</li></a></c:forEach>
        <c:if test="${empty selected.civsIn}"><li>None Known</li></c:if>
        </ul>
        <h4>Known Bases of Operation:</h4>
        <ul>
        <c:forEach items="${selected.bases}" var="powah"><li><a href="${pageContext.request.contextPath}/location?selected=${powah}">${powah}</a></li></c:forEach>
        <c:if test="${empty selected.bases}"><li>None Known</li></c:if>
        </ul>
        <h4>Power Repertoire:</h4>
        <ul>
        <c:forEach items="${powerlibrary}" var="powah"><li><a href="${pageContext.request.contextPath}/location?selected=${powah}">${powah}</a></li></c:forEach>
        <c:if test="${empty powerlibrary}"><li>No known powers at this organization's disposal. That's actually kind of sad.</li></c:if>
        </ul>

        <p><br><br>Edit this Entry</p>
        
    </div>


<%@include file="htmlfooter.jsp" %>