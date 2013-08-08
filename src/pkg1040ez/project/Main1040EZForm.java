/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Main1040EZForm extends JFrame {
    boolean isMFJ = false;
    boolean oneAsDep = false;
    boolean bothAsDep = false;
    JCheckBox selfBox;
    JCheckBox spouseBox;
    JCheckBox mfjBox;
    JButton computeAGIBtn;
    JButton computeDeduction;
    JButton computeTaxableIncome;
    JButton testButton;
    JButton calcEIC;
    JButton calcTotalPaymentsAndCredits;
    JButton calcTax;
    JButton calcTaxOrRefund;
    JButton convertToBigD;
    JTextField w2IncomeEntry;
    JTextField interestIncomeEntry;
    JTextField unemploymentEntry;
    JTextField AGIField;
    JTextField exemptionAmountEntry;
    JTextField taxableIncome;
    JTextField withholdingEntry;
    JTextField earnedIncomeCreditField;
    JTextField nonTaxableCombatPayElectionField;
    JTextField totalPaymentsAndCreditsField;
    JTextField taxField;
    JTextField dueOrRefundField;
    JTextField amountOfChildrenField;
    JTextField testEntryField;
    JLabel testLabel;
    JLabel dueOrRefund;
    JPanel panel;
    
    
    public Main1040EZForm() {
        initUI();
    }
    
    public void initUI() {
                
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        // Labels corresponding with data entry fields
        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment compensation and Alaska Permanent Fund dividends:");
        JLabel adjustedGrossIncomeLabel = new JLabel("Your Adjusted Gross Income:");
        JLabel dependencyLabel = new JLabel("Can you or your spouse can be claimed as a dependent on another's return:");
        final JLabel mfjLabel = new JLabel("Married Filing Jointly:");
        JLabel taxableIncomeLabel = new JLabel("Taxable Income:");
        JLabel incomeTaxWithheld = new JLabel("Income Tax Withheld:");
        JLabel earnedIncomeCreditLabel = new JLabel("Earned Income Credit:");
        JLabel nonTaxableCombatPayElectionLabel = new JLabel("Nontaxable combat pay election:");
        JLabel totalPaymentsAndCreditsLabel = new JLabel("Total payments and credits:");
        JLabel taxLabel = new JLabel("Tax on income:");
        JLabel amountOfChildrenLabel = new JLabel("How many children do you have:");
        dueOrRefund = new JLabel("Tax Due/Refund:");
        testLabel = new JLabel("This is a test label.");
        
        // Text Fields for data entry
        w2IncomeEntry = new JTextField("0");
        interestIncomeEntry = new JTextField("0");
        unemploymentEntry = new JTextField("0");
        AGIField = new JTextField("0");
        exemptionAmountEntry = new JTextField("0");
        taxableIncome = new JTextField("0");
        withholdingEntry = new JTextField("0");
        nonTaxableCombatPayElectionField = new JTextField("0");
        earnedIncomeCreditField = new JTextField("0");
        totalPaymentsAndCreditsField = new JTextField("0");
        taxField = new JTextField("0");
        dueOrRefundField = new JTextField("0");
        amountOfChildrenField = new JTextField("0");
        testEntryField = new JTextField("0");
        
        // Button to compute calculations
        computeAGIBtn = new JButton("Compute AGI");
        computeDeduction = new JButton("Compute deduction");
        computeTaxableIncome = new JButton("Compute taxable income");
        calcEIC = new JButton("Calculate EIC");
        calcTotalPaymentsAndCredits = new JButton("Calc total payments/credits");
        calcTax = new JButton("Calculate Tax");
        testButton = new JButton("This is a test");
        calcTaxOrRefund = new JButton("Calc Tax/Refund");
        convertToBigD = new JButton("Convert to BigDecimal");
        
        // Checkboxes to determine exemption amounts
        selfBox = new JCheckBox("You");
        selfBox.setSelected(false);
        spouseBox = new JCheckBox("Spouse");
        spouseBox.setSelected(false);
        mfjBox = new JCheckBox("MFJ");
        mfjBox.setSelected(false);
        
        
        // Set location for buttons
        computeAGIBtn.setBounds(550, 105, 120, 25);
        computeDeduction.setBounds(550, 175, 160, 25);
        computeTaxableIncome.setBounds(550, 215, 180, 25);
        testButton.setBounds(300, 400, 120, 25);
        calcEIC.setBounds(550, 315, 120, 25);
        calcTotalPaymentsAndCredits.setBounds(550, 350, 200, 25);
        calcTax.setBounds(550, 385, 120, 25);
        calcTaxOrRefund.setBounds(550, 420, 150, 25);
        convertToBigD.setBounds(245, 550, 180, 30);
       
        
        
        // Set location for labels
        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        adjustedGrossIncomeLabel.setBounds(265, 95, 175, 50);
        dependencyLabel.setBounds(25, 125, 600, 50);
        mfjLabel.setBounds(200, 165, 150, 50);
        taxableIncomeLabel.setBounds(335, 205, 200, 50);
        incomeTaxWithheld.setBounds(308, 250, 150, 30);
        nonTaxableCombatPayElectionLabel.setBounds(248, 280, 200, 30);
        earnedIncomeCreditLabel.setBounds(308, 315, 150, 30);
        totalPaymentsAndCreditsLabel.setBounds(275, 350, 200, 30);
        taxLabel.setBounds(345, 385, 100, 30);
        dueOrRefund.setBounds(340, 420, 100, 30);
        amountOfChildrenLabel.setBounds(50, 400, 200, 50);
        testLabel.setBounds(100, 500, 150, 50);
        
        // Set location for data entry fields
        w2IncomeEntry.setBounds(435, 15, 100, 30);
        interestIncomeEntry.setBounds(435, 45, 100, 30);
        unemploymentEntry.setBounds(435, 75, 100, 30);
        AGIField.setBounds(435, 105, 100, 30);
        exemptionAmountEntry.setBounds(435, 175, 100, 30);
        taxableIncome.setBounds(435, 215, 100, 30);
        withholdingEntry.setBounds(435, 250, 100, 30);
        nonTaxableCombatPayElectionField.setBounds(435, 280, 100, 30);
        earnedIncomeCreditField.setBounds(435, 315, 100, 30);
        totalPaymentsAndCreditsField.setBounds(435, 350, 100, 30);
        taxField.setBounds(435, 385, 100, 30);
        dueOrRefundField.setBounds(435, 420, 100, 30);
        amountOfChildrenField.setBounds(250, 415, 20, 20);
        testEntryField.setBounds(435, 550, 100, 30);
        
        // Set location for exemption checkboxes
        selfBox.setBounds(530, 138, 100, 25);
        spouseBox.setBounds(460, 138, 100, 25);
        mfjBox.setBounds(350, 178, 50, 25);
        
        panel.add(computeAGIBtn);
        panel.add(computeDeduction);
        panel.add(computeTaxableIncome);
        panel.add(calcEIC);
        panel.add(calcTotalPaymentsAndCredits);
        panel.add(calcTax);
        panel.add(calcTaxOrRefund);
        panel.add(convertToBigD);
        
        panel.add(w2IncomeLabel);
        panel.add(interestIncomeLabel);
        panel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        panel.add(adjustedGrossIncomeLabel);
        panel.add(dependencyLabel);
        panel.add(mfjLabel);
        panel.add(taxableIncomeLabel);
        panel.add(incomeTaxWithheld);
        panel.add(earnedIncomeCreditLabel);
        panel.add(nonTaxableCombatPayElectionLabel);
        panel.add(totalPaymentsAndCreditsLabel);
        panel.add(testLabel);
        panel.add(dueOrRefund);
        panel.add(taxLabel);
        panel.add(amountOfChildrenLabel);
        
        panel.add(w2IncomeEntry);
        panel.add(interestIncomeEntry);
        panel.add(unemploymentEntry);
        panel.add(AGIField);
        panel.add(exemptionAmountEntry);
        panel.add(taxableIncome);
        panel.add(withholdingEntry);
        panel.add(earnedIncomeCreditField);
        panel.add(nonTaxableCombatPayElectionField);
        panel.add(totalPaymentsAndCreditsField);
        panel.add(taxField);
        panel.add(dueOrRefundField);
        panel.add(amountOfChildrenField);
        panel.add(testEntryField);
        
        panel.add(selfBox);
        panel.add(spouseBox);
        panel.add(mfjBox);
        
        setTitle("Compute AGI For 1040-EZ");
        setSize(900, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        CheckHandlerClass handler = new CheckHandlerClass();
        selfBox.addItemListener(handler);
        spouseBox.addItemListener(handler);
        mfjBox.addItemListener(handler);
        
        ButtonHandlerClass buttonHandler = new ButtonHandlerClass();
        computeAGIBtn.addActionListener(buttonHandler);
        computeDeduction.addActionListener(buttonHandler);
        computeTaxableIncome.addActionListener(buttonHandler);
        calcTotalPaymentsAndCredits.addActionListener(buttonHandler);
        calcTax.addActionListener(buttonHandler);
        calcTaxOrRefund.addActionListener(buttonHandler);
        calcEIC.addActionListener(buttonHandler);
        convertToBigD.addActionListener(buttonHandler);
           
        InputVerifier verification = new InputVerifier() {
            public boolean verify(JComponent comp){
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    Double.parseDouble(textField.getText());
                    double num = Double.parseDouble(textField.getText());
                    returnValue = num >= 0;
                    if(num < 0) {
                        JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
                    returnValue = false;
                }

                return returnValue;
                
            }
            
        };
        
        testEntryField.setInputVerifier(verification);
        w2IncomeEntry.setInputVerifier(verification);
        interestIncomeEntry.setInputVerifier(verification);
        unemploymentEntry.setInputVerifier(verification);
        withholdingEntry.setInputVerifier(verification);
        nonTaxableCombatPayElectionField.setInputVerifier(verification);
        amountOfChildrenField.setInputVerifier(verification);
        AGIField.setInputVerifier(verification);
        exemptionAmountEntry.setInputVerifier(verification);
        taxableIncome.setInputVerifier(verification);
        earnedIncomeCreditField.setInputVerifier(verification);
        totalPaymentsAndCreditsField.setInputVerifier(verification);
        taxField.setInputVerifier(verification);
        dueOrRefundField.setInputVerifier(verification);
                
    }
    
    private class ButtonHandlerClass implements ActionListener {
        @Override   
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == computeAGIBtn){
                BigDecimal w2income = new BigDecimal(w2IncomeEntry.getText());
                BigDecimal interestIncome = new BigDecimal(interestIncomeEntry.getText());
                BigDecimal UIAndAlaskaIncome = new BigDecimal(unemploymentEntry.getText());
                BigDecimal totalIncome = w2income.add(interestIncome.add(UIAndAlaskaIncome));
                totalIncome = totalIncome.setScale(0, RoundingMode.HALF_UP);
                
                AGIField.setText(totalIncome.toPlainString());  
            }
            
            if(source == computeDeduction){
                deductionCalculator dedCalcer = new deductionCalculator();
                String lineFiveDeduction =  Integer.toString(dedCalcer.DedCalc((Integer.parseInt(w2IncomeEntry.getText())), isMFJ, oneAsDep, bothAsDep));
                exemptionAmountEntry.setText(lineFiveDeduction);
            }
            
            if(source == computeTaxableIncome){
                int totalAGI = Integer.parseInt(AGIField.getText());
                int totalDeduction = Integer.parseInt(exemptionAmountEntry.getText());
                String taxInc = Integer.toString(totalAGI - totalDeduction);
                taxableIncome.setText(taxInc);
            }
            
            if(source == calcTotalPaymentsAndCredits){
                
                BigDecimal withHoldings = new BigDecimal(withholdingEntry.getText());
                BigDecimal calculatedEIC = new BigDecimal(earnedIncomeCreditField.getText());
                BigDecimal totalPaymentsAndCredits = withHoldings.add(calculatedEIC);
                totalPaymentsAndCredits = totalPaymentsAndCredits.setScale(0, RoundingMode.HALF_UP);
                totalPaymentsAndCreditsField.setText(totalPaymentsAndCredits.toPlainString());
            }
            
            if(source == calcTax){
                taxCalculator taxAmountCalculator = new taxCalculator();
                int taxToCompute = Integer.parseInt(taxableIncome.getText());
                BigDecimal taxAmount = new BigDecimal(taxAmountCalculator.CalcTax(taxToCompute));
                taxAmount = taxAmount.setScale(0, RoundingMode.HALF_UP);
                //String taxAmount = Double.toString(taxAmountCalculator.CalcTax(taxToCompute));
                taxField.setText(taxAmount.toPlainString());
            }
            
            if(source == calcTaxOrRefund){
                int payments = Integer.parseInt(totalPaymentsAndCreditsField.getText());
                int tax = Integer.parseInt(taxField.getText());
                int taxOrRefund = tax - payments;

                if(taxOrRefund > 0){
                    String taxOrRefundString = Integer.toString(taxOrRefund);
                    dueOrRefund.setText("Tax Due:");
                    dueOrRefundField.setText(taxOrRefundString);
                } else {
                    taxOrRefund = taxOrRefund * -1;
                    String taxOrRefundString = Integer.toString(taxOrRefund);
                    dueOrRefund.setText("Refund!");
                    dueOrRefundField.setText(taxOrRefundString);
                }
                
            }
            
            if(source == calcEIC){
                EICDatabaseAccessor EICGrabber = new EICDatabaseAccessor();
                int amtOfChildren = Integer.parseInt(amountOfChildrenField.getText());
                int amtOfIncome = Integer.parseInt(taxableIncome.getText());
                int combatIncome = Integer.parseInt(nonTaxableCombatPayElectionField.getText());
                int amtOfIncomeWithCombat = Integer.parseInt(taxableIncome.getText()) + combatIncome;
                int EICWithoutCombat = 0;
                int EICWithCombat = 0;
                String filingStatus;
                String childrenClaimed = "";
                String EICAmt;
                
                if(amtOfChildren == 0){
                    childrenClaimed = "NO_CHILD";
                } else if(amtOfChildren == 1){
                    childrenClaimed = "ONE_CHILD";
                } else if(amtOfChildren == 2){
                    childrenClaimed = "TWO_CHILD";
                } else if(amtOfChildren >= 3){
                    childrenClaimed = "THREE_CHILD";
                }
                
                if(mfjBox.isSelected()){
                    filingStatus = "MFJ";
                } else {
                    filingStatus = "SINGLE";
                }
                
                if(amtOfIncome > 0 || combatIncome > 0){
                    EICWithoutCombat = EICGrabber.DetermineEIC(amtOfIncome, childrenClaimed, filingStatus);
                    EICWithCombat = EICGrabber.DetermineEIC(amtOfIncomeWithCombat, childrenClaimed, filingStatus);
                }

                if(EICWithoutCombat >= EICWithCombat){
                    EICAmt = Integer.toString(EICWithoutCombat);
                } else {
                    EICAmt = Integer.toString(EICWithCombat);
                }

                earnedIncomeCreditField.setText(EICAmt);
            }
            
            if(source == convertToBigD){
                BigDecimal decimal = new BigDecimal(testEntryField.getText());
                decimal = decimal.setScale(0, RoundingMode.HALF_UP);
                //decimal = decimal.round(new MathContext(2, RoundingMode.HALF_UP));
                testEntryField.setText(decimal.toPlainString());
            }
        }
    }
    
    private class CheckHandlerClass implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if(source == mfjBox && mfjBox.isSelected()){
                isMFJ = true;
                //testLabel.setText("Married");
            } else if (source == mfjBox && !mfjBox.isSelected()){
                isMFJ = false;
                //testLabel.setText("Unmarried");
            }
            
            if(selfBox.isSelected() && spouseBox.isSelected()){
                bothAsDep = true;
                //testLabel.setText("Both Dep");
            } else if(selfBox.isSelected() || spouseBox.isSelected()){
                oneAsDep = true;
                //testLabel.setText("One Dep");
            } else if (!selfBox.isSelected() && !spouseBox.isSelected()){
                oneAsDep = false;
                bothAsDep = false;
                //testLabel.setText("No deps here");
            }
            
        }
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main1040EZForm ex = new Main1040EZForm();
                ex.setVisible(true);
            }
            
        });
        // TODO code application logic here
    }
}