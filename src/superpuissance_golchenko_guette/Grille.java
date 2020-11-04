/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

/**
 *
 * @author dagou
 */
public class Grille {
     Cellule [][] Cellules = new Cellule [6][7];
    public Grille(){
       for (int i=0; i<6; i++){
           for (int j=0; j<7; j++){
               Cellules[i][j]=new Cellule();
           }
       }
       
    }
    public boolean colonneRemplie(int ind_colonne){
        return(Cellules[5][ind_colonne].recupererJeton()!=null);
    }
    public boolean ajouterJetonDansColonne(Joueur jouerCourrant, int ind_colonne){
        if(colonneRemplie(ind_colonne)==true){
            return false;
        }
        int i=0;
        
     return true;   
    }
    public boolean etreRemplie(){
        for (int i=0; i<6; i++){
           for (int j=0; j<7; j++){
               if (Cellules[i][j]!=null){
               return true;
               }
               else{
                   return false;
               }
           }    
        }
        return false;
    }
    public void viderGrille(){
        for (int i=0; i<6; i++){
           for (int j=0; j<7; j++){
               Cellules[i][j]=null;
           }
        }
    }
    public void afficherGrilleSurConsole(){
        System.out.println(Cellules[6][7]);
    }
    public boolean celluleOccupee(int indLigne, int indColonne ){
        if (Cellules[indLigne][indColonne]!=null){
            return true;
        }
        return false;
    }
    public String lireCouleurDuJeton(int indLigne, int indColonne){
       
        
    }
    public boolean etreGagnantePourJoueur(Joueur JoueurCourrant){
           
    }
    public void tasserGrille(int intColonne){
        int i;
        for (i=0; i<7;i++){
            if(Cellules[i][intColonne]==null){
                Cellules[i][intColonne]=Cellules[i+1][intColonne];
            }
        }
    }
}
