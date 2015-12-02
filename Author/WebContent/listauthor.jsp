<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Publisher</th>
                <th>Address</th>
                 <th colspan=2>Action</th>
            </tr>
        </thead>
                <tbody>
           
            <c:forEach items="${authors}" var="ab">
                <tr>
                    <td><c:out value="${ab.id}"/></td>
                    <td><c:out value="${ab.name}" /></td>
                    <td><c:out value="${ab.publisher}" /></td>
                    <td><c:out value="${ab.address}" /></td>
                  <td><a href="AuthorServlet?action=edit&id=<c:out value="${ab.id}"/>">Update</a></td>
                  <td><a href="AuthorServlet?action=delete&id=<c:out value="${ab.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        
        
  <p><a href="AuthorServlet?action=insert">Add Author</a></p>  
        
        
</body>
</html>