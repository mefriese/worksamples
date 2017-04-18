<%@include file="htmlheader.jsp" %>

<div class="row">
    <h1>Organizations and Locations of Interest:</h1>
</div>

<div class="row">
    <div class="col-xs-6">
        <h2>Organizations:</h2>
        <c:forEach items="${orglist}" var="item">
            <div class="datapagepanel">
                <div class="row">
                    <h3><a href="${pageContext.request.contextPath}/org?selected=${item.name}">${item.name}</a></h3>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <h4>Hero Membership:</h4>
                        <ul>
                            <c:forEach items="${item.heroesIn}" var="member">
                                <li><a href="${pageContext.request.contextPath}/hero?selected=${member}">${member}</a></li>
                            </c:forEach>
                        </ul>
                        <h4>Civilian Membership:</h4>
                        <ul>
                            <c:forEach items="${item.civsIn}" var="member">
                                <li>${member}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col-xs-6">
                        <h4>Headquarters:</h4>
                        <ul><li><a href="${pageContext.request.contextPath}/location?selected=${item.headquarters}">${item.headquarters}</a></li></ul>
                        <h5>Other Bases:</h5>
                        <c:forEach items="${item.bases}" var="member">
                            <li><a href="${pageContext.request.contextPath}/location?selected=${member}">${member}</a></li>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="col-xs-6">
        <h2>Locations:</h2>
        <c:forEach items="${loclist}" var="item">
            <div class="datapagepanel">
                <div class="row">
                    <h3>${item.name}</h3>
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <h4>Orgs Present:</h4>
                        <ul>
                            <li>Unknown</li>
                        </ul>
                    </div>
                    <div class="col-xs-8">
                        <ul>
                            <li><b>Description:</b> ${item.desc}</li>
                            <li><b>Address:</b> ${item.address}</li>
                            <li><b>Coords:</b> ${item.longitude}, ${item.latitude}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="htmlfooter.jsp" %>