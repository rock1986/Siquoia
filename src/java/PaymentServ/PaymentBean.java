/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaymentServ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;

/**
 *
 * @author rock
 */
@Stateless
public class PaymentBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private String method;
    private String cardNum;
    private String month;
    private String year;
    private String code;
    private String firstname;
    private String lastname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;
    private String email;
    private boolean firsttime=true;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFirsttime() {
        return firsttime;
    }

    public void setFirsttime(boolean firsttime) {
        this.firsttime = firsttime;
    }
    
    public boolean hasAttribute(String attribute)
    {
        if (attribute.trim().equals(""))
            return false;
        else 
            return true; 
    }

    public boolean isValidMethod(String method)
    {
        if (method.equals("--TYPE--"))
            return false;
        else
            return true;
    }        
    
    public boolean isValidMonth(String month)
    {
        if (month.equals("--MM--"))
            return false;
        else
            return true;
    }    
    
    public boolean isValidState(String state)
    {
        if (state.equals("--Select one--"))
            return false;
        else
            return true;
    }    
    
    public boolean isValidYear(String year)
    {
        if (year.equals("--YEAR--"))
            return false;
        else
            return true;
    }
    
    public boolean isValidCountry(String country)
    {
        if (country.equals("--Select one--"))
            return false;
        else
            return true;        
    }
    
    public boolean isValidExpire()
    {
        if (month.equals("--MM--") || year.equals("--YEAR--"))
            return false;
        else
            return true;         
    }
    
    public boolean isValidEmail(String email_addr) 
    {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern;
        Matcher matcher;
        if (email_addr == null) {
            return false;
        } else {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email_addr);
            return matcher.matches();
        }
    }
    
    public boolean isValidPage() {
        if (hasAttribute(firstname) && hasAttribute(lastname) && hasAttribute(address1)
                && hasAttribute(city) && isValidState(state) && isValidCountry(country) && hasAttribute(zip)
                && hasAttribute(phone) && isValidExpire() && isValidEmail(email)) 
        {
            return true;
        } else 
        {
            return false;
        }
    }    
}
