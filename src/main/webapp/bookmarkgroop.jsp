<%@ page import="com.wifi.BookMarkDataValue" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./cssapp/index.css">


    <title>와이파이 정보 구하기</title>
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
    <tr class="three">
        <td>ID</td>
        <td>북마크 이름</td>
        <td>와이파이명</td>
        <td>순서</td>
        <td>등록일자</td>
        <td>수정날짜</td>
        <td>비고</td>
    </tr>
    <%
        if(request.getAttribute("rows")!=null){
            List<BookMarkDataValue.row> al = (List<BookMarkDataValue.row>) request.getAttribute("rows");
            for (BookMarkDataValue.row row : al) {
    %>
    <tr>
        <form action="<%=request.getContextPath()%>/bookmarkmodi-servlet" method="post">
            <input type="hidden" name="id" value="<%=row.getId()%>" />
        <td><%=row.getId()%></td>
        <td><%=row.getBookmark_name()%></td>
        <td><%=row.getWifi_name()%></td>
        <td><%=row.getOrder_num()%></td>
        <td><%=row.getRegistration_date()%></td>
        <td><%=row.getModification_date()%></td>
        <td>
            <button type="submit" name="modi">수정</button>
            <button type="submit" name="delete">삭제</button>
        </td>
        </form>
    </tr>

<%
            }
    }
            %>

</table>
</body>
</html>