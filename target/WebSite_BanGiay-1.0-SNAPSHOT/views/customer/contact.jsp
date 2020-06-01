<%-- 
    Document   : contact
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
        <%@include file="/shared/customer/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/shared/customer/nav-bar.jsp" %>
            <div id="colorlib-contact">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h3>Contact Information</h3>
                            <div class="row contact-info-wrap">
                                <div class="col-md-3">
                                    <p><span><i class="icon-location"></i></span> 198 West 21th Street, <br> Suite 721 New York NY 10016</p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-phone3"></i></span> <a href="tel://1234567920">+ 1235 2355 98</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-paperplane"></i></span> <a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-globe"></i></span> <a href="#">yoursite.com</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="contact-wrap">
                                <h3>Get In Touch</h3>
                                <form action="#" class="contact-form">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="fname">First Name</label>
                                                <input type="text" id="fname" class="form-control" placeholder="Your firstname">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Last Name</label>
                                                <input type="text" id="lname" class="form-control" placeholder="Your lastname">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="email">Email</label>
                                                <input type="text" id="email" class="form-control" placeholder="Your email address">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="subject">Subject</label>
                                                <input type="text" id="subject" class="form-control" placeholder="Your subject of this message">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="message">Message</label>
                                                <textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Say something about us"></textarea>
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <input type="submit" value="Send Message" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div id="map" class="colorlib-map" style="background:#f5f5f5;">
                                <img src="~/Content/images/map.png" alt="Alternate Text" height="717px" width="540px"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="/shared/customer/footer.jsp" %>
        </div>
        <script>
            $(document).ready(function(){
               $.each($('ul.nav-menu > li'), function(i,e){
                   
                   e.classList.remove('active');
               });
               
               $('.contact-page').each(function(k,e){
                  e.classList.add('active');
               })
            })
        </script>
    </body>
</html>
