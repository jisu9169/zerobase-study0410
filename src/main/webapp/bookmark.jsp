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
<br>
<br>
<form action="<%=request.getContextPath()%>/bookmarkgroop-servlet" method="GET">
    <select name="bookmark_group_name">
        <option value="">북마크 그룹 이름 선택</option>
        <option value="내 집 근처">내 집 근처</option>
        <option value="내 회사 근처">내 회사 근처</option>
        <option value="자주가는 카페 근처">자주가는 카페 근처</option>
        <input type="hidden" name="wifiname" value="<%=request.getAttribute("tel_no")%>" />

    </select>
    <Button type="submit" value="전송" >북마크 추가하기</Button>
</form>




<table id="two">
    <tr>
        <td>거리(km)</td>
        <td><%=request.getAttribute("distance")%></td>
    </tr>
    <tr>
        <td>관리번호</td>
        <td><%=request.getAttribute("x_swifi_sub_nm")%></td>
    </tr>
    <tr>
        <td>자치구</td>
        <td><%=request.getAttribute("addr")%></td>
    </tr>
    <tr>
        <td>와이파이명</td>
        <td><%=request.getAttribute("tel_no")%></td>
    </tr>
    <tr>
        <td>도로명주소</td>
        <td><%=request.getAttribute("work_dttm")%></td>
    </tr>
    <tr>
        <td>상세주소</td>
        <td><%=request.getAttribute("work_group")%></td>
    </tr>
    <tr>
        <td>설치위치(층)</td>
        <td><%=request.getAttribute("work_nm")%></td>
    </tr>
    <tr>
        <td>설치유형</td>
        <td><%=request.getAttribute("work_yadm_nm")%></td>
    </tr>
    <tr>
        <td>설치기관</td>
        <td><%=request.getAttribute("work_tel")%></td>
    </tr>
    <tr>
        <td>서비스구분</td>
        <td><%=request.getAttribute("dist_target")%></td>
    </tr>
    <tr>
        <td #one>망종류</td>
        <td><%=request.getAttribute("sh_addr")%></td>
    </tr>
    <tr>
        <td>설치년도</td>
        <td><%=request.getAttribute("sh_addr2")%></td>
    </tr>
    <tr>
        <td>실내외구분</td>
        <td><%=request.getAttribute("gis_x_co")%></td>
    </tr>
    <tr>
        <td>WIFI접속환경</td>
        <td><%=request.getAttribute("gis_y_co")%></td>
    </tr>
    <tr>
        <td>X좌표</td>
        <td><%=request.getAttribute("gis_x_co")%></td>
    </tr>
    <tr>
        <td>Y좌표</td>
        <td><%=request.getAttribute("gis_y_co")%></td>
    </tr>
    <tr>
        <td>작업일자</td>
        <td><%=request.getAttribute("disp_yn")%></td>
    </tr>
</table>
</body>
</html>