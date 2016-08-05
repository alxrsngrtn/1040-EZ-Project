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
     * Modifies the input tax amount based on how taxable income is placed within the tax bracket.
     * TODO: convert to big decimal
     * @param tax starting tax amount
     * @param taxableIncome total income
     * @param lowerBound min amount to fall in bracket
     * @param upperBound if <= 0, treated as no upper bound
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

    public double singleTaxes(double taxableIncome) {
        double tax;
        tax = updateTaxIfWithinBracket(0,   taxableIncome, 0,     8700,  0.10);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 8700,  35350, 0.15);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 35350, 85650, 0.25);
        tax = updateTaxIfWithinBracket(tax, taxableIncome, 85650, -1,    0.28);
        return tax;
    }
}