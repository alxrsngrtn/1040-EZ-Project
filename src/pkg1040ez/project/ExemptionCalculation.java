/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

/**
 *
 * @author Bryan
 */
public class ExemptionCalculation extends Project {
    
    public int ExemptionCalc(int w2Income) {
        int w2income;
        int lineA = w2income + 300;
        int lineB = 950;
        int lineC;
        int lineD;
        int lineE;
        int lineF;
        int lineG;
        
        // Checking whether Taxpayer's W-2 income + 300 is in excess of the minimun standard deduction.
        // If it is, that amount is entered onto line C, else, the standard deduction is used.
        if(lineA > lineB){
            lineC = lineA;
        } else {
            lineC = lineB;
        }
        
        
        
        
        
        return 0;
    }
    private int minStandardDeduction;
    private int maximumStandardDeduction;
}
