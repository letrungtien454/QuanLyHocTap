package doan.Servlet;

import doan.Dao.HocVienDAO;
import doan.Dao.KhoaHocDAO;
import doan.Dao.BaiHocDAO;
import doan.Dao.DangKyDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {

    private HocVienDAO hocVienDAO = new HocVienDAO();
    private KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
    private BaiHocDAO baiHocDAO = new BaiHocDAO();
    private DangKyDAO dangKyDAO = new DangKyDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy số lượng dữ liệu để hiển thị dashboard
        req.setAttribute("countHocVien", hocVienDAO.getAll().size());
        req.setAttribute("countKhoaHoc", khoaHocDAO.getAll().size());
        req.setAttribute("countBaiHoc", baiHocDAO.getAll().size());
        req.setAttribute("countDangKy", dangKyDAO.getAll().size());

        req.getRequestDispatcher("/admin/views/home/index.jsp").forward(req, resp);
    }
}
