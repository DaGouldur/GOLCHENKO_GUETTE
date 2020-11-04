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
    public boolean ajouterJetonDansColonne(Joueur JoueurCourant, int colonne){
        if(colonneRemplie(colonne)==false){
            int i=0;
            while(Cellules[i][colonne].JetonCourrant!=null){
                i++;
            }
            Jeton unJeton = JoueurCourant.retirerJeton();
            Cellules[i][colonne].JetonCourrant=unJeton;
            if(Cellules[i][colonne].presenceDesintegrateur()){
                Cellules[i][colonne].recupererDesintegrateur();
                JoueurCourant.nombreDesintegrateurs++;
            }
            if(Cellules[i][colonne].presenceTrouNoir()){
                Cellules[i][colonne].activerTrouNoir();
            }
        }
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
    public boolean celluleOccupee(int ligne, int colonne ){
        if (Cellules[ligne][colonne]!=null){
            return true;
        }
        return false;
    }
    public String lireCouleurDuJeton(int ligne, int colonne){
       return Cellules[ligne][colonne].lireCouleurDuJeton();
        
    }
    public boolean etreGagnantePourJoueur(Joueur JoueurCourrant){
        String Gagnant=null;
        String couleur;
        while(Gagnant==null){
            for(int i=0;i<6;i++){
                for(int j=0;i<7;i++){
                    if(Cellules[i][j]=="Rouge"){
                       couleur=lireCouleurDuJeton(i,j);
                       
                    }
        }
        }
        }
    }
    public void tasserGrille(int colonne){
        int i;
        for (i=0; i<7;i++){
            if(Cellules[i][colonne]==null){
                Cellules[i][colonne]=Cellules[i+1][colonne];
                if (i==6 && Cellules[6][colonne]==null){
                    Cellules[i][colonne]=null;
                }
                else{
                    Cellules[6][colonne]=Cellules[6][colonne];
                }
            }
        }
    }
   public boolean colonneRemplie(int indColonne){
        return(Cellules[5][indColonne].recupererJeton()!=null);
   }
   public boolean placerTrouNoir(int ligne, int colonne){
       if(Cellules[ligne][colonne]==null){
           return true;
       }
       return false;    
}
}
