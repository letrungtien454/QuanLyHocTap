package doan.Model;

import java.util.List;

public class Chuong {
    private int maChuong;
    private int maKhoaHoc;
    private String tenChuong;
    private int thuTu;

    // dùng cho client sau này
    private List<BaiHoc> danhSachBaiHoc;

    public Chuong() {}

    public Chuong(int maChuong, int maKhoaHoc, String tenChuong, int thuTu) {
        this.maChuong = maChuong;
        this.maKhoaHoc = maKhoaHoc;
        this.tenChuong = tenChuong;
        this.thuTu = thuTu;
    }

    public int getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(int maChuong) {
        this.maChuong = maChuong;
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public int getThuTu() {
        return thuTu;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }

    public List<BaiHoc> getDanhSachBaiHoc() {
        return danhSachBaiHoc;
    }

    public void setDanhSachBaiHoc(List<BaiHoc> danhSachBaiHoc) {
        this.danhSachBaiHoc = danhSachBaiHoc;
    }
}
