<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/> 
<div class="navbar navbar-fixed-bottom">
    <footer class="page-footer blue center-on-small-only">

        <!--Footer Links-->
        <div class="container-fluid">
            <div class="row">
                &copy; Copyright - <fmt:formatDate value="${now}" dateStyle="long"/> -  TOBA
            </div>
        </div>
    </footer>
</div>
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.js"></script>

    <script type="text/javascript">
    jQuery(document).ready(function($){
        var url = window.location.href;
        $('.nav a[href="'+url+'"]').parent().addClass('active');
    });
</script>

