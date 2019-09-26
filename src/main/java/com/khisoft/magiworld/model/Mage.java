package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public class Mage extends Character {
    /**
     * The constructor.
     *
     * @param level        The level
     * @param strength     The strength
     * @param agility      The agility
     * @param intelligence The intelligence
     * @throws CharacterException The character exception
     */
    public Mage(int level, int strength, int agility, int intelligence) throws CharacterException {
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
     * The player heals his life and regains his amount of intelligence times 2 in life points.
     * Careful, he can’t have more life than he had in the first place.
     * @return The IAttack interface model.
     */
    public IAttack getSpecialAttack() throws CharacterException {
        int hpWon = getIntelligence()*2;
        int hp = getHp()+hpWon;
        if(hp>getLevel()*5) {
            hp = getLevel() * 5;
        }
        setHp(hp);
        IAttack  attack = new Attack(this.getStrength(),"Soin et gagne "+hp+" vitalité");
        return attack;
    }

    @Override
    public String toString() {
        return "Abracadabra je suis le mage";
    }
}