package de.dragonplayer.ledcontroller.util;

public class LEDContainer {

    private final byte[] bytes;

    public LEDContainer(int length) {
        bytes = new byte[length * 3];
    }

    public LEDContainer modify(int led, int r, int g, int b) {
        if (led >= 0 && led < bytes.length / 3) {
            bytes[led * 3] = (byte) r;
            bytes[led * 3 + 1] = (byte) g;
            bytes[led * 3 + 2] = (byte) b;
        }
        return this;
    }

    public LEDContainer fill(int start, int end, int r, int g, int b) {
        if (start >= 0 && start < bytes.length / 3 && end >= 0 && end < bytes.length / 3) {
            for (int i = Math.min(start, end); i <= Math.max(start, end); i++) {
                bytes[i * 3] = (byte) r;
                bytes[i * 3 + 1] = (byte) g;
                bytes[i * 3 + 2] = (byte) b;
            }
        }
        return this;
    }

    public LEDContainer clear() {
        return fill(0, getLength() - 1, 0, 0, 0);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public int getLength() {
        return bytes.length / 3;
    }
}
