package entity;

import dao.DB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Role {
    public int id;
//    public static int cpt ;
    public String nom_role;


    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_role() {
        return nom_role;
    }

    public void setNom_role(String nom_role) {
        this.nom_role = nom_role;
    }
    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    public int add(Role roles) {
        String sql = "INSERT INTO role( id , nom_role) VALUES(null, ? )";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, roles.getNom_role());


            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }


    public List<Role> list() {
        List<Role> role = new ArrayList<>();
        String sql ="SELECT * FROM role ORDER BY id ASC";
        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setNom_role(rs.getString("nom_role"));
                role.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }
    }

