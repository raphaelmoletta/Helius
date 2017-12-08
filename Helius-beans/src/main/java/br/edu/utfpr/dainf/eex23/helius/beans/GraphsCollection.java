package br.edu.utfpr.dainf.eex23.helius.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rapha
 */
public class GraphsCollection implements Serializable {
    private static final long serialVersionUID = -8743882954820236087L;
    private List<DataPoint> year;
    private List<DataPoint> month;
    private List<DataPoint> week;
    private List<DataPoint> day;

    public List<DataPoint> getYear() {
        return year;
    }

    public void setYear(List<DataPoint> year) {
        this.year = year;
    }

    public List<DataPoint> getMonth() {
        return month;
    }

    public void setMonth(List<DataPoint> month) {
        this.month = month;
    }

    public List<DataPoint> getWeek() {
        return week;
    }

    public void setWeek(List<DataPoint> week) {
        this.week = week;
    }

    public List<DataPoint> getDay() {
        return day;
    }

    public void setDay(List<DataPoint> day) {
        this.day = day;
    }
}
