package br.edu.utfpr.dainf.eex23.helius.a.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import br.edu.utfpr.dainf.eex23.helius.a.R;
import br.edu.utfpr.dainf.eex23.helius.a.ac.HeliusAC;
import br.edu.utfpr.dainf.eex23.helius.a.beans.DTO;
import br.edu.utfpr.dainf.eex23.helius.a.beans.HomeData;


public class HomeActivity extends AppCompatActivity {
    private boolean loadHomeData() {
        DTO DTO = HeliusAC.getHomeData();

        switch (DTO.getStatus()) {
            case OK:
                Gson gson = new Gson();
                fillHomeData((HomeData) gson.fromJson(DTO.getData(), HomeData.class));
                return true;
            case ERROR:
                fillError(DTO);
                return false;
            case EMPTY:
                fillError(new DTO("Dados vazios!","", br.edu.utfpr.dainf.eex23.helius.a.beans.DTO.STATUS.EMPTY));
                return false;
            default:
                fillError(new DTO("Erro desconhecido!","", br.edu.utfpr.dainf.eex23.helius.a.beans.DTO.STATUS.EMPTY));
                return false;
        }
    }

    private void fillError(DTO errorData) {
        /*
        TextView textError = (TextView) findViewById(R.id.textError);
        textError.setText(errorData.getData());
        textError.setVisibility(View.VISIBLE);
        */
    }

    private void fillHomeData(HomeData homeData) {
        ((TextView) findViewById(R.id.textView8)).setText(" " + homeData.getEconomia() + " reais");
        ((TextView) findViewById(R.id.textView6)).setText(" " + homeData.getIncidencia());
        ((TextView) findViewById(R.id.textView4)).setText(" " + homeData.getTemperatura() + " graus");
        ((TextView) findViewById(R.id.textView2)).setText(" " + homeData.getEficiencia() + "%");
    }

    public void goGraphSelectionActivity(View view) {
        Intent intent2;
        intent2 = new Intent(getApplicationContext(), GraphSelectionActivity.class);
        startActivity(intent2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadHomeData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
