package doan.Model;

public class DangKy {
    private int maHV;
    private int maKhoaHoc;
    private String ngayDangKy;

    public DangKy() {}

    public DangKy(int maHV, int maKhoaHoc, String ngayDangKy) {
        this.maHV = maHV;
        this.maKhoaHoc = maKhoaHoc;
        this.ngayDangKy = ngayDangKy;
    }

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}
