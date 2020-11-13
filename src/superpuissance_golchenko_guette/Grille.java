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
            while(Cellules[i][colonne].JetonCourant!=null){
                i++;
            }
            Jeton unJeton = JoueurCourant.retirerJeton();
            Cellules[i][colonne].JetonCourant=unJeton;
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
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j].JetonCourant==null){
                return false;
            }
        }
    }
        return true;
    }
public void viderGrille(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            Cellules[i][j].JetonCourant=null;// supprime les jetons
            if (Cellules[i][j].presenceTrouNoir()==true){// supprime ls trous noirs
                Cellules[i][j].trouNoir=false;
            }
            if (Cellules[i][j].presenceDesintegrateur()==true){// supprime les desintegrateurs
                Cellules[i][j].desintegrateur=false;
            } 
        }
    }
}
    public void afficherGrilleSurConsole(){
        for (int i =0;i<6;i++){
            for (int j =0;j<7;j++){
                if (Cellules[i][j].trouNoir==true){
                    System.out.print(" T");
                }
                if (Cellules[i][j].desintegrateur==true){
                    System.out.print(" D");
                }
                if (Cellules[i][j].JetonCourant==null){
                    System.out.print(" N");   
                }
                else{
                    System.out.print(" "+Cellules[i][j].JetonCourant);
                }
            }
            System.out.println(" ");
        }
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
        for (int i = 0; i<6 ; i++){
        for (int j = 0; j<7 ; j++){
        if (lireCouleurDuJeton(i, j) == lireCouleurDuJeton(i+1, j) && lireCouleurDuJeton(i + 1, j) == lireCouleurDuJeton(i+2, j) && lireCouleurDuJeton(i+2, j) == lireCouleurDuJeton(i+3, j) || lireCouleurDuJeton(i, j) == lireCouleurDuJeton(i, j+1) && lireCouleurDuJeton(i, j+1) == lireCouleurDuJeton(i, j+2) && lireCouleurDuJeton(i, j+2) == lireCouleurDuJeton(i, j+3)){
            return true;
        }
       
        if (lireCouleurDuJeton(i, j) == lireCouleurDuJeton(i-1, j+1) && lireCouleurDuJeton(i-1, j+1) == lireCouleurDuJeton(i-2, j+2) && lireCouleurDuJeton(i-2, j+2) == lireCouleurDuJeton(i-3, j+3) || lireCouleurDuJeton(i, j) == lireCouleurDuJeton(i+1, j+1) && lireCouleurDuJeton(i+1, j+1) == lireCouleurDuJeton(i+2, j+2) && lireCouleurDuJeton(i+2, j+2) == lireCouleurDuJeton(i+3, j+3)){
            return true;
        }
    } 
    }
    return false;
}
    public void tasserGrille(int ligne,int colonne){
     while (ligne>0){
        Cellules[ligne][colonne].JetonCourant=Cellules[ligne-1][colonne].JetonCourant;
        ligne=ligne-1;
         
    }
    Cellules[0][colonne].JetonCourant=null;
    }
   public boolean colonneRemplie(int indColonne){
        return(Cellules[5][indColonne].recupererJeton()!=null);
   }
   public boolean placerTrouNoir(int ligne, int colonne){
       if(Cellules[ligne][colonne].presenceTrouNoir()==false){
           Cellules[ligne][colonne].placerTrouNoir();
           return true;
       }
       return false;    
}
      public boolean placerDesintegrateur(int ligne, int colonne){
       if(Cellules[ligne][colonne].presenceDesintegrateur()==false){
           Cellules[ligne][colonne].placerDesintegrateur();
           return true;
        }
       return false;    
}
    public boolean supprimerJeton(int ligne, int colonne){
       if(Cellules[ligne][colonne].JetonCourant!=null){
           Cellules[ligne][colonne].JetonCourant=null;
           return true;
       }
       return false;    
}     
    public Jeton recupererJeton(int ligne, int colonne){
        return Cellules[ligne][colonne].recupererJeton();
    }
}
