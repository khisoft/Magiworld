package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public class Warrior extends  Character implements ICharacter {
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
    public Warrior(int index, int level, int strength, int agility, int intelligence) throws CharacterException {
        super(index,level, strength, agility, intelligence);
    }

    /**
     * This method performs the basic attack.
     * The basic attack is "Performs damage equal to the player's strength on the opponent".
     * @return IAttack interface model.
     */
    public IAttack getBasicAttack() {
        IAttack  attack = new Attack(this.getStrength(),"Joueur "+getIndex()+" utilise Coup d’Épée et inflige "+this.getStrength()+" dommages");
        return attack;
    }


    /**
     * This method performs the special attack.
     * Performs damage equal to the player's two-time force on the opponent.
     * The player launching the attack loses vitality: the value of his force divided by 2.
     * @return The IAttack interface model.
     */
    public IAttack getSpecialAttack() throws CharacterException {
        int hpLoose = getStrength()/2;
        setHp(getHp()-hpLoose);
        IAttack  attack = new Attack(this.getStrength()*2,"Joueur "+getIndex()+" utilise Coup de Rage et inflige "+this.getStrength()*2+" dommages");
        System.out.println("Joueur "+getIndex()+" perd "+hpLoose+" points de vie");
        return attack;
    }

    @Override
    public String toString() {
        return "Woarg je suis le Guerrier Joueur "+getIndex()+" niveau "+getLevel()+" je posséde "+getHp()+
                " de vitalité, "+getStrength()+" de force, "+getAgility()+" d'agilité et "+getIntelligence()+" d'intelligence !";
    }
}
