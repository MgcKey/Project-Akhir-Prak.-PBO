package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*; 

public class controllerPengunjung {
    modelApotek mApotek;
    homePengunjung hPengunjung;
    formLogin fLogin;
    String dataTerpilih = "";

    public controllerPengunjung(modelApotek mApotek, homePengunjung hPengunjung, formLogin fLogin){
        this.mApotek = mApotek;
        this.hPengunjung = hPengunjung;
        this.fLogin = fLogin;
        if (mApotek.getBanyakDataObat()==0) {
            JOptionPane.showMessageDialog(null, "Data obat masih kosong");
        }
        else {
            String data[][] = mApotek.listObatPengunjung();
            hPengunjung.tabel.setModel((new JTable(data, hPengunjung.namaKolom)).getModel());
        }
        
        hPengunjung.tabel.addMouseListener(new MouseAdapter(){    
            public void mouseClicked(MouseEvent me) {
                super.mousePressed(me);
                int baris = hPengunjung.tabel.getSelectedRow();
                dataTerpilih = hPengunjung.tabel.getValueAt(baris, 0).toString();
                
        }
        });
        
        hPengunjung.btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(dataTerpilih.equals("") && hPengunjung.getJumlah().equals("")){
                    JOptionPane.showMessageDialog(null, "Belum ada inputan yang diberikan");
                }
                else{
                    if(dataTerpilih.equals("")){
                        JOptionPane.showMessageDialog(null, "Silahkan pilih obat terlebih dahulu!");
                    }
                    else{
                        if(hPengunjung.getJumlah().equals("")){
                           JOptionPane.showMessageDialog(null, "Jumlah obat belum diisi");  
                        }
                        else{
                            if(mApotek.getStok(dataTerpilih)==0){
                                JOptionPane.showMessageDialog(null, "Maaf, stok obat sedang kosong"); 
                            }
                            else{
                                int stok = Integer.parseInt(hPengunjung.getJumlah());
                                if(mApotek.getStok(dataTerpilih)<stok){
                                    JOptionPane.showMessageDialog(null, "Maaf, stok obat tidak memenuhi"); 
                                }
                                else{
                                    String username = fLogin.getUlogin();
                                    String jumlah = hPengunjung.getJumlah();
                                    mApotek.buatPesanan(username, dataTerpilih, jumlah);
                                    mApotek.updateStok(username);
                                    String data[][] = mApotek.listObatPengunjung();
                                    hPengunjung.tabel.setModel((new JTable(data, hPengunjung.namaKolom)).getModel());
                                    dataTerpilih = "";
                                }
                            }
                        }
                    }
                }
            }
        });
        
        hPengunjung.btnPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lihatKeranjang lk = new lihatKeranjang();
                modelApotek ma = new modelApotek();
                new controllerKeranjang(ma, lk, fLogin);
            }
        });
    }
      
}
