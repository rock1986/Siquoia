<%-- 
    Document   : payment
    Created on : Nov 25, 2013, 2:15:41 AM
    Author     : rock
--%>
<jsp:useBean id="bean" class="PaymentServ.PaymentBean" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Simple Intelligence Quotient Increasing Application</title>
        <link rel="stylesheet" type="text/css" href="css/paymentpage.css" />
    </head>
    <body>
        <div id="main">
        <div id="top_html">
                <p>To make a payment, please fill in the amount you wish to pay in the fields provided.</p></div>
        <form action="http://localhost:8080/Siquoia/PaymentServlet" method="post" class="pmtpg" id="form_pmtpg">
        <div id="content" style="display: block;">
        <div id="float-container">
                <div id="col_left">
                        <!-- payment info -->
                        <div class="row">
                                <div class="cell_double">
                                        <h3>Payment Information</h3>
                                </div>
                        </div>
                <!-- Amount -->
                       <div class="row">
                                <div class="cell_left">
                                        <h4>Amount</h4>
                                </div>
                                <div class="cell_right right">
                                    <h4>$2.99</h4>
                                </div>
                                <div id="error_amount_0" style="text-align:right;clear:both;" class="cell_double errormessage"></div>
                                <div class="clearboth"></div>
                        </div>
                </div> <!-- col_left end -->


                <div id="col_right">
                        <!-- payment method -->
                        <div class="row">
                                <div class="cell_double">
                                        <h3>Payment Method</h3>
                                </div>
                        </div>
                                                <!-- payment type -->
                                <div class="row paywith">
                                        <div class="cell_left">
                                                <label>Pay with<span class="asterisk">*</span></label>
                                        </div>
                                        <div class="cell_right nowrap">
                                        <select name="bill_method" id="cc_exp_month"
                                                <% String method = bean.getMethod();
                                                        if (!bean.isFirsttime() && !bean.isValidMethod(method))
                                                            out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                                %>
                                                >
                                            <option value="--TYPE--"  ${bean.getMethod()==""? "selected = 'selected'":""}>--TYPE--</option>
                                            <option value="Visa" ${bean.getMonth()=="Visa"? "selected = 'selected'":""}>Visa</option>
                                            <option value="Master" ${bean.getMethod()=="Master"? "selected='selected'":""}>Master</option>				
                                        </select><br/>
                                            <% if(!bean.isFirsttime() && !bean.isValidMethod(method))
                                                     out.print("<span class=\"red\">Please select payment method!</span>");   
                                                        %>
                                        </div>
                                </div>
                                <!-- Spacer -->
                                <div class="row paywith">
                                </div>
                                        <!-- Card number -->
                        <div class="row cc" style="display: block;">
                                <div class="cell_left">
                                        <label>Card Number<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="card_number" id="cc_number" value="${bean.getCardNum()}" maxlength="50" class="digits_spaces_hyphens"
                                               <% String cardNum=bean.getCardNum();
                                                       if (!bean.isFirsttime() && !bean.hasAttribute(cardNum))
                                                           out.print("style=\"background-color: white; border-width:1px; border-color:red; border-style:solid;\"");
                                                       else
                                                           out.print("style=\"background-color: white;\"");
                                               %>
                                               ><br/>
                                            <%  if (!bean.isFirsttime() && !bean.hasAttribute(cardNum))
                                                    out.print("<span class=\"red\">Empty Field! Please fill in the blank!</span>");
                                                       %>
                                </div>
                        </div>
                        <!-- Expiration -->
                        <div class="row cc" style="display: block;">
                                <div class="cell_left">
                                        <label>Expires<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <select name="exp_month" id="cc_exp_month"
                                                <%String month=bean.getMonth();
                                                    if (!bean.isFirsttime() && !bean.isValidMonth(month))
                                                        out.print("style=\"background-color: white; border-width:1px; border-color:red; border-style:solid;\"");
                                                    else
                                                        out.print("style=\"background-color: white;\"");                                                    
                                            %>
                                                >
                                            <option value="--MM--"  ${bean.getMonth()==""? "selected = 'selected'":""}>--MM--</option>
                                            <option value="1" ${bean.getMonth()=="1"? "selected = 'selected'":""}>1</option>
                                            <option value="2" ${bean.getMonth()=="2"? "selected = 'selected'":""}>2</option>
                                            <option value="3" ${bean.getMonth()=="3"? "selected = 'selected'":""}>3</option>
                                            <option value="4" ${bean.getMonth()=="4"? "selected = 'selected'":""}>4</option>
                                            <option value="5" ${bean.getMonth()=="5"? "selected = 'selected'":""}>5</option>
                                            <option value="6" ${bean.getMonth()=="6"? "selected = 'selected'":""}>6</option>
                                            <option value="7" ${bean.getMonth()=="7"? "selected = 'selected'":""}>7</option>
                                            <option value="8" ${bean.getMonth()=="8"? "selected = 'selected'":""}>8</option>
                                            <option value="9" ${bean.getMonth()=="9"? "selected = 'selected'":""}>9</option>
                                            <option value="10" ${bean.getMonth()=="10"? "selected = 'selected'":""}>10</option>
                                            <option value="11" ${bean.getMonth()=="11"? "selected = 'selected'":""}>11</option>
                                            <option value="12" ${bean.getMonth()=="12"? "selected = 'selected'":""}>12</option>				
                                        </select>                                        
                                        <span> - </span>
                                        <select name="exp_year" id="cc_exp_year"
                                            <% String year=bean.getYear(); 
                                              if (!bean.isFirsttime()&&!bean.isValidYear(year)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %> 
                                                >
                                            <option value="--YEAR--" ${bean.getYear()==""? "selected = 'selected'":""}>--YEAR--</option>
                                            <option value="2013" ${bean.getYear()=="2013"? "selected = 'selected'":""}>2013</option>
                                            <option value="2014" ${bean.getYear()=="2014"? "selected = 'selected'":""}>2014</option>
                                            <option value="2015" ${bean.getYear()=="2015"? "selected = 'selected'":""}>2015</option>
                                            <option value="2016" ${bean.getYear()=="2016"? "selected = 'selected'":""}>2016</option>
                                            <option value="2017" ${bean.getYear()=="2017"? "selected = 'selected'":""}>2017</option>
                                            <option value="2018" ${bean.getYear()=="2018"? "selected = 'selected'":""}>2018</option>
                                        </select><br/>
                                        <% if (!bean.isFirsttime()&&!bean.isValidYear(year)){
                                                 out.print("<span class=\"red\">Please select your expiration time!</span>");
                                             } %>                                         
                                </div>
                        </div>
                        <div class="row cc cc_cvv" style="display: block;">
                                <div class="cell_left">
                                        <label>Security Code<span class="asterisk">*</span></label>
                                </div>
                        	<div class="cell_right">
                                    <input type="text" name="cc_cvv" id="cc_cvv" value="${bean.getCode()}" class="digits" maxlength="4"
                                            <% String code=bean.getCode(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(code)){
                                                  out.print("style=\"width: 35px; background-color: white; border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                              else
                                                  out.print("style=\"width: 35px; background-color: white;\"");
                                            %>                                            
                                           ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(code)){
                                                 out.print("<span class=\"red\">Please enter your security code!</span>");
                                             } %>                                         
				</div>
                        </div>                        
                        <!-- Spacer -->
                        <div class="row">
                                <div class="cell_left">
                                        &nbsp;
                                </div>
                                <div class="cell_right">
                                </div>
                        </div>
                        <!-- Billing Address -->
                        <div class="row bill">
                                <div class="cell_double">
                                        <h3>Billing Address</h3>
                                </div>
                        </div>

                        <!-- Billing name -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>First Name<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_fname" id="bill_name" value="${bean.getFirstname()}" maxlength="40"
                                           <% String fname=bean.getFirstname(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(fname)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(fname)){
                                                 out.print("<span class=\"red\">Please enter your first name!</span>");
                                             } %>                                            
                                </div>
                        </div>
                         <div class="row bill">   
                                <div class="cell_left">
                                        <label>Last Name<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_lname" id="bill_name" value="${bean.getLastname()}" maxlength="40"
                                           <% String lname=bean.getLastname(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(lname)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(lname)){
                                                 out.print("<span class=\"red\">Please enter your last name!</span>");
                                             } %>                                               
                                </div>                            
                        </div>
                        <!-- Billing Street address -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>Street Address1<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_address_1" id="bill_address_1" value="${bean.getAddress1()}" maxlength="40"
                                           <% String addr1=bean.getAddress1(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(addr1)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(addr1)){
                                                 out.print("<span class=\"red\">Please enter your address!</span>");
                                             } %>                                               
                                </div>
                        </div>
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>Street Address2</label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_address_2" id="bill_address_2" value="" maxlength="40" style="background-color: white;">
                                </div>
                        </div>                        
                        <!-- Billing City/Town -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>City/Town<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_city" id="bill_city" value="${bean.getCity()}" maxlength="20"
                                           <% String city=bean.getCity(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(city)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(city)){
                                                 out.print("<span class=\"red\">Please enter your city!</span>");
                                             } %>                                               
                                </div>
                        </div>
                        
                        <!-- Billing Location -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>Country<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <select name="bill_country" id="bill_country"
                                           <% String country=bean.getCountry(); 
                                              if (!bean.isFirsttime()&&!bean.isValidCountry(country)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               >
                                               
                                            <option value="--Select one--"   ${bean.getCountry()==""? "selected = 'selected'":""}>--Select one--</option>
                                            <option value="US" ${bean.getCountry()=="US"? "selected = 'selected'":""}>United States of America</option>
                                            <option value="CA"  ${bean.getCountry()=="CA"? "selected = 'selected'":""}>Canada</option>
                                            <option value="AF"  ${bean.getCountry()=="AF"? "selected = 'selected'":""}>Afghanistan</option>
                                            <option value="AX"  ${bean.getCountry()=="AX"? "selected = 'selected'":""}>Aland Islands</option>
                                            <option value="AL"  ${bean.getCountry()=="AL"? "selected = 'selected'":""}>Albania</option>
                                            <option value="DZ"  ${bean.getCountry()=="DZ"? "selected = 'selected'":""}>Algeria</option>
                                            <option value="AS"  ${bean.getCountry()=="AS"? "selected = 'selected'":""}>American Samoa</option>
                                            <option value="AD"  ${bean.getCountry()=="AD"? "selected = 'selected'":""}>Andorra</option>
                                            <option value="AO"  ${bean.getCountry()=="AO"? "selected = 'selected'":""}>Angola</option>
                                            <option value="AI"  ${bean.getCountry()=="AI"? "selected = 'selected'":""}>Anguilla</option>
                                            <option value="AG"  ${bean.getCountry()=="AG"? "selected = 'selected'":""}>Antigua and Barbuda</option>
                                            <option value="AR"  ${bean.getCountry()=="AR"? "selected = 'selected'":""}>Argentina</option>
                                            <option value="AM"  ${bean.getCountry()=="AM"? "selected = 'selected'":""}>Armenia</option>
                                            <option value="AW"  ${bean.getCountry()=="AW"? "selected = 'selected'":""}>Aruba</option>
                                            <option value="AU"  ${bean.getCountry()=="AU"? "selected = 'selected'":""}>Australia</option>
                                            <option value="AT"  ${bean.getCountry()=="AT"? "selected = 'selected'":""}>Austria</option>
                                            <option value="AZ"  ${bean.getCountry()=="AZ"? "selected = 'selected'":""}>Azerbaijan</option>
                                            <option value="AP"  ${bean.getCountry()=="AP"? "selected = 'selected'":""}>Azores</option>
                                            <option value="BS"  ${bean.getCountry()=="BS"? "selected = 'selected'":""}>Bahamas</option>
                                            <option value="BH"  ${bean.getCountry()=="BH"? "selected = 'selected'":""}>Bahrain</option>
                                            <option value="BD"  ${bean.getCountry()=="BD"? "selected = 'selected'":""}>Bangladesh</option>
                                            <option value="BB"  ${bean.getCountry()=="BB"? "selected = 'selected'":""}>Barbados</option>
                                            <option value="BY"  ${bean.getCountry()=="BY"? "selected = 'selected'":""}>Belarus</option>
                                            <option value="BE"  ${bean.getCountry()=="BE"? "selected = 'selected'":""}>Belgium</option>
                                            <option value="BZ"  ${bean.getCountry()=="BZ"? "selected = 'selected'":""}>Belize</option>
                                            <option value="BJ"  ${bean.getCountry()=="BJ"? "selected = 'selected'":""}>Benin</option>
                                            <option value="BM"  ${bean.getCountry()=="BM"? "selected = 'selected'":""}>Bermuda</option>
                                            <option value="BT"  ${bean.getCountry()=="BT"? "selected = 'selected'":""}>Bhutan</option>
                                            <option value="BO"  ${bean.getCountry()=="BO"? "selected = 'selected'":""}>Bolivia</option>
                                            <option value="ANB" ${bean.getCountry()=="ANB"? "selected = 'selected'":""}>Bonaire (Netherlands Antilles)</option>
                                            <option value="BA"  ${bean.getCountry()=="BA"? "selected = 'selected'":""}>Bosnia</option>
                                            <option value="BW"  ${bean.getCountry()=="BW"? "selected = 'selected'":""}>Botswana</option>
                                            <option value="BR"  ${bean.getCountry()=="BR"? "selected = 'selected'":""}>Brazil</option>
                                            <option value="VG"  ${bean.getCountry()=="VG"? "selected = 'selected'":""}>British Virgin Isles</option>
                                            <option value="BN"  ${bean.getCountry()=="BN"? "selected = 'selected'":""}>Brunei Darussalam</option>
                                            <option value="BG"  ${bean.getCountry()=="BG"? "selected = 'selected'":""}>Bulgaria</option>
                                            <option value="BF"  ${bean.getCountry()=="BF"? "selected = 'selected'":""}>Burkina Faso</option>
                                            <option value="BI"  ${bean.getCountry()=="BI"? "selected = 'selected'":""}>Burundi</option>
                                            <option value="KH"  ${bean.getCountry()=="KH"? "selected = 'selected'":""}>Cambodia</option>
                                            <option value="CM"  ${bean.getCountry()=="CM"? "selected = 'selected'":""}>Cameroon</option>
                                            <option value="IC"  ${bean.getCountry()=="IC"? "selected = 'selected'":""}>Canary Islands</option>
                                            <option value="CV"  ${bean.getCountry()=="CV"? "selected = 'selected'":""}>Cape Verde</option>
                                        </select><br/>                                        
                                        <% if (!bean.isFirsttime()&&!bean.isValidCountry(country)){
                                                 out.print("<span class=\"red\">Please select your country!</span>");
                                             } %> 
                                </div>
                        </div>
                        
                        <!-- Billing State -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>State/Province<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <select name="bill_state" id="bill_state_US" class="billstate"
                                           <% String state=bean.getState(); 
                                              if (!bean.isFirsttime()&&!bean.isValidState(state)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                            >                                                
                                            <option value="--Select one--" ${bean.getState()==""? "selected = 'selected'":"" }>--Select one--</option>
                                            <option value="AL" ${bean.getState()=="AL"? "selected = 'selected'":"" }>Alabama</option>
                                            <option value="AK" ${bean.getState()=="AK"? "selected = 'selected'":"" }>Alaska</option>
                                            <option value="AZ" ${bean.getState()=="AZ"? "selected = 'selected'":"" }>Arizona</option>
                                            <option value="AR" ${bean.getState()=="AR"? "selected = 'selected'":"" }>Arkansas</option>
                                            <option value="CA" ${bean.getState()=="CA"? "selected = 'selected'":"" }>California</option>
                                            <option value="CO" ${bean.getState()=="CO"? "selected = 'selected'":"" }>Colorado</option>
                                            <option value="CT" ${bean.getState()=="CT"? "selected = 'selected'":"" }>Connecticut</option>
                                            <option value="DE" ${bean.getState()=="DE"? "selected = 'selected'":"" }>Delaware</option>
                                            <option value="DC" ${bean.getState()=="DC"? "selected = 'selected'":"" }>District of Columbia</option>
                                            <option value="FL" ${bean.getState()=="FL"? "selected = 'selected'":"" }>Florida</option>
                                            <option value="GA" ${bean.getState()=="GA"? "selected = 'selected'":"" }>Georgia</option>
                                            <option value="HI" ${bean.getState()=="HI"? "selected = 'selected'":"" }>Hawaii</option>
                                            <option value="ID" ${bean.getState()=="ID"? "selected = 'selected'":"" }>Idaho</option>
                                            <option value="IL" ${bean.getState()=="IL"? "selected = 'selected'":"" }>Illinois</option>
                                            <option value="IN" ${bean.getState()=="IN"? "selected = 'selected'":"" }>Indiana</option>
                                            <option value="IA" ${bean.getState()=="IA"? "selected = 'selected'":"" }>Iowa</option>
                                            <option value="KS" ${bean.getState()=="KS"? "selected = 'selected'":"" }>Kansas</option>
                                            <option value="KY" ${bean.getState()=="KY"? "selected = 'selected'":"" }>Kentucky</option>
                                            <option value="LA" ${bean.getState()=="LA"? "selected = 'selected'":"" }>Louisiana</option>
                                            <option value="ME" ${bean.getState()=="ME"? "selected = 'selected'":"" }>Maine</option>
                                            <option value="MD" ${bean.getState()=="MD"? "selected = 'selected'":"" }>Maryland</option>
                                            <option value="MA" ${bean.getState()=="MA"? "selected = 'selected'":"" }>Massachusetts</option>
                                            <option value="MI" ${bean.getState()=="MI"? "selected = 'selected'":"" }>Michigan</option>
                                            <option value="MN" ${bean.getState()=="MN"? "selected = 'selected'":"" }>Minnesota</option>
                                            <option value="MS" ${bean.getState()=="MS"? "selected = 'selected'":"" }>Mississippi</option>
                                            <option value="MO" ${bean.getState()=="MO"? "selected = 'selected'":"" }>Missouri</option>
                                            <option value="MT" ${bean.getState()=="MT"? "selected = 'selected'":"" }>Montana</option>
                                            <option value="NE" ${bean.getState()=="NE"? "selected = 'selected'":"" }>Nebraska</option>
                                            <option value="NV" ${bean.getState()=="NV"? "selected = 'selected'":"" }>Nevada</option>
                                            <option value="NH" ${bean.getState()=="NH"? "selected = 'selected'":"" }>New Hampshire</option>
                                            <option value="NJ" ${bean.getState()=="NJ"? "selected = 'selected'":"" }>New Jersey</option>
                                            <option value="NM" ${bean.getState()=="NM"? "selected = 'selected'":"" }>New Mexico</option>
                                            <option value="NY" ${bean.getState()=="NY"? "selected = 'selected'":"" }>New York</option>
                                            <option value="NC" ${bean.getState()=="NC"? "selected = 'selected'":"" }>North Carolina</option>
                                            <option value="ND" ${bean.getState()=="ND"? "selected = 'selected'":"" }>North Dakota</option>
                                            <option value="OH" ${bean.getState()=="OH"? "selected = 'selected'":"" }>Ohio</option>
                                            <option value="OK" ${bean.getState()=="OK"? "selected = 'selected'":"" }>Oklahoma</option>
                                            <option value="OR" ${bean.getState()=="OR"? "selected = 'selected'":"" }>Oregon</option>
                                            <option value="PA" ${bean.getState()=="PA"? "selected = 'selected'":"" }>Pennsylvania</option>
                                            <option value="RI" ${bean.getState()=="RI"? "selected = 'selected'":"" }>Rhode Island</option>
                                            <option value="SC" ${bean.getState()=="SC"? "selected = 'selected'":"" }>South Carolina</option>
                                            <option value="SD" ${bean.getState()=="SD"? "selected = 'selected'":"" }>South Dakota</option>
                                            <option value="TN" ${bean.getState()=="TN"? "selected = 'selected'":"" }>Tennessee</option>
                                            <option value="TX" ${bean.getState()=="TX"? "selected = 'selected'":"" }>Texas</option>
                                            <option value="UT" ${bean.getState()=="UT"? "selected = 'selected'":"" }>Utah</option>
                                            <option value="VT" ${bean.getState()=="VT"? "selected = 'selected'":"" }>Vermont</option>
                                            <option value="VA" ${bean.getState()=="VA"? "selected = 'selected'":"" }>Virginia</option>
                                            <option value="WA" ${bean.getState()=="WA"? "selected = 'selected'":"" }>Washington</option>
                                            <option value="WV" ${bean.getState()=="WV"? "selected = 'selected'":"" }>West Virginia</option>
                                            <option value="WI" ${bean.getState()=="WI"? "selected = 'selected'":"" }>Wisconsin</option>
                                            <option value="WY" ${bean.getState()=="WY"? "selected = 'selected'":"" }>Wyoming</option>
                                            <option value="PR" ${bean.getState()=="PR"? "selected = 'selected'":"" }>Puerto Rico</option>
                                            <option value="VI" ${bean.getState()=="VI"? "selected = 'selected'":"" }>Virgin Islands</option>
                                            <option value="MP" ${bean.getState()=="MP"? "selected = 'selected'":"" }>Northern Mariana Islands</option>
                                            <option value="MH" ${bean.getState()=="MH"? "selected = 'selected'":"" }>Marshall Islands</option>
                                            <option value="GU" ${bean.getState()=="GU"? "selected = 'selected'":"" }>Guam</option>
                                            <option value="AS" ${bean.getState()=="AS"? "selected = 'selected'":"" }>American Samoa</option>
                                        </select><br/>
                                        <% if (!bean.isFirsttime()&&!bean.isValidState(state)){
                                                 out.print("<span class=\"red\">Please select your state!</span>");
                                             } %>                                         
                                </div>
                        </div>
                                               
                        <!-- Billing ZIP/Postal Code -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>ZIP/Postal Code<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_zip" id="bill_zip" value="" class="zip" maxlength="12"
                                           <% String zip=bean.getZip(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(zip)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(zip)){
                                                 out.print("<span class=\"red\">Please enter the zip code!</span>");
                                             } %>                                               
                                </div>
                        </div>
                        <!-- Billing Phone number -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>Phone<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_phone" id="bill_phone" value="" class="phone" maxlength="15"
                                           <% String phone=bean.getPhone(); 
                                              if (!bean.isFirsttime()&&!bean.hasAttribute(phone)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                        <% if (!bean.isFirsttime()&&!bean.hasAttribute(phone)){
                                                 out.print("<span class=\"red\">Please enter your phone!</span>");
                                             } %>                                               
                                </div>
                        </div>
                        <!-- Billing Email address -->
                        <div class="row bill">
                                <div class="cell_left">
                                        <label>Email<span class="asterisk">*</span></label>
                                </div>
                                <div class="cell_right">
                                        <input type="text" name="bill_email" id="bill_email" value="" maxlength="40" class="email"
                                           <% String email=bean.getEmail(); 
                                              if (!bean.isFirsttime()&&!bean.isValidEmail(email)){
                                                  out.print("style=\"border-width:1px; border-color:red; border-style:solid;\"");
                                              }
                                            %>                                                
                                               ><br/>
                                            <% if (!bean.isFirsttime()&&!bean.isValidEmail(email)){
                                                 out.print("<span class=\"red\">Please enter your email address!</span>");
                                             } %>                                               
                                        <div id="error_bill_email" class="errormessage"></div>
                                </div>
                        </div>
                        <!-- Spacer -->
                        <div class="row ship" style="display: none;">
                                <div class="cell_left">
                                        &nbsp;
                                </div>
                                <div class="cell_right">
                                </div>
                        </div>

                        <!-- Spacer -->
                        <div>
                                <div class="cell_left">&nbsp;</div>
                                <div class="cell_right">&nbsp;</div>
                        </div>

                        <!-- Submit Button -->
                        <!-- *Required -->
                        <div class="row">
                                <div class="cell_left">
                                        <span class="asterisk float_left">*&nbsp;</span>
                                        <span class="required_word float_left">Required</span>
                                </div>
                                <div class="cell_right">
                                        <input type="image" id="process_transaction_button" value="Submit" style="float:right; margin:0px 76px 0px 0px;">
                                </div>
                        </div>
                </div> <!-- col_right end -->
        <div class="clearboth"></div>
        </div> <!-- float container end -->
        </div> <!-- content end -->
        </form>
        </div>
    </body>
</html>