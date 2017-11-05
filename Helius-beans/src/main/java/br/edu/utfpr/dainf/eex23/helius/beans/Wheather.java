package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class Wheather implements Serializable {

    private static final long serialVersionUID = -2609539523371696850L;

    @SerializedName(value = "n", alternate = "name")
    protected String name;
    @SerializedName(value = "t", alternate = "temperature")
    protected double temperature;
    @SerializedName(value = "i", alternate = "irradiance")
    protected double irradiance;

    public Wheather(String name, double temperature, double irradiance) {
        this.name = name;
        this.temperature = temperature;
        this.irradiance = irradiance;
    }
    
    public Wheather(double temperature, double irradiance) {
        this("", temperature, irradiance);
    }

    public Wheather(String name) {
        this(name, 0, 0);
    }

    public Wheather() {
        this("", 0, 0);
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
