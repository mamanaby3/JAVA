package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Class.forName;

public class DB {

    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    private int ok;

    //Methode de connection
    private void getconnection(){
        //Parametre de connexion
        String host = "localhost";
        String database = "jdbc";
        int port = 3306;
        String url ="jdbc:mysql://"+host+":"+port+"/"+database;
        String user = "root";
        String password ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            cnx = DriverManager.getConnection(url, user, password);
//                    System.out.println("CONNEXION REUSSIE!!!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initPrepar(String sql){
        try {
            getconnection();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet executeSelect(){
        rs = null;
        try {
            rs = pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public void closeConnection(){
        try{
            if (cnx !=  null)
                cnx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public PreparedStatement getPstm(){
        return pstm;
    }
}

