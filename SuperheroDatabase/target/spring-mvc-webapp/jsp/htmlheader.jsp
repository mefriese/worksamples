<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Superhero Database</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/stylesheet.css" rel="stylesheet">
         
    </head>
    <body>
        <div id="wrapper">

            <div class ="row" id="mainHeading">
                <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/banner.png" id="bannerImg"/></a>
            </div>

            <div class="row" id="navbardiv">
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></div>
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/heroes">Heroes & Civilians</a></div>
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/powers">Powers</a></div>
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/orgs">Organizations & Locations</a></div>
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/search">Search & Look Up</a></div>
                <div class="navbar col-xs-2"><a href="${pageContext.request.contextPath}/addnew">Submit Data</a></div>
            </div>

            <div id="contentdiv"> 