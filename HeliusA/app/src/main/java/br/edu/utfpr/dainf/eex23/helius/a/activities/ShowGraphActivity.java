package br.edu.utfpr.dainf.eex23.helius.a.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import br.edu.utfpr.dainf.eex23.helius.a.R;
import br.edu.utfpr.dainf.eex23.helius.a.ac.HeliusAC;
import br.edu.utfpr.dainf.eex23.helius.a.beans.GraphData;


public class ShowGraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> fillSeries(String value) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        Gson gson = new Gson();
        GraphData graphData = gson.fromJson(value, GraphData.class);
        for(DataPoint point : graphData.getPoints()) {
            series.appendData(point,false, graphData.getPoints().size(),false);
        }
        return series;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_graph_activity);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = fillSeries(HeliusAC.getGraphData(HeliusAC.TIME.day).getData());

        graph.addSeries(series);
        series.setColor(0xFFFFFFFF);

        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.setTitle("Eficiência X Tempo- Diário");


        //-------Gráfico Semanal--------------//

        GraphView graph2 = (GraphView) findViewById(R.id.graph2);


        series = fillSeries(HeliusAC.getGraphData(HeliusAC.TIME.week).getData());

        graph2.addSeries(series);
        series.setColor(Color.GREEN);


        graph2.getViewport().setScrollable(true); // enables horizontal scrolling
        graph2.getViewport().setScrollableY(true); // enables vertical scrolling
        graph2.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph2.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph2.setTitle("Eficiência X Tempo- Semanal");


        //----------Gráfico Mensal-----//

        GraphView graph3 = (GraphView) findViewById(R.id.graph3);


        series = fillSeries(HeliusAC.getGraphData(HeliusAC.TIME.month).getData());
        graph3.addSeries(series);
        series.setColor(Color.RED);


        graph3.getViewport().setScrollable(true); // enables horizontal scrolling
        graph3.getViewport().setScrollableY(true); // enables vertical scrolling
        graph3.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph3.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph3.setTitle("Eficiência X Tempo- Mensal");


        //-----------Gráfico Anual---------//


        GraphView graph4 = (GraphView) findViewById(R.id.graph4);


        series = fillSeries(HeliusAC.getGraphData(HeliusAC.TIME.year).getData());
        graph4.addSeries(series);
        series.setColor(Color.YELLOW);


        graph4.getViewport().setScrollable(true); // enables horizontal scrolling
        graph4.getViewport().setScrollableY(true); // enables vertical scrolling
        graph4.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph4.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph4.setTitle("Eficiência X Tempo- Anual");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_graphs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
