package com.khisoft.magiworld.model;

public class Attack implements IAttack {
    private int damage;
    private String sentence="";

    /**
     * The constructor.
     * @param damage The damage
     * @param sentence The sentence
     */
    public Attack(int damage, String sentence) {
        this.damage = damage;
        this.sentence = sentence;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getSentence() {
        return this.sentence;
    }
}
