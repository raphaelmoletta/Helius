#include"HeliusAR.h"

Wheather::Wheather(double temperature, double irradiance) {
	this->temperature = temperature;
	this->irradiance = irradiance;
}
Wheather::Wheather() : Wheather(0.0,0.0) {}
double 	Wheather::getTemperature() 					{ return this->temperature;}
double 	Wheather::getIrradiance() 					{ return this->irradiance; }
void 	Wheather::setTemperature(double temperature){ this->temperature = temperature; }
void 	Wheather::setIrradiance(double irradiance) 	{ this->irradiance = irradiance; }
String 	Wheather::toJSON() {
  return "['t':'" + String(this->temperature) + "','i':'" + String(this->irradiance) + "']";
}

Eletrical::Eletrical(double voltage, double current) {
	this->voltage = voltage;
	this->current = current;
}
Eletrical::Eletrical(void) : Eletrical(0.0,0.0){
}
double 	Eletrical::getVoltage()						{ return this->voltage; }
double 	Eletrical::getCurrent()						{ return this->current; }
void 	Eletrical::setVoltage(double voltage) 		{ this->voltage = voltage; }
void 	Eletrical::setCurrent(double current) 		{ this->current = current; }
String 	Eletrical::toJSON() {
  return "['v':'" + String(this->voltage) + "','t':'" + String(this->current) + "']";
}

Data::Data(void) {

}

long 	Data::getID() 								{ return this->id; }
void 	Data::setID(long id) 						{ this->id = id; }

String Data::toJSON() {
  return "{'status':'ok', 'id':'" + String(this->id) + "','v':'";
}

unsigned long HeliusAR::getID() {
	unsigned long id = 0;
	if(EEPROM.read(0) == 73) { 
		id =  ((unsigned long)EEPROM.read(1)) << 24;
		id += ((unsigned long)EEPROM.read(2)) << 16;
		id += ((unsigned long)EEPROM.read(3)) << 8;
		id += ((unsigned long)EEPROM.read(4));
	} else {
		randomSeed(analogRead(0));
		byte aux;
		EEPROM.write(0, 73);
		aux = random(255);
		EEPROM.write(1, aux);
		aux = ((byte)random(255));
		EEPROM.write(2, aux);
		aux = ((byte)random(255));
		EEPROM.write(3, aux);
		aux = ((byte)random(255));
		EEPROM.write(4, aux);
	}
	return id;
}

