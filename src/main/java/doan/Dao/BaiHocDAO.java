package doan.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import doan.Model.BaiHoc;
import doan.utils.DBContext;

public class BaiHocDAO {

    // ================== ADMIN ==================

    // Lấy tất cả bài học
    public List<BaiHoc> getAll() {
        List<BaiHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM BaiHoc";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BaiHoc bh = new BaiHoc(
                        rs.getInt("MaBaiHoc"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TieuDe"),
                        rs.getString("NoiDung"),
                        rs.getString("Video")
                );
                list.add(bh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy 1 bài học theo ID
    public BaiHoc getById(int id) {
        String sql = "SELECT * FROM BaiHoc WHERE MaBaiHoc = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new BaiHoc(
                        rs.getInt("MaBaiHoc"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TieuDe"),
                        rs.getString("NoiDung"),
                        rs.getString("Video")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm bài học
    public void insert(BaiHoc bh) {
        String sql = "INSERT INTO BaiHoc (MaKhoaHoc, TieuDe, NoiDung, Video) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bh.getMaKhoaHoc());
            ps.setString(2, bh.getTieuDe());
            ps.setString(3, bh.getNoiDung());
            ps.setString(4, bh.getVideo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sửa bài học
    public void update(BaiHoc bh) {
        String sql = "UPDATE BaiHoc SET TieuDe=?, NoiDung=?, Video=?, MaKhoaHoc=? WHERE MaBaiHoc=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bh.getTieuDe());
            ps.setString(2, bh.getNoiDung());
            ps.setString(3, bh.getVideo());
            ps.setInt(4, bh.getMaKhoaHoc());
            ps.setInt(5, bh.getMaBaiHoc());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa bài học
    public void delete(int id) {
        String sql = "DELETE FROM BaiHoc WHERE MaBaiHoc=?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================== TRANG CHỦ ==================

    // Lấy bài học theo khóa học (PHỤC VỤ HOME)
    public List<BaiHoc> getByKhoaHoc(int maKhoaHoc) {
        List<BaiHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM BaiHoc WHERE MaKhoaHoc = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maKhoaHoc);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BaiHoc bh = new BaiHoc(
                        rs.getInt("MaBaiHoc"),
                        rs.getInt("MaKhoaHoc"),
                        rs.getString("TieuDe"),
                        rs.getString("NoiDung"),
                        rs.getString("Video")
                );
                list.add(bh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
