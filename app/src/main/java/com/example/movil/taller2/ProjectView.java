package com.example.movil.taller2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Classes.Project;

public class ProjectView extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_view);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

        Intent i = getIntent();

        project = (Project) i.getSerializableExtra("project");
    }


    public void calculate(View view) {
        String[] data = { et1.getText().toString(),  et2.getText().toString(), et3.getText().toString() };
        if(data[0].isEmpty() || data[1].isEmpty() || data[2].isEmpty()) {
            Toast.makeText(this, "Debe digitar las 3 notas", Toast.LENGTH_SHORT).show();
        }else{
            double n1 = Double.parseDouble(data[0]);
            double n2 = Double.parseDouble(data[1]);
            double n3 = Double.parseDouble(data[2]);
            if (n1 > 5 || n2 > 5 || n3 > 5) {
                Toast.makeText(this, "Las 3 notas deben ser menores o iguales a 5", Toast.LENGTH_SHORT).show();
            }else if(n1 < 0 || n2 < 0 || n3 < 0){
                Toast.makeText(this, "Las 3 notas deben ser mayores o iguales a 0", Toast.LENGTH_SHORT).show();
            } else {
                double grade = n1 * 0.50 + n2 * 0.25 + n3 * 0.25;
                project.setFunctionality(n1);
                project.setPresentation(n2);
                project.setUsability(n3);
                project.setGrade(grade);

                Intent i = new Intent();
                i.putExtra("project", project);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        }
    }
}
