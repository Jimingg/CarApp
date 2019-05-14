package sg.edu.rp.c346.carapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    Button btnGetCar;
    EditText etbrand;
    EditText etlitre;
    ListView lv;
    ArrayList<Car> al;
    CarAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetCar = findViewById(R.id.btnGetCar);
        btnInsert = findViewById(R.id.btnInsert);
        etbrand = findViewById(R.id.editTextbrand);
        etlitre = findViewById(R.id.editTextlitre);
        lv = findViewById(R.id.lv);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                Double litre = Double.valueOf(etlitre.getText().toString());
                // Insert a task
                db.insertCar(etbrand.getText().toString(), litre);
                db.close();
            }
        });
        btnGetCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task


                al = new ArrayList<Car>();

                al = db.getAllNotes();


                aa = new CarAdapter(MainActivity.this, R.layout.row, al);

                lv.setAdapter(aa);

                aa.notifyDataSetChanged();
            }
        });
    }
}
