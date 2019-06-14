<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/13/19
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/jsp/common/meta.jsp"/>
    <title>Customer index</title>
    <!-- GLOBAL MAINLY STYLES-->
    <jsp:include page="/WEB-INF/jsp/common/css.jsp"/>
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />

</head>

<body class="fixed-navbar">
<div class="page-wrapper">
    <!-- START HEADER-->
    <header class="header">
        <jsp:include page="../../common/brand.jsp"/>
        <div class="flexbox flex-1">
            <!-- START TOP-LEFT TOOLBAR-->
            <jsp:include page="../../common/top-search.jsp"/>
            <!-- END TOP-LEFT TOOLBAR-->

            <!-- START TOP-RIGHT TOOLBAR-->
            <jsp:include page="../../common/top-right-toolbar.jsp"/>
            <!-- END TOP-RIGHT TOOLBAR-->
        </div>
    </header>
    <!-- END HEADER-->
    <!-- START SIDEBAR-->
    <jsp:include page="/WEB-INF/jsp/admin/menu.jsp"/>
    <!-- END SIDEBAR-->
    <div class="content-wrapper">
        <!-- START PAGE CONTENT-->
        <div class="page-heading">
            <h1 class="page-title">Musteriler</h1>
        </div>
        <div class="page-content fade-in-up">
            <div class="ibox">
                <div class="ibox-head">
                    <div class="ibox-title">Musteriler</div>
                </div>
                <div class="ibox-body">


                    <table class="table table-striped table-bordered table-hover" id="customer-table" cellspacing="0"
                           width="100%">
                        <thead>
                        <tr>
                            <th>Musteri</th>
                            <th>Email</th>
                            <th>Sexsiyyet vesiqesi</th>
                            <th>Telefon </th>
                            <th>Status</th>
                            <th>Emeliyyatlar</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Musteri</th>
                            <th>Email</th>
                            <th>Sexsiyyet vesiqesi</th>
                            <th>Telefon </th>
                            <th>Status</th>
                            <th>Emeliyyatlar</th>
                        </tr>
                        </tfoot>

                    </table>
                    <div id="viewCustomer" style="display: none">

                    </div>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTENT-->
       <jsp:include page="../../common/footer.jsp"/>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/paga.jsp"/>

<!-- CORE PLUGINS-->
<jsp:include page="/WEB-INF/jsp/common/script.jsp"/>
<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
<script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL PLUGINS-->
<script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
<%--<script src="./assets/js/admin/customer.js"/>--%>

<script>
    $(document).ready(function () {
        console.log('customer.js loaded');
        createDataTable();

        createDialogs();
    });

    function createDataTable() {
        console.log('create data table');
        $('#customer-table').DataTable({
            "serverSide": true,
            "ajax": "admin?action=searchCustomers",
            "initComplete": function (settings, json) {
                console.log('customer datatable loaded');
                $(".viewCustomer").on('click', function(e){
                    console.log('clicked view customer id = ' + $(this).attr('customer_id'));
                    $("#viewCustomer").load('admin?action=viewCustomer&id=' + $(this).attr('customer_id'), function (e) {
                        console.log('successfully loaded customer data');
                        $("#viewCustomer").dialog('open');
                    })

                });
            }
        });
    }

    function createDialogs() {
        console.log('create view customer dialog');
        $("#viewCustomer").dialog({
            title: 'Musteri Profili',
            autoOpen: false,
            height: 300,
            width: 300,
            modal: true,
            buttons: {
                'Bagla': function() {
                    $(this).dialog("close");
                }
            }
        });
    }
</script>
</body>

</html>
