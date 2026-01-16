package doan.Dao;

import doan.Model.Chuong;
import doan.utils.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChuongDAO {

    // Lấy tất cả chương
    public List<Chuong> getAll() {
        List<Chuong> list = new ArrayList<>();
        String sql = "SELECT * FROM Chuong ORDER BY MaKhoaHoc, ThuTu";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Chuong(
                        rs.getInt("MaChuong"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TenChuong"),
                        rs.getInt("ThuTu")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


        public List<Chuong> findByKhoaHoc(int maKhoaHoc) {
            List<Chuong> list = new ArrayList<>();
            String sql = "SELECT * FROM Chuong WHERE MaKhoaHoc=?";
            try (Connection conn = DBContext.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, maKhoaHoc);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Chuong c = new Chuong();
                    c.setMaChuong(rs.getInt("MaChuong"));
                    c.setTenChuong(rs.getString("TenChuong"));
                    c.setMaKhoaHoc(maKhoaHoc);
                    list.add(c);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
    
    // Lấy chương theo khóa học
    public List<Chuong> getByKhoaHoc(int maKhoaHoc) {
        List<Chuong> list = new ArrayList<>();
        String sql = "SELECT * FROM Chuong WHERE MaKhoaHoc = ? ORDER BY ThuTu";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoaHoc);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Chuong(
                        rs.getInt("MaChuong"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TenChuong"),
                        rs.getInt("ThuTu")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy 1 chương
    public Chuong getById(int id) {
        String sql = "SELECT * FROM Chuong WHERE MaChuong = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Chuong(
                        rs.getInt("MaChuong"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TenChuong"),
                        rs.getInt("ThuTu")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm chương
    public void insert(Chuong c) {
        String sql = "INSERT INTO Chuong (MaKhoaHoc, TenChuong, ThuTu) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getMaKhoaHoc());
            ps.setString(2, c.getTenChuong());
            ps.setInt(3, c.getThuTu());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật chương
    public void update(Chuong c) {
        String sql = "UPDATE Chuong SET MaKhoaHoc=?, TenChuong=?, ThuTu=? WHERE MaChuong=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getMaKhoaHoc());
            ps.setString(2, c.getTenChuong());
            ps.setInt(3, c.getThuTu());
            ps.setInt(4, c.getMaChuong());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa chương
    public void delete(int id) {
        String sql = "DELETE FROM Chuong WHERE MaChuong=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
