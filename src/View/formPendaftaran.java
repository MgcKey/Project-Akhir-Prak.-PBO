package View;

import javax.swing.*;

public class formPendaftaran extends JFrame{
    JLabel dtitle = new JLabel("SILAHKAN ISI FORM TERLEBIH DAHULU!");
    JLabel lndaftar = new JLabel("Nama");
    JLabel ljkdaftar = new JLabel("Jenis Kelamin");
    JLabel ledaftar = new JLabel("Email");
    JLabel ludaftar = new JLabel("Username");
    JLabel lpdaftar = new JLabel("Pasword");
    public JRadioButton rldaftar = new JRadioButton("Laki-laki");
    public JRadioButton rpdaftar = new JRadioButton("Perempuan");
    ButtonGroup gjkdaftar = new ButtonGroup();
    JTextField fndaftar = new JTextField();;
    JTextField fedaftar = new JTextField();;
    JTextField fudaftar = new JTextField();;
    JTextField fpdaftar = new JTextField();;
    public JButton btnsubmit = new JButton("Submit");
    
    String jenisKelamin;

    public formPendaftaran() {
        setTitle("Form Pendaftaran");
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(dtitle);
        dtitle.setBounds(80, 30, 275, 20);
        add(lndaftar);
        lndaftar.setBounds(40, 80, 100, 20);
        add(fndaftar);
        fndaftar.setBounds(120, 80, 230, 20);
        add(ljkdaftar);
        ljkdaftar.setBounds(40, 120, 100, 20);
        gjkdaftar.add(rldaftar);
        gjkdaftar.add(rpdaftar);
        add(rldaftar);
        rldaftar.setBounds(160, 120, 80, 20);
        add(rpdaftar);
        rpdaftar.setBounds(250, 120, 100, 20);
        add(ledaftar);
        ledaftar.setBounds(40, 160, 100, 20);
        add(fedaftar);
        fedaftar.setBounds(120, 160, 230, 20);
        add(ludaftar);
        ludaftar.setBounds(40, 200, 100, 20);
        add(fudaftar);
        fudaftar.setBounds(120, 200, 230, 20);
        add(lpdaftar);
        lpdaftar.setBounds(40, 240, 100, 20);
        add(fpdaftar);
        fpdaftar.setBounds(120, 240, 230, 20);
        add(btnsubmit);
        btnsubmit.setBounds(150, 300, 80, 20); 
    }
     
    public String getNdaftar(){
        return fndaftar.getText();
    }
     
    public String getEdaftar(){
        return fedaftar.getText();
    }
    
    public String getUdaftar(){
        return fudaftar.getText();
    }
    
    public String getPdaftar(){
        return fpdaftar.getText();
    }
    
}
