
#define USE_ARDUINO_INTERRUPTS true    // Set-up low-level interrupts for most acurate BPM math.

#include <PulseSensorPlayground.h> // Includes the PulseSensorPlayground Library. 
#include <LiquidCrystal.h>




// initialize the library with the numbers of the interface pins
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);


int sensorBatimentos = 4;
volatile int sinal;


void setup() {
  // set up the LCD's number of columns and rows: 
  lcd.begin(16, 2);
  
  // Print a message to the LCD.
  lcd.print("qa");

  Serial.begin(115200);
  pinMode(sensorBatimentos,OUTPUT);
  
}

void loop() {
  // set the cursor to column 0, line 1
  // (note: line 1 is the second row, since counting begins with 0):
  lcd.setCursor(0, 0);
  delay(2000);
  //Print a message to second line of LCD
  lcd.print("testeee");

  sinal = analogRead(sensorBatimentos);
  Serial.print("Sinal: ");
  Serial.println(sinal);
}
