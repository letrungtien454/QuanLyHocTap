<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

<div class="pagetitle">
    <h1>Thêm bài học</h1>
</div>

<section class="section">
<div class="card">
<div class="card-body">

<form method="post"
      action="${pageContext.request.contextPath}/admin/baihoc/add">

    <div class="mb-3">
        <label>Tiêu đề bài học</label>
        <input name="tieuDe" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Nội dung</label>
        <textarea name="noiDung" class="form-control"></textarea>
    </div>

    <div class="mb-3">
        <label>Link video</label>
        <input name="video" class="form-control">
    </div>

    <div class="mb-3">
        <label>Mã khóa học</label>
        <input name="maKhoaHoc" type="number" class="form-control" required>
    </div>

    <button class="btn btn-success">Lưu</button>
</form>



</main>

<%@ include file="/admin/inc/footer.jsp" %>
