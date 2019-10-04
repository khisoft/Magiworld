package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProwlerTest {

    @Test
    void getBasicAttack() {
        System.out.println("Attaque Basique - Tir à l’Arc : Effectue des dommages égaux à l’agilité du joueur sur l’adversaire.");
        try {
            Prowler prowler = new Prowler(1,10,0,10,0);
            final int expectedDamage  = 10;
            final int expectedHp = 50;
            final String expectedSentence = "Joueur 1 utilise Tir à l’Arc et inflige 10 dommages";
            IAttack attack = prowler.getBasicAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, prowler.getHp());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void getSpecialAttack() {
        System.out.println("Attaque Spéciale - Concentration : Le joueur gagne son niveau divisé par 2 en agilité.");
        try {
            Prowler prowler = new Prowler(1,10,0,10,0);
            final int expectedDamage  =0;
            final int expectedHp = 50;
            final int expectedAgility = 15;
            final String expectedSentence = "Joueur 1 utilise Concentration et gagne 5 d'agilité";
            IAttack attack = prowler.getSpecialAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, prowler.getHp());
            assertEquals(expectedAgility, prowler.getAgility());

        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }


    }

    @Test
    void testToString() {
        String expectedSentence  = "Oyé oyé chevalier je suis le Rodeur Joueur 1 niveau 10 je posséde 50 de vitalité, 0 de force, 10 d'agilité et 0 d'intelligence !";
        try {
            Prowler prowler = new Prowler(1,10,0,10,0);
            assertEquals(expectedSentence,prowler.toString());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}