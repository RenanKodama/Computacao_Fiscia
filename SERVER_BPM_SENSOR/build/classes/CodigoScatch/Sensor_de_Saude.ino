#define USE_ARDUINO_INTERRUPTS true    

#include <PulseSensorPlayground.h> 
#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);


PulseSensorPlayground pulseSensor;
const int Pulse = 0;    //leitor BPM
const int Led13 = 13;   //led
const int Temp = 5;     //leitor de Temperatura
int Hold = 550;
int vetorTemp[10];
int posicao = 0;
int tamanho = 10;

String opcao = "";


void setup() {
  Serial.begin(9600);
  
  lcd.begin(16, 2);
  
  pulseSensor.analogInput(Pulse);   
  pulseSensor.blinkOnPulse(Led13);     
  pulseSensor.setThreshold(Hold); 
 
  pinMode(Led13,OUTPUT);
  Serial.println("oque voce deseja medir: \n batimentos ou temperatura ");

  pulseSensor.begin(); 
    
  
}

String leStringSerial(){
  String conteudo = "";
  char caractere;
  
  while(Serial.available() > 0) {
    caractere = Serial.read();
    if (caractere != '\n'){
      conteudo.concat(caractere);
      lcd.clear();
      opcao = conteudo;
    }
    
  }
    
  //Serial.print("Recebi: ");
  //Serial.println(conteudo);

  //lcd.print(conteudo);
  return conteudo;
}

void batimentosCardiacos(){
 int myBPM = pulseSensor.getBeatsPerMinute();  
                                              
  if (pulseSensor.sawStartOfBeat()) {            
   
   Serial.print("BPM: ");                       
   Serial.println(myBPM);                       

   lcd.clear(); 
   lcd.setCursor(0,0);
   lcd.print("BPM: ");                        
   lcd.print(myBPM); 
  }
  delay(20);                   
}

float Ler_Temperatura(){
  float temperatura = (float((analogRead(Temp) *5) / 1023.0)/0.01);   
  Serial.print("Temperatura: ");
  Serial.println(temperatura);

  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Temp: ");
  
  lcd.print(temperatura);
  delay(3000);
}

void loop() {


  
  leStringSerial();
  if(opcao == "batimentos"){
      batimentosCardiacos();  
  }
  
  if(opcao == "temperatura"){
      Ler_Temperatura();  
  }
  
  
  
  

}
