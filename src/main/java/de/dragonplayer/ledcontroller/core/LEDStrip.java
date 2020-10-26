package de.dragonplayer.ledcontroller.core;

import com.diozero.api.SPIConstants;
import com.diozero.api.SpiDevice;
import de.dragonplayer.ledcontroller.controller.LEDController;
import de.dragonplayer.ledcontroller.util.LEDContainer;

import java.util.Timer;
import java.util.TimerTask;

public class LEDStrip {

    private final int spiPort;
    private final int ledAmount;
    private final SpiDevice spiDevice;
    private final Timer timer;
    private LEDContainer ledContainer;
    private LEDController ledController;

    public LEDStrip(int spiPort, int ledAmount) {
        this.spiPort = spiPort;
        this.ledAmount = ledAmount;
        spiDevice = new SpiDevice(spiPort, 0, 1000000, SPIConstants.DEFAULT_SPI_CLOCK_MODE, false);
        ledContainer = new LEDContainer(ledAmount);
        timer = new Timer();
    }

    public void setMode(LEDController ledController) {
        this.ledController = ledController;
        timer.cancel();
        write(ledContainer.clear());
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                write(ledController.update(ledContainer));
            }
        }, 0, ledController.getSpeed());
    }

    public void write(LEDContainer ledContainer) {
        this.ledContainer = ledContainer;
        spiDevice.write(ledContainer.getBytes());
    }

    public int getSpiPort() {
        return spiPort;
    }

    public int getLedAmount() {
        return ledAmount;
    }

    public LEDContainer getLedContainer() {
        return ledContainer;
    }

    public LEDController getLedController() {
        return ledController;
    }
}
