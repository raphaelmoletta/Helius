package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class Data implements Serializable {
    @SerializedName(value = "id")
    protected String id;
    @SerializedName(value = "v", alternate = "voltage")
    protected double voltage;
    @SerializedName(value = "c", alternate = "current")
    protected double current;
    @SerializedName(value = "t", alternate = "temperature")
    protected double temperature;
    @SerializedName(value = "i", alternate = "irradiance")
    protected double irradiance;

    public Data(String id, double voltage, double current, double temperature, double irradiance) {
        this.id = id;
        this.voltage = voltage;
        this.current = current;
        this.temperature = temperature;
        this.irradiance = irradiance;
    }

    public Data() {
        this("",0,0,0,0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getIrradiance() {
        return irradiance;
    }

    public void setIrradiance(double irradiance) {
        this.irradiance = irradiance;
    }   
}
