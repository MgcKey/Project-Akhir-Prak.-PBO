package Model;

import java.sql.*;
import javax.swing.*;

public class modelApotek {
    String DBurl = "jdbc:mysql://localhost/dbapotek";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    String uLogin = "";
    String pLogin = "";
    String rLogin = "";    
    
    public modelApotek() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public void login(String username){
        int jumlahData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                jumlahData++;
            }
            if(jumlahData == 0){
               JOptionPane.showMessageDialog(null, "Data users belum ada");
            }
            else{
                query = "SELECT * FROM users WHERE username = '" + username + "' "; 
                resultSet = statement.executeQuery(query); 
                while(resultSet.next()){
                    uLogin = resultSet.getString("username");
                    pLogin = resultSet.getString("password");
                    rLogin = resultSet.getString("status_role");
                }
            }
        }catch(SQLException error){
           System.out.println(error.getMessage());
           System.out.println("SQL Error");
        }
    }
    
    public void daftar(String nama, String jenisKelamin, String email, String username, String password){
        int jumlahData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' "; 
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                jumlahData++;
            }
            if(jumlahData == 0){
                query = "INSERT INTO users VALUES(NULL,'"+nama+"','"+jenisKelamin+"','"+email+"','"+username+"','"+password+"','pengunjung')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Berhasil mendaftar");
            }
            else{
                JOptionPane.showMessageDialog(null, "Username telah digunakan");
            }
        }catch(SQLException error){
           System.out.println(error.getMessage());
           System.out.println("SQL Error");
        }
    }
    
    public int getBanyakDataObat(){
        int jumlahData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM obat";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jumlahData++;
            }
            return jumlahData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String [][] listObatAdmin(){
        try{
            int jumlahData = 0;
            String data[][] = new String[getBanyakDataObat()][6]; 
            String query = "SELECT * FROM obat"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlahData][0] = resultSet.getString("id_obat");
                data[jumlahData][1] = resultSet.getString("nama"); 
                data[jumlahData][2] = resultSet.getString("bentuk");                
                data[jumlahData][3] = resultSet.getString("aturan_konsumsi");
                data[jumlahData][4] = resultSet.getString("stok");
                data[jumlahData][5] = resultSet.getString("harga");
                jumlahData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void addObat(String nama, String bentuk, String aturanKonsumsi, String stok, String harga){
        int jumlahData=0;
        int stokObat = Integer.parseInt(stok);
        int hargaObat = Integer.parseInt(harga);
        try {
           String query = "SELECT * FROM obat WHERE nama = '" + nama + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){ 
                jumlahData++;
            }    
            if (jumlahData==0) {
                query = "INSERT INTO obat VALUES(NULL,'"+nama+"','"+bentuk+"','"+aturanKonsumsi+"','"+stokObat+"','"+hargaObat+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data obat berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data obat sudah ada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateObat(String nama, String bentuk, String aturanKonsumsi, String stok, String harga){
        int jumlahData=0;
        int stokObat = Integer.parseInt(stok);
        int hargaObat = Integer.parseInt(harga);
        try {
           String query = "SELECT * FROM obat WHERE nama = '" + nama + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){ 
                jumlahData++;
            }    
            if (jumlahData==0) {
                JOptionPane.showMessageDialog(null, "Data obat tidak tersedia");
            }
            else {
                query = "UPDATE obat SET bentuk='" + bentuk + "', aturan_konsumsi='" + aturanKonsumsi + "', stok='" + stokObat + "', harga = '" + hargaObat +"' WHERE nama='" + nama +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data obat berhasil diperbaharui");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void deleteObat(String nama){
        try{
            String query = "DELETE FROM obat WHERE nama = '"+nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data obat berhasil dihapus");
            
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String getNama(String username){
        try{
            String namaUser = new String();
            statement = koneksi.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' "; 
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                namaUser = resultSet.getString("nama");
            }
            return namaUser;
        }catch(SQLException error){
           System.out.println(error.getMessage());
           System.out.println("SQL Error");
           return null;
        }
    }
    
    public String [][] listObatPengunjung(){
        try{
            int jumlahData = 0;
            String data[][] = new String[getBanyakDataObat()][4]; 
            String query = "SELECT * FROM obat"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlahData][0] = resultSet.getString("nama"); 
                data[jumlahData][1] = resultSet.getString("bentuk");                
                data[jumlahData][2] = resultSet.getString("stok");
                data[jumlahData][3] = resultSet.getString("harga");
                jumlahData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void buatPesanan(String username, String nama, String jumlah){
        try {
            int idUser = 0;
            int idObat = 0; 
            int hargaObat = 0;
            int total = 0;
            String namaObat = new String();
            String namaUser = new String();
            String query = "SELECT * FROM obat WHERE nama = '" + nama + "' ";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idObat = resultSet.getInt("id_obat");
                namaObat = resultSet.getString("nama");
                hargaObat = resultSet.getInt("harga");
            }
            int jumlahObat = Integer.parseInt(jumlah);
            total = hargaObat * jumlahObat;
            query = "SELECT * FROM users WHERE username = '" + username + "' ";
            statement = (Statement) koneksi.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idUser = resultSet.getInt("id_user");
                namaUser = resultSet.getString("nama");
            }  
            query = "INSERT INTO pemesanan VALUES(NULL,'"+idUser+"','"+idObat+"','"+namaUser+"','"+namaObat+"','"+jumlahObat+"','"+total+"','Pending')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data pesanan berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public int getStok(String nama){
        try {
            int stok = 0;
            String query = "SELECT * FROM obat WHERE nama = '" + nama + "' ";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                stok = resultSet.getInt("stok");
            }
            return stok;
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    public int getIsiKeranjang(String username){
        try{
            int jumlahData = 0;
            int idUser = 0;
            statement = koneksi.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                idUser = resultSet.getInt("id_user");
            }
            query = "SELECT * FROM pemesanan WHERE id_user = '" + idUser + "' AND status_bayar = 'Pending'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahData++;
            }
            return jumlahData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
        public String [][] keranjangPesanan(String username){
        try{
            int jumlahData = 0;
            int idUser = 0;
            String data[][] = new String[getIsiKeranjang(username)][3]; 
            String query = "SELECT * FROM users WHERE username = '" + username + "' ";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idUser = resultSet.getInt("id_user");
            }
            query = "SELECT * FROM pemesanan WHERE id_user = '" + idUser + "' AND status_bayar = 'Pending'";
            statement = (Statement) koneksi.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlahData][0] = resultSet.getString("nama_obat"); 
                data[jumlahData][1] = resultSet.getString("jumlah_obat");                
                data[jumlahData][2] = resultSet.getString("total_harga");
                jumlahData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getTotalBayar(String username){
        try{
            int idUser = 0;
            int totalHarga = 0;
            int totalBayar = 0;
            String query = "SELECT * FROM users WHERE username = '" + username + "' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idUser = resultSet.getInt("id_user");
            }
            query = "SELECT * FROM pemesanan WHERE id_user = '" + idUser + "' AND status_bayar = 'Pending'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                totalHarga = resultSet.getInt("total_harga");
                totalBayar = totalBayar + totalHarga;
            }
            return totalBayar;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void updateStatusBayar(String username){
        try {
            int idUser = 0;
            String query = "SELECT * FROM users WHERE username = '" + username + "' "; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idUser = resultSet.getInt("id_user");
            }
            query = "UPDATE pemesanan SET status_bayar='Completed' WHERE id_user='" + idUser +"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil membayar pesanan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateStok(String username){
        try {
            int idUser = 0;
            int idObat = 0;
            int jumlahObat = 0;
            int stok = 0;
            int stokSekarang = 0;
            String query = "SELECT * FROM users WHERE username = '" + username + "' "; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                idUser = resultSet.getInt("id_user");
            }
            query = "SELECT * FROM pemesanan WHERE id_user= '" + idUser + "' AND status_bayar='Pending'"; 
            statement = (Statement) koneksi.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){ 
                idObat = resultSet.getInt("id_obat");
                jumlahObat = resultSet.getInt("jumlah_obat");
            }
            query = "SELECT * FROM obat WHERE id_obat= '" + idObat + "' "; 
            statement = (Statement) koneksi.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                stok = resultSet.getInt("stok");
                stokSekarang = stok-jumlahObat;
            }
             query = "UPDATE obat SET stok= '" +stokSekarang+ "' WHERE id_obat= '" + idObat + "' ";
             statement = (Statement) koneksi.createStatement();
             statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public int getBanyakDataPesanan(){
        int jumlahData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM pemesanan";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jumlahData++;
            }
            return jumlahData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String [][] listDataPesanan(){
        try{
            int jumlahData = 0;
            String data[][] = new String[getBanyakDataPesanan()][8]; 
            String query = "SELECT * FROM pemesanan"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlahData][0] = resultSet.getString("id_pesanan");
                data[jumlahData][1] = resultSet.getString("id_user"); 
                data[jumlahData][2] = resultSet.getString("id_obat");                
                data[jumlahData][3] = resultSet.getString("nama_pemesan");
                data[jumlahData][4] = resultSet.getString("nama_obat");
                data[jumlahData][5] = resultSet.getString("jumlah_obat");
                data[jumlahData][6] = resultSet.getString("total_harga");
                data[jumlahData][7] = resultSet.getString("status_bayar");
                jumlahData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String getuLogin(){
        return uLogin;
    }
    
    public String getpLogin(){
        return pLogin;
    }
    
    public String getrLogin(){
        return rLogin;
    }
    
}
