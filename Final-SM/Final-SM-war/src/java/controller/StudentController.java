/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import entities.Students;
import model.*;
import java.util.*;
import javax.annotation.ManagedBean;
import javax.ejb.*;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Admin
 */
@Named(value = "studentController")
@Dependent
@SessionScoped
public class StudentController {
    @EJB
    private StudentsFacade studentsFacade;
    private  Students s = new Students();
    private String id;

    public Students getS() {
        return s;
    }

    public void setS(Students s) {
        this.s = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Creates a new instance of StudentController
     */
    public StudentController() {
        
    }
    
    public List<Students> findAll(){
        return this.studentsFacade.findAll();
    }
    public static Integer getIdParam(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        int result =   Integer.parseInt(params.get("id"));
        return result - 1;
	}
    public String detail(Students s){        
        this.s = s;
        return "details";
    }
    
}
