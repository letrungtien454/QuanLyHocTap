package doan.Servlet;

import doan.Dao.BaiHocDAO;
import doan.Model.BaiHoc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/baihoc/*")
public class AdminBaiHocServlet extends HttpServlet {

    private BaiHocDAO dao = new BaiHocDAO();

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
                req.getRequestDispatcher("/admin/views/baihoc/add.jsp").forward(req, resp);
                break;

            case "/edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("b", dao.getById(id));
                req.getRequestDispatcher("/admin/views/baihoc/edit.jsp").forward(req, resp);
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

        if (path == null) {
            resp.sendRedirect(req.getContextPath() + "/admin/baihoc");
            return;
        }

        switch (path) {
            case "/add":
                insert(req, resp);
                break;

            case "/edit":
                update(req, resp);
                break;

            default:
                resp.sendRedirect(req.getContextPath() + "/admin/baihoc");
        }
    }


    // ===== METHODS =====
    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<BaiHoc> list = dao.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/views/baihoc/index.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        BaiHoc b = new BaiHoc();

        b.setTieuDe(req.getParameter("tieuDe"));
        b.setNoiDung(req.getParameter("noiDung"));
        b.setVideo(req.getParameter("video"));
        b.setMaKhoaHoc(Integer.parseInt(req.getParameter("maKhoaHoc")));

        dao.insert(b);

        resp.sendRedirect(req.getContextPath() + "/admin/baihoc");
    }



    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        BaiHoc b = new BaiHoc();
        b.setMaBaiHoc(Integer.parseInt(req.getParameter("id")));
        b.setTieuDe(req.getParameter("tieude"));
        b.setNoiDung(req.getParameter("noidung"));
        b.setVideo(req.getParameter("video"));
        b.setMaKhoaHoc(Integer.parseInt(req.getParameter("makhoa")));

        dao.update(b);
        resp.sendRedirect(req.getContextPath() + "/admin/baihoc");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/baihoc");
    }
}
