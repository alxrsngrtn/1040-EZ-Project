
package pkg1040ez.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main1040EZForm extends JFrame {
    JTabbedPane tabbedPane;
    JPanel panel, incomeEntryPanel, personalDetailsPanel, finalTaxFormPanel;
    
    /* Boolean values to indicate filing status and whether user and/or spouse
     * may be claimed as dependents.
     */
    
    boolean isMFJ, oneAsDep, bothAsDep;

    UserNumberEntry w2Income;
    
    /* Checkboxes for user to indicate filing status and dependent status.
     * Works in conjunction with above booleans.
     */
    JCheckBox selfBox, spouseBox, mfjBox;
    JCheckBox selfBoxDisplay, spouseBoxDisplay, mfjBoxDisplay;
    JCheckBox filingSingleBox;
    
    /* TextFields used for user entry on first and second tab. 
     * Entries are used as basis for tax calculations and are passed to
     * similarly named, disabled TextFields on Form 1040-EZ for appearance only.
     */
    JTextField w2IncomeEntry, interestIncomeEntry, unemploymentEntry;
    JTextField combatPayEntry, withholdingEntry, amountOfChildrenEntry;
    
    /* TextFields that display user entries and calculations on the completed
     * Form 1040-EZ. They are disabled to prevent alternation with entries
     * on that page.
     */
    
    JTextField w2incomeFormDisplay, interestIncomeFormDisplay;
    JTextField unemploymentIncomeFormDisplay, combatPayFormDisplay;
    JTextField withholdingFormDisplay, amountOfChildrenFormDisplay;
    
    JTextField AGIFieldFormDisplay, exemptionAmountFormDisplay;
    JTextField taxableIncomeFormDisplay, earnedIncomeCreditFormDisplay;
    JTextField paymentsAndCreditsFormDisplay, taxFormDisplay;
    JTextField taxDueOrRefundFormDisplay;
    
    /* Label which changes in accord with whether receives refund or has tax due
     * in accord with calculation triggered by dueOrRefund button below.
     */
    JLabel dueOrRefundLabel;
    
    /* Only button user has to click to make all tax calculations and determine
     * whether user owes tax or will receive a refund.
     */
    JButton calcTaxOrRefund;
    
    public Main1040EZForm() {
        
        setTitle("1040EZ Project");
        setSize(900, 550);
                
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        incomePage();
        personalDetailsPage();
        finalFormPage();
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Income and Withholding Information", incomeEntryPanel);
        tabbedPane.addTab("Personal Details", personalDetailsPanel);
        tabbedPane.addTab("Form 1040-EZ", finalTaxFormPanel);
        topPanel.add(tabbedPane, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void incomePage(){
        
        incomeEntryPanel = new JPanel();
        incomeEntryPanel.setLayout(null);
        
        /* Used to set TextArea incomeLimitationsAreaLabel to match panel
         * background color.
         */
        Color backgroundColor = incomeEntryPanel.getBackground();

        w2Income = new UserNumberEntry("Wages, salaries, and tips. Enter total"
                + "income from Box 1 of Form(s) W-2:",
                "0", 25, 410, 100, 15, 30, 25);

        w2Income.addToPanel(incomeEntryPanel);

        
        // Labels corresponding with TextFields for user information entry
//        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total"
//                + "income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total"
                + "is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment"
                + "compensation and Alaska Permanent Fund dividends:");
        JLabel nonTaxableCombatPayElectionLabel = new JLabel("Nontaxable combat pay election:");
        JLabel incomeTaxWithheld = new JLabel("Income Tax Withheld:");
        
        // TextFields for user information entry.
//        w2IncomeEntry = new JTextField("0");
        interestIncomeEntry = new JTextField("0");
        unemploymentEntry = new JTextField("0");
        combatPayEntry = new JTextField("0");
        withholdingEntry = new JTextField("0");
        
        // TextArea to indicate some of the important limitations on using a 1040EZ.
        JTextArea incomeLimitationsAreaLabel = new JTextArea("Note: If your taxable interest income exceeds"
                + "$1,500 or your total taxable income exceeds\n"
                + "$100,000, you cannot use this Form."); 
        incomeLimitationsAreaLabel.setBackground(backgroundColor);
        
//        w2IncomeEntry.setBounds(435, 15, 100, 30);
        interestIncomeEntry.setBounds(435, 45, 100, 30);
        unemploymentEntry.setBounds(435, 75, 100, 30);
        combatPayEntry.setBounds(435, 105, 100, 30);
        withholdingEntry.setBounds(435, 135, 100, 30);

//        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        nonTaxableCombatPayElectionLabel.setBounds(231, 105, 200, 30);
        incomeTaxWithheld.setBounds(231, 135, 150, 30);
        
        incomeLimitationsAreaLabel.setBounds(25, 175, 600, 40);
        
//        incomeEntryPanel.add(w2IncomeEntry);
        incomeEntryPanel.add(interestIncomeEntry);
        incomeEntryPanel.add(unemploymentEntry);
        incomeEntryPanel.add(combatPayEntry);
        incomeEntryPanel.add(withholdingEntry);

//        incomeEntryPanel.add(w2IncomeLabel);
        incomeEntryPanel.add(interestIncomeLabel);
        incomeEntryPanel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        incomeEntryPanel.add(nonTaxableCombatPayElectionLabel);
        incomeEntryPanel.add(incomeTaxWithheld);
        
        incomeEntryPanel.add(incomeLimitationsAreaLabel);
        
        /* Included input verifier to ensure that all information entered by
         * user is a number equal to or greater than zero. Otherwise, user
         * is prompted with warning label and cursor will not leave textfield.
         */
        InputVerifier verification = new InputVerifier() {
            public boolean verify(JComponent comp){
            boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    Double.parseDouble(textField.getText());
                    double num = Double.parseDouble(textField.getText());
                    double w2inc = Double.parseDouble(w2Income.getEntryText());
                    double intInc = Double.parseDouble(interestIncomeEntry.getText());
                    returnValue = num >= 0;
                    if(num < 0) {
                        JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
                    } else if(w2inc > 100000){
                        JOptionPane.showMessageDialog(panel, "Your W-2 income is in excess of $100,000. You cannot use this form.");
                    } else if(intInc > 1500){
                        JOptionPane.showMessageDialog(panel, "Your interest income is in excess of $1,500. You cannot use this form.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
                    returnValue = false;
                }

                return returnValue;
            }
       };

        w2Income.setVerification(verification);

//        w2IncomeEntry.setInputVerifier(verification);
        interestIncomeEntry.setInputVerifier(verification);
        unemploymentEntry.setInputVerifier(verification);
        withholdingEntry.setInputVerifier(verification);
        combatPayEntry.setInputVerifier(verification);
        
    }
    
    private void personalDetailsPage(){
        
        personalDetailsPanel = new JPanel();
        personalDetailsPanel.setLayout(null);
        
        // Allows TextAreas below to match panel background color.
        Color backgroundColor = personalDetailsPanel.getBackground();
        
        JLabel dependencyLabel = new JLabel("Can you or your spouse can be claimed as a dependent on another's return:");
        JLabel amountOfChildrenLabel = new JLabel("Enter the amount of dependents you have that meet all four of the above conditions:");
        JLabel marriedFilingJointlyLabel = new JLabel("Check box if you are married, filing jointly:");
        JLabel eicInfoLabel = new JLabel("If you will be claiming qualifying children for the Earned Income Credit, continue to section below. Otherwise, proceed to the next tab.");
        
        JLabel eicFourConditionsLabel = new JLabel("For your child/children to be considered a Qualified Child under the Earned Income Tax Credit, s/he/they must satisfy the following four conditions:");
        JTextArea eicConditionALabel = new JTextArea("A. Be your son, daughter, stepchild, foster child, or a descendant of any of them, or\n"
                + "     Brother, sister, half brother, half sister, stepbrother, stepsister, or any descendent of any of them.");
        eicConditionALabel.setBackground(backgroundColor);
        JTextArea eicConditionBLabel = new JTextArea("B. Under the age of 19 at the end of 2012 and younger than you (or your spouse, if married, filing jointly), or\n"
                + "     Under age 24 at the end of 2012, a student, and younger than you (or spouse, if MFJ), or\n"
                + "     Permanently and totally disabled at any time during the year, regardless of age.");
        eicConditionBLabel.setBackground(backgroundColor);
        JTextArea eicConditionCLabel = new JTextArea("C. Who is not filing a joint return for 2012 (or is filing a joint return for 2012 only to claim a refund of income tax\n"
                + "     withheld or estimated tax paid).");
        eicConditionCLabel.setBackground(backgroundColor);
        JTextArea eicConditionDLabel = new JTextArea("D. Who lived with you in the United States for more than half of 2012.");
        eicConditionDLabel.setBackground(backgroundColor);

        amountOfChildrenEntry = new JTextField("0");
        
        selfBox = new JCheckBox("You");
        selfBox.setSelected(false);
        spouseBox = new JCheckBox("Spouse");
        spouseBox.setSelected(false);
        mfjBox = new JCheckBox("Married Filing Jointly");
        mfjBox.setSelected(false);
        
        
        dependencyLabel.setBounds(25, 15, 450, 30);
        marriedFilingJointlyLabel.setBounds(25, 45, 250, 30);
        eicInfoLabel.setBounds(25, 75, 750, 30);
        eicFourConditionsLabel.setBounds(25, 120, 850, 30);
        eicConditionALabel.setBounds(40, 155, 800, 30);
        eicConditionBLabel.setBounds(40, 190, 800, 50);
        eicConditionCLabel.setBounds(40, 240, 800, 30);
        eicConditionDLabel.setBounds(40, 275, 800, 30);
        amountOfChildrenLabel.setBounds(25, 310, 480, 30);
        
        amountOfChildrenEntry.setBounds(510, 315, 20, 20);

        selfBox.setBounds(475, 18, 50, 25);
        spouseBox.setBounds(550, 18, 75, 25);
        mfjBox.setBounds(275, 48, 150, 25);
        
        
        personalDetailsPanel.add(dependencyLabel);
        personalDetailsPanel.add(marriedFilingJointlyLabel);
        personalDetailsPanel.add(eicInfoLabel);
        personalDetailsPanel.add(eicFourConditionsLabel);
        personalDetailsPanel.add(eicConditionALabel);
        personalDetailsPanel.add(eicConditionBLabel);
        personalDetailsPanel.add(eicConditionCLabel);
        personalDetailsPanel.add(eicConditionDLabel);
        personalDetailsPanel.add(amountOfChildrenLabel); 

        personalDetailsPanel.add(amountOfChildrenEntry);
        
        personalDetailsPanel.add(selfBox);
        personalDetailsPanel.add(spouseBox);
        personalDetailsPanel.add(mfjBox);
        
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
       
        amountOfChildrenEntry.setInputVerifier(verification);
        
        
    }
    
    private void finalFormPage(){
        
        finalTaxFormPanel = new JPanel();
        finalTaxFormPanel.setLayout(null);
        
        // Allows TextAreas below to match panel background color.
        Color backgroundColor = personalDetailsPanel.getBackground();
        
        // Creating labels to describe TextField information on resulting 1040EZ.
        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment compensation and Alaska Permanent Fund dividends:");
        JLabel adjustedGrossIncomeLabel = new JLabel("Your Adjusted Gross Income:");
        JLabel deductionAndExemptionsLabel = new JLabel("Deductions/Exemptions:");
        JLabel dependencyLabel = new JLabel("You and your spouse selected as dependents:");
        JLabel filingStatusLabel = new JLabel("Your filing status:");
        JLabel taxableIncomeLabel = new JLabel("Taxable Income:");
        JLabel incomeTaxWithheld = new JLabel("Income Tax Withheld:");
        JLabel earnedIncomeCreditLabel = new JLabel("Earned Income Credit:");
        JLabel nonTaxableCombatPayElectionLabel = new JLabel("Nontaxable combat pay election:");
        JLabel totalPaymentsAndCreditsLabel = new JLabel("Total payments and credits:");
        JLabel taxLabel = new JLabel("Tax on income:");
        JLabel amountOfChildrenLabel = new JLabel("Qualifying children for EIC:");
        dueOrRefundLabel = new JLabel("Tax Due/Refund:");
        
        /* Setting TextFields to a "display" setting, where they only show what
         * the user has entered and any calculations based on that information.
         * This prevents interference with the program tax calculations and
         * reduces redundancy, negating the need for more input verification.
         * Also set the text color to black to increase visiblity.
         */
        w2incomeFormDisplay = new JTextField("0");
        w2incomeFormDisplay.setEnabled(false);
        w2incomeFormDisplay.setDisabledTextColor(Color.BLACK);
        interestIncomeFormDisplay = new JTextField("0");
        interestIncomeFormDisplay.setEnabled(false);
        interestIncomeFormDisplay.setDisabledTextColor(Color.BLACK);
        unemploymentIncomeFormDisplay = new JTextField("0");
        unemploymentIncomeFormDisplay.setEnabled(false);
        unemploymentIncomeFormDisplay.setDisabledTextColor(Color.BLACK);
        AGIFieldFormDisplay = new JTextField("0");
        AGIFieldFormDisplay.setEnabled(false);
        AGIFieldFormDisplay.setDisabledTextColor(Color.BLACK);
        exemptionAmountFormDisplay = new JTextField("0");
        exemptionAmountFormDisplay.setEnabled(false);
        exemptionAmountFormDisplay.setDisabledTextColor(Color.BLACK);
        taxableIncomeFormDisplay = new JTextField("0");
        taxableIncomeFormDisplay.setEnabled(false);
        taxableIncomeFormDisplay.setDisabledTextColor(Color.BLACK);
        withholdingFormDisplay = new JTextField("0");
        withholdingFormDisplay.setEnabled(false);
        withholdingFormDisplay.setDisabledTextColor(Color.BLACK);
        combatPayFormDisplay = new JTextField("0");
        combatPayFormDisplay.setEnabled(false);
        combatPayFormDisplay.setDisabledTextColor(Color.BLACK);
        earnedIncomeCreditFormDisplay = new JTextField("0");
        earnedIncomeCreditFormDisplay.setEnabled(false);
        earnedIncomeCreditFormDisplay.setDisabledTextColor(Color.BLACK);
        paymentsAndCreditsFormDisplay = new JTextField("0");
        paymentsAndCreditsFormDisplay.setEnabled(false);
        paymentsAndCreditsFormDisplay.setDisabledTextColor(Color.BLACK);
        taxFormDisplay = new JTextField("0");
        taxFormDisplay.setEnabled(false);
        taxFormDisplay.setDisabledTextColor(Color.BLACK);
        taxDueOrRefundFormDisplay = new JTextField("0");
        taxDueOrRefundFormDisplay.setEnabled(false);
        taxDueOrRefundFormDisplay.setDisabledTextColor(Color.BLACK);
        amountOfChildrenFormDisplay = new JTextField("0");
        amountOfChildrenFormDisplay.setEnabled(false);
        amountOfChildrenFormDisplay.setDisabledTextColor(Color.BLACK);
        
        selfBoxDisplay = new JCheckBox("You");
        selfBoxDisplay.setSelected(selfBox.isSelected());
        selfBoxDisplay.setEnabled(false);
        spouseBoxDisplay = new JCheckBox("Spouse");
        spouseBoxDisplay.setSelected(spouseBox.isSelected());
        spouseBoxDisplay.setEnabled(false);
        mfjBoxDisplay = new JCheckBox("Married Filing Jointly");
        mfjBoxDisplay.setSelected(mfjBox.isSelected());
        mfjBoxDisplay.setEnabled(false);
        filingSingleBox = new JCheckBox("Single");
        filingSingleBox.setSelected(!mfjBox.isSelected());
        filingSingleBox.setEnabled(false);
        
        calcTaxOrRefund = new JButton("Calculate!");
        
        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        adjustedGrossIncomeLabel.setBounds(265, 105, 175, 30);
        deductionAndExemptionsLabel.setBounds(290, 135, 150, 30);
        dependencyLabel.setBounds(560, 15, 600, 30);
        filingStatusLabel.setBounds(560, 75, 200, 30);
        taxableIncomeLabel.setBounds(335, 165, 200, 30);
        incomeTaxWithheld.setBounds(308, 195, 150, 30);
        nonTaxableCombatPayElectionLabel.setBounds(248, 225, 200, 30);
        earnedIncomeCreditLabel.setBounds(308, 255, 150, 30);
        totalPaymentsAndCreditsLabel.setBounds(275, 285, 200, 30);
        taxLabel.setBounds(345, 315, 100, 30);
        dueOrRefundLabel.setBounds(340, 345, 100, 30);
        amountOfChildrenLabel.setBounds(560, 135, 200, 30);
        
        w2incomeFormDisplay.setBounds(435, 15, 100, 30);
        interestIncomeFormDisplay.setBounds(435, 45, 100, 30);
        unemploymentIncomeFormDisplay.setBounds(435, 75, 100, 30);
        AGIFieldFormDisplay.setBounds(435, 105, 100, 30);
        exemptionAmountFormDisplay.setBounds(435, 135, 100, 30);
        taxableIncomeFormDisplay.setBounds(435, 165, 100, 30);
        withholdingFormDisplay.setBounds(435, 195, 100, 30);
        combatPayFormDisplay.setBounds(435, 225, 100, 30);
        earnedIncomeCreditFormDisplay.setBounds(435, 255, 100, 30);
        paymentsAndCreditsFormDisplay.setBounds(435, 285, 100, 30);
        taxFormDisplay.setBounds(435, 315, 100, 30);
        taxDueOrRefundFormDisplay.setBounds(435, 345, 100, 30);
        amountOfChildrenFormDisplay.setBounds(560, 170, 20, 20);
        
        selfBoxDisplay.setBounds(560, 45, 50, 25);
        spouseBoxDisplay.setBounds(630, 45, 75, 25);
        mfjBoxDisplay.setBounds(650, 105, 150, 25);
        filingSingleBox.setBounds(560, 105, 75, 25);
        
        calcTaxOrRefund.setBounds(550, 420, 150, 25);

        // Adding descriptive labels for TextField displays
        finalTaxFormPanel.add(w2IncomeLabel);
        finalTaxFormPanel.add(interestIncomeLabel);
        finalTaxFormPanel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        finalTaxFormPanel.add(adjustedGrossIncomeLabel);
        finalTaxFormPanel.add(deductionAndExemptionsLabel);
        finalTaxFormPanel.add(dependencyLabel);
        finalTaxFormPanel.add(filingStatusLabel);
        finalTaxFormPanel.add(taxableIncomeLabel);
        finalTaxFormPanel.add(incomeTaxWithheld);
        finalTaxFormPanel.add(earnedIncomeCreditLabel);
        finalTaxFormPanel.add(nonTaxableCombatPayElectionLabel);
        finalTaxFormPanel.add(totalPaymentsAndCreditsLabel);
        finalTaxFormPanel.add(dueOrRefundLabel);
        finalTaxFormPanel.add(taxLabel);
        finalTaxFormPanel.add(amountOfChildrenLabel);
        
        // Adding TextField displays
        finalTaxFormPanel.add(w2incomeFormDisplay);
        finalTaxFormPanel.add(interestIncomeFormDisplay);
        finalTaxFormPanel.add(unemploymentIncomeFormDisplay);
        finalTaxFormPanel.add(AGIFieldFormDisplay);
        finalTaxFormPanel.add(exemptionAmountFormDisplay);
        finalTaxFormPanel.add(taxableIncomeFormDisplay);
        finalTaxFormPanel.add(withholdingFormDisplay);
        finalTaxFormPanel.add(earnedIncomeCreditFormDisplay);
        finalTaxFormPanel.add(combatPayFormDisplay);
        finalTaxFormPanel.add(paymentsAndCreditsFormDisplay);
        finalTaxFormPanel.add(taxFormDisplay);
        finalTaxFormPanel.add(taxDueOrRefundFormDisplay);
        finalTaxFormPanel.add(amountOfChildrenFormDisplay);
        
        // Adding CheckBox displays
        finalTaxFormPanel.add(selfBoxDisplay);
        finalTaxFormPanel.add(spouseBoxDisplay);
        finalTaxFormPanel.add(mfjBoxDisplay);
        finalTaxFormPanel.add(filingSingleBox);
        
        finalTaxFormPanel.add(calcTaxOrRefund);
       
        CheckHandlerClass handler = new CheckHandlerClass();
        selfBox.addItemListener(handler);
        spouseBox.addItemListener(handler);
        mfjBox.addItemListener(handler); 
        
        ButtonHandlerClass buttonHandler = new ButtonHandlerClass();
        calcTaxOrRefund.addActionListener(buttonHandler);
    }

    
    private class ButtonHandlerClass implements ActionListener {
        
        @Override   
        public void actionPerformed(ActionEvent e) {          
            Object source = e.getSource();
            
            //Instantiating needed classes for tax calculations
            taxComputations taxComps = new taxComputations();
            taxCalculator taxAmountCalculator = new taxCalculator();
            deductionCalculator dedCalcer = new deductionCalculator();
            
            if(source == calcTaxOrRefund){
                
                /* Taking user entries from input TextFields and displaying them
                 * on corresponding entry displays on Form.
                 */
                w2incomeFormDisplay.setText(w2Income.getEntryText());
//                w2incomeFormDisplay.setText(w2IncomeEntry.getText());
                interestIncomeFormDisplay.setText(interestIncomeEntry.getText());
                unemploymentIncomeFormDisplay.setText(unemploymentEntry.getText());
                combatPayFormDisplay.setText(combatPayEntry.getText());
                withholdingFormDisplay.setText(withholdingEntry.getText());
                amountOfChildrenFormDisplay.setText(amountOfChildrenEntry.getText());
                
                // Computation to determine user's AGI.
                AGIFieldFormDisplay.setText(taxComps.returnAGI(w2Income.getEntryText(),
                                                    interestIncomeEntry.getText(),
                                                     unemploymentEntry.getText()));
                
                // Computation to determine user's allowed deductions/exemptions.
                exemptionAmountFormDisplay.setText(dedCalcer.DedCalc((Integer.parseInt(w2Income.getEntryText())),
                                                                                                 isMFJ,
                                                                                                 oneAsDep,
                                                                                                 bothAsDep));
                // Computation to determine user's taxable income.
                taxableIncomeFormDisplay.setText(taxComps.computeTaxableIncome(AGIFieldFormDisplay.getText(),
                                                                    exemptionAmountFormDisplay.getText()));
                
                // Computation to determine user's tax (based on taxable income).
                taxFormDisplay.setText(taxAmountCalculator.CalcTax(taxableIncomeFormDisplay.getText(), mfjBox.isSelected()));
                
                /*
                 * Instantiate the EICDatabaseAccessor class, to allow for the EIC computation.
                 * Determine the amount of qualifying children, amount of normal taxable income
                 * user has, and the amount of nontaxable combat income user has.
                 * User may elect to include nontaxable combat pay in the EIC calc,
                 * but wont want to do it if it decreases his allowed credit.
                 * Passes all of this information to EICGrabber, which returns the
                 * optimal credit amount for user.
                 */
                EICDatabaseAccessor EICGrabber = new EICDatabaseAccessor();
                int amtOfChildren = Integer.parseInt(amountOfChildrenEntry.getText());
                int amtOfIncome = Integer.parseInt(taxableIncomeFormDisplay.getText());
                int combatIncome = Integer.parseInt(combatPayEntry.getText());
                int amtOfIncomeWithCombat = Integer.parseInt(taxableIncomeFormDisplay.getText()) + combatIncome;
                
                // EICGrabber is called only if there is income upon which to base the credit.
                if(amtOfIncome > 0){
                earnedIncomeCreditFormDisplay.setText(EICGrabber.DetermineEIC(amtOfIncome, combatIncome, amtOfChildren, mfjBox.isSelected()));
                }
                
                // Computation to add user's withholding and EIC credit together.
                paymentsAndCreditsFormDisplay.setText(taxComps.calcTotalPaymentsAndCredits(withholdingEntry.getText(),
                                                                                          earnedIncomeCreditFormDisplay.getText()));
                
                /* Converts total payments and credits and tax into integers,
                 * to determine whether user will owe, receive a refund, or will
                 * have a balance of zero on his taxes.
                 */
                int payments = Integer.parseInt(paymentsAndCreditsFormDisplay.getText());
                int tax = Integer.parseInt(taxFormDisplay.getText());
                int taxOrRefund = tax - payments;

                if(taxOrRefund > 0){
                    String taxOrRefundString = Integer.toString(taxOrRefund);
                    dueOrRefundLabel.setText("Tax Due:");
                    taxDueOrRefundFormDisplay.setText(taxOrRefundString);
                } else if(taxOrRefund == 0){
                    String taxOrRefundString = Integer.toString(taxOrRefund);
                    dueOrRefundLabel.setText("Zero Balance:");
                    taxDueOrRefundFormDisplay.setText(taxOrRefundString);
                } else {
                    taxOrRefund = taxOrRefund * -1;
                    String taxOrRefundString = Integer.toString(taxOrRefund);
                    dueOrRefundLabel.setText("Refund!");
                    taxDueOrRefundFormDisplay.setText(taxOrRefundString);
                }
                
            }
        }
    }
    
        /* ItemListener which corresponds with usable checkboxes above.
         * Allows user to determine filing status and whether user or
         * spouse are claimed as dependents on another person's return.
         * Alters corresponding boolean values to use in computations.
         */
        private class CheckHandlerClass implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if(source == mfjBox && mfjBox.isSelected()){
                isMFJ = true;
                mfjBoxDisplay.setSelected(true);
                filingSingleBox.setSelected(false);
                //testLabel.setText("Married");
            } else if (source == mfjBox && !mfjBox.isSelected()){
                isMFJ = false;
                mfjBoxDisplay.setSelected(false);
                filingSingleBox.setSelected(true);
                //testLabel.setText("Unmarried");
            }
            
            if(selfBox.isSelected() && spouseBox.isSelected()){
                bothAsDep = true;
                selfBoxDisplay.setSelected(true);
                spouseBoxDisplay.setSelected(true);
                //testLabel.setText("Both Dep");
            } else if(selfBox.isSelected() || spouseBox.isSelected()){
                oneAsDep = true;
                if(selfBox.isSelected()){
                    selfBoxDisplay.setSelected(true);
                } else {
                    selfBoxDisplay.setSelected(false);
                }
                
                if(spouseBox.isSelected()){
                    spouseBoxDisplay.setSelected(true);
                    
                } else {
                    spouseBoxDisplay.setSelected(false);
                }
                
                //testLabel.setText("One Dep");
            } else if (!selfBox.isSelected() && !spouseBox.isSelected()){
                oneAsDep = false;
                bothAsDep = false;
                selfBoxDisplay.setSelected(false);
                spouseBoxDisplay.setSelected(false);
                //testLabel.setText("No deps here");
            }
            
        }
    }
    
    // Creates and initializes the program, sets it visible
    public static void main(String[] args) {
        Main1040EZForm ex = new Main1040EZForm();
                ex.setVisible(true);
    }          
}