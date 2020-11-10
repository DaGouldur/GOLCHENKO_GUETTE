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
        Random rand= new Random();
        boolean couleur;
        couleur=rand.nextBoolean();
        if (couleur==true){
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
        System.out.println(J1.Couleur+" est attribué a "+J1.Nom);
        System.out.println(J2.Couleur+" est attribué a "+J2.Nom);
        Random rand= new Random();
        boolean lePremier=rand.nextBoolean();
        if(lePremier==true){
            JoueurCourant=ListeJoueurs[0];
        }
        else{
            JoueurCourant=ListeJoueurs[1];
        }
        for(int i=0;i<21;i++){
            J1.ajouterJeton(new Jeton(J1.Couleur));
            J2.ajouterJeton(new Jeton(J2.Couleur));
        }
        int compteur=0;
        for(int i=0;i<5;i++){
            int ligneTrouNoir=rand.nextInt(6);
            int colonneTrouNoir=rand.nextInt(7);
            if(compteur<2){
                GrilleJeu.placerDesintegrateur(ligneTrouNoir, colonneTrouNoir);
                compteur=compteur+1;
            }
            GrilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir);   
        }
        for(int i=0;i<3;i++){
            int ligneDesintegrateur=rand.nextInt(6);
            int colonneDesintegrateur=rand.nextInt(7);
            if(GrilleJeu.Cellules[ligneDesintegrateur][colonneDesintegrateur]==null){
            GrilleJeu.placerDesintegrateur(ligneDesintegrateur, colonneDesintegrateur);
            }
            }
        }
    }
