package doan.Servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import doan.Dao.KhoaHocDAO;
import doan.Model.KhoaHoc;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private KhoaHocDAO khoaHocDAO = new KhoaHocDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<KhoaHoc> khoaHocList = khoaHocDAO.getAll();

        req.setAttribute("khoaHocList", khoaHocList);
        req.getRequestDispatcher("/client/views/home/index.jsp").forward(req, resp);
    }
}



