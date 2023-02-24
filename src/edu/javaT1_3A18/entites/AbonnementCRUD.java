package edu.javaT1_3A18.entites;


import edu.javaT1.interfaces.EntityCRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import edu.javaT1_3A18.entites.Abonnement;
import edu.javaT1_3A18.utils.DB;

public  class AbonnementCRUD implements EntityCRUD<Abonnement>{
  
    
    private final Connection conn = DB.getInstance().getCnx();

    public AbonnementCRUD() {
        
    }

    public void ajouter(Abonnement abonnement) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO abonnements (idAbonnement, idClient, dateDebut, dureeAbonnement, prix, typeAbonnement) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, abonnement.getIdAbonnement());
            stmt.setInt(2, abonnement.getIdClient());
            stmt.setDate(3, abonnement.getDateDebut());
            stmt.setString(4, abonnement.getDureeAbonnement());
            stmt.setFloat(5, (float) abonnement.getPrix());
            stmt.setString(6, abonnement.getTypeAbonnement());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifier(Abonnement abonnement) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE abonnements SET id_client=?, dateDebut=?, dureeAbonnement=?, prix=?, typeAbonnement=? WHERE idAbonnement=?");
            
            stmt.setInt(1, abonnement.getIdClient());
            stmt.setDate(2, abonnement.getDateDebut());
            stmt.setString(3, abonnement.getDureeAbonnement());
            stmt.setFloat(4, (float) abonnement.getPrix());
            stmt.setString(5, abonnement.getTypeAbonnement());
            stmt.setInt(6, abonnement.getIdAbonnement());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(int idAbonnement) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM abonnements WHERE idAbonnement=?");
            stmt.setInt(1, idAbonnement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Abonnement> lister() {
        List<Abonnement> abonnements = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM abonnements");
            while (rs.next()) {
                Abonnement abonnement = new Abonnement(
                        rs.getInt("idAbonnement"),
                        rs.getInt("idClient"),
                        rs.getDate("DateDebut"),
                        rs.getString("DureeAbonnement"),
                        rs.getFloat("Prix"),
                        rs.getString("TypeAbonnement")
                        
                         
                        
                ) ;
                abonnements.add(abonnement); // ajouter l'abonnement à la liste abonnements
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonnements;
    }

    
    public Abonnement trouverParIdAbonnement(int idAbonnement) {
       Abonnement abonnement = null;
       try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM abonnements WHERE idAbonnement = ?");
            stmt.setInt(1, idAbonnement);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                abonnement = new Abonnement(
                       rs.getInt("idAbonnement"),
                        rs.getInt("idClient"),
                        rs.getDate("DateDebut"),
                        rs.getString("DureeAbonnement"),
                        rs.getFloat("Prix"),
                        rs.getString("TypeAbonnement")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return abonnement;
    }
    public Abonnement trouverParIdClien(int idClient) {
       Abonnement abonnement = null;
       try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM abonnements WHERE idclient = ?");
            stmt.setInt(1, idClient);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                abonnement = new Abonnement(
                       rs.getInt("idAbonnement"),
                        rs.getInt("idClient"),
                        rs.getDate("DateDebut"),
                        rs.getString("DureeAbonnement"),
                        rs.getFloat("Prix"),
                        rs.getString("TypeAbonnement")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return abonnement;
    }

    

}
