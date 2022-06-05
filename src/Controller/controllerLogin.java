package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import javax.swing.*;

public class controllerLogin {
    modelApotek mApotek;
    formLogin fLogin;

    public controllerLogin(modelApotek mApotek, formLogin fLogin) {
        this.mApotek = mApotek;
        this.fLogin = fLogin;
        
        
        fLogin.btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = fLogin.getUlogin();
                String password = fLogin.getPlogin();
                mApotek.login(username);
                if(mApotek.getuLogin().equals(username)){
                    if(mApotek.getpLogin().equals(password)){
                        if(mApotek.getrLogin().equals("admin")){
                            JOptionPane.showMessageDialog(null, "Berhasil login sebagai admin");
                            homeAdmin ha = new homeAdmin();
                            modelApotek ma = new modelApotek();
                            new controllerAdmin(ma, ha);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Berhasil login sebagai pengunjung");
                            homePengunjung hp = new homePengunjung();
                            hp.lWelcome.setText("Selamat datang di Apotek Veteran, " +mApotek.getNama(username));
                            modelApotek ma = new modelApotek();
                            new controllerPengunjung(ma, hp, fLogin);
                        }
                    }
                    else{
                        if(password.equals("")){
                            JOptionPane.showMessageDialog(null, "Password belum diisi");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Password anda salah");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
                }
            }
        });
        
        fLogin.btndaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                formPendaftaran fp = new formPendaftaran();
                modelApotek ma = new modelApotek();
                controllerDaftar cd = new controllerDaftar(ma, fp);
            }
        });
    }
    
    
}
