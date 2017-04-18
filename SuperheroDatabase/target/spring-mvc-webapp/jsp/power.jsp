<%@include file="htmlheader.jsp" %>
<div class="row">
    <h2>Power Detailed View:</h2>
    <h1 id="selhero">${selected.name}</h1>
</div>

<div class="row">
    <h4>Description: ${selected.desc}</h4>
    <h4>Role: ${selected.role}</h4>
    <h4>Coolness Rating: ${selected.coolnessRating}</h4>
    <h4>Viability Rating: ${selected.usefulnessRating}</h4>
    <h4>Heroes who have this Power:</h4>
    <ul>
        <c:forEach items="${selected.heroesWith}" var="herowith">
            <li><a href="${pageContext.request.contextPath}/hero?selected=${herowith}">${herowith}</a></li>
        </c:forEach>
    </ul>

<%@include file="htmlfooter.jsp" %>