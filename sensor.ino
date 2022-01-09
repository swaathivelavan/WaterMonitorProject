include <ESP8266WiFi.h>        // Include the Wi-Fi library

#include <WiFiClient.h>;    //This file is required to send request to web browser

#include <ThingSpeak.h>;

const char* ssid     = "Shiva";         // The SSID (name) of the Wi-Fi network you want to connect to
const char* password = "vvelan12345";     // The password of the Wi-Fi network

WiFiClient client;

unsigned long myChannelNumber =  994647; //Your Channel Number (Without Brackets)

const char * myWriteAPIKey = "B18FQSIZLOTYO07M"; //Your Write API Key

#define FlowMeterPulsePerSecondPerLiter 6.9
//#define FlowMeterPulsePerSecondPerLiter 7.5
float FlowCalculationDuration =1000;


float FlowCalculationStartTime;
volatile float PulseCount;
float LPM;
int LPMdecimal;
int total;
float volume;

void ICACHE_RAM_ATTR pulseCounter2();

void setup()
  {
  volume=0;
  PulseCount = 0;
  Serial.begin(9600);
  delay(10);
  Serial.println('\n');
 
  WiFi.begin(ssid, password);             // Connect to the network
  Serial.print("Connecting to ");
  Serial.print(ssid); Serial.println(" ...");

  int i = 0;
 
  while (WiFi.status() != WL_CONNECTED) { // Wait for the Wi-Fi to connect
    delay(1000);
    Serial.print(++i); Serial.print(' ');
  }
  Serial.println('\n');
  Serial.println("Connection established!");  
  Serial.print("IP address:\t");
  Serial.println(WiFi.localIP());         // Send the IP address of the ESP8266 to the computer

  ThingSpeak.begin(client);  
  pinMode(13,INPUT);
  LPM               = 0;
  LPMdecimal        = 2;
  attachInterrupt(digitalPinToInterrupt(13),pulseCounter2, CHANGE);
  FlowCalculationStartTime = millis();
  }

void loop()
  {
  CalculateFlow2();
 
  }


void CalculateFlow2()
  {
  if (millis()-FlowCalculationStartTime > FlowCalculationDuration)
    {
    LPM = PulseCount/(2*FlowMeterPulsePerSecondPerLiter*(FlowCalculationDuration/1000));
    volume+=LPM/60;
    DisplayLPM();
    FlowCalculationStartTime = millis();
    PulseCount=0;
    }
  Serial.println(volume);
  }

void ICACHE_RAM_ATTR pulseCounter2()
  {
  PulseCount++;
  }
 

void DisplayLPM()
  {
  ThingSpeak.writeField(myChannelNumber, 1,LPM, myWriteAPIKey);
  ThingSpeak.writeField(myChannelNumber,2,volume,myWriteAPIKey);
  Serial.println(LPM,LPMdecimal);
  }
