package View;


import javax.swing.*;

public class formLogin extends JFrame{
    JLabel ltitle = new JLabel("SILAHKAN LOGIN TERLEBIH DAHULU!");
    JLabel lulogin = new JLabel("Username");
    JLabel lplogin = new JLabel("Password"); 
    public JTextField fulogin = new JTextField();;
    JTextField fplogin = new JTextField();;
    public JButton btnlogin = new JButton("Login");
    public JButton btndaftar = new JButton("Daftar");
    
    public formLogin() {
        setTitle("Form Login");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(ltitle);
        ltitle.setBounds(80, 50, 275, 20);
        add(lulogin);
        lulogin.setBounds(40, 100, 100, 20);
        add(fulogin);
        fulogin.setBounds(120, 100, 230, 20);
        add(lplogin);
        lplogin.setBounds(40, 170, 100, 20);
        add(fplogin);
        fplogin.setBounds(120, 170, 230, 20);
        add(btnlogin);
        btnlogin.setBounds(160, 220, 70, 20);
        add(btndaftar);
        btndaftar.setBounds(280, 310, 70, 20);
    }
    
    public String getUlogin(){
        return fulogin.getText();
    }

    public String getPlogin(){
        return fplogin.getText();
    }
    
    
}
