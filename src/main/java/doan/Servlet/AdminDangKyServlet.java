package doan.Servlet;

import doan.Dao.DangKyDAO;
import doan.Model.DangKy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dangky/*")
public class AdminDangKyServlet extends HttpServlet {

    private DangKyDAO dao = new DangKyDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            list(req, resp);
            return;
        }

        switch (path) {
            case "/add":
                req.getRequestDispatcher("/admin/views/dangky/add.jsp").forward(req, resp);
                break;

            case "/delete":
                int maHV = Integer.parseInt(req.getParameter("mahv"));
                int maKH = Integer.parseInt(req.getParameter("makh"));
                dao.delete(maHV, maKH);
                resp.sendRedirect(req.getContextPath() + "/admin/dangky");
                break;

            default:
                list(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();
        // Nếu path null, coi là add
        if (path == null || path.equals("/") || path.equals("/add")) {
            DangKy dk = new DangKy();
            dk.setMaHV(Integer.parseInt(req.getParameter("mahv")));
            dk.setMaKhoaHoc(Integer.parseInt(req.getParameter("makh")));
            dk.setNgayDangKy(req.getParameter("ngaydangky"));

            dao.insert(dk);
            resp.sendRedirect(req.getContextPath() + "/admin/dangky");
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/dangky");
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<DangKy> list = dao.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/views/dangky/index.jsp").forward(req, resp);
    }
}
