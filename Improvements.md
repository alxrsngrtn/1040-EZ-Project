# Improvements

## Bugs Found
- Needs text wrapping: text gets clipped and appended with ellipsis (...)
- [x] Display text can be accessed and modified through tabbing.
- On Form 1040-EZ tab: text occluding form
- Error: `[java] Database inaccessible!`. Caused by: 
 1. When you click "Calculate" button too many times with minimal input (e.g. just wage form entered)
- [x] Possible bug: for mfjTaxes (and singleTaxes), when taxableIncome is zero, the calculated tax is 9735.25? 
- Users should be allowed to enter decimal numbers (cents) into forms
## Enhancements
- Should comma delimit numbers, will make input text more readable
- Empty input should be automatically replaced with zero
- On Form 1040-EZ tab: If form/number elements are not editable, they should be styled differently
- [x] Add Tax Summary text explaining in English what the user's tax bill or refund is. 

## Test Cases
### Main
- Form should be able to calculate double user input
- Users should be able to input BigDecimal numbers (that exceed the max limit of doubles) into the unemployment compensation, nontaxable combat pay, and income tax witheld forms
- 

### taxCalculatorTest
#### CalcTax()
- Should be able to reject negative double values of taxable income
- Should throw an error for non-numeric taxableIncString input
- Should be able to round very small numbers to zero
- Should be able to correctly calculate the tax on zero income
- Should be able to calculate taxes on numbers larger than the positive max allowed for doubles since the input and output are Strings

#### mfjTaxes() & singleTaxes()
- [x] Should calculate the correct tax amount above, below, and equal to every threshold/bracket
- [x] Should calculate the correct tax amount for a wide range of possible values (general case)
- [x] Should calculate the correct tax amount for edge cases: 
    1. [x] Zero 
    2. [x] Max limit of double
    3. [x] Underflow limits of double (i.e. very small number floating point precision)

## Refactoring Suggestions
### General
- Remove unused imports
- Change protected variables to private
- Change many methods from public to private
- Add proper Javadoc Comments --> list parameters, return, and if possible side effects
- Verbose and descriptive method names
- REMOVE MAGIC NUMBERS --> put them as final constants at top of file
- Extract method from repeated logic
- Improve whitespacing
- Project structure: enforce strict MVC file structure. Label files as services, models, controllers, or DAOs (data access objects)
- Class names in Java should be capitalized

### Main1040EZForm
- BREAK UP MONOLITHIC METHODS INTO BITE SIZED FUNCTIONS --> makes more readable, testable, and maintainable
- Change variable access from protected to private
- [x] Make helper functions private
- Convert magic numbers to constants at top of file, make configurable
- Convert methods to pure functions, minimize side effects. 
- [x] Idea: move InputVerifier into a class
- [x] Idea: write class that creates label with input field. Set the boundry in this method, too. Also add to incomeEntryPane, etc. Also set verifier on these labels.
- [x] Idea: pull out magic numbers for positioning into constants so they can be configured at the top of the file
- Move ButtonHandlerClass to another file
- Move CheckHandlerClass to another file

### taxCalculator
- REMOVE MAGIC NUMBERS
- [x] Extract method from repeated logic
- [x] Possible bug: for mfjTaxes (and singleTaxes), when taxableIncome is zero, the calculated tax is 9735.25? 
- If you want the outputs to be in big decimal, the inputs should be in big decimal. This will be more robust. If the service should handle decimal inputs, then overload the functions and deffer the computation to the big decimal implementation.
- [x] Convert to pure functions, i.e. eliminate side effects. These can cause errors.
- [x] improved whitespace

### taxComputations
- Change method/variable names to be more verbose

### EICDatabaseAccessor
- [x] Remove unused variables
- [x] Log or print errors for easier debugging
- if --> switch
- [x] Initializing to null is redundant
- [x] Improve whitespace
- Separate controller logic with model accessor

### deductionCalculator
- More verbose variable names
- Remove unused variables
- Pull out magic numbers
- Extract repeated logic into method

