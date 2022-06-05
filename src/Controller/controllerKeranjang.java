package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*; 

public class controllerKeranjang{
    modelApotek mApotek;
    lihatKeranjang lKeranjang;
    formLogin fLogin;
 
    public controllerKeranjang(modelApotek mApotek, lihatKeranjang lKeranjang, formLogin fLogin) {
        this.mApotek = mApotek;
        this.lKeranjang = lKeranjang;
        this.fLogin = fLogin;
        String username = fLogin.getUlogin();
        if(mApotek.getIsiKeranjang(username)==0){
            lKeranjang.btnBayar.setVisible(false);
            String data[][] = mApotek.keranjangPesanan(username);
            lKeranjang.tabel.setModel((new JTable(data, lKeranjang.namaKolom)).getModel());
            JOptionPane.showMessageDialog(null, "Keranjang pesanan masih kosong");
        }
        else{
            String data[][] = mApotek.keranjangPesanan(username);
            lKeranjang.tabel.setModel((new JTable(data, lKeranjang.namaKolom)).getModel());
        }
        
        lKeranjang.btnBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int hapus = JOptionPane.showConfirmDialog(null,
                    "Apa anda ingin memproses pembayaran sebesar Rp " + mApotek.getTotalBayar(username) + "?", "Pembayaran", JOptionPane.YES_NO_OPTION);
                    if (hapus == 0) {
                        mApotek.updateStatusBayar(username);
                        lKeranjang.btnBayar.setVisible(false);
                        String data[][] = mApotek.keranjangPesanan(username);
                        lKeranjang.tabel.setModel((new JTable(data, lKeranjang.namaKolom)).getModel());
                    } else {
                        JOptionPane.showMessageDialog(null, "Tidak jadi membayar");
                }
                
            }
        });
    }
}
