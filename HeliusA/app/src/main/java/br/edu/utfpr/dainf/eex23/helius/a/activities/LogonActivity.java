package br.edu.utfpr.dainf.eex23.helius.a.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.edu.utfpr.dainf.eex23.helius.a.R;
import br.edu.utfpr.dainf.eex23.helius.a.ac.HeliusAC;
import br.edu.utfpr.dainf.eex23.helius.a.beans.DTO;

public class LogonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logon_activity);
        errorMessage();
    }

    public void goHomeActivity(View view) {
        DTO DTO = HeliusAC.getHomeData();
        //if (DTO.getStatus() == br.edu.utfpr.dainf.eex23.helius.a.beans.DTO.STATUS.OK) {
            Intent intentl = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intentl);
        //} else {
        //    errorMessage(DTO.getData());
        //}

    }

    public void errorMessage(String msg) {
        TextView textError = (TextView) findViewById(R.id.textError);

        textError.setText(msg);
        textError.setVisibility(View.VISIBLE);
    }

    public void errorMessage() {
        TextView textError = (TextView) findViewById(R.id.textError);
        textError.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
