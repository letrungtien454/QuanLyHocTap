package doan.Model;

public class HocVien {
    private int maHV;
    private String hoTen;
    private String email;
    private String matKhau;
    private String ngayTao;

    public HocVien() {}

    public HocVien(int maHV, String hoTen, String email, String matKhau, String ngayTao) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
    }

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
