package br.edu.utfpr.dainf.eex23.helius.a.beans;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */

public class GraphData {
    List<DataPoint> points;

    public GraphData(List<DataPoint> points) {
        this.points = points;
    }

    public GraphData() {
        this(new ArrayList<DataPoint>());
    }

    public List<DataPoint> getPoints() {
        return points;
    }

    public void setPoints(List<DataPoint> points) {
        this.points = points;
    }
}
