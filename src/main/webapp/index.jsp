<%@ page import="com.wifi.DataValue" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./cssapp/index.css">

    <script>
        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition, showError);
            } else {
                alert("이 브라우저에서는 위치 정보를 가져올 수 없습니다.");
            }
        }

        function showPosition(position) {
            var lat = position.coords.latitude;
            var lnt = position.coords.longitude;

            document.getElementById("lat").value = lat;
            document.getElementById("lnt").value = lnt;

            alert("현재 위치 정보를 가져왔습니다.");
        }

        function showError(error) {
            switch(error.code) {
                case error.PERMISSION_DENIED:
                    alert("사용자가 위치 정보 요청을 거부했습니다.");
                    break;
                case error.POSITION_UNAVAILABLE:
                    alert("현재 위치 정보를 사용할 수 없습니다.");
                    break;
                case error.TIMEOUT:
                    alert("위치 정보 요청 시간이 초과되었습니다.");
                    break;
                case error.UNKNOWN_ERROR:
                    alert("알 수 없는 오류가 발생했습니다.");
                    break;
            }
        }
    </script>

    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>
    와이파이 정보 구하기
</h1>
<br/>
<a href="home-servlet">홈</a>
<a href="location-servlet">위치 히스토리 목록</a>
<a href="openApi-servlet">open API 와이파이 정보 가져오기</a>
<a href="bookmarklist-servlet">북마크 보기</a>
<a href="bookmarklist-servlet">북마크 그룹관리</a>
<form action="<%=request.getContextPath() %>/nearbyWifiInfo-servlet" method="GET">
    LAT: <input type="text" id="lat" name="lat" placeholder="LAT 위도 ">
    LNT: <input type="text" id="lnt" name="lnt" placeholder="LNT 경도 ">
    <button type="button" onclick="getLocation()">내 위치 가져오기</button>
    <button type="submit" vlaue="전송">근처 WIFI정보 보기</button>
</form>
<table>
    <tr id="one">
        <td>거리(Km)</td>
        <td>관리번호</td>
        <td>자치구</td>
        <td>와이파이명</td>
        <td>도로명주소</td>
        <td>상세주소</td>
        <td>설치위치(층)</td>
        <td>설치유형</td>
        <td>설치기관</td>
        <td>서비스구분</td>
        <td>망종류</td>
        <td>설치년도</td>
        <td>실내외구분</td>
        <td>WIFI접속환경</td>
        <td>X좌표</td>
        <td>Y좌표</td>
        <td>작업일자</td>
    </tr>
<%
    if(request.getAttribute("rows")!=null){
        List<DataValue.row> al = (List<DataValue.row>) request.getAttribute("rows");
        for (DataValue.row row : al) {
%>
    <tr>
        <td><%= row.getDistance()%></td>
        <td><%= row.getX_SWIFI_MGR_NO() %></td>
        <td><%= row.getX_SWIFI_WRDOFC()%></td>
        <td><a href="bookmark-servlet?
        &amp;distance=<%=row.getDistance()%>
        &amp;x_swifi_sub_nm=<%=row.getX_SWIFI_MGR_NO()%>
        &amp;addr=<%=row.getX_SWIFI_WRDOFC()%>
        &amp;tel_no=<%=row.getX_SWIFI_MAIN_NM()%>
        &amp;work_dttm=<%=row.getX_SWIFI_ADRES1()%>
        &amp;work_group=<%=row.getX_SWIFI_ADRES2()%>
        &amp;work_nm=<%=row.getX_SWIFI_INSTL_FLOOR()%>
        &amp;work_yadm_nm=<%=row.getX_SWIFI_INSTL_TY()%>
        &amp;work_tel=<%=row.getX_SWIFI_INSTL_MBY()%>
        &amp;dist_target=<%=row.getX_SWIFI_SVC_SE()%>
        &amp;sh_addr=<%=row.getX_SWIFI_CMCWR()%>
        &amp;sh_addr2=<%=row.getX_SWIFI_CNSTC_YEAR()%>
        &amp;gis_x_co=<%=row.getX_SWIFI_INOUT_DOOR()%>
        &amp;gis_y_co=<%=row.getX_SWIFI_REMARS3()%>
        &amp;app_nm=<%=row.getLAT()%>
        &amp;un_nm=<%=row.getLNT()%>
        &amp;disp_yn=<%=row.getWORK_DTTM()%>">
            <%=row.getX_SWIFI_MAIN_NM()%>
        </a>
        </td>
        <td><%= row.getX_SWIFI_ADRES1()%></td>
        <td><%= row.getX_SWIFI_ADRES2()%></td>
        <td><%= row.getX_SWIFI_INSTL_FLOOR()%></td>
        <td><%= row.getX_SWIFI_INSTL_TY()%></td>
        <td><%= row.getX_SWIFI_INSTL_MBY()%></td>
        <td><%= row.getX_SWIFI_SVC_SE()%></td>
        <td><%= row.getX_SWIFI_CMCWR()%></td>
        <td><%= row.getX_SWIFI_CNSTC_YEAR()%></td>
        <td><%= row.getX_SWIFI_INOUT_DOOR()%></td>
        <td><%= row.getX_SWIFI_REMARS3()%></td>
        <td><%= row.getLAT()%></td>
        <td><%= row.getLNT()%></td>
        <td><%= row.getWORK_DTTM()%></td>

    </tr>
<%
        }
    }
%>




</table>
</body>
</html>