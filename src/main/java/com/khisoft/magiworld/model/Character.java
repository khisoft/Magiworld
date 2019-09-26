package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

/**
 * @author Xgin33
 */
public abstract class Character implements ICharacter{
    private int level, hp, strength, agility, intelligence;

    /**
     * The constructor.
     * @param level The level
     * @param strength The strength
     * @param agility The agility
     * @param intelligence The intelligence
     * @throws CharacterException The character exception
     */
    public Character(int level, int strength, int agility, int intelligence) throws CharacterException {
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hp = 5*level;
        checkFeatures();

    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws CharacterException {
        if (level >= 1 && level <= 100) {
            this.level = level;
        } else {
            throw new CharacterException("Le niveau est entre 1 et 100");
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) throws CharacterException {
        checkFeature(strength);
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) throws CharacterException {
        checkFeature(agility);
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) throws CharacterException {
        checkFeature(intelligence);
        this.intelligence = intelligence;
    }

    public void setDamage(int damage)
    {
        this.hp -=damage;
    }

    /**
     * This method check the feature.
     * @param feature The feature to check.
     * @return The 'True' if the feature is correct.
     * @throws CharacterException The character exception
     */
    private boolean checkFeature(int feature) throws CharacterException {
        if (feature < 0 || feature > 100) {
            throw new CharacterException("La caractéristique "+feature+" doit être entre 0 et 100");
        } else {
            return true;
        }
    }


    /**
     * This method checks if features are equal to level.
     * @return The 'True' if features are equal to level.
     * @throws CharacterException
     * Verifie si tous les points sont égaux ou inferieur par rapport au niveau
     */
    private boolean checkFeatures() throws CharacterException {
        if((this.agility + this.intelligence+ this.strength) != this.level){
            throw new CharacterException("Le level et l'ensemble des caractériques du personnage doivent être égale");
        }
        return true;
    }

}
