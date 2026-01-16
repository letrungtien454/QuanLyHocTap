package doan.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import doan.Model.HocVien;
import doan.utils.DBContext;

public class HocVienDAO {

    public List<HocVien> getAll() {
        List<HocVien> list = new ArrayList<>();
        String sql = "SELECT * FROM HocVien";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HocVien hv = new HocVien(
                    rs.getInt("MaHV"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("MatKhau"),
                    rs.getString("NgayTao")
                );
                list.add(hv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HocVien getById(int id) {
        String sql = "SELECT * FROM HocVien WHERE MaHV=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new HocVien(
                    rs.getInt("MaHV"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("MatKhau"),
                    rs.getString("NgayTao")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(HocVien hv) {
        String sql = "INSERT INTO HocVien (HoTen, Email, MatKhau) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hv.getHoTen());
            ps.setString(2, hv.getEmail());
            ps.setString(3, hv.getMatKhau());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(HocVien hv) {
        String sql = "UPDATE HocVien SET HoTen=?, Email=?, MatKhau=? WHERE MaHV=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hv.getHoTen());
            ps.setString(2, hv.getEmail());
            ps.setString(3, hv.getMatKhau());
            ps.setInt(4, hv.getMaHV());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM HocVien WHERE MaHV=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
