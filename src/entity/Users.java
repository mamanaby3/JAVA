package entity;

import dao.DB;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class Users {
    public int id;
    public String nom;
    public String password;
    public String passwordHashed;
    public int id_role;

    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHhashed(String passwordHashed) {
    }


    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id = id_role;
    }




//Ajout utilisateurs

public int add(Users user) {
    String sql = "INSERT INTO Users(id, nom, password , id_role) VALUES(null, ? , ?, ?)";
    try {
        db.initPrepar(sql);
        db.getPstm().setString(1, user.getNom());
        db.getPstm().setString(2, user.getPassword());
//        db.getPstm().setString(3, user.getPasswordHashed());
        db.getPstm().setInt(3, user.getId_role());
        ok = db.executeMaj();
        db.closeConnection();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ok;
}


    //Liste des utilisateurs
    public List<Users> list() {
        List<Users> utilisateurs = new ArrayList<>();
        String sql ="SELECT * FROM Users ORDER BY id ASC";
        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                Users u = new Users();
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setId_role(rs.getInt("id_role"));
                utilisateurs.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return utilisateurs;
    }


}
