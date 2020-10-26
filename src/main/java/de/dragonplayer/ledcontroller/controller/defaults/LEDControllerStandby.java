package de.dragonplayer.ledcontroller.controller.defaults;

import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDContainer;

public class LEDControllerStandby extends LEDController {

    public LEDControllerStandby() {
        super(-1);
    }

    @Override
    public LEDContainer update(LEDContainer ledContainer) {
        return ledContainer;
    }
}
