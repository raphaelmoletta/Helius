#include <Arduino.h>
#include <EEPROM.h>
#ifndef WHEATERSENSORS
	#define WHEATERSENSORS 1
#endif
#ifndef ELETRICALSENSORS
	#define ELETRICALSENSORS 2
#endif

class Wheather {
	private:
		//Properties
		double irradiance;
		double temperature;
		
	public:
		//Constructors
		Wheather(double temperature, double irradiance);
		Wheather(void);
		
		
		//Gets and Sets
		double getTemperature(void);
		double getIrradiance(void);
		void setIrradiance(double irradiance);
		void setTemperature(double temperature);
		
		//JSON
		String toJSON();
};

class Eletrical {
	private:
		double voltage;
		double current;
	public:
		//Constructors
		Eletrical(void);
		Eletrical(double voltage, double current);
		
		//Gets and Sets
		double getVoltage(void);
		double getCurrent(void);
		void setVoltage(double voltage);
		void setCurrent(double current);
		
		//JSON
		String toJSON();
};

class Data {
	private:
		//Properties
		long id = 0;
		Wheather wheater[WHEATERSENSORS];
		Eletrical eletrical[ELETRICALSENSORS];
		
		
	public:
	
		Data(void);
		long getID();
		void setID(long id);
		
		//JSON
		String toJSON();
};

class HeliusAR {
	public:
		unsigned long getID();
		String getPackage();
};