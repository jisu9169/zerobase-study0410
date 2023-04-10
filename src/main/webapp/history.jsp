<%@ page import="java.util.List" %>
<%@ page import="com.wifi.History" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./cssapp/index.css">


    <title>와이파이 정보 구하기</title>
    <script>
<%
        if (request.getAttribute("alertMessage") != null) {
%>
            alert('<%= request.getAttribute("alertMessage") %>');
<%
        }
%>
    </script>
</head>
<body>
<h1>
    위치 히스토리 목록
</h1>
<br/>
<a href="home-servlet">홈</a>
<a href="location-servlet">위치 히스토리 목록</a>
<a href="openApi-servlet">open API 와이파이 정보 가져오기</a>
<a href="bookmarklist-servlet">북마크 보기</a>
<a href="bookmarklist-servlet">북마크 그룹관리</a>
<table>
    <tr id="one">
        <td>ID</td>
        <td>X좌표</td>
        <td>Y좌표</td>
        <td>조회일자</td>
        <td>비고</td>
    </tr>
<%
    if(request.getAttribute("rows")!=null){
        List<History.row> al = (List<History.row>) request.getAttribute("rows");
        for (History.row row : al) {
%>
    <tr>
        <form action="<%=request.getContextPath()%>/locationdelete-servlet" method="POST">
            <input type="hidden" name="id" value="<%=row.getId()%>" />
            <td><%=row.getId()%></td>
            <td><%=row.getLAT()%></td>
            <td><%=row.getLNT()%></td>
            <td><%=row.getSearch_date()%></td>
            <td><button type="submit" value="전송">삭제</button></td>
        </form>
    </tr>
<%
        }
    }
%>
</table>
</body>
</html>