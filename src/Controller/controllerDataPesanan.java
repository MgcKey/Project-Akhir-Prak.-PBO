
package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*; 

public class controllerDataPesanan {
    modelApotek mApotek;
    dataPesanan dPesanan;

    public controllerDataPesanan(modelApotek mApotek, dataPesanan dPesanan) {
        this.mApotek = mApotek;
        this.dPesanan = dPesanan;
        
        if(mApotek.getBanyakDataPesanan()==0){
            String data[][] = mApotek.listDataPesanan();
            dPesanan.tabel.setModel((new JTable(data, dPesanan.namaKolom)).getModel());
            JOptionPane.showMessageDialog(null, "Data pesanan masih kosong");
        }
        
        else{
            String data[][] = mApotek.listDataPesanan();
            dPesanan.tabel.setModel((new JTable(data, dPesanan.namaKolom)).getModel());
        }
    }
    
}
