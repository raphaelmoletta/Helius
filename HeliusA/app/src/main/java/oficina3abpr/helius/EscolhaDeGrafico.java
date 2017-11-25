package oficina3abpr.helius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EscolhaDeGrafico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_de_grafico);
    }

    public void irParaTelaGraficos1(View view){
        Intent intentA= new Intent(getApplicationContext(),showGraphs.class);
        startActivity(intentA);



    }

    public void irParaTelaGraficos2(View view){
        Intent intentB= new Intent(getApplicationContext(),TelaDeGraficos.class);
        startActivity(intentB);



    }

    public void irParaTelaGraficos3(View view){
        Intent intentC= new Intent(getApplicationContext(),TelaDeGraficos.class);
        startActivity(intentC);



    }


    public void irParaTelaGraficos4(View view){
        Intent intentD= new Intent(getApplicationContext(),TelaDeEconomia.class);
        startActivity(intentD);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escolha_de_grafico, menu);
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
