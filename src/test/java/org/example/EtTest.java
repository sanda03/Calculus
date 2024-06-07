package org.example;

import org.example.calculus.ractionator.Affirmation;
import org.example.calculus.ractionator.Resultat;
import org.example.calculus.ractionator.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class EtTest {
    @Test
    public void doit_etre_vrai(){
        Affirmation verite = new Affirmation("Lou est beau.", Status.VERITE);
        assertEquals(verite.et(verite).calculer(), Resultat.VRAI);
    }

    @Test
    public void doit_etre_faux(){
        Affirmation verite = new Affirmation("Lou est beau.", Status.VERITE);
        Affirmation affirmation = new Affirmation("Lou est généreux.", Status.AFFIRMATION);
        Affirmation mensonge = new Affirmation("Lou est pauvre", Status.MENSONGE);
        assertEquals(verite.et(verite).et(mensonge.et(verite)).calculer(), Resultat.FAUX);
        assertEquals(verite.et(mensonge).et(affirmation.et(verite)).calculer(), Resultat.FAUX);
    }

    @Test
    public void doit_etre_jenesaispas(){
        Affirmation verite = new Affirmation("Lou est beau.", Status.VERITE);
        Affirmation affirmation = new Affirmation("Lou est généreux.", Status.AFFIRMATION);
        assertEquals(verite.et(affirmation).calculer(), Resultat.JE_NE_SAIS_PAS);
        assertEquals(verite.et(affirmation.et(verite)).calculer(), Resultat.JE_NE_SAIS_PAS);
    }
}