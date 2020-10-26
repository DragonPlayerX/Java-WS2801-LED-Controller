package de.dragonplayer.ledcontroller.controller.defaults;

import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDColor;
import de.dragonplayer.ledcontroller.util.LEDContainer;

public class LEDControllerColor extends LEDController {

    private LEDColor ledColor;

    public LEDControllerColor(LEDColor ledColor) {
        super(-1);
        this.ledColor = ledColor;
    }

    @Override
    public LEDContainer update(LEDContainer ledContainer) {
        return ledContainer.fill(0, ledContainer.getLength() - 1, ledColor.getR(), ledColor.getG(), ledColor.getB());
    }
}
