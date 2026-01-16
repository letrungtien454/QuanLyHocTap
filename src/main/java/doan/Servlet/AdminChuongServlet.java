package doan.Servlet;

import doan.Dao.ChuongDAO;
import doan.Dao.KhoaHocDAO;
import doan.Model.Chuong;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/chuong")
public class AdminChuongServlet extends HttpServlet {

    private ChuongDAO chuongDAO = new ChuongDAO();
    private KhoaHocDAO khoaHocDAO = new KhoaHocDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("listChuong", chuongDAO.getAll());
            request.getRequestDispatcher("/admin/views/chuong/index.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "add":
                request.setAttribute("listKhoaHoc", khoaHocDAO.getAll());
                request.getRequestDispatcher("/admin/views/chuong/add.jsp").forward(request, response);
                break;

            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("chuong", chuongDAO.getById(id));
                request.setAttribute("listKhoaHoc", khoaHocDAO.getAll());
                request.getRequestDispatcher("/admin/views/chuong/edit.jsp").forward(request, response);
                break;

            case "delete":
                chuongDAO.delete(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("chuong");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
        String tenChuong = request.getParameter("tenChuong");
        int thuTu = Integer.parseInt(request.getParameter("thuTu"));

        Chuong c = new Chuong();
        c.setMaKhoaHoc(maKhoaHoc);
        c.setTenChuong(tenChuong);
        c.setThuTu(thuTu);

        String id = request.getParameter("maChuong");
        if (id == null) {
            chuongDAO.insert(c);
        } else {
            c.setMaChuong(Integer.parseInt(id));
            chuongDAO.update(c);
        }

        response.sendRedirect("chuong");
    }
}

