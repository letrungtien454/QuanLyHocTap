<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

<div class="container">
    <h2>Thêm học viên</h2>

    <form method="post"
          action="${pageContext.request.contextPath}/admin/hocvien/add">

        Họ tên:
        <input name="hoten" class="form-control" required>

        Email:
        <input name="email" type="email" class="form-control" required>

        Mật khẩu:
        <input name="matkhau" type="password" class="form-control" required>

        <button class="btn btn-success mt-3">Lưu</button>
    </form>
</div>

</main>

<%@ include file="/admin/inc/footer.jsp" %>
