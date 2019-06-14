<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="page-sidebar" id="sidebar">
    <div id="sidebar-collapse">
        <div class="admin-block d-flex">
            <div>
                <img src="./assets/img/admin-avatar.png" width="45px" />
            </div>
            <div class="admin-info">
                <div class="font-strong">${sessionScope.user.name}&nbsp;${sessionScope.user.surname}</div><small>Customer</small></div>
        </div>
        <ul class="side-menu metismenu">
            <li>
                <a href="customer?action=addresses"><i class="sidebar-item-icon fa fa-bookmark"></i>
                    <span class="nav-label">Xaricdeki Unvanlarim</span><i class="fa"></i></a>
            </li>
            <li>
                <a href="customer?action=orders"><i class="sidebar-item-icon fa fa-edit"></i>
                    <span class="nav-label">Sifarislerim</span><i class="fa"></i></a>
            </li>
            <li>
                <a href="customer?action=balance"><i class="sidebar-item-icon fa fa-table"></i>
                    <span class="nav-label">Balans</span><i class="fa"></i></a>
            </li>
            <li>
                <a href="customer?action=messages"><i class="sidebar-item-icon fa fa-bar-chart"></i>
                    <span class="nav-label">Mesajlarim</span><i class="fa"></i></a>
            </li>
            <li>
                <a href="javascript:;"><i class="sidebar-item-icon fa fa-map"></i>
                    <span class="nav-label">Tenzimlemeler</span><i class="fa fa-angle-left arrow"></i></a>
                <ul class="nav-2-level collapse">
                    <li>
                        <a href="customer?action=profile">Profil</a>
                    </li>
                    <li>
                        <a href="customer?action=changePassword">Shifreni deyis</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
