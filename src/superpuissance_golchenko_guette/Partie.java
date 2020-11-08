/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dagou
 */
public class Partie {
    Joueur []  ListeJoueurs = new Joueur[2];
    Grille GrilleJeu=new Grille();
    Joueur JoueurCourant; 
    
    public void attribuerCouleursAuxJoueurs(){
        Random r= new Random();
        boolean couleur;
        couleur=r.nextBoolean();
        if (couleur){
            ListeJoueurs[0].Couleur="Rouge";
            ListeJoueurs[1].Couleur="Jaune";
        }
        else{
             ListeJoueurs[0].Couleur="Jaune";  
             ListeJoueurs[1].Couleur="Rouge";
        }
        
    }
    public Joueur prochainJoueur(Joueur UnJoueur){
        if (ListeJoueurs[0]==JoueurCourant){
            return ListeJoueurs[1];
        }
        return ListeJoueurs[0];
    }
    public void initialiserPartie(){
        GrilleJeu.viderGrille();
        Scanner sc=new Scanner(System.in);
        System.out.println("Pseudo du premier joueur: ");
        Joueur J1=new Joueur(sc.nextLine());
        System.out.println("Pseudo du second joueur: ");
        Joueur J2=new Joueur(sc.nextLine());
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        attribuerCouleursAuxJoueurs();
        System.out.println(J1.Nom+" est de couleur "+J1.Couleur);
        System.out.println(J2.Nom+" est de couleur "+J2.Couleur);
        for (int i=0;i<21; i++){
        }
    }
}
