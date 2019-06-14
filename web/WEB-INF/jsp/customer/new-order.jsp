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
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/jvectormap/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>
    <!-- THEME STYLES-->
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
            <h1 class="page-title">Basic Form</h1>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html"><i class="la la-home font-20"></i></a>
                </li>
                <li class="breadcrumb-item">Basic Form</li>
            </ol>
        </div>
        <div class="page-content fade-in-up">

            <div class="ibox">
                <div class="ibox-head">
                    <div class="ibox-title">Yeni Sifarisler</div>
                </div>
                <div class="ibox-body">
                    <form class="form-inline">
                        <div id="order1">
                            <label class="sr-only" for="link1">Mehsulun linki</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="link1" type="text"
                                   placeholder="Mehsulun linki">

                            <label class="sr-only" for="quantity1">Say</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="quantity1" type="number"
                                   placeholder="Say">

                            <label class="sr-only" for="price1">Qiymet</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="price1" type="number"
                                   placeholder="Qiymet">

                            <label class="sr-only" for="service1">Komissiya</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="service1" type="text" placeholder="+5%"
                                   value="+5%" readonly="readonly">

                            <label class="sr-only" for="total1">Cem</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="total1" type="number"
                                   placeholder="Cem">

                            <label class="sr-only" for="note1">Qeyd</label>
                            <%--<input class="form-control mb-2 mr-sm-2 mb-sm-0" id="note1" type="text" placeholder="Qeyd">--%>
                            <textarea id="note1" placeholder="Qeyd" rows="3" cols="30">
                            </textarea>
                        </div>

                        <div id="order2">
                            <label class="sr-only" for="link1">Mehsulun linki</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="link2" type="text"
                                   placeholder="Mehsulun linki">

                            <label class="sr-only" for="quantity1">Say</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="quantity2" type="number"
                                   placeholder="Say">

                            <label class="sr-only" for="price1">Qiymet</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="price2" type="number"
                                   placeholder="Qiymet">

                            <label class="sr-only" for="service1">Komissiya</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="service2" type="text" placeholder="+5%"
                                   value="+5%" readonly="readonly">

                            <label class="sr-only" for="total1">Cem</label>
                            <input class="form-control mb-2 mr-sm-2 mb-sm-0" id="total2" type="number"
                                   placeholder="Cem">

                            <label class="sr-only" for="note1">Qeyd</label>
                            <%--<input class="form-control mb-2 mr-sm-2 mb-sm-0" id="note2" type="text" placeholder="Qeyd">--%>
                            <textarea id="note2" placeholder="Qeyd" rows="3" cols="30">
                            </textarea>
                        </div>

                        <button class="btn btn-success" type="submit">Sifaris ver</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTENT-->
        <jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
    </div>

</div>

<jsp:include page="/WEB-INF/jsp/common/paga.jsp"/>

<!-- CORE PLUGINS-->
<jsp:include page="/WEB-INF/jsp/common/script.jsp"/>
<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
<script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL PLUGINS-->
</body>

</html>
