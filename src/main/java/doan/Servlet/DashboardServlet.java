package doan.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet điều hướng đến trang dashboard quản trị.
 * Kế thừa từ BaseAdminServlet để dùng chung cấu hình hệ thống.
 */
@WebServlet("/admin/dashboard")
public class DashboardServlet extends BaseAdminServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến trang dashboard JSP
        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Nếu cần xử lý POST trong tương lai
    }
}
