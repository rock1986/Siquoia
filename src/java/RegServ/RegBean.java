/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegServ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;

/**
 *
 * @author rock
 */
@Stateless
public class RegBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstname;
    private String lastname;
    private String useremail;
    private String userpassword;
    private String userpassword_conf;
    private boolean hasUser = false;
    private boolean paid;
    private boolean isFirstTime = true;    

    public boolean isHasUser() {
        return hasUser;
    }

    public void setHasUser(boolean hasUser) {
        this.hasUser = hasUser;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
            this.userpassword = userpassword;
    }

    public String getUserpassword_conf() {
        return userpassword_conf;
    }

    public void setUserpassword_conf(String userpassword_conf) {
        this.userpassword_conf = userpassword_conf;
    }

    public boolean isIsFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }
    
    public boolean samePassword()
    {
        if (userpassword == null || userpassword_conf == null)
            return false;
        else
            return (userpassword_conf.equals(userpassword));        
    }
    
    public boolean isValidEmail(String email_addr) {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern;
        Matcher matcher;
        if (email_addr.equals("")) {
            return false;
        } else {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email_addr);
            return matcher.matches();
        }
    }
    
    public boolean isGoodPassword(String password)
    {
            final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

            Pattern pattern;
            Matcher matcher;
        if (password.equals("")) 
            return false;
        else
        {
            pattern = Pattern.compile(PASSWORD_PATTERN);
            matcher = pattern.matcher(password);
            return matcher.matches();
        }

    }
    
    public boolean isVaildPage()
    {
        if (isGoodPassword(userpassword) && isValidEmail(useremail) && samePassword() && !isHasUser())
            return true;
        else
            return false;
    }
    
//    public boolean isValidInput(String str)
//    {
//        return !isIsFirstTime() && !str.trim().equals("");
//    }
    
//    public void initialize()
//    {
//        this.setUseremail(null);
//        this.setUserpassword(null);
//        this.setUserpassword_conf(null);
//        this.setHasUser(true);
//    }
}
