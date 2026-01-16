package doan.Servlet;

import doan.Dao.KhoaHocDAO;
import doan.Model.KhoaHoc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/khoahoc/*")
public class AdminKhoaHocServlet extends HttpServlet {

    private KhoaHocDAO dao = new KhoaHocDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        // /admin/khoahoc  -> list
        if (path == null || path.equals("/")) {
            list(req, resp);
            return;
        }

        switch (path) {
            case "/add":
                req.getRequestDispatcher("/admin/views/khoahoc/add.jsp").forward(req, resp);
                break;

            case "/edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("kh", dao.getById(id));
                req.getRequestDispatcher("/admin/views/khoahoc/edit.jsp").forward(req, resp);
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
            case "/delete":
                delete(req, resp);
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<KhoaHoc> list = dao.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/views/khoahoc/index.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        KhoaHoc kh = new KhoaHoc();
        kh.setTenKhoaHoc(req.getParameter("ten"));
        kh.setMoTa(req.getParameter("mota"));
        kh.setGia(Double.parseDouble(req.getParameter("gia")));
        kh.setHinhAnh(req.getParameter("anh"));

        dao.insert(kh);
        resp.sendRedirect(req.getContextPath() + "/admin/khoahoc");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        KhoaHoc kh = new KhoaHoc();
        kh.setMaKhoaHoc(Integer.parseInt(req.getParameter("id")));
        kh.setTenKhoaHoc(req.getParameter("ten"));
        kh.setMoTa(req.getParameter("mota"));
        kh.setGia(Double.parseDouble(req.getParameter("gia")));
        kh.setHinhAnh(req.getParameter("anh"));

        dao.update(kh);
        resp.sendRedirect(req.getContextPath() + "/admin/khoahoc");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/khoahoc");
    }
}

