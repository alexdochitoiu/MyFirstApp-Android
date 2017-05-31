package com.example.alexdochitoiu.myapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button save, load;
    EditText name, date, details;
    DatabaseController dbController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        date = (EditText) findViewById(R.id.date);
        details = (EditText) findViewById(R.id.details);
        dbController = new DatabaseController(this,"",null,1);
        save = (Button) findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbController.insertEvent(name.getText().toString(), date.getText().toString(), details.getText().toString());
                Toast.makeText(getBaseContext(), "Event saved!",
                        Toast.LENGTH_LONG).show();
            }
        });
        load = (Button) findViewById(R.id.list);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
