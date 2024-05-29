/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.controller.auth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.com.organization.controller.QuanLyController;
import src.com.organization.model.NguoiDung;
import src.com.organization.view.auth.DangNhapView;
import src.com.organization.dao.NguoiDungDAO;
import src.com.organization.view.NguoiDungView;
import src.com.organization.view.main.QuanLyView;

public class DangNhapController {

    private final DangNhapView dangNhapView;
    private final NguoiDungDAO nguoiDungDAO;

    public DangNhapController(DangNhapView dangNhapView, NguoiDungDAO nguoiDungDAO) {
        this.dangNhapView = dangNhapView;
        this.nguoiDungDAO = nguoiDungDAO;
        // Gán sự kiện cho nút đăng nhập
        dangNhapView.getBtnDangNhap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kiemTraDangNhap();
            }
        });

    }

    public void kiemTraDangNhap() {
        String tenDangNhap = dangNhapView.getTxtTenDangNhap().getText();

        String matKhau = new String(dangNhapView.getTxtMatKhau().getPassword());
        try {
            // Tạo câu truy vấn để kiểm tra thông tin đăng nhập trong cơ sở dữ liệu
            NguoiDung nguoiDung = nguoiDungDAO.authenticate(tenDangNhap, matKhau);
            if (nguoiDung != null) {
                // Đăng nhập thành công, hiển thị thông báo và mở màn hình chính
                // Tạo và hiển thị màn hình quản lý tài khoản
                NguoiDungView quanLyTaiKhoanView = new NguoiDungView();
                quanLyTaiKhoanView.setVisible(true);

                // Đóng màn hình đăng nhập
                dangNhapView.dispose();

                // Thêm code để mở màn hình chính ở đây nếu cần
                QuanLyView quanLyView = new QuanLyView();
                new QuanLyController(quanLyView, nguoiDung);
                quanLyView.setVisible(true);

            } else {
                // Đăng nhập thất bại, hiển thị thông báo lỗi
                dangNhapView.setLblSaiMatKhau("Tên đăng nhập hoặc mật khẩu không đúng!");

            }
        } catch (Exception e) {
            e.printStackTrace();
            dangNhapView.setLblSaiMatKhau("Đã xảy ra lỗi khi xác thực đăng nhập!");

        }
    }

}
