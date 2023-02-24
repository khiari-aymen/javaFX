/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.javaT1_3A18.entites;

/**
 *
 * @author khiar
 */
public class Type {
    
  private String nom;
  private float prix;
  private int id;

   
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Type(int id,String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
        this.id= id;
    }

    public Type() {
    }
  
    
}
