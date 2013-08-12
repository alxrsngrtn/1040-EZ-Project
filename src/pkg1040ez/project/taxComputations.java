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
public class taxComputations {
    
    /* Computes the AGI for the user. Takes in the String entries from the
     * W-2 Income, Interest Income, and UI/Alaska Dividends Income fields,
     * converts them to BigDecimals, adds them, and rounds them up to the nearest
     * dollar. Then converts them back to a string and passes it to the AGI
     * TextField in the main program.
     * 
     * That AGI TextField is then called in subsequent methods.
     */
    
    public String returnAGI(String w2income, String interestIncome, String UIAndAlaskaIncome){
        
        BigDecimal w2inc = new BigDecimal(w2income);
        BigDecimal intInc = new BigDecimal(interestIncome);
        BigDecimal UIAndAlaskaInc = new BigDecimal(UIAndAlaskaIncome);
        BigDecimal totalIncome = w2inc.add(intInc.add(UIAndAlaskaInc));
        
        totalIncome = totalIncome.setScale(0, RoundingMode.HALF_UP);
        
        return totalIncome.toPlainString();
    }
    
    /* Computes the user's taxable income by taking the AGI of the user from the
     * AGI field and the total deduction amount from the exemptionAmountEntry
     * field, subtracting the exemption amount from the AGI, and returning the
     * result as a string, which will be placed in the taxableIncome TextField. 
     */
    
    public String computeTaxableIncome(String AGIField, String exemptionEntry){
        int totalAGI = Integer.parseInt(AGIField);
        int totalDeduction = Integer.parseInt(exemptionEntry);
        String taxInc = Integer.toString(totalAGI - totalDeduction);
        
        return taxInc;

    }
    
    /* Computes user's total payments and credits by taking the withholdings
     * entered by the user and the calculated EIC as strings. Converts them
     * to BigDecimals for rounding purposes, adds them together, and returns
     * the sum as a string to the totalPaymentsAndCreditsField.
     */
    
    public String calcTotalPaymentsAndCredits(String withholding, String EIC){
        BigDecimal withHoldings = new BigDecimal(withholding);
        BigDecimal calculatedEIC = new BigDecimal(EIC);
        BigDecimal totalPaymentsAndCredits = withHoldings.add(calculatedEIC);
        totalPaymentsAndCredits = totalPaymentsAndCredits.setScale(0, RoundingMode.HALF_UP);
        
        return totalPaymentsAndCredits.toPlainString();
    }
   
    
}
