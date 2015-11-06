package com;

/**
 * Created by daniela.domnici on 06/11/15.
 */
public class TeamLeadQa extends QualityAssurance {

    // Defined the input variable
    private String qaAttributes;

    // Created the Constructor with parameters
    public TeamLeadQa(int id, String name, String birthDate, String cnp, int qaLevel, String qaAttributes) {
        super(id, name, birthDate, cnp, qaLevel);
        this.qaAttributes = qaAttributes;
    }

    /**
     * Public function "getter" for the defined input variable "qaAttributes"
     * @return
     */
    public String getAttributes() {
        return qaAttributes;
    }

    /**
     * Public function "setter" for the defined input variable "qaAttributes"
     * @param qaAttributes
     */
    public void setAttributes(String qaAttributes) {
        this.qaAttributes = qaAttributes;
    }
}
