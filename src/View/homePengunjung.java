package View;

import javax.swing.*;
import javax.swing.table.*;

public class homePengunjung extends JFrame{
    public Object namaKolom[] = {"Nama Obat", "Bentuk Obat", "Stok Obat", "Harga"};
    public JLabel lWelcome = new JLabel() ;
    JLabel lJumlah = new JLabel("Jumlah Obat");
    JLabel lTotal = new JLabel("Total Harga");
    JLabel fTotal = new JLabel();
    JTextField fJumlah = new JTextField();
    public JButton btnPesan = new JButton("Buat Pesanan");
    public JButton btnPesanan = new JButton("Lihat Data Pesanan");
    public JTable tabel = new JTable();
    DefaultTableModel mdlTabel = new DefaultTableModel(namaKolom, 0);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    public homePengunjung() {
        setTitle("Home Pengunjung");
        setSize(600,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(lWelcome);
        lWelcome.setBounds(20, 30, 400, 20);
        
        add(scrollPane);
        scrollPane.setBounds(20, 70, 400, 250);
        
        add(lJumlah);
        lJumlah.setBounds(450, 130, 90, 20);
        add(fJumlah);
        fJumlah.setBounds(450, 160, 120, 20);
        
        add(btnPesan);
        btnPesan.setBounds(450, 210, 120, 20);
        add(btnPesanan);
        btnPesanan.setBounds(20, 350, 150, 20);   
    }
    public String getJumlah(){
        return fJumlah.getText();
    }
}
