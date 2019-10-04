package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    void getBasicAttack() {
        System.out.println("Attaque Basique - Boule de Feu : Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire.");
        try {
            Mage mage = new Mage(1,10,0,0,10);
            final int expectedDamage  = 10;
            final int expectedHp = 50;
            final String expectedSentence = "Joueur 1 utilise Boule de Feu et inflige 10 dommages";
            IAttack attack = mage.getBasicAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, mage.getHp());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void getSpecialAttack() {
        System.out.println("Attaque Spéciale - Soin : Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie. Attention, il ne peut pas avoir plus de vie qu’il n’en avait au départ.");
        try {
            Mage mage = new Mage(1,10,0,0,10);
            mage.setHp(40);
            assertEquals(40, mage.getHp());
            final int expectedDamage  =0;
            final int expectedHp = 50;
            final String expectedSentence = "Joueur 1 utilise Soin et gagne 20 de vitalité";
            IAttack attack = mage.getSpecialAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, mage.getHp());

        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    void testToString() {
        String expectedSentence  = "Abracadabra je suis le Mage Joueur 1 niveau 10 je posséde 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !";
        try {
            Mage mage = new Mage(1,10,0,0,10);
            assertEquals(expectedSentence,mage.toString());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}