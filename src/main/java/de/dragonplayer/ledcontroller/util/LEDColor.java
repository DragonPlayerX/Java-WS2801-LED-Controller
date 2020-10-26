package de.dragonplayer.ledcontroller.util;

public enum LEDColor {
    RED(255, 0, 0),
    ROSE(255, 0, 128),
    MAGENTA(255, 0, 255),
    VIOLET(128, 0, 255),
    BLUE(0, 0, 255),
    AZURE(0, 128, 255),
    CYAN(0, 255, 255),
    SPRING(0, 255, 128),
    GREEN(0, 255, 0),
    CHARTREUSE(128, 255, 0),
    YELLOW(255, 255, 0),
    ORANGE(255, 128, 0),
    BLACK(0, 0, 0);

    private int r;
    private int g;
    private int b;

    LEDColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    private int getIndex() {
        for (int i = 0; i < values().length; i++) {
            if (values()[i] == this) {
                return i;
            }
        }
        return 0;
    }

    public LEDColor next() {
        int index = getIndex();
        if (index >= values().length - 2) {
            return values()[0];
        } else {
            return values()[index + 1];
        }
    }
}
