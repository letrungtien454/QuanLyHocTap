
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>${khoaHoc.tenKhoaHoc}</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/clienttemplate/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/clienttemplate/assets/css/style.css">
</head>

<body>

<!-- HEADER -->
<div class="header-area header-transparent">
    <div class="main-header">
        <div class="header-bottom header-sticky">
            <div class="container-fluid">
                <ul id="navigation">
                    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/courses">Courses</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- CONTENT -->
<main class="container mt-5">
    <div class="row">

        <!-- LEFT CONTENT (3/4) -->
        <div class="col-lg-8">
    <h1>${khoaHoc.tenKhoaHoc}</h1>
    <p>${khoaHoc.moTa}</p>

    <h4 class="mt-4">Nội dung khóa học</h4>

    <ul class="list-group">
        <c:forEach var="bh" items="${baiHocList}" varStatus="st">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                ${st.index + 1}. ${bh.tieuDe}
                <button class="btn btn-sm btn-primary"
                        onclick="toggleVideo('v${bh.maBaiHoc}')">
                    Xem
                </button>
            </li>

            <div id="v${bh.maBaiHoc}" style="display:none" class="mt-2 mb-3">
                <p>${bh.noiDung}</p>
                <iframe width="100%" height="315"
                        src="${fn:replace(bh.video,'watch?v=','embed/')}"
                        allowfullscreen>
                </iframe>
            </div>
        </c:forEach>
    </ul>
</div>


        <!-- RIGHT SIDEBAR -->
        <div class="col-lg-4">
            <img class="img-fluid mb-3"
                 src="${pageContext.request.contextPath}/client/uploads/${khoaHoc.hinhAnh}">

            <div class="card p-3">
                <p>
                    Giá:
                    <c:choose>
                        <c:when test="${khoaHoc.gia == 0}">Miễn phí</c:when>
                        <c:otherwise>${khoaHoc.gia} đ</c:otherwise>
                    </c:choose>
                </p>
                <a class="btn btn-success">Bắt đầu học</a>
            </div>
        </div>

    </div>
</main> 

<script>
function toggleVideo(id) {
    const el = document.getElementById(id);
    el.style.display = el.style.display === 'none' ? 'block' : 'none';
}
</script>

</body>
</html>
