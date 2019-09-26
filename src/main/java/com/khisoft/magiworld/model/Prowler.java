package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public class Prowler extends Character {


    /**
     * The constructor.
     *
     * @param level        The level
     * @param strength     The strength
     * @param agility      The agility
     * @param intelligence The intelligence
     * @throws CharacterException The character exception
     */
    public Prowler(int level, int strength, int agility, int intelligence) throws CharacterException {
        super(level, strength, agility, intelligence);
    }

    /**
     * This method performs the basic attack.
     * The basic attack is "Performs damage equal to the player's agility on the opponent".
     * @return IAttack interface model.
     */
    public IAttack basicAttack() {
        IAttack  attack = new Attack(this.getAgility(),"Tir à l’Arc et inflige "+this.getAgility()+" dommages");
        return attack;
    }


    /**
     * This method performs the special attack.
     * The player gets level divided by 2 in agility.
     * @return The IAttack interface model.
     */
    public IAttack getSpecialAttack() throws CharacterException {
        setAgility(getAgility()/2+getAgility());
        IAttack  attack = new Attack(this.getAgility(),"Concentration et inflige "+this.getAgility()+" dommages");
        return attack;
    }

    @Override
    public String toString() {
        return "Oyé oyé chevalier je suis le Rodeur";
    }
}
