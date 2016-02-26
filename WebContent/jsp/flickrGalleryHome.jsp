<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
	<jsp:include page="pageImports.jsp" flush="true"></jsp:include>
<style>
#searchResults{
	visibility: hidden;
}
</style>
<script type="text/javascript">
function findPhotosByTag(tag) {
	
	if (tag) {
		$.ajax({
			url : '${findPhotosByTagURL}'+tag,
			dataType : "json",
			type : "GET",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(result) {
						displaySearchResults(result);
					},
			error : function(XMLHttpRequest, textStatus,errorThrown) {}
		});
	};
}

function hideInitialGallery(){
	$("#initialGallery").hide();
}


function displaySearchResults(jsonList) {
	var i=1;
	$.each(jsonList, function(id, desc) {
				
				var photoItem = $.parseJSON(desc);
				$("#searchResults").append('<li class="span3 gallery-item" data-type="illustration"> <div style="/text-align:left; height:400px; width:300px; overflow: hidden;/"> <a href='+photoItem['link']+' target="/_blank/"><img src='+photoItem['media']['m'] +' alt="/Gallery/"></a><br/>'
				+ '<a href="#">'+photoItem['title']+'</a> by <a href=#>'+photoItem['author']+'</a><br/>'
                + '<div><p>Description : contained html code with same image above</p></div>'
				+ '<div>Tags : '+photoItem['tags']+'</div></div></li>');
				i=i+1;
			});
	
	hideInitialGallery();
	$("#searchResults").addClass("gallery-post-grid").addClass("holder");
	$("#searchResults").css('visibility', 'visible');
	
}

$(document).ready(function() {
});
</script>
</head>

<body>
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">
    
      <div class="row header"><!-- Begin Header -->
      
        <!-- Logo
        ================================================== -->
        <div class="span5 logo">
        <h1><a href="/flickrgallery/">
        		Flickr Gallery
        	<!-- <img src="img/piccolo-logo.png" alt="" /> --></a>
            </h1>
        	<!-- <h5>Big Things... Small Packages</h5> -->
        </div>
        
        <!-- Main Navigation
        ================================================== -->
        <div class="span7 navigation">
            <div class="navbar hidden-phone">
            </div>

            <!-- Mobile Nav
            ================================================== -->
            <form action="#" id="mobile-nav" class="visible-phone">
                <div class="mobile-nav-select">
                </div>
             </form>
            
       </div>

      </div><!-- End Header -->
     
    <!-- Page Content
    ================================================== --> 
    <div class="row">

        <!-- Gallery Items
        ================================================== --> 
        <div class="span12 gallery">
            
            <span class="span12" style="margin-left: -2px; border-bottom: dotted thick orange;">
            	
            </span>

            <div class="row clearfix">
                <ul class="gallery-post-grid holder" id="initialGallery">
	                <c:set var="count" value="0" scope="page"/>
	                <c:forEach items="${photoItems}" var="item" varStatus="i">
	                	<li class="span3 gallery-item" data-id="id-${i.count}" data-type="illustration">
							<div style="text-align:left; height:400px; width:300px; overflow: hidden;">
		                        <a href="${item.link}" target="_blank"><img src="${item.media.m}" alt="Gallery"></a><br/>
		                        <a href=#>${item.title}</a> by <a href=#>${item.author}</a><br/>
		                        <div>
									<p>Description : contained html code with same image above</p>  
								</div>
								<div>Tags : 
									 <c:forEach var="tag" items="${fn:split(item.tags, ' ')}">
		                        		<a href="javascript:void(0);" onclick="javascript:findPhotosByTag('${tag}');"><c:out value="${tag}" />,</a>  
		                    		</c:forEach>
								</div>
							</div>
	                    </li>
	                </c:forEach>
                </ul>
                
                <ul class="gallery-post-grid holder" id="searchResults">
                                    
                </ul>
            </div>

        </div><!-- End gallery list-->

    </div><!-- End container row -->
    
    </div> <!-- End Container -->

    <!-- Footer Area
        ================================================== -->
	<div class="footer-container"><!-- Begin Footer -->
    	<div class="container">
        	<div class="row footer-row">
                <div class="span3 footer-col">
                    <h5><a href="mailto:sh.passang@gmail.com">Feedbacks</a></h5>
				</div>
            </div>
        </div>
    </div><!-- End Footer -->

    <!-- Scroll to Top -->  
    <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
    
</body>
</html>