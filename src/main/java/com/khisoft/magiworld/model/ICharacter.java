package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public interface ICharacter {
    /**
     * This method is the basic attack.
     * @return IAttack interface model.
     */
    IAttack getBasicAttack();

    /**
     * This method is the special attack.
     * @return IAttack interface model.
     */
    IAttack getSpecialAttack() throws CharacterException;

    /**
     * This method gets the HP
     * @return the hp
     */
    int getHp();

    /**
     * This method set the HP.
     * @param hp The hp to set.
     */
    void setHp(int hp);

    /**
     * This method gets the character index.
     * @return the character index.
     */
    int getIndex();
}
