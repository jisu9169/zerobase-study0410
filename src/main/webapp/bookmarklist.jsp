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

<table id="two">
    <tr>
        <td>ID</td>
        <td>북마크 이름</td>
        <td>와이파이명</td>
        <td>등록일자</td>
        <td>삭제</td>
    </tr>
</table>
</body>
</html>