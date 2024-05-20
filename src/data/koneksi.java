package data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Angga
 */
public class koneksi {
    private static Connection mysqlkoneksi;
    public static Connection configDB()throws SQLException{
        try {
            //ip server pak rojikin
            String url="jdbc:mysql://103.133.25.99:3306/gogonet_separe?zeroDateTimeBehavior=convertToNull";
            String user="gogonet_separe";
            String password="1YMVTLOjzW3S";
            //ip server jh
//            String url="jdbc:mysql://103.163.138.104:3306/younutsm_data?zeroDateTimeBehavior=convertToNull";
//            String user="younutsm_admin";
//            String password="Athabeef123.";
            //ip ku
//            String url="jdbc:mysql://192.168.43.1:3306/project_angga?zeroDateTimeBehavior=convertToNull";
//            String user="angga";
//            String password="Athabeef123.";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlkoneksi=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("koneksi gagal! "+e.getMessage());
        }
        return mysqlkoneksi;
    }
}
