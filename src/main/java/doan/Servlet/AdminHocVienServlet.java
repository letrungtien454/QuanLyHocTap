package doan.Servlet;

import doan.Dao.HocVienDAO;
import doan.Model.HocVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/hocvien/*")
public class AdminHocVienServlet extends HttpServlet {

    private HocVienDAO dao = new HocVienDAO();

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
                req.getRequestDispatcher("/admin/views/hocvien/add.jsp").forward(req, resp);
                break;

            case "/edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("hv", dao.getById(id));
                req.getRequestDispatcher("/admin/views/hocvien/edit.jsp").forward(req, resp);
                break;

            case "/delete":
                delete(req, resp);
                break;

            default:
                list(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        switch (path) {
            case "/add":
                insert(req, resp);
                break;
            case "/edit":
                update(req, resp);
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<HocVien> list = dao.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/views/hocvien/index.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HocVien hv = new HocVien();
        hv.setHoTen(req.getParameter("hoten"));
        hv.setEmail(req.getParameter("email"));
        hv.setMatKhau(req.getParameter("matkhau"));

        dao.insert(hv);
        resp.sendRedirect(req.getContextPath() + "/admin/hocvien");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HocVien hv = new HocVien();
        hv.setMaHV(Integer.parseInt(req.getParameter("id")));
        hv.setHoTen(req.getParameter("hoten"));
        hv.setEmail(req.getParameter("email"));
        hv.setMatKhau(req.getParameter("matkhau"));

        dao.update(hv);
        resp.sendRedirect(req.getContextPath() + "/admin/hocvien");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/hocvien");
    }
}
