package de.dragonplayer.ledcontroller.controller.defaults;

import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDContainer;

public class LEDControllerFade extends LEDController {

    private int r;
    private int g;
    private int b;

    public LEDControllerFade() {
        super(100);
        r = 255;
        g = 0;
        b = 0;
    }

    @Override
    public LEDContainer update(LEDContainer ledContainer) {
        if (b == 0 && r > 0) {
            r--;
            g++;
        } else if (r == 0 && g > 0) {
            g--;
            b++;
        } else if (g == 0 && b > 0) {
            b--;
            r++;
        }
        ledContainer.fill(0, ledContainer.getLength() - 1, r, g, b);
        return ledContainer;
    }
}
