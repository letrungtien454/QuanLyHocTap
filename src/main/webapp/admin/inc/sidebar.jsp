<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="dashboard.jsp">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->




<li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/admin/chuong">
        <i class="bi bi-journal-text"></i><span>Quản lý Chương</span>
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/admin/khoahoc">
        <i class="bi bi-journal-text"></i><span>Quản lý khóa học</span>
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/admin/hocvien">
        <i class="bi bi-people"></i><span>Quản lý học viên</span>
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/admin/baihoc">
        <i class="bi bi-collection-play"></i><span>Quản lý bài học</span>
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/admin/dangky">
        <i class="bi bi-cart-check"></i><span>Quản lý đăng ký</span>
    </a>
</li>

      <!-- End Components Nav -->

      
      </li><!-- End Blank Page Nav -->

    </ul>

  </aside><!-- End Sidebar-->
