package com;

/**
 * Created by daniela.domnici on 06/11/15.
 */
public class TeamLeadDev extends Development {

    // Define the input variable
    private String devAttributes;

    // Created the constructor with parameters


    public TeamLeadDev(int id, String name, String birthDate, String cnp, int devLevel, String devAttributes) {
        super(id, name, birthDate, cnp, devLevel);
        this.devAttributes = devAttributes;
    }

    /**
     * Public function "getter" for the defined input variable "devAttributes"
     * @return
     */
    public String getDevAttributes() {
        return devAttributes;
    }

    /**
     * Public function "setter" for the defined input variable "devAttributes"
     * @param devAttributes
     */
    public void setDevAttributes(String devAttributes) {
        this.devAttributes = devAttributes;
    }
}