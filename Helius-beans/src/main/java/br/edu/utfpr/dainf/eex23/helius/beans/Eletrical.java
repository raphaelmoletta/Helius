package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class Eletrical implements Serializable {

    private static final long serialVersionUID = -5851138107591637291L;
    
    @SerializedName(value = "n", alternate = "name")
    protected String name;
    @SerializedName(value = "v", alternate = "voltage")
    protected double voltage;
    @SerializedName(value = "c", alternate = "current")
    protected double current;

    public Eletrical(String name, double voltage, double current) {
        this.name = name;
        this.voltage = voltage;
        this.current = current;
    }

    public Eletrical(double voltage, double current) {
        this("", voltage, current);
    }

    public Eletrical(String name) {
        this(name, 0, 0);
    }

    public Eletrical() {
        this("", 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
