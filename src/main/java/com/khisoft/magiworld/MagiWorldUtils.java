package com.khisoft.magiworld;

import com.khisoft.magiworld.exception.CharacterException;
import com.khisoft.magiworld.model.ICharacter;
import com.khisoft.magiworld.model.Mage;
import com.khisoft.magiworld.model.Prowler;
import com.khisoft.magiworld.model.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagiWorldUtils {

    /**
     * Constants
     */
    private final static String  CHARACTER_ERROR = "Veuillez saisir un entier entre 1 et 3";
    private final static int WARRIOR = 1;
    private final static int PROWLER = 2;
    private final static int MAGE = 3;

    /**
     * This method ceates two characters.
     * @param scanner The Scanner object
     * @return The list of two characters.
     */
    public static List<ICharacter> createCharacters(final Scanner scanner) throws CharacterException {
        final List<ICharacter> characters = new ArrayList<>();
        System.out.println("Création du personnage du Joueur 1");
        characters.add( createCharacter(scanner,1));
        System.out.println("Création du personnage du Joueur 2");
        characters.add( createCharacter(scanner,2));
        return characters;
    }

    /**
     * This method create a character.
     * @param scanner The Scanner object
     * @param index The character index.
     * @return The character.
     */
    private static ICharacter createCharacter(final Scanner scanner,int index) throws CharacterException {
        System.out.println("Veuillez choisir la classe de votre personnage ("+WARRIOR+" : Guerrier, "+PROWLER+" : Rôdeur, "+MAGE+" : Mage");
        return create(scanner,index, scanner.nextInt());

    }

    /**
     * This method creates the personnage with level, ...
     * @param scanner The Scanner object
     * @param index The character index.
     * @param chosenCharacter The chosen character
     * @return The character.
     */
    private static ICharacter create(final Scanner scanner,int index, int chosenCharacter)   {
        int level = getLevel(scanner);
        int strength = getFeature(scanner,"Force du personnage ?");
        int agility = getFeature(scanner,"Agilité du personnage ?");
        int intelligence = getFeature(scanner,"Intelligence du personnage ?");
        ICharacter character = null;
        try {
            switch (chosenCharacter) {
                case (WARRIOR):
                    character = new Warrior(index, level, strength, agility, intelligence);
                    break;
                case (PROWLER):
                    character = new Prowler(index, level, strength, agility, intelligence);
                    break;
                case (MAGE):
                    character = new Mage(index, level, strength, agility, intelligence);
                    break;
                default:
                    System.err.println("Le personnage " + chosenCharacter + " n'est pas encore disponible");
            }
        }catch (CharacterException characterException)
        {
            System.err.println(characterException.getMessage());
            return create(scanner,index,chosenCharacter);
        }
        // Get the introduction sentence.
        System.out.println(character.toString());

        return character;
    }

    /**
     * This method get a feature between 0 and 100.
     * @param scanner The Scanner object
     * @param sentence The sentence for the feature.
     * @return The feature value.
     */
    private static int getFeature(final Scanner scanner, String sentence) {
        System.out.println(sentence);
        int feature = scanner.nextInt();
        if (feature < 0 || feature > 100) {
            System.err.println("La valeur doit être entre 0 et 100");
            return  getFeature(scanner,sentence);
        }
        return feature;

    }

    /**
     * This method get the level for the character.
     * @param scanner The Scanner object
     * @return The character level between 1 and 100
     */
    private static int getLevel(final Scanner scanner) {
        System.out.println("Niveau du personnage ? ");
         int level = scanner.nextInt();
        if (level < 1 || level > 100) {
            System.err.println("Le level doit être entre 1 et 100");
            return getLevel(scanner);
        }
        return level;
    }

}
