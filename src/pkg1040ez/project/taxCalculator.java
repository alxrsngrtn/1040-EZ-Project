/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

/**
 *
 * @author Bryan
 */
public class taxCalculator {
    
    public double CalcTax(int taxableIncome){
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

        return tax;
    }
    
}
