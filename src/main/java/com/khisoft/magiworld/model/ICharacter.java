package com.khisoft.magiworld.model;

import com.khisoft.magiworld.exception.CharacterException;

public interface ICharacter {
    /**
     * This method is the basic attack.
     * @return IAttack interface model.
     */
    IAttack basicAttack();

    /**
     * This method is the special attack.
     * @return IAttack interface model.
     */
    IAttack getSpecialAttack() throws CharacterException;
}
