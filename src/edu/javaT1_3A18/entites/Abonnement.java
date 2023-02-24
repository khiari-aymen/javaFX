/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.javaT1_3A18.entites;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author khiar
 */
public class Abonnement {
    private int idAbonnement;
    private int idClient;
    private Date dateDebut;
    private String DureeAbonnement;
    private float prix;
    private String TypeAbonnement;

    // constructeurs, getters, setters


public enum DureeAbonnement {
    TROIS_MOIS,
    SIX_MOIS,
    UN_AN,
}




    public Abonnement(int idAbonnement ,int idClient, Date dateDebut, String DureeAbonnement, float prix, String TypeAbonnement) {
        this.idAbonnement = idAbonnement;
        this.idClient = idClient;
        this.dateDebut = dateDebut;
        this.DureeAbonnement = DureeAbonnement;
        this.prix = prix;
        this.TypeAbonnement = TypeAbonnement;
    }

    public Abonnement(int idClient, Date dateDebut, String DureeAbonnement, float prix, String TypeAbonnement) {
        this.idClient = idClient;
        this.dateDebut = dateDebut;
        this.DureeAbonnement = DureeAbonnement;
        this.prix = prix;
        this.TypeAbonnement = TypeAbonnement;
    }

    public Abonnement() {
    }

    public int getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(int idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDureeAbonnement() {
        return DureeAbonnement;
    }

    public void setDureeAbonnement(String DureeAbonnement) {
        this.DureeAbonnement = DureeAbonnement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTypeAbonnement() {
        return TypeAbonnement;
    }

    public void setTypeAbonnement(String TypeAbonnement) {
        this.TypeAbonnement = TypeAbonnement;
    }


}





