
#define LED_PIN 6 // 12 not PWM compat, but 11 is

void setup() {
  // put your setup code here, to run once:
  pinMode(LED_PIN, OUTPUT); 
  analogWrite(LED_PIN, 10); // 55 * 0.04 = 10.2
  pinMode(LED_BUILTIN, OUTPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(LED_PIN, HIGH);
  delay(1000);
  digitalWrite(LED_PIN, LOW);
  delay(1000);
  digitalWrite(LED_PIN, HIGH);
  delay(1000);
  digitalWrite(LED_PIN, LOW);
  delay(1000);
  analogWrite(LED_PIN, 255);
  digitalWrite(LED_PIN, HIGH);
  delay(1000);
  digitalWrite(LED_PIN, LOW);
  delay(2000);
}
