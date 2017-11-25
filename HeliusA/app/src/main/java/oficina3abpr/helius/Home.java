package oficina3abpr.helius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import oficina3abpr.helius.beans.HomeData;
import oficina3abpr.helius.heliusac.ComunicacaoWebService;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textoEconomia= (TextView)findViewById(R.id.textView8);
        textoEconomia.setText(" " + ComunicacaoWebService.dadosHome.getEconomia() + " reais");

        TextView textoIncidencia= (TextView)findViewById(R.id.textView6);
        textoIncidencia.setText(" " + ComunicacaoWebService.dadosHome.getIncidencia());

        TextView textoTemperatura= (TextView)findViewById(R.id.textView4);
        textoTemperatura.setText(" " + ComunicacaoWebService.dadosHome.getTemperatura() + " graus" );

        TextView textoEficiencia= (TextView)findViewById(R.id.textView2);
        textoEficiencia.setText(" " + ComunicacaoWebService.dadosHome.getEficiencia() + "%");



    }

    public void irParaEscolheGraficos(View view){
        Intent intent2;
        intent2 = new Intent(getApplicationContext(),EscolhaDeGrafico.class);
        startActivity(intent2);



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
