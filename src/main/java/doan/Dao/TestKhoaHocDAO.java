package doan.Dao;

import doan.Dao.KhoaHocDAO;
import doan.Model.KhoaHoc;
import java.util.List;

public class TestKhoaHocDAO {
    public static void main(String[] args) {
        KhoaHocDAO dao = new KhoaHocDAO();
        List<KhoaHoc> list = dao.getAll();
        for(KhoaHoc kh : list){
            System.out.println(kh.getMaKhoaHoc() + " | " + kh.getTenKhoaHoc() + " | " + kh.getGia());
        }
    }
}
