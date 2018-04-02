
#define USE_ARDUINO_INTERRUPTS true    

#include <PulseSensorPlayground.h> 
#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);


PulseSensorPlayground pulseSensor;
const int Pulse = 4;    //leitor BPM
const int Led13 = 13;   //led
int Signal;            //sinal
int Hold = 550;


void setup() {
  Serial.begin(9600);
  
  lcd.begin(16, 2);
  lcd.print("Pedroso");

  pulseSensor.analogInput(Pulse);   
  pulseSensor.blinkOnPulse(Led13);     
  pulseSensor.setThreshold(Hold); 
 
  pinMode(Led13,OUTPUT);

  if (pulseSensor.begin()) {
    Serial.println("Ativando Leitor de Batimentos Cardiacos!"); 
  }
}


void loop() {
  lcd.setCursor(0, 0);
  lcd.print("Kodama");

  int myBPM = pulseSensor.getBeatsPerMinute();

  Signal = analogRead(Pulse);
  
  //Serial.print("Sinal: ");
  //Serial.println(Signal);

  if (pulseSensor.sawStartOfBeat()) {           
   Serial.println("Lendo Batimentos Cardiacos! ♥"); 
   Serial.print("BPM: ");                      
   Serial.println(myBPM);                        
  }

  delay(20);
}
