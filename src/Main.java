import entity.Role;
import entity.Users;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Users utilisateur = new Users();
        Scanner scan = new Scanner(System.in);
        Role role = new Role();
        List<Role> roles = role.list();

        System.out.println("Liste des rôles disponibles :");
        for (Role r : roles) {
            System.out.println("ID : " + r.getId() + ", Nom : " + r.getNom_role());
               int ess = r.getId();
            utilisateur.setId_role(ess);
        }

        System.out.println("Choix du rôle pour l'utilisateur (entrez l'ID du rôle) :");
        int choix = scan.nextInt();

        boolean roleExiste = false;
        for (Role r : roles) {
            if (r.getId() == choix) {
                roleExiste =  true;
//                utilisateur.setId_role(r.getId());
                break;
            }
        }

        if (roleExiste) {
            System.out.println("Donner le nom de l'utilisateur :");
            String nomUtilisateur = scan.next();

            System.out.println("Donner le mot de passe de l'utilisateur :");
            String passwordUtilisateur = scan.next();


//            String hashedPassword = BCrypt.hashpw(passwordUtilisateur, BCrypt.gensalt());

            utilisateur.setNom(nomUtilisateur);
            utilisateur.setPassword(passwordUtilisateur);

//            utilisateur.setPasswordHhashed(hashed Password);
            utilisateur.add(utilisateur);
            System.out.println("Utilisateur ajouté avec succès !");
        } else {
            System.out.println("Rôle choisi invalide.");
        }



        List<Users> users = utilisateur.list();
        System.out.println("\nListe des utilisateurs avec leur rôle :");
        for (Users u : users) {
            System.out.println("Nom : " + u.getNom() + ", Rôle : " + u.getId_role());
        }
    }
}


 

