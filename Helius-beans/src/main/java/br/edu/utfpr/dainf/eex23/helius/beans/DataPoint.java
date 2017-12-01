package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.annotations.SerializedName;
//import com.jjoe64.graphview.series.DataPoint;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dell on 15/11/2017.
 */
public class DataPoint {//extends DataPoint implements Serializable {

    private static final long serialVersionUID = 7640412432722849632L;
    @SerializedName(value = "x")
    private double x;
    @SerializedName(value = "y")
    private double y;

    public DataPoint(double x, double y) {
       this.x = x;
       this.y = y;

    }

    //@Override
    public double getX() {
        return this.x;
    }
    //@Override
    public double getY() {
        return this.y;
    }
    @Override
    public String toString() {
        return "[" + this.x + "/" + this.y + "]";
    }
}

