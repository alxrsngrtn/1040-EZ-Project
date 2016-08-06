/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * TODO: convert to big decimal instead of double. Overload double functions and deffer to big decimal
 * @author Bryan
 */
public class taxCalculator {

    // TODO: convert to big decimal
    public String CalcTax(String taxableIncString, boolean mfj) {
        double incomeToTax = Double.parseDouble(taxableIncString);
        double tax = 0;

        /* If user is married, filing jointly, this calls the method to determine
         * the user's tax rate in accord with the MFJ marginal tax rates.
         * Alternatively, it calls the marginal tax rates for single filers.
         */

        if (mfj) {
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

    public double mfjTaxes(double taxableIncome) {
        double tax;
        tax = updateTaxIfWithinBracket(0,   taxableIncome, 0,     17400, 0.10);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 17400, 70700, 0.15);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 70700, -1,    0.25);
        return tax;

    }

    /**
     * Returns the tax bracket a person resides in -- for married filing jointly
     * @param taxableIncome
     * @return
     */
    public double mfjTaxBracket(double taxableIncome){
        if(isInTaxBracket(taxableIncome, 0.0, 17400.0)){
            return 0.10;
        }
        if(isInTaxBracket(taxableIncome, 17400.0, 70700.0)){
            return 0.15;
        }
        return 0.25;
    }


    /**
     * Modifies the input tax amount based on how taxable income is placed within the tax bracket.
     * @param tax starting tax amount
     * @param taxableIncome total income
     * @param lowerBound min amount to fall in bracket
     * @param upperBound if upperBound <= 0, treated as no upper bound
     * @param rate rate to be taxed in this bracket
     * @return modified tax value
     */
    private double updateTaxIfWithinBracket(double tax, double taxableIncome, double lowerBound, double upperBound, double rate){
        if (taxableIncome > lowerBound) {
            if (taxableIncome > upperBound && upperBound > 0) {
                tax = tax + (upperBound - lowerBound) * rate;
            } else {
                tax = tax + (((taxableIncome - lowerBound)) * rate);
            }
        }

        return tax;
    }

    /**
     * Determines if person is within tax bracket, non-inclusive
     * @param income taxable income
     * @param lower lower bound for bracket
     * @param upper upper bound for bracket
     * @return boolean, true if they are within the bracket
     */
    private boolean isInTaxBracket(double income, double lower, double upper){
        if(upper < 0){
            return income >= lower;
        }
        return income >= lower && income < upper;
    }

    public double singleTaxes(double taxableIncome) {
        double tax;
        tax = updateTaxIfWithinBracket(0,   taxableIncome, 0,     8700,  0.10);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 8700,  35350, 0.15);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 35350, 85650, 0.25);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 85650, -1,    0.28);
        return tax;
    }

    /**
     * Returns the tax bracket a person resides in -- for filing single
     * @param taxableIncome
     * @return
     */
    public double singleTaxBracket(double taxableIncome){
        if(isInTaxBracket(taxableIncome, 0.0, 8700.0)){
            return 0.10;
        }
        if(isInTaxBracket(taxableIncome, 8700.0, 35350.0)){
            return 0.15;
        }
        if(isInTaxBracket(taxableIncome, 35350.0, 85650.0)){
            return 0.25;
        }
        return 0.28;
    }
}