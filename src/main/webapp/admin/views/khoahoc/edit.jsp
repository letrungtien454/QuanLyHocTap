<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

  <div class="pagetitle">
    <h1>Chỉnh sửa khóa học</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
        </li>
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath}/admin/khoahoc">Khóa học</a>
        </li>
        <li class="breadcrumb-item active">Chỉnh sửa</li>
      </ol>
    </nav>
  </div>

  <section class="section">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Cập nhật thông tin khóa học</h5>

        <form method="post"
              action="${pageContext.request.contextPath}/admin/khoahoc/edit">

          <input type="hidden" name="id" value="${kh.maKhoaHoc}">

          <div class="mb-3">
            <label class="form-label">Tên khóa học</label>
            <input name="ten"
                   class="form-control"
                   value="${kh.tenKhoaHoc}"
                   required>
          </div>

          <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <textarea name="mota"
                      class="form-control"
                      rows="4">${kh.moTa}</textarea>
          </div>

          <div class="mb-3">
            <label class="form-label">Giá</label>
            <input name="gia"
                   type="number"
                   step="0.01"
                   class="form-control"
                   value="${kh.gia}"
                   required>
          </div>

          <div class="mb-3">
            <label class="form-label">Hình ảnh</label>
            <input name="anh"
                   class="form-control"
                   value="${kh.hinhAnh}">
          </div>

          <button class="btn btn-primary">Cập nhật</button>
          <a href="${pageContext.request.contextPath}/admin/khoahoc"
             class="btn btn-secondary">Quay lại</a>
        </form>

      </div>
    </div>
  </section>

</main>

<%@ include file="/admin/inc/footer.jsp" %>
