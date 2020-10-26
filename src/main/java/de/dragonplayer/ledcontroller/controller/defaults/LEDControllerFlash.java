package de.dragonplayer.ledcontroller.controller.defaults;

import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDColor;
import de.dragonplayer.ledcontroller.util.LEDContainer;

public class LEDControllerFlash extends LEDController {

    private LEDColor ledColor;

    public LEDControllerFlash(int speed) {
        super(speed);
    }

    @Override
    public LEDContainer update(LEDContainer ledContainer) {
        ledContainer.fill(0, ledContainer.getLength() - 1, ledColor.getR(), ledColor.getG(), ledColor.getB());
        ledColor = ledColor.next();
        return ledContainer;
    }
}
