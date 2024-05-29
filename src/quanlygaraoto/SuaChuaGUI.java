/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlygaraoto;

/**
 *
 * @author luongtopp
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuaChuaGUI extends JFrame {
    private JTextField txtMoTaSuaChua, txtNgaySuaChua, txtSoLuongSuDung, txtChiPhi;
    private JComboBox<String> cbXe, cbVatTu, cbKyThuatVien;
    private JButton btnLuu, btnHuy, btnThem, btnSua, btnXoa;

    public SuaChuaGUI() {
        setTitle("Giao Diện Sửa Chữa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));
        setPreferredSize(new Dimension(400, 300));

        JLabel lblMoTaSuaChua = new JLabel("Mô Tả Sửa Chữa:");
        txtMoTaSuaChua = new JTextField(20);

        JLabel lblNgaySuaChua = new JLabel("Ngày Sửa Chữa:");
        txtNgaySuaChua = new JTextField(10);

        JLabel lblXe = new JLabel("Chọn Xe:");
        cbXe = new JComboBox<>();
        // Code để lấy danh sách xe từ cơ sở dữ liệu và thêm vào combobox

        JLabel lblVatTu = new JLabel("Chọn Vật Tư:");
        cbVatTu = new JComboBox<>();
        // Code để lấy danh sách vật tư từ cơ sở dữ liệu và thêm vào combobox

        JLabel lblSoLuongSuDung = new JLabel("Số Lượng Sử Dụng:");
        txtSoLuongSuDung = new JTextField(5);

        JLabel lblKyThuatVien = new JLabel("Chọn Kỹ Thuật Viên:");
        cbKyThuatVien = new JComboBox<>();
        // Code để lấy danh sách kỹ thuật viên từ cơ sở dữ liệu và thêm vào combobox

        JLabel lblChiPhi = new JLabel("Chi Phí:");
        txtChiPhi = new JTextField(10);

        btnLuu = new JButton("Lưu");
        btnHuy = new JButton("Hủy");
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code xử lý lưu thông tin sửa chữa vào cơ sở dữ liệu
            }
        });

        btnHuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ khi nhấn nút Hủy
            }
        });

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code xử lý thêm bản ghi vào cơ sở dữ liệu
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code xử lý cập nhật bản ghi trong cơ sở dữ liệu
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code xử lý xóa bản ghi khỏi cơ sở dữ liệu
            }
        });

        add(lblMoTaSuaChua);
        add(txtMoTaSuaChua);
        add(lblNgaySuaChua);
        add(txtNgaySuaChua);
        add(lblXe);
        add(cbXe);
        add(lblVatTu);
        add(cbVatTu);
        add(lblSoLuongSuDung);
        add(txtSoLuongSuDung);
        add(lblKyThuatVien);
        add(cbKyThuatVien);
        add(lblChiPhi);
        add(txtChiPhi);
        add(btnLuu);
        add(btnHuy);
        add(btnThem);
        add(btnSua);
        add(btnXoa);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SuaChuaGUI();
            }
        });
    }
}
