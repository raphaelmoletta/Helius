package br.edu.utfpr.dainf.eex23.helius.a.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class HomeData implements Serializable {

    private static final long serialVersionUID = 7640412432724324444L;


    @SerializedName(value = "ef", alternate = "eficiencia")
    private double eficiencia;

    @SerializedName(value = "t", alternate = "temperatura")
    private double temperatura;
    @SerializedName(value = "i", alternate = "incidencia")
    private double incidencia;
    @SerializedName(value = "ec", alternate = "economia")
    private double economia;


    public HomeData(double economia, double eficiencia, double temperatura, double incidencia) {
        this.economia = economia;
        this.eficiencia = eficiencia;
        this.temperatura = temperatura;
        this.incidencia = incidencia;
    }


    public HomeData() {
        this(0, 0, 0, 0);
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(double incidencia) {
        this.incidencia = incidencia;
    }

    public double getEconomia() {
        return economia;
    }

    public void setEconomia(double economia) {
        this.economia = economia;
    }
}
