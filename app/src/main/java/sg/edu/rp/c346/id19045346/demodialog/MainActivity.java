package sg.edu.rp.c346.id19045346.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    TextView tvDemo2;
    Button btnDemo2;
    Button btnDemo3;
    TextView tvDemo3;

    Button btnExercise3;
    TextView tvExercise3;

    Button btnDemo4;
    TextView tvDemo4;

    Button btnDemo5;
    TextView tvDemo5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);

        btnExercise3 = findViewById(R.id.buttonExercise3);
        tvExercise3 = findViewById(R.id.textViewExercise3);

        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                //Set the dialog details
                /*
                myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);


                 */


                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                // if touch screen, it can't be cancelled
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Button Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);


                //Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final" so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //let user view on the layout
                View viewDialog = inflater.inflate(R.layout.exercise3,null);

                final EditText n1 = viewDialog.findViewById(R.id.editTextNumber1);
                final EditText n2 = viewDialog.findViewById(R.id.editTextNumber2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //set the view to the desire layout
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");

                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int number1 = Integer.parseInt(n1.getText().toString());
                        int number2 = Integer.parseInt(n2.getText().toString());

                        int total = number1 + number2;

                        tvExercise3.setText("The sum is "+total);
                    }
                });

                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };

                Calendar cal1 = Calendar.getInstance();
                // Create the Date Picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener,cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH),cal1.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" +minute);
                    }
                };

                Calendar time1 = Calendar.getInstance();
                //Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener,time1.get(Calendar.HOUR),time1.get(Calendar.MINUTE),false);

                myTimeDialog.show();
            }
        });
    }
}
