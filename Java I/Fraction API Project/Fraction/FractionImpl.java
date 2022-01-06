package Fraction;

import java.lang.reflect.Field;


public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;
    public FractionImpl(int numerator, int denominator) {
        // TODO
        int newDenominator;
        int newNumerator;

        if (numerator > 0 && denominator > 0){
            this.numerator = numerator;
            this.denominator = denominator;
        }
        if (numerator > 0 && denominator < 0){
            this.numerator = -(numerator);
            this.denominator = -(denominator);
        }
        if (numerator < 0 && denominator >0){
            this.numerator = numerator;
            this.denominator = denominator;
        }
        if (numerator < 0 && denominator <0){
            this.numerator = -(numerator);
            this.denominator = -(denominator);
        }
        if(numerator == 0){
            this.numerator = 0;
            this.denominator = 1;
        }
        if(denominator == 0){
            throw new ArithmeticException("Divide by zero");
        }
        if(GCD(this.numerator,this.denominator) == 1){
            //pass
        }
        else {
            int divider = GCD(this.numerator,this.denominator);
            if(divider < 0){
                divider = -(divider);
            }
            this.denominator = this.denominator/divider;
            this.numerator = this.numerator/divider;
        }

    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        if(wholeNumber == 0){
            this.numerator = 0;
            this.denominator = 1;
        }
        else {
            this.numerator = wholeNumber;
            this.denominator = 1;
        }
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // TODO
        int numerator = 0;
        String numString = "";
        int denominator = 0;
        String denomString = "";
        boolean seperator = false;
        int numMinusCount = 0;
        int denomMinusCount = 0;

        for(int i = 0; i < fraction.length(); i++){
            int num = fraction.charAt(i);
            if(num == 45 && seperator == false){ numMinusCount++;}
            else if(num == 45 && seperator == true){ denomMinusCount++;}
            else if(num == 47){ seperator = true;}
            else if((num >= 48 && num <= 57)) {
                if(seperator == false) {
                    numString += fraction.charAt(i);
                }
                if(seperator == true) {
                    denomString += fraction.charAt((i));
                }
            }
            else if((num == 32)){
                if(fraction.charAt(i-1)!=32){
                    throw new NumberFormatException("Illegal space");
                }
            }
            else{
                throw new NumberFormatException("Not a number");
            }
        }


        if(denomString == ""){
            if(numMinusCount % 2 == 1){
                this.numerator = -(Integer.parseInt(numString));

            }
            if(numMinusCount % 2 == 0) {
                this.numerator = Integer.parseInt(numString);
            }
                this.denominator = 1;

        }
        else {
            if (numMinusCount % 2 == 1 && denomMinusCount % 2 == 1){
                this.numerator = Integer.parseInt(numString);
                this.denominator = Integer.parseInt(denomString);
            }
            if (numMinusCount % 2 == 0 && denomMinusCount % 2 == 1){
                this.numerator = -(Integer.parseInt(numString));
                this.denominator = Integer.parseInt(denomString);
            }
            if (numMinusCount % 2 == 1 && denomMinusCount % 2 == 0){
                this.numerator = -(Integer.parseInt(numString));
                this.denominator = Integer.parseInt(denomString);
            }
            if (numMinusCount % 2 == 0 && denomMinusCount % 2 == 0){
                this.numerator = Integer.parseInt(numString);
                this.denominator = Integer.parseInt(denomString);
            }
            if(Integer.parseInt(denomString)==0){
                throw new ArithmeticException("Divide by zero");
            }
        }
        int divider = GCD(this.numerator,this.denominator);
        if(divider < 0){
            divider = -(divider);
        }
        this.denominator = this.denominator/divider;
        this.numerator = this.numerator/divider;

    }

    /**
     * @inheritDoc
     */
   @Override
    public Fraction add(Fraction f)  {
       String z = f.toString();
       FractionImpl newFrac = new FractionImpl(z);
       int fNumerator = newFrac.numerator;
       int fDenominator = newFrac.denominator;
       int retDenominator = LCM(fDenominator, denominator);
       int retNumerator = (numerator*(retDenominator/denominator))+(fNumerator*(retDenominator/fDenominator));
       return new FractionImpl((retNumerator), retDenominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        String z = f.toString();
        FractionImpl newFrac = new FractionImpl(z);
        int fNumerator = newFrac.numerator;
        int fDenominator = newFrac.denominator;
        int retDenominator = LCM(fDenominator, denominator);
        int retNumerator = (numerator*(retDenominator/denominator))-(fNumerator*(retDenominator/fDenominator));
        return new FractionImpl((retNumerator), retDenominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        String z = f.toString();
        FractionImpl newFrac = new FractionImpl(z);
        int fNumerator = newFrac.numerator;
        int fDenominator = newFrac.denominator;

        return new FractionImpl((numerator*fNumerator), (denominator*fDenominator));

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
            String z = f.toString();
            FractionImpl newFrac = new FractionImpl(z);
            int fNumerator = newFrac.numerator;
            int fDenominator = newFrac.denominator;

            return new FractionImpl(numerator*fDenominator, denominator*fNumerator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        int numerator  = this.numerator;
        int denominator = this.denominator;
        if(numerator < 0){ numerator = -(this.numerator);}

        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int numerator = -(this.numerator);
        int denominator = this.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction == false){
            return false;
        }
        String z = obj.toString();
        Fraction baseFrac = new FractionImpl(this.numerator,this.denominator);
        Fraction oFrac = new FractionImpl(z);
        oFrac = baseFrac.divide(oFrac);
        FractionImpl getFrac = new FractionImpl(oFrac.toString());
        if(getFrac.numerator == 1 && getFrac.denominator == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        int numerator = this.denominator;
        int denominator = this.numerator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction f) {
        String z = f.toString();
        FractionImpl fFrac = new FractionImpl(z);
        Fraction thisFrac = new FractionImpl(this.numerator, this.denominator);
        try{
            FractionImpl compareFrac = new FractionImpl(fFrac.divide(thisFrac).toString());
            float compNum = compareFrac.numerator;
            float compDenom = compareFrac.denominator;
            if((compNum/compDenom) > 1){
                return -1;
            }
            if((compNum/compDenom) < 1) {
                return 1;
            }
            return 0;
        }
        catch (Exception e){
            if(fFrac.numerator < 0){
                return -1;
            }
            if(fFrac.numerator > 0){
                return 1;
            }
            if(fFrac.numerator == 0){
                return 0;
            }
        }
        return 99;
    }

    //Method that calculate Lowest Common Multiple
    /**
     * @inheritDoc
     */
    @Override
    public int LCM(int num1, int num2){
        for(int i = 1; i <= num2; i++) {
            if(i*num1 % num2 == 0) {
                return i*num1;
            }
        }
        return num1;
    }
    //Methods that calculates Greatest Common Divisor, using recursion.
    /**
     * @inheritDoc
     */
    @Override
    public int GCD(int a, int b) { return b==0 ? a: GCD(b, a%b);}

    /**
     * @inheritDoc
     */
    public FractionImpl fGCD (int n1, int n2){
        int god = GCD(n1,n2);
        n1 = n1/god;
        n2 = n2/god;
        return new FractionImpl(n1,n2);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        String retStr;
        //Returns 1 instead of 1/1
        if(this.denominator == 1 && this.numerator != 0) {
            retStr = Integer.toString(this.numerator);
        }
        else {
             retStr = Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
            return retStr;
        }
        return retStr;
    }
}