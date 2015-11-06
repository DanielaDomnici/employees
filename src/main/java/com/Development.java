package com;

/**
 * Created by daniela.domnici on 06/11/15.
 */
public class Development extends Employee {

    // Define the input variable
    private int devLevel;

    // Created the Constructor with parameters
    public Development(int id, String name, String birthDate, String cnp, int devLevel) {
        super(id, name, birthDate, cnp);
        this.devLevel = devLevel;
    }

    /**
     * Public function "getter" for the defined input variable "devLevel"
     * @return
     */
    public int getDevLevel() {
        return devLevel;
    }

    /**
     * Public function "setter" for the defined input variable "devLevel"
     * @param devLevel
     */
    public void setDevLevel(int devLevel) {
        this.devLevel = devLevel;
    }
}
