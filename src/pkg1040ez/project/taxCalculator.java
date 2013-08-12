/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Bryan
 */
public class taxCalculator {
    
    public String CalcTax(String taxableIncString){
        double taxableIncome = Double.parseDouble(taxableIncString);
        double tax = 0;
        
        if(taxableIncome > 0){
            if(taxableIncome > 8700){
                tax = 8700 * .10;
            } else {
                tax = taxableIncome * .10;
            }
        }
        
        if(taxableIncome > 8700){
            if(taxableIncome > 35350){
                tax = tax + 26650 * .15;
            } else {
                tax = tax + (((taxableIncome - 8700)) * .15);
            }
        }
        
        if(taxableIncome > 35350){
            if(taxableIncome > 85650){
                tax = tax + 50300 * .25;
            } else {
                tax = tax + ((taxableIncome - 35350) * .25);
            }
        }
   
        if(taxableIncome > 85650){
            tax = tax + ((taxableIncome - 85650) * .28);
        }
        
        BigDecimal taxAmount = new BigDecimal(tax);
        taxAmount = taxAmount.setScale(0, RoundingMode.HALF_UP);
        return taxAmount.toPlainString();
 
    }
    
}
