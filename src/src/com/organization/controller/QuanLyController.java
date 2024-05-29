package src.com.organization.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import src.com.organization.dao.GiamDocDAO;
import src.com.organization.dao.KeToanDAO;
import src.com.organization.dao.KyThuatVienDAO;
import src.com.organization.dao.NguoiDungDAO;
import src.com.organization.dao.SuaChuaDAO;
import src.com.organization.dao.ThongKeDAO;
import src.com.organization.dao.VatTuDAO;
import src.com.organization.dao.XeDAO;
import src.com.organization.model.NguoiDung;
import src.com.organization.view.GiamDocView;
import src.com.organization.view.KeToanView;
import src.com.organization.view.main.QuanLyView;
import src.com.organization.view.KyThuatVienView;
import src.com.organization.view.NguoiDungView;
import src.com.organization.view.SuaChuaView;
import src.com.organization.view.VatTuView;
import src.com.organization.view.ThongKeView;
import src.com.organization.view.XeView;
import src.com.organization.view.TrangChuView;

public class QuanLyController {

    private final QuanLyView quanLyView;
    private final JPanel kyThuatVienView;
    private final JPanel nguoiDungView;
    private final JPanel suaChuaView;
    private final JPanel vatTuView;
    private final JPanel xeView;
    private final JPanel trangChuView;
    private final JPanel giamDocView;
    private final JPanel keToanView;
    private final JPanel thongKeView;

    private JPanel hienThi;
    private CardLayout cardLayout;

    public QuanLyController(QuanLyView View, NguoiDung nguoiDung) {

        this.quanLyView = new QuanLyView();
        this.kyThuatVienView = new KyThuatVienView();
        this.nguoiDungView = new NguoiDungView();
        this.suaChuaView = new SuaChuaView();
        this.vatTuView = new VatTuView();
        this.xeView = new XeView();
        this.trangChuView = new TrangChuView();
        this.giamDocView = new GiamDocView();
        this.keToanView = new KeToanView();
        this.thongKeView = new ThongKeView();

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        new NguoiDungController((NguoiDungView) nguoiDungView, nguoiDungDAO);

        KyThuatVienDAO kyThuatVienDAO = new KyThuatVienDAO();
        new KyThuatVienController((KyThuatVienView) kyThuatVienView, kyThuatVienDAO);

        XeDAO xeDAO = new XeDAO();
        new XeController((XeView) xeView, xeDAO);

        VatTuDAO vatTuDAO = new VatTuDAO();
        new VatTuController((VatTuView) vatTuView, vatTuDAO);

        GiamDocDAO giamDocDAO = new GiamDocDAO();
        new GiamDocController((GiamDocView) giamDocView, giamDocDAO);

        ThongKeDAO thongKeDAO = new ThongKeDAO();
        new ThongKeController((ThongKeView) thongKeView, thongKeDAO);

        SuaChuaDAO suaChuaDAO = new SuaChuaDAO();
        new SuaChuaController((SuaChuaView) suaChuaView, suaChuaDAO, xeDAO, vatTuDAO, kyThuatVienDAO);

        KeToanDAO keToanDAO = new KeToanDAO();
        new KeToanController((KeToanView) keToanView, keToanDAO, suaChuaDAO);

        hienThi = View.getPnlHienThi();
        cardLayout = new CardLayout();
        hienThi.setLayout(cardLayout);

        // Thêm các panel vào pnlHienThi
        hienThi.add(trangChuView, "TrangChuView");
        hienThi.add(kyThuatVienView, "QuanLyNhanVienView");
        hienThi.add(nguoiDungView, "QuanLyTaiKhoanView");
        hienThi.add(suaChuaView, "SuaChuaView");
        hienThi.add(vatTuView, "QuanLyVatTuView");
        hienThi.add(giamDocView, "GiamDocView");
        hienThi.add(keToanView, "KeToanView");
        hienThi.add(thongKeView, "ThongKeView");
        hienThi.add(xeView, "QuanLyXeView");

        View.setPnlHienThi(hienThi);

        if (nguoiDung.getVaiTro().equals("NhanVien")) {
            View.getBtnQuanLyTaiKhoan().setVisible(false);
            View.getBtnQuanLyNhanVien().setVisible(false);
            View.getBtnGiamDoc().setVisible(false);            
            View.getBtnThongKe().setVisible(false);            
            View.getBtnKeToan().setVisible(false);
        } else if(nguoiDung.getVaiTro().equals("KeToan")) {
             View.getBtnQuanLyTaiKhoan().setVisible(false);
            View.getBtnQuanLyNhanVien().setVisible(false);
            View.getBtnGiamDoc().setVisible(false);            
        } 

        // Gán sự kiện cho nút Trang Chủ
        View.getBtnTrangChu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "TrangChuView");
            }
        });

        // Gán sự kiện cho nút Quản Lý Nhân Viên
        View.getBtnQuanLyNhanVien().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "QuanLyNhanVienView");
            }
        });

        // Gán sự kiện cho nút Quản Lý Tài Khoản
        View.getBtnQuanLyTaiKhoan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "QuanLyTaiKhoanView");
            }
        });

        // Gán sự kiện cho nút Quản Lý Vật Tư
        View.getBtnQuanLyVatTu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "QuanLyVatTuView");
            }
        });

        // Gán sự kiện cho nút Sửa Chữa
        View.getBtnSuaChua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "SuaChuaView");
            }
        });

        // Gán sự kiện cho nút Quản Lý Xe
        View.getBtnQuanLyXe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "QuanLyXeView");
            }
        });

        // Gán sự kiện cho nút Giám Đốc
        View.getBtnGiamDoc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "GiamDocView");
            }
        });

        // Gán sự kiện cho nút Kế Toán
        View.getBtnKeToan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "KeToanView");
            }
        });

        // Gán sự kiện cho nút Kế Toán
        View.getBtnThongKe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(View.getPnlHienThi(), "ThongKeView");
            }
        });

    }

}
