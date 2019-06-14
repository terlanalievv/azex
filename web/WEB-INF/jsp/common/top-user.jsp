<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 3/6/19
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a class="nav-link dropdown-toggle link" data-toggle="dropdown">
    <img src="./assets/img/admin-avatar.png" />
    <span></span>${sessionScope.user.name}&nbsp;${sessionScope.user.surname}<i class="fa fa-angle-down m-l-5"></i></a>
<ul class="dropdown-menu dropdown-menu-right">
    <a class="dropdown-item" href="customer?action=profile"><i class="fa fa-user"></i>Profile</a>
    <a class="dropdown-item" href="profile.html"><i class="fa fa-cog"></i>Settings</a>
    <a class="dropdown-item" href="javascript:;"><i class="fa fa-support"></i>Support</a>
    <li class="dropdown-divider"></li>
    <a class="dropdown-item" href="logout"><i class="fa fa-power-off"></i>Logout</a>
</ul>