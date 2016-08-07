package org.dragons.core.valueobject;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

public class Knight {

    private Integer attack;
    private Integer armor;
    private Integer agility;
    private Integer endurance;

    public Knight(Integer attack, Integer armor, Integer agility, Integer endurance) {
        this.attack = attack;
        this.armor = armor;
        this.agility = agility;
        this.endurance = endurance;
    }

    public Knight() {
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getArmor() {
        return armor;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public List<Integer> getAttributesArray() {
        return Arrays.asList(attack, armor, agility, endurance);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "attack=" + attack +
                ", armor=" + armor +
                ", agility=" + agility +
                ", endurance=" + endurance +
                '}';
    }
}