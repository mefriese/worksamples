<%@include file="htmlheader.jsp" %>

<div class="row">
    <h1>Provide Data</h1>
    <h2>${status}</h2>
</div>
<div class="row">
    <div class="datapagepanel">
        <p>Note: Fields marked with an Asterisk are required to submit an entry. Editing is not yet available on this page: go to an entry's specific detail page to make edits.</p>
    </div>
</div>
<div class="row">
    <div class="datapagepanel">
        <div class="row">
            <form id="sightinginput" name="sightinginput" action="${pageContext.request.contextPath}/newsight" method="post">
                <div class="col-xs-4">
                    <h2>Record a sighting:</h2>
                    <p>*Date of Sighting:
                    <nobr><select name="datemonth" required><option value="">  </option>
                            <c:forEach var="i" begin="1" end="12"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                            </select> /
                            <select name="dateday" required><option value="">  </option>
                            <c:forEach var="i" begin="1" end="31"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                            </select> /
                            <select name="datecentury" required><option value="">  </option>
                            <c:forEach var="i" begin="19" end="21"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                            </select>
                            <select name="datedecade" required><option value="">  </option>
                            <c:forEach var="i" begin="0" end="9"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                            </select>
                            <select name="dateyear" required><option value="">  </option>
                            <c:forEach var="i" begin="0" end="9"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                            </select>
                        </nobr>
                        </p>
                        <p>Location: <select id="sightingloc" name="sightingloc" required>
                                <option value=""></option>
                                <option value="Unknown">Unknown</option>
                            <c:forEach items="${locationoptions}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                        &emsp;
                    </p>
                </div>
                <div class="col-xs-4">
                    <h3>Heroes Present:</h3>
                    <c:forEach items="${herooptions}" var="item">
                        <nobr>&emsp;<input type="checkbox" name="heroesatsighting" value="${item}">${item}</nobr>
                        </c:forEach>

                </div>
                <div class="col-xs-4">
                    <h3>*Description:</h3>
                    <input type="text" id="loclonginput" name="sightdescinput" required>
                    &emsp;
                </div>
                <input type="submit">
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-xs-6">
        <div class="datapagepanel">
            <h2>Add Hero</h2>
            <form name="heroinput" id="heroinput" action="${pageContext.request.contextPath}/newhero" method="post">
                <ul>
                    <li>*Hero Name: <input type="text" id="heronameinput" name="heronameinput" maxlength="20" required></li>
                    <li>Real Name: <input type="text" id="herorealinput" name="herorealinput" maxlength="30"></li>
                    <li>Description: <input type="text" id="herodescinput" name="herodescinput"></li>
                    <li>Moral Alignment: <input type="text" id="heroalininput" name="heroalininput"></li>
                    <li>Power<sup>1</sup>: <select id="heropowerinput" name="heropowerinput">
                            <option value="Unknown">Unknown</option>
                            <c:forEach items="${pwroptions}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select></li>
                    <li>Organization<sup>1</sup>: <select id="heroorginput" name="heroorginput">
                            <option value="Unknown">Unknown</option>
                            <c:forEach items="${orgoptions}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select></li>
                </ul>
                <input type="submit">
            </form>
        </div>
    </div>
    <div class="col-xs-6">
        <div class="datapagepanel">
            <h2>Add Power</h2>
            <form name="powerinput" id="powerinput" action="${pageContext.request.contextPath}/newpower" method="post">
                <li>*Power Name: <input type="text" id="powernameinput" name="powernameinput" required></li>
                <li>Power Role: <input type="text" id="powerroleinput" name="powerroleinput"></li>
                <li>Power Description: <input type="text" id="powerdescinput" name="powerdescinput"></li>
                <li>Coolness Rating: <select name="coolnessinput"><option value="0">  </option>
                        <c:forEach var="i" begin="1" end="10"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                        </select></li>
                    <li>Usefulness Rating: <select name="usefulnessinput"><option value="0">  </option>
                        <c:forEach var="i" begin="1" end="10"> <option value='<c:out value="${i}" />'><c:out value="${i}" /></option> </c:forEach>
                        </select></li>
                    <li>Heroes shown to have this power:<br>
                    <c:forEach items="${herooptions}" var="item">
                    <nobr> &emsp; <input type="checkbox" name="herowithpower" value="${item}">${item}</nobr>
                    </c:forEach>
                </li>
                <input type="submit">
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <div class="datapagepanel">
                <h2>Add Organization</h2>
                <form name="orginput" id="orginput" action="${pageContext.request.contextPath}/neworg" method="post">
                    <ul>
                        <li>*Organization Name: <input type="text" id="orgnameinput" name="orgnameinput" required></li>
                        <li>Headquarters: <select name="orghqinput" id="orghqinput">
                                <option value="Unknown">Unknown</option>
                                <c:forEach items="${locationoptions}" var="item">
                                    <option value="${item}">${item}</option>
                                </c:forEach>
                            </select></li>
                        <li>Mission Statement: <input type="text" id="orgmissioninput" name="orgmissioninput"></li>
                        <li>Classification: <input type="text" id="orgclassinput" name="orgclassinput"></li>
                        <li>Hero Membership:<br>
                            <c:forEach items="${herooptions}" var="item">
                            <nobr>&emsp;<input type="checkbox" name="orgheroesin" value="${item}">${item}</nobr>
                            </c:forEach>
                        </li>
                        <li>Other Locations where present:<br>
                            <c:forEach items="${locationoptions}" var="item">
                            <nobr>&emsp;<input type="checkbox" name="orglocations" value="${item}">${item}</nobr>
                            </c:forEach>
                        </li> 
                    </ul>
                    <input type="submit">
                </form>
            </div>
        </div>
        <div class="col-xs-6">
            <div class="datapagepanel">
                <h2>Add Location of Interest</h2>
                <form name="locinput" id="locinput" action="${pageContext.request.contextPath}/newloc" method="post">
                    <ul>
                        <li>*Location Name: <input type="text" id="locnameinput" name="locnameinput" required></li>
                        <li>Address: <input type="text" id="locaddrinput" name="locaddrinput"></li>
                        <li>Description: <input type="text" id="locdescinput" name="locdescinput"></li>
                        <li>Latitude: <input type="text" id="loclatinput" name="loclatinput"></li>
                        <li>Longitude: <input type="text" id="loclonginput" name="loclonginput"></li>
                        <li>Organizations present:<br>
                            <c:forEach items="${orgoptions}" var="item">
                            <nobr>&emsp;<input type="checkbox" name="locorglocations" value="${item}">${item}</nobr>
                            </c:forEach>
                        </li>
                    </ul>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="htmlfooter.jsp" %>