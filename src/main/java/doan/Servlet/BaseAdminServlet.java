package doan.Servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

/**
 * Base servlet cho phần admin.
 * Kiểm tra session admin trước khi vào các servlet con.
 */
public class BaseAdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Kiểm tra admin đã login hay chưa
     */
    protected boolean isAdminLoggedIn(HttpServletRequest request) {
        // Giả sử thông tin admin lưu trong session với key "admin"
        return request.getSession().getAttribute("admin") != null;
    }

    /**
     * Chuyển hướng về trang login nếu chưa login
     */
    protected void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/${pageContext.request.contextPath}/admintemplate/login.jsp");
    }

    /**
     * Ghi đè service() để kiểm tra admin trước khi gọi doGet/doPost
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAdminLoggedIn(request)) {
            redirectToLogin(request, response);
            return; // Dừng xử lý servlet con nếu chưa login
        }
        super.service(request, response); // Gọi doGet/doPost của servlet con
    }
}
