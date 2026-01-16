<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

<div class="pagetitle">
    <h1>Sửa bài học</h1>
</div>

<section class="section">
<div class="card">
<div class="card-body">

<form method="post"
      action="${pageContext.request.contextPath}/admin/baihoc/edit">

    <input type="hidden" name="id" value="${b.maBaiHoc}">

<div class="mb-3">
    <label class="form-label">Tiêu đề bài học</label>
    <input name="tieuDe" class="form-control"
           value="${b.tieuDe}" required>
</div>

<div class="mb-3">
    <label class="form-label">Nội dung</label>
    <textarea name="noiDung"
              class="form-control"
              rows="4">${b.noiDung}</textarea>
</div>

<div class="mb-3">
    <label class="form-label">Video</label>
    <input name="video"
           class="form-control"
           value="${b.video}">
</div>

<div class="mb-3">
    <label class="form-label">Mã khóa học</label>
    <input name="maKhoaHoc"
           type="number"
           class="form-control"
           value="${b.maKhoaHoc}">
</div>


    <button class="btn btn-success">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/admin/baihoc"
       class="btn btn-secondary">Quay lại</a>
</form>

</div>
</div>
</section>

</main>

<%@ include file="/admin/inc/footer.jsp" %>
