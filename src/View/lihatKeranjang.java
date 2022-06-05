package View;

import javax.swing.*;
import javax.swing.table.*;

public class lihatKeranjang extends JFrame {
    public Object namaKolom[] = {"Nama Obat", "Jumlah", "Total Harga"};
    public JTable tabel = new JTable();
    DefaultTableModel mdlTabel = new DefaultTableModel(namaKolom, 0);
    JScrollPane scrollPane = new JScrollPane(tabel);
    public JButton btnBayar = new JButton("Bayar");

    public lihatKeranjang() {
        setTitle("Keranjang Pesanan");
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 350, 250);
        
        add(btnBayar);
        btnBayar.setBounds(150, 300, 100, 20);
        
    }
    
}
