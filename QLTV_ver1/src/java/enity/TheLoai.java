/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

/**
 *
 * @author thain
 */
public class TheLoai {
    private String maTheLoai, tenTheLoai, ghiChu;

    public TheLoai(String maTheLoai, String tenTheLoai, String ghiChu) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.ghiChu = ghiChu;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
