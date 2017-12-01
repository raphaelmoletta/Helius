package br.edu.utfpr.dainf.eex23.helius.a.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.edu.utfpr.dainf.eex23.helius.a.R;
import br.edu.utfpr.dainf.eex23.helius.a.ac.HeliusAC;

public class GraphSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_selection_activity);
    }

    public void irParaTelaGraficos1(View view) {
        //eficiencia
        HeliusAC.setGraph(HeliusAC.TYPE.efficiency);
        loadGraph();
    }

    public void irParaTelaGraficos2(View view) {
        //corrente
        HeliusAC.setGraph(HeliusAC.TYPE.current);
        loadGraph();
    }

    public void irParaTelaGraficos3(View view) {
        //tensão
        HeliusAC.setGraph(HeliusAC.TYPE.voltage);
        loadGraph();
    }


    public void irParaTelaGraficos4(View view) {
        //economia
        HeliusAC.setGraph(HeliusAC.TYPE.economy);
        loadGraph();
    }

    private void loadGraph() {
        Intent intent = new Intent(getApplicationContext(), ShowGraphActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escolha_de_grafico, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
