package doan.Model;

public class BaiHoc {
    private int maBaiHoc;
    private int maKhoaHoc;
    private String tieuDe;
    private String noiDung;
    private String video;

    public BaiHoc() {}

    public BaiHoc(int maBaiHoc, int maKhoaHoc, String tieuDe, String noiDung, String video) {
        this.maBaiHoc = maBaiHoc;
        this.maKhoaHoc = maKhoaHoc;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.video = video;
    }

    public int getMaBaiHoc() {
        return maBaiHoc;
    }

    public void setMaBaiHoc(int maBaiHoc) {
        this.maBaiHoc = maBaiHoc;
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
