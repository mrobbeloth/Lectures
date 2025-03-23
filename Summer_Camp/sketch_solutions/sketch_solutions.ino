/*
	Engineering Summer 2024 Camp Solution Code
	Dr. Robbeloth (https://cs.mvnu.edu)
       
      // Serial.println(Serial.readBytes( (char*)(&leds[dot]), 3));
      // clear this led for the next time around the loop
      // leds[dot] = CRGB::Black;    
*/
#include <FastLED.h>
#define NUM_LEDS 60
#define DATA_PIN 6
CRGB leds[NUM_LEDS];

void setup() {
  // for debugging purposes
  Serial.begin(9600);  
  
  // Configure the BTF-LIGHTING WS2812B RGB 5050SMD
  // strip 
  FastLED.addLeds<NEOPIXEL, DATA_PIN>(leds, NUM_LEDS);

  // For exercise 5, assuming nothing connected to 
  // analog pin 0
  randomSeed(analogRead(0));
}

void clearArray() {
  for(int dot = 0; dot < NUM_LEDS; dot++) { 
    leds[dot] = CRGB::Black;
  }
}

void exercise8() {
  fill_gradient_RGB(leds, 0, CRGB::Blue, NUM_LEDS, CRGB::Green);
  FastLED.show();
  delay(1000);
  clearArray();
  FastLED.show();
  delay(1000);
}
void exercise7() {
  fill_rainbow(leds, NUM_LEDS, 0);
  FastLED.show();
  delay(1000);
  clearArray();
  FastLED.show();
  delay(1000);
}

void exercise6() {
  fill_solid(leds, NUM_LEDS, CRGB::Orange);
  FastLED.show();
  delay(1000);
  clearArray();
  FastLED.show();
  delay(1000);
}

void exercise5() {

  // addressing individual fields/data members of pixel object
  for(int dot = 0; dot < NUM_LEDS; dot++) {
    // pick weird random red, blue, and green components
    // could also do leds[dot] = CRGB(random(), random(), random())
    // could also do leds[i] = 0xFF007F; to teach hex
    leds[dot].red = random(0,255);
    leds[dot].blue = random(0,255);
    leds[dot].green = random(0,255);

    // Dim by 50%
    leds[dot].fadeLightBy(192);

    // show randomness
    FastLED.show();

    // delay animation a bit
    delay(100); 
  }

  // let's admire everything for 5 seconds
  delay(5000);
  clearArray();
}

void exercise4() {

  for(int dot = 0; dot < NUM_LEDS; dot++) { 
    if(dot % 2 == 1) {
      // odd
      leds[dot] = CRGB::Orange;
    }
    else {
      // even
      leds[dot] = CRGB::Green;
    }
    
    // Fade by 75%
    leds[dot].fadeLightBy(192); 

    FastLED.show();
    delay(100);
  }

  // let's animate
  clearArray();
}

/* Let's get patriotic with animation*/
void exercise3() {
   // Let's get patriotic   
  // Move through each LED in sequence
  for(int dot = 0; dot < NUM_LEDS; dot++) { 
      if (dot != 0)
        leds[dot-1] = CRGB::Blue;
      leds[dot] = CRGB::White;

      if (dot != NUM_LEDS - 1)
        leds[dot+1] = CRGB::Red;
        
      FastLED.show();
      
      // Serial.println(Serial.readBytes( (char*)(&leds[dot]), 3));
      // clear this led for the next time around the loop
      // leds[dot] = CRGB::Black;    

      // a nice delay to see everything
      delay(250);
  }
  
  // Clear out the array before starting again
  clearArray();
}

void exercise2 () {
   // Let's get patriotic   
  // Move through each LED in sequence
  for(int dot = 0; dot < (NUM_LEDS / 2); dot++) { 
      leds[dot] = CRGB::Blue;
      FastLED.show();
      delay(10);
  }
  
  for(int dot = (NUM_LEDS / 2); dot < NUM_LEDS; dot++) {
      leds[dot] = CRGB::Red;
      FastLED.show();
      delay(10);
  }

  // we could call clearArray here if pressed for time

}

/* Turn all leds purple */
void exercise1() {
     // 1st exercise, turn all LEDs purple
   for(int dot = 0; dot < NUM_LEDS; dot++) { 
      leds[dot] = CRGB::Purple;
      FastLED.show();
      delay(100);
   }
}

void loop() {
  exercise8();
}
