package de.dragonplayer.ledcontroller.controller;

import de.dragonplayer.ledcontroller.util.LEDContainer;

public abstract class LEDController {

    private int speed;

    public LEDController(int speed) {
        this.speed = speed;
    }

    public abstract LEDContainer update(LEDContainer ledContainer);

    public int getSpeed() {
        return speed;
    }
}
