/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

/**
 *
 * @author Bryan
 */
public class deductionCalculator {
    
    /*
     * This program calculate's the user's deduction/exemptions.
     * The calculations are done in accord with the worksheet attached to
     * Form 1040EZ if the user or spouse or both are claimed as dependents on
     * another person's return. If not, it assigns the default standard deduction/
     * exemption based on filing status.
     */
    
    public String DedCalc(int w2income, boolean mfj, boolean oneAsDep, boolean bothAsDep){
    int minStdDed = 950;
    int maxStdDed;
    int actualStdDed;
    int exemptionAmt;
    int lineC;
    int lineF = 0;
    int total;
    
        /*
         * First the method checks whether the user or the spouse were claimed as
         * as a dependent on another person's tax return. If not, it assigns
         * the user the standard deduction/exemption amount in accord with
         * "else" at the bottom.
         */
    
        if(oneAsDep){
            if((w2income+300) < minStdDed){
                lineC = minStdDed;
            } else {
                lineC = w2income+300;
            }
        
            
            if(!mfj){
                maxStdDed = 5950;
            } else {
                maxStdDed = 11900;
            }
        
            if(lineC < maxStdDed){
                actualStdDed = lineC;
            } else {
                actualStdDed = maxStdDed;
            }
        
            if(!mfj){
                lineF = 0;
            } else if(mfj && bothAsDep){
                lineF = 0;
            } else if(mfj && oneAsDep){
                lineF = 3800;
            }
        
            total = lineF + actualStdDed;

        } else {
            if(mfj){
                total = 19500;
            } else {
                total = 9750;
            }
        }

        return Integer.toString(total);
    }
    
}
