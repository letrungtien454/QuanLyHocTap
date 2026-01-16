package doan.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import doan.Model.KhoaHoc;
import doan.utils.DBContext;

public class KhoaHocDAO {

    public List<KhoaHoc> getAll() {
        List<KhoaHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM KhoaHoc";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc(
                    rs.getInt("MaKhoaHoc"),
                    rs.getString("TenKhoaHoc"),
                    rs.getString("MoTa"),
                    rs.getDouble("Gia"),
                    rs.getString("HinhAnh"),
                    rs.getString("NgayTao")
                );
                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhoaHoc getById(int id) {
    	KhoaHoc kh = null;
        String sql = "SELECT * FROM KhoaHoc WHERE MaKhoaHoc=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new KhoaHoc(
                    rs.getInt("MaKhoaHoc"),
                    rs.getString("TenKhoaHoc"),
                    rs.getString("MoTa"),
                    rs.getDouble("Gia"),
                    rs.getString("HinhAnh"),
                    rs.getString("NgayTao")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(KhoaHoc kh) {
        String sql = "INSERT INTO KhoaHoc (TenKhoaHoc, MoTa, Gia, HinhAnh) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getTenKhoaHoc());
            ps.setString(2, kh.getMoTa());
            ps.setDouble(3, kh.getGia());
            ps.setString(4, kh.getHinhAnh());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(KhoaHoc kh) {
        String sql = "UPDATE KhoaHoc SET TenKhoaHoc=?, MoTa=?, Gia=?, HinhAnh=? WHERE MaKhoaHoc=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getTenKhoaHoc());
            ps.setString(2, kh.getMoTa());
            ps.setDouble(3, kh.getGia());
            ps.setString(4, kh.getHinhAnh());
            ps.setInt(5, kh.getMaKhoaHoc());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM KhoaHoc WHERE MaKhoaHoc=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
