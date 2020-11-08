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
public class Cellule {
    boolean trouNoir;
    boolean desintegrateur;
    Jeton JetonCourant;
     
    public Cellule(){
        JetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }   
    public boolean affecterJeton(Jeton LeJetonCourrant){
        boolean A=false;
        if (JetonCourant==null){
            JetonCourant=LeJetonCourrant;
           A=true;
        }
        else{
            A=false;
        }
        
        return A;
    }
    public Jeton recupererJeton(){
       return JetonCourant;
    }
    public boolean supprimerJeton(){
       boolean B = false;
       if (JetonCourant!=null){
           JetonCourant=null;
           B=true;
       }
       else{
           B=false;
       }
       return B;
    }
    public boolean placerTrouNoir(){
        if (trouNoir==false){
            trouNoir=true;
        }
        return trouNoir;
    }
    public boolean placerDesintegrateur(){
        if (desintegrateur==false){
            desintegrateur=true;
        }
        return desintegrateur;
    }
    public boolean presenceDesintegrateur(){
       return desintegrateur;
    }
    public boolean presenceTrouNoir(){
        return trouNoir;
    }
    
    public String lireCouleurDuJeton(){
        return JetonCourant.Couleur;
    }
    public boolean recupererDesintegrateur(){
        if (desintegrateur==true){
            desintegrateur=false;
        }
        return desintegrateur;
    }
    public boolean activerTrouNoir(){
        if (trouNoir==true){
           if (JetonCourant!=null){
           JetonCourant=null;
           return true;
           }
           else{
               return false;
           }
        }
        else{
            return false;
        }
    }
}
