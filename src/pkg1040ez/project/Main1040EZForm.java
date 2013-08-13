/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    //Declaring variables that will be used by the the Event methods.
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
    JLabel dueOrRefund;
    JPanel panel;
    
    
    public Main1040EZForm() {
        initUI();
    }
    
    public void initUI() {
        
        //  Creating main panel and setting Layout to null, allowing for absolute
        //  positioning.
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        // Labels corresponding with data entry fields
        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment compensation and Alaska Permanent Fund dividends:");
        JLabel adjustedGrossIncomeLabel = new JLabel("Your Adjusted Gross Income:");
        JLabel dependencyLabel = new JLabel("Can you or your spouse can be claimed as a dependent on another's return:");
        JLabel taxableIncomeLabel = new JLabel("Taxable Income:");
        JLabel incomeTaxWithheld = new JLabel("Income Tax Withheld:");
        JLabel earnedIncomeCreditLabel = new JLabel("Earned Income Credit:");
        JLabel nonTaxableCombatPayElectionLabel = new JLabel("Nontaxable combat pay election:");
        JLabel totalPaymentsAndCreditsLabel = new JLabel("Total payments and credits:");
        JLabel taxLabel = new JLabel("Tax on income:");
        JLabel amountOfChildrenLabel = new JLabel("Qualifying dependents:");
        dueOrRefund = new JLabel("Tax Due/Refund:");
        
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
        
        // Button to compute calculations
        computeAGIBtn = new JButton("Compute AGI");
        computeDeduction = new JButton("Compute deduction");
        computeTaxableIncome = new JButton("Compute taxable income");
        calcEIC = new JButton("Calculate EIC");
        calcTotalPaymentsAndCredits = new JButton("Calc total payments/credits");
        calcTax = new JButton("Calculate Tax");
        calcTaxOrRefund = new JButton("Calc Tax/Refund");
        
        // Checkboxes to determine exemption amounts
        selfBox = new JCheckBox("You");
        selfBox.setSelected(false);
        spouseBox = new JCheckBox("Spouse");
        spouseBox.setSelected(false);
        mfjBox = new JCheckBox("Married Filing Jointly");
        mfjBox.setSelected(false);
        
        
        // Set location for buttons
        computeAGIBtn.setBounds(550, 105, 120, 25);
        computeDeduction.setBounds(550, 175, 160, 25);
        computeTaxableIncome.setBounds(550, 215, 180, 25);
        calcEIC.setBounds(550, 315, 120, 25);
        calcTotalPaymentsAndCredits.setBounds(550, 350, 200, 25);
        calcTax.setBounds(550, 385, 120, 25);
        calcTaxOrRefund.setBounds(550, 420, 150, 25);
       
        // Set location for labels
        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        adjustedGrossIncomeLabel.setBounds(265, 95, 175, 50);
        dependencyLabel.setBounds(25, 125, 600, 50);
        taxableIncomeLabel.setBounds(335, 205, 200, 50);
        incomeTaxWithheld.setBounds(308, 250, 150, 30);
        nonTaxableCombatPayElectionLabel.setBounds(248, 280, 200, 30);
        earnedIncomeCreditLabel.setBounds(308, 315, 150, 30);
        totalPaymentsAndCreditsLabel.setBounds(275, 350, 200, 30);
        taxLabel.setBounds(345, 385, 100, 30);
        dueOrRefund.setBounds(340, 420, 100, 30);
        amountOfChildrenLabel.setBounds(50, 165, 200, 50);
        
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
        amountOfChildrenField.setBounds(190, 180, 20, 20);
        
        
        // Set location for exemption checkboxes
        selfBox.setBounds(530, 138, 100, 25);
        spouseBox.setBounds(460, 138, 100, 25);
        mfjBox.setBounds(250, 178, 150, 25);
        
        // Set locations for computation buttons
        panel.add(computeAGIBtn);
        panel.add(computeDeduction);
        panel.add(computeTaxableIncome);
        panel.add(calcEIC);
        panel.add(calcTotalPaymentsAndCredits);
        panel.add(calcTax);
        panel.add(calcTaxOrRefund);
        
        // Set locations for labels
        panel.add(w2IncomeLabel);
        panel.add(interestIncomeLabel);
        panel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        panel.add(adjustedGrossIncomeLabel);
        panel.add(dependencyLabel);
        panel.add(taxableIncomeLabel);
        panel.add(incomeTaxWithheld);
        panel.add(earnedIncomeCreditLabel);
        panel.add(nonTaxableCombatPayElectionLabel);
        panel.add(totalPaymentsAndCreditsLabel);
        panel.add(dueOrRefund);
        panel.add(taxLabel);
        panel.add(amountOfChildrenLabel);
        
        // Set locations for entry fields
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
        
        // Set location for checkboxes
        panel.add(selfBox);
        panel.add(spouseBox);
        panel.add(mfjBox);
        

        // Create handler class for checkbox events
        CheckHandlerClass handler = new CheckHandlerClass();
        selfBox.addItemListener(handler);
        spouseBox.addItemListener(handler);
        mfjBox.addItemListener(handler);
        
        // Create buttonHandler class for button event calculations
        ButtonHandlerClass buttonHandler = new ButtonHandlerClass();
        computeAGIBtn.addActionListener(buttonHandler);
        computeDeduction.addActionListener(buttonHandler);
        computeTaxableIncome.addActionListener(buttonHandler);
        calcTotalPaymentsAndCredits.addActionListener(buttonHandler);
        calcTax.addActionListener(buttonHandler);
        calcTaxOrRefund.addActionListener(buttonHandler);
        calcEIC.addActionListener(buttonHandler);
        
        // Constructed input verifier to ensure that all numbers entered are
        // Numbers and greater than or equal to 0
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
        
        // Setting a verifier on every field to which data could be entered
        // or overriden
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
        
        // Setting main information for the panel
        setTitle("2012 1040-EZ Tax Calculator");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    // Implementing an event handler for buttons; this catches all of the
    // events driven by clicking on a button and computes the corresponding
    // calculations.
    private class ButtonHandlerClass implements ActionListener {
        @Override   
        public void actionPerformed(ActionEvent e) {
            // Creating instances of computational classes
            taxComputations taxComps = new taxComputations();
            taxCalculator taxAmountCalculator = new taxCalculator();
            deductionCalculator dedCalcer = new deductionCalculator();
            
            Object source = e.getSource();
            
            // Retrieving user's AGI from tax computations class
            if(source == computeAGIBtn){
                AGIField.setText(taxComps.returnAGI(w2IncomeEntry.getText(),
                                                    interestIncomeEntry.getText(),
                                                     unemploymentEntry.getText()));
            }
            
            if(source == computeDeduction){
                exemptionAmountEntry.setText(dedCalcer.DedCalc((Integer.parseInt(w2IncomeEntry.getText())),
                                                                                                 isMFJ,
                                                                                                 oneAsDep,
                                                                                                 bothAsDep));
            }
            
            if(source == computeTaxableIncome){
                taxableIncome.setText(taxComps.computeTaxableIncome(AGIField.getText(),
                                                                    exemptionAmountEntry.getText()));
                
            }
            
            if(source == calcTax){
                taxField.setText(taxAmountCalculator.CalcTax(taxableIncome.getText()));

            }
            
            if(source == calcEIC){
                EICDatabaseAccessor EICGrabber = new EICDatabaseAccessor();
                int amtOfChildren = Integer.parseInt(amountOfChildrenField.getText());
                int amtOfIncome = Integer.parseInt(taxableIncome.getText());
                int combatIncome = Integer.parseInt(nonTaxableCombatPayElectionField.getText());
                int amtOfIncomeWithCombat = Integer.parseInt(taxableIncome.getText()) + combatIncome;

                earnedIncomeCreditField.setText(EICGrabber.DetermineEIC(amtOfIncome, amtOfIncomeWithCombat, amtOfChildren, mfjBox.isSelected()));
            }
            
            if(source == calcTotalPaymentsAndCredits){
                totalPaymentsAndCreditsField.setText(taxComps.calcTotalPaymentsAndCredits(withholdingEntry.getText(),
                                                                                          earnedIncomeCreditField.getText()));
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
        }
    }
    
    // Sets the CheckHandlerClass to monitor the checkboxes and change the
    // corresponding variables (whether the user is single or married filing
    // jointly, can be claimed as a dependent on another's return, etc.)
    private class CheckHandlerClass implements ItemListener {
        @Override
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
    
    // Creates and initializes the program, sets it visible
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main1040EZForm ex = new Main1040EZForm();
                ex.setVisible(true);
            }
            
        });
    }
}