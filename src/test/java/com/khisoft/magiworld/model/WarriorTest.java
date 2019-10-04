package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @org.junit.jupiter.api.Test
    void getBasicAttack() {
        System.out.println("Attaque Basique - Coup d’Épée : Effectue des dommages égaux à la force du joueur sur l’adversaire.");
        try {
            Warrior warrior = new Warrior(1,10,10,0,0);
            final int expectedDamage  = 10;
            final int expectedHp = 50;
            final String expectedSentence = "Joueur 1 utilise Coup d’Épée et inflige 10 dommages";
            IAttack attack = warrior.getBasicAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, warrior.getHp());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }


    }

    @org.junit.jupiter.api.Test
    void getSpecialAttack() {
        System.out.println("Attaque Spéciale - Coup de Rage : Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire. Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2.");
        try {
            Warrior warrior = new Warrior(1,10,10,0,0);
            final int expectedDamage  = 20;
            final int expectedHp = 45;
            final String expectedSentence = "Joueur 1 utilise Coup de Rage et inflige 20 dommages";
            IAttack attack = warrior.getSpecialAttack();
            assertEquals(expectedDamage, attack.getDamage());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedSentence, attack.getSentence());
            assertEquals(expectedHp, warrior.getHp());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expectedSentence  = "Woarg je suis le Guerrier Joueur 1 niveau 10 je posséde 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !";
        try {
            Warrior warrior = new Warrior(1,10,10,0,0);
            assertEquals(expectedSentence,warrior.toString());
        } catch (CharacterException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }
}