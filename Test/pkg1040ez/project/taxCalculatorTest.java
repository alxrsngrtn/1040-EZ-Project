package pkg1040ez.project;

import static org.junit.Assert.*;

/**
 * Created by alxrsngrtn on 8/4/16.
 */
public class taxCalculatorTest {

    private taxCalculator taxCalc = new taxCalculator();
    private final static double EPSILON = 0.001;


    @org.junit.Test
    public void calcTax() throws Exception {
    }

    @org.junit.Test
    public void mfjTaxes() throws Exception {
        // Test cases around thresholds
        double taxThresh1 = 17400;
        double taxThresh2 = 70700;

        double belowThresh1 = taxCalc.mfjTaxes(taxThresh1 - 1);
        double equalThresh1 = taxCalc.mfjTaxes(taxThresh1);
        double aboveThresh1 = taxCalc.mfjTaxes(taxThresh1 + 1);
        assertEquals(1739.9, belowThresh1, EPSILON);
        assertEquals(1740.0, equalThresh1, EPSILON);
        assertEquals(1740.15, aboveThresh1, EPSILON);


        double belowThresh2 = taxCalc.mfjTaxes(taxThresh2 - 1);
        double equalThresh2 = taxCalc.mfjTaxes(taxThresh2);
        double aboveThresh2 = taxCalc.mfjTaxes(taxThresh2 + 1);
        assertEquals(9734.849999999999, belowThresh2, EPSILON);
        assertEquals(9735.0, equalThresh2, EPSILON);
        assertEquals(9735.25, aboveThresh2, EPSILON);

        // Sanity: i *= 2 from 1 .. i <= 524288
        assertEquals(0, taxCalc.mfjTaxes(0), EPSILON);
        assertEquals(0.1, taxCalc.mfjTaxes(1), EPSILON);
        assertEquals(0.4, taxCalc.mfjTaxes(4), EPSILON);
        assertEquals(0.8, taxCalc.mfjTaxes(8), EPSILON);
        assertEquals(1.6, taxCalc.mfjTaxes(16), EPSILON);
        assertEquals(3.2, taxCalc.mfjTaxes(32), EPSILON);
        assertEquals(6.4, taxCalc.mfjTaxes(64), EPSILON);
        assertEquals(12.8, taxCalc.mfjTaxes(128), EPSILON);
        assertEquals(25.6, taxCalc.mfjTaxes(256), EPSILON);
        assertEquals(51.2, taxCalc.mfjTaxes(512), EPSILON);
        assertEquals(102.4, taxCalc.mfjTaxes(1024), EPSILON);
        assertEquals(204.8, taxCalc.mfjTaxes(2048), EPSILON);
        assertEquals(409.6, taxCalc.mfjTaxes(4096), EPSILON);
        assertEquals(819.2, taxCalc.mfjTaxes(8192), EPSILON);
        assertEquals(1638.4, taxCalc.mfjTaxes(16384), EPSILON);
        assertEquals(4045.2, taxCalc.mfjTaxes(32768), EPSILON);
        assertEquals(8960.4, taxCalc.mfjTaxes(65536), EPSILON);
        assertEquals(4045.2, taxCalc.mfjTaxes(32768), EPSILON);
        assertEquals(24828.0, taxCalc.mfjTaxes(131072), EPSILON);
        assertEquals(57596.0, taxCalc.mfjTaxes(262144), EPSILON);
        assertEquals(123132.0, taxCalc.mfjTaxes(524288), EPSILON);
    }

    @org.junit.Test
    public void singleTaxes() throws Exception {

        double taxThresh1 = 8700;
        double taxThresh2 = 35350;
        double taxThresh3 = 85650;

        assertEquals(870.0,taxCalc.singleTaxes(taxThresh1), EPSILON);
        assertEquals(4867.5, taxCalc.singleTaxes(taxThresh2), EPSILON);
        assertEquals(17442.5, taxCalc.singleTaxes(taxThresh3), EPSILON);

        assertEquals(869.90, taxCalc.singleTaxes(taxThresh1-1), EPSILON);
        assertEquals(4867.35, taxCalc.singleTaxes(taxThresh2-1), EPSILON);
        assertEquals(17442.25, taxCalc.singleTaxes(taxThresh3-1), EPSILON);


        assertEquals(870.15, taxCalc.singleTaxes(taxThresh1+1), EPSILON);
        assertEquals(4867.75, taxCalc.singleTaxes(taxThresh2+1), EPSILON);
        assertEquals(17442.78, taxCalc.singleTaxes(taxThresh3+1), EPSILON);


        // Sanity: i *= 2 from 1 .. i <= 524288
        assertEquals(0, taxCalc.singleTaxes(0), EPSILON);
        assertEquals(0.1, taxCalc.singleTaxes(1), EPSILON);
        assertEquals(0.4, taxCalc.singleTaxes(4), EPSILON);
        assertEquals(0.8, taxCalc.singleTaxes(8), EPSILON);
        assertEquals(1.6, taxCalc.singleTaxes(16), EPSILON);
        assertEquals(3.2, taxCalc.singleTaxes(32), EPSILON);
        assertEquals(6.4, taxCalc.singleTaxes(64), EPSILON);
        assertEquals(12.8, taxCalc.singleTaxes(128), EPSILON);
        assertEquals(25.6, taxCalc.singleTaxes(256), EPSILON);
        assertEquals(51.2, taxCalc.singleTaxes(512), EPSILON);
        assertEquals(102.4, taxCalc.singleTaxes(1024), EPSILON);
        assertEquals(204.8, taxCalc.singleTaxes(2048), EPSILON);
        assertEquals(409.6, taxCalc.singleTaxes(4096), EPSILON);
        assertEquals(819.2, taxCalc.singleTaxes(8192), EPSILON);
        assertEquals(2022.6, taxCalc.singleTaxes(16384), EPSILON);
        assertEquals(4480.2, taxCalc.singleTaxes(32768), EPSILON);
        assertEquals(12414.0, taxCalc.singleTaxes(65536), EPSILON);
        assertEquals(4480.2, taxCalc.singleTaxes(32768), EPSILON);
        assertEquals(12414.0, taxCalc.singleTaxes(65536), EPSILON);
        assertEquals(30160.66, taxCalc.singleTaxes(131072), EPSILON);
        assertEquals(66860.82, taxCalc.singleTaxes(262144), EPSILON);
        assertEquals(140261.14, taxCalc.singleTaxes(524288), EPSILON);

    }

}