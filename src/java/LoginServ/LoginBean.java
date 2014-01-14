/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoginServ;

import javax.ejb.Stateless;

/**
 *
 * @author rock
 */
@Stateless
public class LoginBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstname;
    private String lastname;
    private String useremail;
    private String userpassword;
    private int id;
    private int highscore;
    private int total;
    private int point;
    private boolean vaild;
    private boolean paid;
    private boolean admin=false;
    private boolean firsttime=true;
    private String status;
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean newAdmin) {
        this.admin = newAdmin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isVaild() {
        return vaild;
    }

    public void setVaild(boolean newVaild) {
        this.vaild = newVaild;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String newUseremail) {
        this.useremail = newUseremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String newUserpassword) {
        this.userpassword = newUserpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore=highscore;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setIspaid(boolean newIspaid) {
        this.paid = newIspaid;
    }

    public boolean isFirsttime() {
        return firsttime;
    }

    public void setFirsttime(boolean firsttime) {
        this.firsttime = firsttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
}
