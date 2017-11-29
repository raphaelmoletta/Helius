package br.edu.utfpr.dainf.eex23.helius.a;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import br.edu.utfpr.dainf.eex23.helius.a.heliusac.HeliusAC;


public class showGraphs extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_graphs);


        GraphView graph = (GraphView) findViewById(R.id.graph);

        series = new LineGraphSeries<>(HeliusAC.getCurrents(HeliusAC.TIME.day).getGraphVectorDP());


        graph.addSeries(series);
        series.setColor(0xFFFFFFFF);


        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.setTitle("Eficiência X Tempo- Diário");


        //-------Gráfico Semanal--------------//

        GraphView graph2 = (GraphView) findViewById(R.id.graph2);


        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(HeliusAC.getCurrents(HeliusAC.TIME.week).getGraphVectorDP());

            /*    new DataPoint(0,4),
                new DataPoint(2, 3),
                new DataPoint(3, 3),
                new DataPoint(4, 12),
                new DataPoint(5, 3),
                new DataPoint(6, 0),
                new DataPoint(7, 18)
        });

        */
        graph2.addSeries(series2);
        series2.setColor(Color.GREEN);


        graph2.getViewport().setScrollable(true); // enables horizontal scrolling
        graph2.getViewport().setScrollableY(true); // enables vertical scrolling
        graph2.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph2.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph2.setTitle("Eficiência X Tempo- Semanal");


        //----------Gráfico Mensal-----//

        GraphView graph3 = (GraphView) findViewById(R.id.graph3);


        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(8, 12),
                new DataPoint(13, 3),
                new DataPoint(14, 5),
                new DataPoint(25, 18),
                new DataPoint(30, 12)
        });
        graph3.addSeries(series3);
        series3.setColor(Color.RED);


        graph3.getViewport().setScrollable(true); // enables horizontal scrolling
        graph3.getViewport().setScrollableY(true); // enables vertical scrolling
        graph3.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph3.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph3.setTitle("Eficiência X Tempo- Mensal");


        //-----------Gráfico Anual---------//


        GraphView graph4 = (GraphView) findViewById(R.id.graph4);


        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(6, 5),
                new DataPoint(8, 12),
                new DataPoint(9, 3),
                new DataPoint(10, 8),
                new DataPoint(12, 18)
        });
        graph4.addSeries(series4);
        series4.setColor(Color.YELLOW);


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
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
