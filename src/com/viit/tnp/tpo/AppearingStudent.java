/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.tpo;

public class AppearingStudent {
    private Integer stu_id;
    private String sch_date;
    private Integer sch_id;
    
    
    
    public AppearingStudent(Integer Stu_id,Integer Sch_id,String App_date){   //
        this.sch_date=App_date;
        this.stu_id=Stu_id;
        this.sch_id=Sch_id;
    }
    public Integer getstu_id(){
        return stu_id;
    }
    public Integer getsch_id()
    {
        return sch_id;
    }
    
    
    public String getacad_year(){
        return sch_date;
    }
   
    

    
}
