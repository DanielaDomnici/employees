package com;

/**
 * Created by daniela.domnici on 06/11/15.
 */
public class QualityAssurance extends Employee {

    // Defined the input variable
    private int qaLevel;

    // Created the Constructor with parameters
    public QualityAssurance(int id, String name, String birthDate, String cnp, int qaLevel) {
        super(id, name, birthDate, cnp);
        this.qaLevel = qaLevel;
    }

    /**
     * Public function "getter" for the defined input variable "qaLevel"
     * @return
     */
    public int getLevel() {
        return qaLevel;
    }

    /**
     * Public function "setter" for the defined input variable "level"
     * @param level
     */
    public void setLevel(int level) {
        this.qaLevel = level;
    }
}
