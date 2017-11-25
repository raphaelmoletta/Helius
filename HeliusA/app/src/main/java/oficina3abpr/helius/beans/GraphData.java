package oficina3abpr.helius.beans;

import com.google.gson.annotations.SerializedName;
import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by Dell on 15/11/2017.
 */
public class GraphData {

    @SerializedName(value="v")
    private DataPointHelius graphVector[];
    public GraphData() {
        graphVector = (new DataPointHelius[]{
                new DataPointHelius(0, 3),
                new DataPointHelius(1, 5)
                //new DataPointHelius(5, 12),
                //new DataPointHelius(13, 3),
                //new DataPointHelius(14, 5),
               // new DataPointHelius(25, 18),
               // new DataPointHelius(30, 12)
        });

    }



    public DataPointHelius[] getGraphVector() {
        return graphVector;
    }

    public void setGraphVector(DataPointHelius[] graphVector) {
        this.graphVector = graphVector;
    }

    public DataPoint[] getGraphVectorDP() {

        return graphVector;
    }

    public void setGraphVectorDP(DataPoint[] graphVectorDP) {
        this.graphVector = graphVector;
    }





}
