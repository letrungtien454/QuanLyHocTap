<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">
<div class="container">
    <h2>Thêm đăng ký mới</h2>
    <form action="${pageContext.request.contextPath}/admin/dangky/add" method="post">
        <div class="mb-3">
            <label for="mahv" class="form-label">Mã học viên</label>
            <input type="number" class="form-control" name="mahv" id="mahv" required>
        </div>
        <div class="mb-3">
            <label for="makh" class="form-label">Mã khóa học</label>
            <input type="number" class="form-control" name="makh" id="makh" required>
        </div>
        <div class="mb-3">
            <label for="ngaydangky" class="form-label">Ngày đăng ký</label>
            <input type="date" class="form-control" name="ngaydangky" id="ngaydangky" required>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="${pageContext.request.contextPath}/admin/dangky" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</main>

<%@ include file="/admin/inc/footer.jsp" %>
