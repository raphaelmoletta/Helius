#include "HeliusAR.h"

#define WHEATERSENSORS 1
#define ELETRICALSENSORS 2

#define NUM_SAMPLES 10
#define V_PORT A2 //Port to acquire voltage
#define I_PORT A3 //Port to acquire irradiance
#define T_PORT A4 //Port to acquire temperature
#define C_PORT A5 //Port to acquire current

static HeliusAR heliusAR;

void setup() {
    Serial.begin(9600);
}

void loop() {
    while (sample_count < NUM_SAMPLES) {
        v_samples_sum += analogRead(V_PORT);
        i_samples_sum += analogRead(I_PORT);
        t_samples_sum += analogRead(T_PORT);
        c_samples_sum += analogRead(C_PORT);
        sample_count++;
        delay(90);
    }
    voltage = 11*((float)v_samples_sum / (float)NUM_SAMPLES * 5.0) / 1024.0;
    irradiance = (float)i_samples_sum / (float)NUM_SAMPLES;
    temperature = (float)t_samples_sum / (float)NUM_SAMPLES;
    current = (float)c_samples_sum / (float)NUM_SAMPLES;
    sample_count = 0;
    v_samples_sum = 0;
    i_samples_sum = 0;
    t_samples_sum = 0;
    c_samples_sum = 0;
    data = "{'status':'ok', 'v':'" + String(voltage, 3) + "', 'i':'" + String(irradiance) + "','t':'" + String(temperature) + "','c':'" + String(current) + "'}";
    Serial.print(heliusAR.getPackage());
}


