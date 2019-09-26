package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public class Warrior extends  Character {
    /**
     * The constructor.
     *
     * @param level        The level
     * @param strength     The strength
     * @param agility      The agility
     * @param intelligence The intelligence
     * @throws CharacterException The character exception
     */
    public Warrior(int level, int strength, int agility, int intelligence) throws CharacterException {
        super(level, strength, agility, intelligence);
    }

    /**
     * This method performs the basic attack.
     * The basic attack is "Performs damage equal to the player's strength on the opponent".
     * @return IAttack interface model.
     */
    public IAttack basicAttack() {
        IAttack  attack = new Attack(this.getStrength(),"Coup d’Épée et inflige "+this.getStrength()+" dommages");
        return attack;
    }


    /**
     * This method performs the special attack.
     * Performs damage equal to the player's two-time force on the opponent.
     * The player launching the attack loses vitality: the value of his force divided by 2.
     * @return The IAttack interface model.
     */
    public IAttack getSpecialAttack() throws CharacterException {
        setStrength(getStrength()/2);
        IAttack  attack = new Attack(this.getStrength(),"Coup de Rage et inflige "+this.getStrength()+" dommages");
        return attack;
    }

    @Override
    public String toString() {
        return "Woarg je suis le Guerrier";
    }
}
