<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

<div class="container">
    <h2>Sửa học viên</h2>

    <form method="post"
          action="${pageContext.request.contextPath}/admin/hocvien/edit">

        <input type="hidden" name="id" value="${hv.maHV}">

        Họ tên:
        <input name="hoten" class="form-control"
               value="${hv.hoTen}" required>

        Email:
        <input name="email" class="form-control"
               value="${hv.email}" required>

        Mật khẩu:
        <input name="matkhau" class="form-control"
               value="${hv.matKhau}" required>

        <button class="btn btn-success mt-3">Cập nhật</button>
    </form>
</div>

</main>

<%@ include file="/admin/inc/footer.jsp" %>
