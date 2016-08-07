package org.dragons.core.valueobject;

public class Dragon {

    private Integer scaleThickness;
    private Integer clawSharpness;
    private Integer wingStrength;
    private Integer fireBreath;

    public Dragon(Integer scaleThickness, Integer clawSharpness, Integer wingStrength, Integer fireBreath) {
        this.scaleThickness = scaleThickness;
        this.clawSharpness = clawSharpness;
        this.wingStrength = wingStrength;
        this.fireBreath = fireBreath;
    }

    public Integer getScaleThickness() {
        return scaleThickness;
    }

    public Integer getClawSharpness() {
        return clawSharpness;
    }

    public Integer getWingStrength() {
        return wingStrength;
    }

    public Integer getFireBreath() {
        return fireBreath;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "scaleThickness=" + scaleThickness +
                ", clawSharpness=" + clawSharpness +
                ", wingStrength=" + wingStrength +
                ", fireBreath=" + fireBreath +
                '}';
    }
}
