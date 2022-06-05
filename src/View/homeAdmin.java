package View;

import javax.swing.*;
import javax.swing.table.*;

public class homeAdmin extends JFrame{
    public Object namaKolom[] = {"ID Obat", "Nama Obat", "Bentuk Obat", "Aturan Konsumsi", "Stok Obat", "Harga"};
    JLabel lNama = new JLabel("Nama Obat");
    public JComboBox cbBentuk = new JComboBox();
    DefaultComboBoxModel mdlBentuk = new DefaultComboBoxModel();
    JLabel lBentuk = new JLabel("Bentuk Obat");
    JLabel lAturan = new JLabel("Aturan Konsumsi");
    JLabel lStok = new JLabel("Stok Obat");
    JLabel lHarga = new JLabel("Harga");
    public JTextField fNama = new JTextField();
    public JTextField fAturan = new JTextField();
    public JTextField fStok = new JTextField();
    public JTextField fHarga = new JTextField();
    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");
    public JButton btnPesanan = new JButton("Lihat Data Pesanan");
    public JTable tabel = new JTable();
    DefaultTableModel mdlTabel = new DefaultTableModel(namaKolom, 0);
    JScrollPane scrollPane = new JScrollPane(tabel);
    String fBentuk;
    
    public homeAdmin() {
        setTitle("Home Admin");
        setSize(800,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 30, 500, 300);
        
        add(lNama);
        lNama.setBounds(600, 20, 90, 20);
        add(fNama);
        fNama.setBounds(600, 40, 120, 20);
        
        cbBentuk.setModel(mdlBentuk);
        mdlBentuk.addElement("Tablet");
        mdlBentuk.addElement("Kapsul");
        mdlBentuk.addElement("Kaplet");
        mdlBentuk.addElement("Pil");
        mdlBentuk.addElement("Puyer");
        mdlBentuk.addElement("Cair");
        
        add(lBentuk);
        lBentuk.setBounds(600, 70, 90, 20);
        add(cbBentuk);
        cbBentuk.setBounds(600, 90, 120, 20);
        
        add(lAturan);
        lAturan.setBounds(600, 120, 100, 20);
        add(fAturan);
        fAturan.setBounds(600, 140, 120, 20);
        
        add(lStok);
        lStok.setBounds(600, 170, 90, 20);
        add(fStok);
        fStok.setBounds(600, 190, 120, 20);
        
        add(lHarga);
        lHarga.setBounds(600, 220, 90, 20);
        add(fHarga);
        fHarga.setBounds(600, 250, 120, 20);
        
        add(btnAdd);
        btnAdd.setBounds(570, 310, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(670, 310, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(570, 350, 90, 20);
        
        add(btnClear);
        btnClear.setBounds(670, 350, 90, 20);
        
        add(btnPesanan);
        btnPesanan.setBounds(20, 350, 150, 20);
    }
    
    public String getNama(){
        return fNama.getText();
    }
    
    public String getBentuk(){
        fBentuk = cbBentuk.getSelectedItem().toString();
        return fBentuk;
    }
    
    public String getAturan(){
        return fAturan.getText();
    }
    
    public String getStok(){
        return fStok.getText();
    }
    
    public String getHarga(){
        return fHarga.getText();
    }
    
}
