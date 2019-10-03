package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public class Prowler extends Character implements ICharacter{


    /**
     * The constructor.
     *
     * @param index        The index
     * @param level        The level
     * @param strength     The strength
     * @param agility      The agility
     * @param intelligence The intelligence
     * @throws CharacterException The character exception
     */
    public Prowler(int index, int level, int strength, int agility, int intelligence) throws CharacterException {
        super(index,level, strength, agility, intelligence);
    }

    /**
     * This method performs the basic attack.
     * The basic attack is "Performs damage equal to the player's agility on the opponent".
     * @return IAttack interface model.
     */
    public IAttack getBasicAttack() {
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
        return "Oyé oyé chevalier je suis le Rodeur Joueur "+getIndex()+" niveau "+getLevel()+" je posséde "+getHp()+
                " de vitalité, "+getStrength()+" de force, "+getAgility()+" d'agilité et "+getIntelligence()+" d'intelligence !";
    }
}
