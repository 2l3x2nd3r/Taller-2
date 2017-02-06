package com.example.movil.taller2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Classes.Project;

public class MainActivity extends AppCompatActivity {

    ArrayList<Project> projects = new ArrayList<Project>();
    TextView ptv1;
    TextView ptv2;
    TextView ptv3;
    TextView ptv4;

    TextView ctv1;
    TextView ctv2;
    TextView ctv3;
    TextView ctv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projects.add(new Project(0,0,0,"Projecto 1",0));
        projects.add(new Project(0,0,0,"Projecto 2",0));
        projects.add(new Project(0,0,0,"Projecto 3",0));
        projects.add(new Project(0,0,0,"Projecto 4",0));

        ptv1 = (TextView) findViewById(R.id.ptv1);
        ptv1.setText(projects.get(0).getName());
        ptv2 = (TextView) findViewById(R.id.ptv2);
        ptv2.setText(projects.get(1).getName());
        ptv3 = (TextView) findViewById(R.id.ptv3);
        ptv3.setText(projects.get(2).getName());
        ptv4 = (TextView) findViewById(R.id.ptv4);
        ptv4.setText(projects.get(3).getName());

        ctv1 = (TextView) findViewById(R.id.ctv1);
        ctv2 = (TextView) findViewById(R.id.ctv2);
        ctv3 = (TextView) findViewById(R.id.ctv3);
        ctv4 = (TextView) findViewById(R.id.ctv4);
    }

    public void toQualify(View view)
    {
        switch(view.getId())
        {
            case R.id.pbtn1:
                Intent i1 = new Intent(this, ProjectView.class);
                i1.putExtra("project", projects.get(0));

                startActivityForResult(i1, 1);
                break;

            case R.id.pbtn2:
                Intent i2 = new Intent(this, ProjectView.class);
                i2.putExtra("project", projects.get(1));

                startActivityForResult(i2, 2);
                break;

            case R.id.pbtn3:
                Intent i3 = new Intent(this, ProjectView.class);
                i3.putExtra("project", projects.get(2));

                startActivityForResult(i3, 3);
                break;

            case R.id.pbtn4:
                Intent i4 = new Intent(this, ProjectView.class);
                i4.putExtra("project", projects.get(3));

                startActivityForResult(i4, 4);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Project project;

        if(resultCode == RESULT_OK){
            switch(requestCode)
            {
                case 1:
                    projects.set(0, (Project) data.getSerializableExtra("project"));
                    project = projects.get(0);

                    ctv1.setText("Calificado: " + project.getGrade());
                    break;
                case 2:
                    projects.set(1, (Project) data.getSerializableExtra("project"));
                    project = projects.get(1);

                    ctv2.setText("Calificado: " + project.getGrade());
                    break;
                case 3:
                    projects.set(2, (Project) data.getSerializableExtra("project"));
                    project = projects.get(2);

                    ctv3.setText("Calificado: " + project.getGrade());
                    break;
                case 4:
                    projects.set(3, (Project) data.getSerializableExtra("project"));
                    project = projects.get(3);

                    ctv4.setText("Calificado: " + project.getGrade());
                    break;
            }
        }


    }
}
