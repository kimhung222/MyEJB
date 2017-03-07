/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import appclient.Students;
import java.sql.ResultSet;
import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author Admin
 */
@Remote
public interface StudentSessionBeanRemote {
    public List<Students> findAll();
    public List<Students> add(Students new_s);
    public List<Students> edit(Students new_s);
    public List<Students> delete(Integer i);
}


