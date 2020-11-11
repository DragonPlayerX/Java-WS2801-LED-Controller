# Java-WS2801-LED-Controller
Simple library for controlling WS2801 LED strips with Java based on diozero-core library.

To diozero-core: https://www.diozero.com/

## Installation

Simply download the JAR file from the latest version and add it to your project as well as the diozero-core library.

## Usage

Use a LEDStrip object to control your LED strip:

````java
public class LEDStripExample {
    
    public LEDStripExample(){
        // Initialize a LEDStrip object on SPI-Port 0 with 32 LEDs
        LEDStrip ledStrip = new LEDStrip(0, 32);
        
        // Set a new controller to the LED strip
        // You can use own controllers or the default ones which are included in the library
        ledStrip.setMode(new MyLEDController());
    }   
}
````

How to create own controllers for the LED strip:

````java
public class MyLEDController extends LEDController {
    
    public MyLEDController(){
        // Set the update speed to 500ms 
        // Set speed to -1 to trigger update() once and disable the timer
        super(500);
    }

    public LEDContainer update(LEDContainer ledContainer){
        // Do stuff with the led container
        return ledContainer;
    }
}
````

How to deal with a LEDContainer object:

````
    ledContainer.clear(); // Disable all LEDs
    ledContainer.fill(start, end, r, g, b); // Change multiple LEDs
    ledContainer.modify(index, r, g, b); // Change a single LED
````