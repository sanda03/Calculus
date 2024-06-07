package org.example;

import org.example.calculus.ractionator.Affirmation;
import org.example.calculus.ractionator.Resultat;
import org.example.calculus.ractionator.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllTest {
    @Test
    public void doit_etre_faux(){
        Affirmation mensonge = new Affirmation("Lou est pauvre", Status.MENSONGE);
        Affirmation affirmation = new Affirmation("Lou est généreux.", Status.AFFIRMATION);
        Affirmation verite = new Affirmation("Lou est beau.", Status.VERITE);

        assertEquals(verite.ou(affirmation).donc(mensonge).calculer(), Resultat.FAUX);
        assertEquals(mensonge.et(affirmation).calculer(), Resultat.FAUX);
        assertEquals(verite.donc(mensonge).calculer(), Resultat.FAUX);
    }

    @Test
    public void doit_etre_vrai(){
        Affirmation affirmation = new Affirmation("Lou est généreux.", Status.AFFIRMATION);
        Affirmation mensonge = new Affirmation("Lou est pauvre", Status.MENSONGE);

        assertEquals(mensonge.donc(affirmation).calculer(), Resultat.VRAI);
    }
}