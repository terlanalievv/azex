<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/13/19
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="page-sidebar" id="sidebar">
    <div id="sidebar-collapse">
        <div class="admin-block d-flex">
            <div>
                <img src="./assets/img/admin-avatar.png" width="45px" />
            </div>
            <div class="admin-info">
                <div class="font-strong">${sessionScope.user.name}&nbsp;${sessionScope.user.surname}</div><small>Administrator</small></div>
        </div>
        <ul class="side-menu metismenu">
            <li>
                <a class="active" href="admin?action=dashboard"><i class="sidebar-item-icon fa fa-th-large"></i>
                    <span class="nav-label">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="admin?action=addresses"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Xaricdeki unvanlar</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=customers"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Musteriler</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=orders"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Sifarisler</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=urgentorders"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Tecili sifarisler()</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=normalorders"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Linkli sifarisler()</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=shops"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Magazalar</span><i class="fa "></i></a>
            </li>
            <li>
                <a href="admin?action=messages"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Mesajlar</span><i class="fa "></i></a>
            </li>

            <li>
                <a href="javascript:;"><i class="sidebar-item-icon fa fa-edit"></i>
                    <span class="nav-label">Anbar</span><i class="fa fa-angle-left arrow"></i></a>
                <ul class="nav-2-level collapse">
                    <li>
                        <a href="admin?action=stock">Anbar esas sehife</a>
                    </li>
                    <li>
                        <a href="admin?action=delivered">Tehvil verilenler</a>
                    </li>
                    <li>
                        <a href="admin?action=approved">Kassadan gelenler</a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</nav>
