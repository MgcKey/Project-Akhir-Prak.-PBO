package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*;

public class controllerDaftar {
    modelApotek mApotek;
    formPendaftaran fPendaftaran;
    String jKelamin;
    public controllerDaftar(modelApotek mApotek, formPendaftaran fPendaftaran) {
        this.mApotek = mApotek;
        this.fPendaftaran = fPendaftaran;
        
        fPendaftaran.rldaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jKelamin = fPendaftaran.rldaftar.getText();       
            }
        });
        
        fPendaftaran.rpdaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jKelamin = fPendaftaran.rpdaftar.getText();       
            }
        });
        
        
        fPendaftaran.btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = fPendaftaran.getNdaftar();
                String jenisKelamin = jKelamin;       
                String email = fPendaftaran.getEdaftar();
                String username = fPendaftaran.getUdaftar();
                String password = fPendaftaran.getPdaftar();
                if(nama.equals("") || fPendaftaran.rldaftar.getText().equals("") || fPendaftaran.rpdaftar.getText().equals("") || email.equals("") || username.equals("") || password.equals("")){
                    if(!username.equals("")){
                        mApotek.daftar(nama, jenisKelamin, email, username, password);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong");
                    }
                }
                else{
                    mApotek.daftar(nama, jenisKelamin, email, username, password);
                }
            }
        });
    }
    
}
