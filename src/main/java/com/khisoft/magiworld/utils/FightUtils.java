package com.khisoft.magiworld.utils;

import com.khisoft.magiworld.exception.CharacterException;
import com.khisoft.magiworld.model.IAttack;
import com.khisoft.magiworld.model.ICharacter;

import java.util.List;
import java.util.Scanner;

public class FightUtils {
    private final static int BASIC_ATTACK=1;
    private final static int SPECIAL_ATTACK=2;

    public static void fight(final List<ICharacter> characters, final Scanner scanner) throws CharacterException {
        int characterIndex=0;
        while (true)
        {
            ICharacter character =  characters.get(characterIndex);
            int damage = getAttack(scanner,character);
            if(characterIndex == 0) {
                characterIndex = 1;
            }
            else {
                characterIndex = 0;
            }
            ICharacter characterNext = characters.get(characterIndex);
            updateHP(damage,characterNext);
            if(characterNext.getHp()<=0 )
            {
                System.out.println("Joueur "+characterNext.getIndex()+" a perdu");
                break;
            }
            else if(character.getHp()<=0)
            {
                System.out.println("Joueur "+character.getIndex()+" a perdu");
                break;
            }

            //next turn


        }
    }

    /**
     * This method update the hp from the character in function of the attack.
     * @param damage The damage
     * @param character The character
     */
    private static void updateHP(int damage, ICharacter character) {
        System.out.println("Joueur "+character.getIndex()+" perd "+damage+" points de vie.");
        character.setHp(character.getHp() - damage);
    }

    /**
     * This method gets the attack.
     * @param scanner The Scanner
     * @param character The Character
     * @return The damage
     * @throws CharacterException The CharacterException exception.
     */
    private static int getAttack(Scanner scanner, ICharacter character) throws CharacterException {
        System.out.println("Joueur "+character.getIndex()+" ("+character.getHp()+" vitalié) veuillez choisir votre action " +
                "("+BASIC_ATTACK+": Attaque Basique, " +
                SPECIAL_ATTACK+": Attaque Spéciale)");
        int chosenAttack = scanner.nextInt();
        IAttack attack = null;
        switch (chosenAttack) {
            case BASIC_ATTACK:
                attack = character.getBasicAttack();
                break;
            case SPECIAL_ATTACK:
                attack = character.getSpecialAttack();
                break;
            default:
                System.err.println("Cette attaque n'est pas encore disponible");
                getAttack(scanner,character);

        }
        System.out.println(attack.getSentence());
        return attack.getDamage();
    }
}
