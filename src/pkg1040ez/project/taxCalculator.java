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
    double incomeToTax;
    double tax;
    
    
    public String CalcTax(String taxableIncString, boolean mfj){
        incomeToTax = Double.parseDouble(taxableIncString);
        tax = 0;
        
        /* If user is married, filing jointly, this calls the method to determine
         * the user's tax rate in accord with the MFJ marginal tax rates. 
         * Alternatively, it calls the marginal tax rates for single filers.
         */
        
        if(mfj){
            tax = mfjTaxes(incomeToTax);   
        } else {
            tax = singleTaxes(incomeToTax);   
        }
        
        /* Takes tax value, converts to a BigDecimal, and rounds accordingly,
         * returning the result as a string.
         */
        
        BigDecimal taxAmount = new BigDecimal(tax);
        taxAmount = taxAmount.setScale(0, RoundingMode.HALF_UP);
        return taxAmount.toPlainString();
    }
        
    public double mfjTaxes(double taxableIncome){
        if(taxableIncome > 0){
            if(taxableIncome > 17400){
                tax = 17400 * .10;
            } else {
                tax = taxableIncome * .10;
            }
            }

            if(taxableIncome > 17400){
                if(taxableIncome > 70700){
                    tax = tax + 53300 * .15;
                } else {
                    tax = tax + (((taxableIncome - 17400)) * .15);
                }
            }

            if(taxableIncome > 70700){
                tax = tax + ((taxableIncome - 70700) * .25);
            }
            
            return tax;
            
        }
    
    public double singleTaxes(double taxableIncome){
        
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
            
            return tax;
    }
}