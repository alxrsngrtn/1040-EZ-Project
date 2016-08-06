# Improvements

## Bugs Found
- Needs text wrapping: text gets clipped and appended with ellipsis (...)
- Display text can be accessed and modified through tabbing.
- On Form 1040-EZ tab: text occluding form
- Error: `[java] Database inaccessible!`. Caused by: 
 1. When you click "Calculate" button too many times with minimal input (e.g. just wage form entered)
- [x] Possible bug: for mfjTaxes (and singleTaxes), when taxableIncome is zero, the calculated tax is 9735.25? 

## Enhancements
- Should comma delimit numbers, will make input text more readable
- Empty imput should be automatically replaced with zero
- On Form 1040-EZ tab: If form/number elements are not editable, they should be styled differently

## Refactoring Suggestions
### General
- Remove unused imports
- Change protected variables to private
- Change many methods from public to private
- Add proper Javadoc Comments --> list parameters, return, and if possible side effects
- verbose and descriptive method names
- REMOVE MAGIC NUMBERS --> put them as final constants at top of file
- extract method from repeated logic
- Improve whitespacing
- Project structure: enforce strict MVC file structure. Label files as services, models, controllers, or DAOs (data access objects)
- Class names in Java should be capitalized

### Main1040EZForm
- BREAK UP MONOLITHIC METHODS INTO BITE SIZED FUNCTIONS --> makes more readable, testable, and maintainable
- Change variable access from protected to private
- [x] Make helper functions private
- Convert magic numbers to constants at top of file, make configurable
- Convert methods to pure functions, minimize side effects. 
- Idea: move InputVerifier into a class
- Idea: write method that creates label with input field. Set the boundry in this method, too. Also add to incomeEntryPane. Also set verifier on these labels.
- Idea: pull out magic numbers for positioning into constants so they can be configured at the top of the file
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
- change method/variable names to be more verbose

### EICDatabaseAccessor
- [x] Remove unused variables
- [x] Log or print errors for easier debugging
- if --> switch
- [x] Initializing to null is redundant
- [x] Improve whitespace
- Separate controller logic with model accessor

### deductionCalculator
- more verbose variable names
- remove unused variables

