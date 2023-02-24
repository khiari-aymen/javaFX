/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.javaT1.interfaces;
import java.util.List;

/**
 *
 * @author khiar
 * @param <Abonnement>
 */

    

public interface EntityCRUD<Abonnement> {
    void ajouter(Abonnement entity);
    void modifier(Abonnement entity);
    void supprimer(int id);
    List<Abonnement> lister();
}
    

