package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Debug;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HttpGetRequest getRequest = new HttpGetRequest();
                try {
                    String result = getRequest.execute("https://jsonplaceholder.typicode.com/albums/1").get();
                    Log.e("Aqui","va" +result);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            /*    SomeTask someTask = new SomeTask(getApplicationContext(), new OnEventListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(getApplicationContext(), "SUCCESS  Click: "+result, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getApplicationContext(), "ERROR   Click: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                someTask.execute();*/
            }
        });

        SomeTask someTask = new SomeTask(getApplicationContext(), new OnEventListener<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(getApplicationContext(), "SUCCESS: "+result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        someTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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