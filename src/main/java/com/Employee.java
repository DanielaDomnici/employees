package com;

public class Employee {

    //Define the input variables
    int id;
    private String name;
    private String birthDate;
    private String cnp;


    public Employee(int id, String name, String birthDate, String cnp) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.cnp = cnp;
    }

    public Employee() {
    }

    /**
     * Public function "getter" for the defined input variable "name"
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Public function "setter" for the defined input variable "name"
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Public function "getter" for the defined input variable "birthDate"
     *
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Public function "setter" for the defined input variable "birthDate"
     *
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Public function "getter" for the defined input variable "cnp"
     *
     * @return
     */
    public String getCnp() {
        return cnp;
    }

    /**
     * Public function "setter" for the defined input variable "cnp"
     *
     * @param cnp
     */
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    /**
     * Public function "getter" for the defined input variable "id"
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Public function "setter" for the defined input variable "id"
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
