package org.dragons.core.request;

import org.dragons.core.valueobject.Dragon;

import java.util.HashMap;
import java.util.Map;

//TODO Rework and cleanup
public class SolveBattleRequestWrapper {

    private static final String SCALE_THICKNESS_JSON_TAG_NAME = "scaleThickness";
    private static final String CLAW_SHARPNESS_JSON_TAG_NAME = "clawSharpness";
    private static final String WING_STRENGTH_JSON_TAG_NAME = "wingStrength";
    private static final String FIRE_BREATH_JSON_TAG_NAME = "fireBreath";
    private static final String DRAGON_JSON_TAG_NAME = "dragon";

    private Dragon dragon;

    public SolveBattleRequestWrapper(Dragon dragon) {
        this.dragon = dragon;
    }

    public Map<String, Object> getBody() {
        Map<String, Object> request = new HashMap<String, Object>();

        if(dragon != null) {
            Map<String, Object> dragonAttributes = new HashMap<String, Object>();

            dragonAttributes.put(SCALE_THICKNESS_JSON_TAG_NAME, dragon.getScaleThickness());
            dragonAttributes.put(CLAW_SHARPNESS_JSON_TAG_NAME, dragon.getClawSharpness());
            dragonAttributes.put(WING_STRENGTH_JSON_TAG_NAME, dragon.getWingStrength());
            dragonAttributes.put(FIRE_BREATH_JSON_TAG_NAME, dragon.getFireBreath());

            request.put(DRAGON_JSON_TAG_NAME, dragonAttributes);
        }
        return request;
    }
}
