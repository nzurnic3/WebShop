<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
table.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
</head>
<body>

<h1>All Buyers</h1>

<form action="buyer-servlet" method="get">
    <table border="1">
        <th>
            <td>Buyer Name</td>
            <td>Buyer Address</td>
        </th>
        <c:forEach items="${buyers}" var="buyer">
          <tr>
          <td><input type="radio" name="equals" value=${buyer.buyerId}></td>
           <td>${buyer.buyerName}</td>
            <td>${buyer.buyerAddress}</td>
           </tr>
         </c:forEach>
             </table>
    <hr>

    <%@ include file="crudButtons.html" %>
</form>
<button value="Back" onclick="history.back()">Back</button>

</body>
</html>
