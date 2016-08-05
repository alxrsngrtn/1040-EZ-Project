# Improvements

## Bugs Found
- Needs text wrapping: text gets clipped and appended with ellipsis (...)
- Display text can be accessed and modified through tabbing.
- On Form 1040-EZ tab: text occluding form
- Error: `[java] Database inaccessible!`. Caused by: 
 1. When you click "Calculate" button too many times with minimal input (e.g. just wage form entered)


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

### Main1040EZForm
- BREAK UP MONOLITHIC METHODS INTO BITE SIZED FUNCTIONS --> makes more readable, testable, and maintainable
- Change access from protected to private
- Convert magic numbers to constants at top of file, make configurable
- ... 

### taxCalculator
- REMOVE MAGIC NUMBERS
- Extract method from repeated logic

### EICDatabaseAccessor
- Remove unused variables
- Log or print errors for easier debugging
- if --> switch
- Initializing to null is redundant

### deductionCalculator
- more verbose variable names
- remove unused variables
- 
