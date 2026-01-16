package doan.Servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import doan.Dao.KhoaHocDAO;
import doan.Dao.BaiHocDAO;
import doan.Model.KhoaHoc;
import doan.Model.BaiHoc;

@WebServlet("/course")
public class CourseDetailServlet extends HttpServlet {

    private KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
    private BaiHocDAO baiHocDAO = new BaiHocDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        int id;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        // 1. Lấy khóa học
        KhoaHoc khoaHoc = khoaHocDAO.getById(id);
        if (khoaHoc == null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        // 2. Lấy danh sách bài học
        List<BaiHoc> baiHocList = baiHocDAO.getByKhoaHoc(id);

        // 3. Đẩy dữ liệu sang JSP
        req.setAttribute("khoaHoc", khoaHoc);
        req.setAttribute("baiHocList", baiHocList);

        req.getRequestDispatcher("/client/views/home/courseDetail.jsp")
           .forward(req, resp);
    }
}
