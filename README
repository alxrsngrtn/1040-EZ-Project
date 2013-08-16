Hello! This is a simple, personal project to use Java and Swing to create a 1040-EZ simulator. My intent with this project is to re-create the 1040-EZ form, with all of its constraints, such that a person can project his/her tax due at the end of the year.

8/4/2013:

My goal is to simply recreate the main form, while doing calculations that would require an additional worksheet (EITC, standard deduction) in the background.

In the future, I may change the project to a question-and-answer format instead of entering information directly on the form.

8/8/2013:

The main form has been created. All of the input fields for the 1040EZ are functioning properly.

-- Added support for BigDecimals to allow for rounding to the nearest dollar.
-- Fixed an issue with the EIC database not properly accepting an income of "1" as a query. The EIC calculation now correctly interprets $1 as the minimum required to qualify for the EIC and returns the appropriate credit amount in accord with filing status and number of qualifying children.
-- Added input validation to ensure that all entered numbers are greater than or equal to zero and to notify the user if input must be corrected (for example, if the user input a letter, or negative number).

Future goals:

Rework the GUI to give it responsive quality to align properly with user resizing /or/ lock the program to a particular size.
Give the inputs a more sensible layout with regard to choosing filing status, qualifying children, dependency status.
Add entry fields to determine whether claimed dependents are qualifying children for EIC purposes.
Eliminate need to click on so many buttons: simplify process down to one click. Will probably pack functions in 'deprecated' buttons into callable methods for final button.
Refactor code to make it more readable, compact. Add more programmer notes.


Ideal plans:

Spruce up GUI. Give it a more appealing look than the basic Swing appearance.
Possibly change format to multiple screens where user inputs information individually and progresses to return Form with all calculations automatically performed (no need to click all of the buttons). 

8/15/2013:

Big changes! Converted program to use tab format. Completed two new screens. One for entering income and withholdings, the second for entering tax-relevant information (number of qualifying kids, filing status, etc.), and revamped the 1040-EZ Form tab to give it a cleaner appearance.

Also added text to give user information regarding the tests needed to claim a child as a "qualifying child" for the EIC.
Added input verifiers for W-2 income and taxable interest (if income is in excess of 100,000 or 1500, respectively, they are not allowed to use that form).
Simplified process down to one button! No ceaseless clicking!

Future goals:

Find ways to streamline/simplify GUI object implementation. It takes up a lot of space.
Jazz up GUI so it isn't a plain gray screen.
