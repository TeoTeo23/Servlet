/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servlet;

/**
 *
 * @author TeoTeo23_
 */
public class Calculator {
    private double prefix;
    private double suffix;
    private double result;
    private final double PI = 3.14;
    
    // Constructor
    public Calculator(double p, double s){
        this.prefix = p;
        this.suffix = s;
    }
    
    // Getters and Setters
    public double getPrefix(){ return this.prefix; }
    public double getSuffix(){ return this.suffix; }
    public double getResult(){ return this.result; }
    public void setPrefix(double p){ this.prefix = p; }
    public void setSuffix(double s){ this.suffix = s; }
    public void setResult(double r){ this.result = r; }
    
    /*
        * method ADD performs a sum of values p and s
    */
    public double add(double p, double s){ return p + s; }
    /*
        * method SUB performs a subtracion of values p and s
    */
    public double sub(double p, double s){ return p - s; }
    /*
        * method MUL performs a multiplication of values p and s
    */
    public double mul(double p, double s){ return p * s; }
    /*
        * method DIV performs a division between p and s
        * wether or not s = 0 depends on the user only
        * in case s == 0.0, an exception is thrown
    */
    public double div(double p, double s)throws DivisionException{
        if(s == 0.0 || (int) s == 0)
            throw new DivisionException("Division by zero.\r\n");
        return p / s;
    }
    /*
        * method SQUAREROOT return the square root of value p
    */
    public double squareRoot(double p){return Math.sqrt(p); }
    /*
        * method TOPERCENTAGE returns the number in percentage format
    */
    public double toPercentage(double p){ return p / 100; }
    /*
        * ELV method elevates p to the power of exp
    */
    
   // public double elv(double p, int exp){ return Math.pow(p, exp); }
    
    /*
        * method ELVTEN elevates ten to the power of exp
        * like in common calculators you can find this function
        * so it is integrated in this class
    */
    public double elvTen(double exp){ return Math.pow(10, exp); }
    /*
        * FACTORIAL method calculates the factorial of p!
    */
    public double factorial(double p){
        if(p <= 1)
            return 1;
        return (p * factorial(p - 1));
    }
    /*
        * LOGARYTHM method calculates the logarythm in base 10 value of p
    */
    public double logarythm(double p){ return Math.log10(p); }
    /*
        * RADTODEG converts p value from radians to degrees
    */
    public double radToDeg(double p){ return p * (180 / PI); }
    /*
        * DEGTORAD converts p value from degrees to radians
    */
    public double degToRad(double p){ return p * (PI / 180); }
    /*
        * method TOSIN returns sin value of an angle p
    */
    public double toSin(double p){ return Math.sin(p); }
    /*
        * method TOCOS is the same as toSin() method, evaluating the cos value of a p angle
    */
    public double toCos(double p){ return Math.cos(p); }
    /*
        * method TOTAN evaluates the tan value of a p angle
    */
    public double toTan(double p){ return Math.tan(p); }
    /*
        * method FRACTIONSTRING serves to print a fraction in the correct order
        * rather than printing num/den it is visually better to print a fraction
        * as it would normally appear
    */
    public String fractionString(double num, double den){
        return num + "\r\n" + "---" + "\r\n" + den + "\r\n";
    }
}
