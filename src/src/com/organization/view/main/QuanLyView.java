package src.com.organization.view.main;

import javax.swing.JButton;
import javax.swing.JPanel;

public class QuanLyView extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */

    public QuanLyView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public JButton getBtnQuanLyNhanVien() {
        return btnQuanLyNhanVien;
    }

    public void setBtnQuanLyNhanVien(JButton btnQuanLyNhanVien) {
        this.btnQuanLyNhanVien = btnQuanLyNhanVien;
    }

    public JButton getBtnQuanLyTaiKhoan() {
        return btnQuanLyTaiKhoan;
    }

    public void setBtnQuanLyTaiKhoan(JButton btnQuanLyTaiKhoan) {
        this.btnQuanLyTaiKhoan = btnQuanLyTaiKhoan;
    }

    public JButton getBtnQuanLyVatTu() {
        return btnQuanLyVatTu;
    }

    public void setBtnQuanLyVatTu(JButton btnQuanLyVatTu) {
        this.btnQuanLyVatTu = btnQuanLyVatTu;
    }

    public JButton getBtnQuanLyXe() {
        return btnQuanLyXe;
    }

    public void setBtnQuanLyXe(JButton btnQuanLyXe) {
        this.btnQuanLyXe = btnQuanLyXe;
    }

    public JButton getBtnSuaChua() {
        return btnSuaChua;
    }

    public void setBtnSuaChua(JButton btnSuaChua) {
        this.btnSuaChua = btnSuaChua;
    }

    public JButton getBtnTrangChu() {
        return btnTrangChu;
    }

    public void setBtnTrangChu(JButton btnTrangChu) {
        this.btnTrangChu = btnTrangChu;
    }

    public JPanel getPnlChucNang() {
        return pnlChucNang;
    }

    public void setPnlChucNang(JPanel pnlChucNang) {
        this.pnlChucNang = pnlChucNang;
    }

    public JPanel getPnlHienThi() {
        return pnlHienThi;
    }

    public void setPnlHienThi(JPanel pnlHienThi) {
        this.pnlHienThi = pnlHienThi;
    }

    public JButton getBtnGiamDoc() {
        return btnGiamDoc;
    }

    public void setBtnGiamDoc(JButton btnGiamDoc) {
        this.btnGiamDoc = btnGiamDoc;
    }

    public JButton getBtnKeToan() {
        return btnKeToan;
    }

    public void setBtnKeToan(JButton btnKeToan) {
        this.btnKeToan = btnKeToan;
    }

    public JButton getBtnThongKe() {
        return btnThongKe;
    }

    public void setBtnThongKe(JButton btnThongKe) {
        this.btnThongKe = btnThongKe;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChucNang = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnKeToan = new javax.swing.JButton();
        btnGiamDoc = new javax.swing.JButton();
        btnQuanLyVatTu = new javax.swing.JButton();
        btnSuaChua = new javax.swing.JButton();
        btnQuanLyXe = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyTaiKhoan = new javax.swing.JButton();
        pnlHienThi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTrangChu.setText("Trang chủ");

        btnThongKe.setText("Thống kê");

        btnKeToan.setText("Kế toán");

        btnGiamDoc.setText("Giám đốc");

        btnQuanLyVatTu.setText("Quản lý vật tư");

        btnSuaChua.setText("Sửa chữa");

        btnQuanLyXe.setText("Quản lý xe");

        btnQuanLyNhanVien.setText("Quản lý nhân viên");

        btnQuanLyTaiKhoan.setText("Quản lý tài khoản");

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(btnSuaChua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyVatTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKeToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGiamDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKeToan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiamDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyVatTu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyXe, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHienThiLayout = new javax.swing.GroupLayout(pnlHienThi);
        pnlHienThi.setLayout(pnlHienThiLayout);
        pnlHienThiLayout.setHorizontalGroup(
            pnlHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        pnlHienThiLayout.setVerticalGroup(
            pnlHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiamDoc;
    private javax.swing.JButton btnKeToan;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnQuanLyTaiKhoan;
    private javax.swing.JButton btnQuanLyVatTu;
    private javax.swing.JButton btnQuanLyXe;
    private javax.swing.JButton btnSuaChua;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlHienThi;
    // End of variables declaration//GEN-END:variables
}
