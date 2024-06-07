package org.example.calculus.ractionator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Affirmation {
    private final String contenu;
    private final Status status;

    public final Affirmation et(Affirmation affirmation){
        if(vrai(this) &&  vrai(affirmation)){
            return new Affirmation(ajouter(affirmation, "et"), Status.VERITE);
        }
        else if(faux(this) || faux(affirmation)){
            return new Affirmation(ajouter(affirmation, "et"), Status.MENSONGE);
        }else{
            return new Affirmation(ajouter(affirmation, "et"), Status.AFFIRMATION);
        }
    }

    public final Affirmation ou(Affirmation affirmation){
        if(vrai(this) || vrai(affirmation)){
            return new Affirmation(ajouter(affirmation, "ou"), Status.VERITE);
        }else if(jenesaispas(this) || jenesaispas(affirmation)){
            return new Affirmation(ajouter(affirmation, "ou"), Status.AFFIRMATION);
        }else{
            return new Affirmation(ajouter(affirmation, "ou"), Status.MENSONGE);
        }
    }

    public final Affirmation donc(Affirmation affirmation){
        if(vrai(this) && faux(affirmation)){
            return new Affirmation(ajouter(affirmation, "donc"), Status.MENSONGE);
        } else if(faux(this) || vrai(affirmation)){
            return new Affirmation(ajouter(affirmation, "donc"), Status.VERITE);
        }else{
            return new Affirmation(ajouter(affirmation, "donc"), Status.AFFIRMATION);
        }
    }

    public Resultat calculer(){
        if(this.status.equals(Status.AFFIRMATION))
            return Resultat.JE_NE_SAIS_PAS;
        if(this.status.equals(Status.VERITE))
            return Resultat.VRAI;
        return Resultat.FAUX;
    }

    private boolean vrai(Affirmation affirmation){
        return affirmation.status.equals(Status.VERITE);
    }

    private boolean jenesaispas(Affirmation affirmation){
        return affirmation.status.equals(Status.AFFIRMATION);
    }

    private boolean faux(Affirmation affirmation){
        return affirmation.status.equals(Status.MENSONGE);
    }

    private String ajouter(Affirmation b, String suffix){
        return this.contenu + " " + suffix + b.contenu;
    }
}