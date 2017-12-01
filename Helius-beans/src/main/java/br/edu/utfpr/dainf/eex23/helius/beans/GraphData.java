package br.edu.utfpr.dainf.eex23.helius.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


//import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by Dell on 15/11/2017.
 */
public class GraphData implements Serializable {

    private static final long serialVersionUID = 182795098732984L;
    private List<DataPoint> graphVector;
    public GraphData() {
        graphVector = new ArrayList<>();
        graphVector.add(new DataPoint(0, 1));
        graphVector.add(new DataPoint(1, 12));
        graphVector.add(new DataPoint(2, 2));
        graphVector.add(new DataPoint(3, 5));
        graphVector.add(new DataPoint(4, 6));
        graphVector.add(new DataPoint(5, 7));
        graphVector.add(new DataPoint(6, 8));
        graphVector.add(new DataPoint(7, 3));
        graphVector.add(new DataPoint(8, 2));
        graphVector.add(new DataPoint(9, 8));
        graphVector.add(new DataPoint(10, 2));
    }

    public List<DataPoint> getGraphVector() {
        return graphVector;
    }

    public void setGraphVector(List<DataPoint> graphVector) {
        this.graphVector = graphVector;
    }
/*
    public DataPoint[] getGraphVectorDP() {

        return graphVector;
    }

    public void setGraphVectorDP(DataPoint[] graphVectorDP) {
        this.graphVector = graphVector;
    }

*/



}
