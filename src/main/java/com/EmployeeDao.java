package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniela.domnici on 09/11/15.
 * Data Access object class (predefined objects)
 */
public class EmployeeDao {
    List<Employee> employees;

    /**
     * Public method for creating predefined objects, used for fast interaction
     * @return
     */
    public List<Employee> createEmployees(){
        employees = new ArrayList<Employee>();
        Employee em1 = new Employee(1, "PopMarian", "20 august 1987", "1872008039961");
        QualityAssurance em2 = new QualityAssurance(2, "PopescuIoan", "18 mai 1990", "1901805039961", 3);
        Development em3 = new Development(3, "AtillaSzabo", "3 mai 1990", "1900305039961", 2);
        TeamLeadQa em4 = new TeamLeadQa(4, "LiviaPavel", "27 iunie 1985", "2852706061221", 3, "management");
        TeamLeadDev em5 = new TeamLeadDev(5, "MariaAlbu", "25 decembrie 1985", "2852512061621", 3, "management");

        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        employees.add(em4);
        employees.add(em5);

        return employees;
    }

}
