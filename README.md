# Servlet Project
## Implementation of a small calculator using Tomcat.
04/29/2022

As exams come closer, I figured that I could train my coding skills,
hence the need to develop this small, (pretty much) functional calculator, with some basic mathematical functions. 

Below in this documentation I will list methods that work, and ones that don't.

**Note that it is currently _not_ possibile to perform operations with more than two operands.**
***

## Mathematical operations
Every possible operation is listed in class `Calculator`.

Below I made a list that elencates every possible operation:
1. `SUM()`
    * Performs a simple addition between operands.
2. `SUB()`
    * Performs a simple subtraction between operands.
3. `MUL()`
    * Performs a simple multiplication between two operands.
4. `DIV()`
    * Performs a simple division between two operands.
    * Trying to divide by zero will throw a `DivisionExcetpion()`
5. `squareRoot()`
    * Evaluates the square root of an operand.
6. `toPercentage()`
    * Converts the number in a percentage format.
7. `elv()`
    * Currently unavailable, further details can be found below.
8. `elvTen()`
    * Evaluates ten to the power of a value.
9. `factorial()`
    * Evaluates the factorial of an operand in recursive process.
10. `logarithm()`
    * Evaluates the logarithm in base _10_ of an operand.
11. `radToDeg()`
    * Converts from radians to degrees an operand.
12. `degToRad()`
    * Reverse process of the above method.
13. `toSin()`
    * Evaluates the sin of an operand.
14. `toCos()`
    * Evaluates the cosin of an operand.
15. `toTan()`
    * Evaluates the tangent of an operand.
16. `fractionString()`
    * A formatter to print in fraction syntax.
***
## Requesting operation to the server:
To actually make a request to the server, follow the below syntax:
> localhost:8080/Servlet/Calculator/"operation"?param1=&param2=

Where "operation" is the mathematical function you want to apply.
***
## Unavailable methods, typos, bugs
### `elv()` method
As stated before, the `elv()` method is currently unavailable, this is because of formatting issues when parsing the actual URL request, this is mainly because of this block of code:

```
 if(var1 == null || var2 == null || var1.equals("") || var2.equals("")){
            response.sendError(400, "Missing parameters.\r\n");
            return;
        }
```
Which stops the program if either param `x` or `y` is missing.
Because the `elv()` method actually requires two parameters: **base** and **exponent** I couldn't figure out how to (decently) format the request URL.

I know it's a stupid concern, and it is easily solvable; I think it was because I spent too much time on this project solving Tomcat issues and such.

There are some lines of codes that are commented out, the ones below for reference:
```
// double z = Double.parseDouble(var3);
// out.println("<prefix>" + c.getPrefix() + "</prefix>");
// out.println("<suffix>" + c.getSuffix() + "</suffix>");
```
Believe it or not, the `z` parameter is what actually caused the issue of the `elv()` method - for some reason I thought of using a third additional - and optional - parameter.
***
### Single parameter functions
About using _only one parameter_, for instance, the `elvTen()` method only needs one, and as such a user **must** be able to type the request with only one parameter; this is an issue because, as stated before, entering only one parameter results in a 
>400 BAD REQUEST - Missing parameters.

response, which should not happen.

The same issue applies with pretty much every other method, exclduing the main four operation ones.
***
## To do list
- [] Fix single parameters methods.
- [] Fix code readability.
- [] Add more complex functions.
- [] Fix general, smaller bugs.
- [] Implement formatting methods to visualize powers, fractions etc.
***