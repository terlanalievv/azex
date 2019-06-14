<%@ page import="az.azex.web.WebConstants" %>
<%@ page import="az.azex.domain.FlexibleList" %>
<%@ page import="az.azex.domain.FlexibleListItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 1/30/19
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Azex Main Page</title>
  </head>
  <body>
    Hal hazirda saytdaki istifadecilerin sayi =
    <%= request.getServletContext().getAttribute("onlineUserCounter") %>

    <%
      FlexibleList channel = (FlexibleList) request.getServletContext().getAttribute(WebConstants.ACQUISITION_CHANNEL);
    %>

    <h2>Java Code</h2>
    <%
      out.println("<select name='channel'>");
      for(FlexibleListItem item : channel.getItemList()) {
        out.println("<option value='" + item.getValueId() + "'>" + item.getValueName() + "</option>");
      }
      out.println("</select>");
    %>

  <table border="1">
    <tr>
      <td>ID</td>
      <td>Name</td>
    </tr>

      <%
        for(FlexibleListItem item : channel.getItemList()) {
          %>
        <tr>
          <td><%out.print(item.getValueId());%>  </td>
          <td><%=item.getValueName()%>  </td>
        </tr>
      <%
        }
      %>
  </table>

  <h2>JSTL tag</h2>

    <table border="1">
      <tr>
        <td>ID</td>
        <td>Name</td>
      </tr>
      <c:forEach items="${applicationScope.acquisition_channel.itemList}" var="channel" varStatus="status">
        <%--<c:if test="${status.index % 2 == 0}">--%>
          <%--<tr bgcolor="aqua">--%>
            <%--<td>${channel.valueId}</td>--%>
            <%--<td>${channel.valueName}</td>--%>
          <%--</tr>  --%>
        <%--</c:if>--%>

        <c:choose>
          <c:when test="${status.index % 2 == 0}">
            <tr bgcolor="aqua">
          </c:when>

          <c:otherwise>
            <tr bgcolor="#fff8dc">
          </c:otherwise>
        </c:choose>

        <td>${channel.valueId}</td>
        <td>${channel.valueName}</td>
        </tr>

      </c:forEach>

    </table>

  <%
    List<Integer> numbers = Arrays.asList(0, 2, 5, 7, 9, 10, 12);
    request.setAttribute("numbers", numbers);
  %>

  <c:forEach items="${numbers}" begin="0" end="10" step="1" var="i" varStatus="status">
    <p>${status.index} - ${i}</p>
  </c:forEach>

    <br/>
  <c:forTokens items="a,b,c,d,e,f" delims="," var="herf">
    <p>${herf}</p>
  </c:forTokens>
  </body>
</html>
