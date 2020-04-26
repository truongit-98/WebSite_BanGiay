<%-- 
    Document   : about
    Created on : Apr 18, 2020, 10:45:19 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="colorlib-about">
                <div class="container">
                    <div class="row row-pb-lg">
                        <div class="col-sm-6 mb-3">
                            <div class="video colorlib-video" style="background-image: url(images/about.jpg);">
                                <img src="<c:url value="/resources/images/about.jpg" />" alt="Alternate Text" width="550px"/>
                                <a href="https://vimeo.com/channels/staffpicks/93951774" class="popup-vimeo"><i class="icon-play3"></i></a>
                                <div class="overlay"></div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="about-wrap">
                                <h2>Footwear the leading eCommerce Store around the Globe</h2>
                                <p>The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way.</p>
                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="/shared/footer.jsp" %>                        
        <script>
           $(document).ready(function(){
               $.each($('ul.nav-menu > li'), function(i,e){
                   e.classList.remove('active');
               });
               
               $('.about-page').each(function(k,e){
                  e.classList.add('active');
               })
            })
        </script>
    </body>
</html>
