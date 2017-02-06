package Classes;

import java.io.Serializable;

/**
 * Created by movil on 2/6/17.
 */

public class Project implements Serializable {

    private double functionality;
    private double presentation;
    private double usability;
    private double grade;
    private String name;

    public Project(double functionality, double presentation, double usability, String name, double grade) {
        this.functionality = functionality;
        this.presentation = presentation;
        this.usability = usability;
        this.name = name;
    }

    public double getFunctionality() {
        return functionality;
    }

    public void setFunctionality(double functionality) {
        this.functionality = functionality;
    }

    public double getPresentation() {
        return presentation;
    }

    public void setPresentation(double presentation) {
        this.presentation = presentation;
    }

    public double getUsability() {
        return usability;
    }

    public void setUsability(double usability) {
        this.usability = usability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
