package doan.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import doan.Model.DangKy;
import doan.utils.DBContext;

public class DangKyDAO {

    // Lấy tất cả đăng ký
    public List<DangKy> getAll() {
        List<DangKy> list = new ArrayList<>();
        String sql = "SELECT * FROM DangKy";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DangKy dk = new DangKy(
                        rs.getInt("MaHV"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("NgayDangKy")
                );
                list.add(dk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy 1 đăng ký theo học viên + khóa học
    public DangKy getById(int maHV, int maKhoaHoc) {
        String sql = "SELECT * FROM DangKy WHERE MaHV=? AND MaKhoaHoc=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maHV);
            ps.setInt(2, maKhoaHoc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new DangKy(
                        rs.getInt("MaHV"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("NgayDangKy")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm mới đăng ký
    public void insert(DangKy dk) {
        String sql = "INSERT INTO DangKy (MaHV, MaKhoaHoc, NgayDangKy) VALUES (?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dk.getMaHV());
            ps.setInt(2, dk.getMaKhoaHoc());
            ps.setString(3, dk.getNgayDangKy());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa đăng ký
    public void delete(int maHV, int maKhoaHoc) {
        String sql = "DELETE FROM DangKy WHERE MaHV=? AND MaKhoaHoc=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maHV);
            ps.setInt(2, maKhoaHoc);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
