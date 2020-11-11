package de.dragonplayer.ledcontroller.controller.defaults;

import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDColor;
import de.dragonplayer.ledcontroller.util.LEDContainer;

public class LEDControllerPong extends LEDController {

    private int position;
    private boolean invert;
    private LEDColor color;

    public LEDControllerPong() {
        super(25);
        position = 0;
        invert = false;
        color = LEDColor.RED;
    }

    @Override
    public LEDContainer update(LEDContainer ledContainer) {
        ledContainer.modify(position + (position == 0 || position == ledContainer.getLength() - 1 ? (!invert ? 1 : -1) : (invert ? 1 : -1)), 0, 0, 0);
        ledContainer.modify(position, color.getR(), color.getG(), color.getB());
        position += invert ? -1 : 1;
        if (position <= 0 || position >= ledContainer.getLength() - 1) {
            invert = !invert;
            color = color.next();
        }
        return ledContainer;
    }
}
