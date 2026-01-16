<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/header.jsp" %>
<%@ include file="/admin/inc/sidebar.jsp" %>

<main id="main" class="main">

  <div class="pagetitle">
    <h1>Thêm khóa học</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item">Khóa học</li>
        <li class="breadcrumb-item active">Thêm</li>
      </ol>
    </nav>
  </div>

  <section class="section">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Thông tin khóa học</h5>

        <form method="post"
              action="${pageContext.request.contextPath}/admin/khoahoc/add">

          <div class="mb-3">
            <label class="form-label">Tên khóa học</label>
            <input name="ten" class="form-control" required>
          </div>

          <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <textarea name="mota" class="form-control"></textarea>
          </div>

          <div class="mb-3">
            <label class="form-label">Giá</label>
            <input name="gia" type="number" step="0.01"
                   class="form-control" required>
          </div>

          <div class="mb-3">
            <label class="form-label">Hình ảnh</label>
            <input name="anh" class="form-control">
          </div>

          <button class="btn btn-success">Lưu</button>
          <a href="${pageContext.request.contextPath}/admin/khoahoc"
             class="btn btn-secondary">Hủy</a>
        </form>

      </div>
    </div>
  </section>

</main>

<%@ include file="/admin/inc/footer.jsp" %>
