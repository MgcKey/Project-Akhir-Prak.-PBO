package View;

import javax.swing.*;
import javax.swing.table.*;

public class dataPesanan extends JFrame {
    public Object namaKolom[] = {"ID Pesanan", "ID User", "ID Obat", "Nama Pemesan", "Nama Obat", "Nama Obat", "Total Harga", "Status Bayar"};
    public JTable tabel = new JTable();
    DefaultTableModel mdlTabel = new DefaultTableModel(namaKolom, 0);
    JScrollPane scrollPane = new JScrollPane(tabel);

    public dataPesanan() {
        setTitle("Data Pesanan");
        setSize(880,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(30, 30, 800, 358);
    }
    
}
