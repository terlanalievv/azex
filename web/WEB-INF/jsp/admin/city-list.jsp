<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/13/19
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <div class="page-brand">
            <a class="link" href="index.html">
                <span class="brand">AZEX</span>
            </a>
        </div>
        <div class="flexbox flex-1">
            <!-- START TOP-LEFT TOOLBAR-->
            <ul class="nav navbar-toolbar">
                <li>
                    <a class="nav-link sidebar-toggler js-sidebar-toggler"><i class="ti-menu"></i></a>
                </li>
                <li>
                    <form class="navbar-search" action="javascript:;">
                        <div class="rel">
                            <span class="search-icon"><i class="ti-search"></i></span>
                            <input class="form-control" placeholder="Search here...">
                        </div>
                    </form>
                </li>
            </ul>
            <!-- END TOP-LEFT TOOLBAR-->
            <!-- START TOP-RIGHT TOOLBAR-->
            <ul class="nav navbar-toolbar">
                <li class="dropdown dropdown-inbox">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope-o"></i>
                        <span class="badge badge-primary envelope-badge">9</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right dropdown-menu-media">
                        <li class="dropdown-menu-header">
                            <div>
                                <span><strong>9 New</strong> Messages</span>
                                <a class="pull-right" href="mailbox.html">view all</a>
                            </div>
                        </li>
                        <li class="list-group list-group-divider scroller" data-height="240px" data-color="#71808f">
                            <div>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <img src="./assets/img/users/u1.jpg"/>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-strong"></div>
                                            Jeanne Gonzalez
                                            <small class="text-muted float-right">Just now</small>
                                            <div class="font-13">Your proposal interested me.</div>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <img src="./assets/img/users/u2.jpg"/>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-strong"></div>
                                            Becky Brooks
                                            <small class="text-muted float-right">18 mins</small>
                                            <div class="font-13">Lorem Ipsum is simply.</div>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <img src="./assets/img/users/u3.jpg"/>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-strong"></div>
                                            Frank Cruz
                                            <small class="text-muted float-right">18 mins</small>
                                            <div class="font-13">Lorem Ipsum is simply.</div>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <img src="./assets/img/users/u4.jpg"/>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-strong"></div>
                                            Rose Pearson
                                            <small class="text-muted float-right">3 hrs</small>
                                            <div class="font-13">Lorem Ipsum is simply.</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown dropdown-notification">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell-o rel"><span
                            class="notify-signal"></span></i></a>
                    <ul class="dropdown-menu dropdown-menu-right dropdown-menu-media">
                        <li class="dropdown-menu-header">
                            <div>
                                <span><strong>5 New</strong> Notifications</span>
                                <a class="pull-right" href="javascript:;">view all</a>
                            </div>
                        </li>
                        <li class="list-group list-group-divider scroller" data-height="240px" data-color="#71808f">
                            <div>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <span class="badge badge-success badge-big"><i
                                                    class="fa fa-check"></i></span>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-13">4 task compiled</div>
                                            <small class="text-muted">22 mins</small>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <span class="badge badge-default badge-big"><i
                                                    class="fa fa-shopping-basket"></i></span>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-13">You have 12 new orders</div>
                                            <small class="text-muted">40 mins</small>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <span class="badge badge-danger badge-big"><i class="fa fa-bolt"></i></span>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-13">Server #7 rebooted</div>
                                            <small class="text-muted">2 hrs</small>
                                        </div>
                                    </div>
                                </a>
                                <a class="list-group-item">
                                    <div class="media">
                                        <div class="media-img">
                                            <span class="badge badge-success badge-big"><i
                                                    class="fa fa-user"></i></span>
                                        </div>
                                        <div class="media-body">
                                            <div class="font-13">New user registered</div>
                                            <small class="text-muted">2 hrs</small>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown dropdown-user">
                    <a class="nav-link dropdown-toggle link" data-toggle="dropdown">
                        <img src="./assets/img/admin-avatar.png"/>
                        <span></span>${sessionScope.user.name}&nbsp;${sessionScope.user.surname}<i
                            class="fa fa-angle-down m-l-5"></i></a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="customer?action=profile"><i class="fa fa-user"></i>Profile</a>
                        <a class="dropdown-item" href="profile.html"><i class="fa fa-cog"></i>Settings</a>
                        <a class="dropdown-item" href="javascript:;"><i class="fa fa-support"></i>Support</a>
                        <li class="dropdown-divider"></li>
                        <a class="dropdown-item" href="logout"><i class="fa fa-power-off"></i>Logout</a>
                    </ul>
                </li>
            </ul>
            <!-- END TOP-RIGHT TOOLBAR-->
        </div>
    </header>
    <!-- END HEADER-->
    <!-- START SIDEBAR-->
    <jsp:include page="/WEB-INF/jsp/customer/menu.jsp"/>
    <!-- END SIDEBAR-->
    <div class="content-wrapper">
        <!-- START PAGE CONTENT-->
        <div class="page-heading">
            <h1 class="page-title">DataTables</h1>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html"><i class="la la-home font-20"></i></a>
                </li>
                <li class="breadcrumb-item">DataTables</li>
            </ol>
        </div>
        <div class="page-content fade-in-up">
            <div class="ibox">
                <div class="ibox-head">
                    <div class="ibox-title">Sheherler</div>
                </div>
                <div class="ibox-body">


                    <table class="table table-striped table-bordered table-hover" id="city-table" cellspacing="0"
                           width="100%">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Id</th>
                            <th>Sheher ID</th>
                            <th>Sheher Adi</th>
                            <th>Elave olunma tarixi</th>
                        </tr>
                        </thead>

                    </table>
                </div>
            </div>
            <div>
                <a class="adminca-banner" href="http://admincast.com/adminca/" target="_blank">
                    <div class="adminca-banner-ribbon"><i class="fa fa-trophy mr-2"></i>PREMIUM TEMPLATE</div>
                    <div class="wrap-1">
                        <div class="wrap-2">
                            <div>
                                <img src="./assets/img/adminca-banner/adminca-preview.jpg"
                                     style="height:160px;margin-top:50px;"/>
                            </div>
                            <div class="color-white" style="margin-left:40px;">
                                <h1 class="font-bold">ADMINCA</h1>
                                <p class="font-16">Save your time, choose the best</p>
                                <ul class="list-unstyled">
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>High Quality Design</li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Fully Customizable and Easy Code
                                    </li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Bootstrap 4 and Angular 5+</li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Best Build Tools: Gulp, SaSS, Pug...
                                    </li>
                                    <li><i class="ti-check m-r-5"></i>More layouts, pages, components</li>
                                </ul>
                            </div>
                        </div>
                        <div style="flex:1;">
                            <div class="d-flex justify-content-end wrap-3">
                                <div class="adminca-banner-b m-r-20">
                                    <img src="./assets/img/adminca-banner/bootstrap.png"
                                         style="width:40px;margin-right:10px;"/>Bootstrap v4
                                </div>
                                <div class="adminca-banner-b m-r-10">
                                    <img src="./assets/img/adminca-banner/angular.png"
                                         style="width:35px;margin-right:10px;"/>Angular v5+
                                </div>
                            </div>
                            <div class="dev-img">
                                <img src="./assets/img/adminca-banner/sprite.png"/>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <!-- END PAGE CONTENT-->
        <footer class="page-footer">
            <div class="font-13">2018 © <b>AdminCAST</b> - All rights reserved.</div>
            <a class="px-4"
               href="http://themeforest.net/item/adminca-responsive-bootstrap-4-3-angular-4-admin-dashboard-template/20912589"
               target="_blank">BUY PREMIUM</a>
            <div class="to-top"><i class="fa fa-angle-double-up"></i></div>
        </footer>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/paga.jsp"/>

<!-- CORE PLUGINS-->
<jsp:include page="/WEB-INF/jsp/common/script.jsp"/>
<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
<script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL PLUGINS-->
<script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function() {
        $('#city-table').DataTable({
            "serverSide": true,
            "ajax": "admin?action=getFlexibleListItems&name=city"

        });
    })
</script>
</body>

</html>
