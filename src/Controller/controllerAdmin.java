package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*;

public class controllerAdmin {
    modelApotek mApotek;
    homeAdmin hAdmin;
    String dataTerpilih = "";

    public controllerAdmin(modelApotek mApotek, homeAdmin hAdmin) {
        this.mApotek = mApotek;
        this.hAdmin = hAdmin;
        
        if (mApotek.getBanyakDataObat()==0) {
            JOptionPane.showMessageDialog(null, "Data obat masih kosong");
        }
        else {
            String data[][] = mApotek.listObatAdmin();
            hAdmin.tabel.setModel((new JTable(data, hAdmin.namaKolom)).getModel());
        }
        
        hAdmin.tabel.addMouseListener(new MouseAdapter(){    
            public void mouseClicked(MouseEvent me) {
                super.mousePressed(me);
                int baris = hAdmin.tabel.getSelectedRow();
                dataTerpilih = hAdmin.tabel.getValueAt(baris, 1).toString();   
        }
        });
        
        hAdmin.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = hAdmin.getNama();
                String bentuk = hAdmin.getBentuk();
                String aturanKonsumsi = hAdmin.getAturan();
                String stok = hAdmin.getStok();
                String harga = hAdmin.getHarga();
                if(nama.equals("") || bentuk.equals("") || aturanKonsumsi.equals("") || stok.equals("") || harga.equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong");
                }
                else{
                    mApotek.addObat(nama, bentuk, aturanKonsumsi, stok, harga);
                    String data[][] = mApotek.listObatAdmin();
                    hAdmin.tabel.setModel((new JTable(data, hAdmin.namaKolom)).getModel());
                }
            }
        });
        
        hAdmin.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = hAdmin.getNama();
                String bentuk = hAdmin.getBentuk();
                String aturanKonsumsi = hAdmin.getAturan();
                String stok = hAdmin.getStok();
                String harga = hAdmin.getHarga();
                if(nama.equals("") || bentuk.equals("") || aturanKonsumsi.equals("") || stok.equals("") || harga.equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong");
                }
                else{
                    mApotek.updateObat(nama, bentuk, aturanKonsumsi, stok, harga);
                    String data[][] = mApotek.listObatAdmin();
                    hAdmin.tabel.setModel((new JTable(data, hAdmin.namaKolom)).getModel());
                }
            }
        });
        
        hAdmin.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(dataTerpilih.equals("")){
                    JOptionPane.showMessageDialog(null, "Belum ada data yang dipilih");
                }
                else{
                    int hapus = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus obat " + dataTerpilih + "?", "Opsi Hapus", JOptionPane.YES_NO_OPTION);
                    if (hapus == 0) {
                        mApotek.deleteObat(dataTerpilih);
                        String data[][] = mApotek.listObatAdmin();
                        hAdmin.tabel.setModel((new JTable(data, hAdmin.namaKolom)).getModel());
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "Tidak jadi dihapus");
                    }
                }
            }
        });
        
        hAdmin.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hAdmin.fNama.setText("");
                hAdmin.cbBentuk.setSelectedIndex(0);
                hAdmin.fAturan.setText("");
                hAdmin.fStok.setText("");
                hAdmin.fHarga.setText("");
            }
        }); 
        
        hAdmin.btnPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dataPesanan dp = new dataPesanan();
                modelApotek ma = new modelApotek();
                new controllerDataPesanan(ma, dp);
            }
        });
        
        
    }  
}
