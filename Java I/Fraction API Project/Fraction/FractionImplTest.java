package Fraction;

import Fraction.Fraction;
import Fraction.FractionImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionImplTest {
    private String add = "add";
    private String subtract = "subtract";
    private String multiply = "multiply";
    private String divide = "divide";
    private String abs = "abs";
    private String compareto = "compareto";
    private String inverse = "inverse";
    private String negate = "negate";
    private String equals = "equals";

    private String create_two_fractions_return_operation(String f1s, String f2s, String operation) throws NoSuchFieldException, IllegalAccessException {
        Fraction f1 = new FractionImpl(f1s);
        Fraction f2 = new FractionImpl(f2s);
        switch (operation){
            case "add":
                return f1.add(f2).toString();
            case "subtract":
                return f1.subtract(f2).toString();
            case "multiply":
                return f1.multiply(f2).toString();
            case "divide":
                return f1.divide(f2).toString();
            case "equals":
                return Boolean.toString(f1.equals(f2));
            case "compareto":
                return Integer.toString(f1.compareTo(f2));
            default:
                System.out.println("INVALID OPERATION GIVEN TO create_two_fractions_return_operation");
                return "";
        }
    }
    private String create_fraction_test_operation(String f1s, String operation){
        Fraction f1 = new FractionImpl(f1s);
        switch (operation){
            case "abs":
                return f1.abs().toString();
            case "negate":
                return f1.negate().toString();
            case "inverse":
                return f1.inverse().toString();
            default:
                return "";
        }
    }

    @org.junit.Test
    public void constructions1() throws Exception {
        assertEquals(new FractionImpl(8, -1).toString(), "-8");
    }

    @org.junit.Test
    public void constructions2() throws Exception {
        assertEquals(new FractionImpl(8, 12).toString(), "2/3");
    }

    @org.junit.Test
    public void constructions3() throws Exception {
        assertEquals(new FractionImpl(8, -12).toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions4() throws Exception {
        assertEquals(new FractionImpl(-8, 12).toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions4a() throws Exception {
        assertEquals(new FractionImpl(-8, -12).toString(), "2/3");
    }

    @org.junit.Test
    public void constructions4b() throws Exception {
        assertEquals(new FractionImpl(-2, -3).toString(), "2/3");
    }

    @org.junit.Test
    public void constructions4c() throws Exception {
        assertEquals(new FractionImpl(0, 4).toString(), "0");
    }

    @org.junit.Test
    public void constructions5() throws Exception {
        assertEquals(new FractionImpl(-6).toString(), "-6");
    }

    @org.junit.Test
    public void constructions6() throws Exception {
        assertEquals(new FractionImpl(6).toString(), "6");
    }

    @org.junit.Test
    public void constructions7() throws Exception {
        assertEquals(new FractionImpl(0).toString(), "0");
    }

    @org.junit.Test
    public void constructions8() throws Exception {
        assertEquals(new FractionImpl("-8/12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions9() throws Exception {
        assertEquals(new FractionImpl("8/-12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions10() throws Exception {
        assertEquals(new FractionImpl("-8/-12").toString(), "2/3");
    }

    @org.junit.Test
    public void constructions11() throws Exception {
        assertEquals(new FractionImpl("-5/6").toString(), "-5/6");
    }

    @org.junit.Test
    public void constructions12() throws Exception {
        assertEquals(new FractionImpl("8/-1").toString(), "-8");
    }

    @org.junit.Test
    public void constructions13() throws Exception {
        assertEquals(new FractionImpl("-6").toString(), "-6");
    }

    @org.junit.Test
    public void constructions14() throws Exception {
        assertEquals(new FractionImpl("6").toString(), "6");
    }

    @org.junit.Test
    public void constructions15() throws Exception {
        assertEquals(new FractionImpl("0").toString(), "0");
    }

    // now with spaces


    @org.junit.Test
    public void constructions16() throws Exception {
        assertEquals(new FractionImpl("-8/12 ").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions17() throws Exception {
        assertEquals(new FractionImpl(" 8 / -12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions18() throws Exception {
        assertEquals(new FractionImpl("-8/-12 ").toString(), "2/3");
    }

    @org.junit.Test
    public void constructions19() throws Exception {
        assertEquals(new FractionImpl(" 8 / -12 ").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions20() throws Exception {
        assertEquals(new FractionImpl(" 8/ -12 ").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions21() throws Exception {
        assertEquals(new FractionImpl("8 /-12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions22() throws Exception {
        assertEquals(new FractionImpl("8 / -12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions23() throws Exception {
        assertEquals(new FractionImpl("8 / -12").toString(), "-2/3");
    }

    @org.junit.Test
    public void constructions24() throws Exception {
        assertEquals(new FractionImpl("-5 /6 ").toString(), "-5/6");
    }

    @org.junit.Test
    public void constructions25() throws Exception {
        assertEquals(new FractionImpl("8/-1 ").toString(), "-8");
    }

    @org.junit.Test
    public void constructions26() throws Exception {
        assertEquals(new FractionImpl("0/4").toString(), "0");
    }




    @org.junit.Test
    public void constructions27() throws Exception {
        assertEquals(new FractionImpl("4/4").toString(), "1");
    }

    @org.junit.Test
    public void constructions28() throws Exception {
        assertEquals(new FractionImpl("150/2").toString(), "75");
    }




    @Test(expected =  ArithmeticException.class)
    public void testConstructionsArithmeticExceptionThrown(){
        assertEquals(new FractionImpl("1/0").toString(), "0");
    }


    @org.junit.Test
    public void add1() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/3", "1/3", add), "2/3");
    }
    @org.junit.Test
    public void add2() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/2", "1/2", add), "1");
    }

    @org.junit.Test
    public void add3() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "1/2", add), "0");
    }

    @org.junit.Test
    public void add4() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "-1/2", add), "-1");
    }

    @org.junit.Test
    public void add5() throws Exception {
        assertEquals(create_two_fractions_return_operation("-4/3", "1/3", add), "-1");
    }

    @org.junit.Test
    public void add6() throws Exception {
        assertEquals(create_two_fractions_return_operation("4/3", "-1/3", add), "1");
    }

    @org.junit.Test
    public void add7() throws Exception {
        assertEquals(create_two_fractions_return_operation("3", "-3", add), "0");
    }

    @org.junit.Test
    public void add8() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", add), "17/3");
    }

    @org.junit.Test
    public void add9() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", add), "13/16");
    }

    @org.junit.Test
    public void add10() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", add), "17/3");
    }

    @org.junit.Test
    public void add11() throws Exception {
        assertEquals(create_two_fractions_return_operation("-12","-4/1", add), "-16");
    }

    @org.junit.Test
    public void add12() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4","1/9", add), "31/36");
    }

    @org.junit.Test
    public void add13() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4","1/16", add), "13/16");
    }

    @org.junit.Test
    public void add14() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4","0", add), "3/4");
    }

    @org.junit.Test
    public void add15() throws Exception {
        assertEquals(create_two_fractions_return_operation("0","0", add), "0");
    }



    @Test(expected =  ArithmeticException.class)
    public void testAddArithmeticExceptionThrown() throws NoSuchFieldException, IllegalAccessException {
        assertEquals(create_two_fractions_return_operation("1/0","0", add), "0");;
    }


    @org.junit.Test
    public void subtract1() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/3", "1/3", subtract), "0");
    }

    @org.junit.Test
    public void subtract2() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/2", "1/2", subtract), "0");
    }

    @org.junit.Test
    public void subtract3() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "1/2", subtract), "-1");
    }

    @org.junit.Test
    public void subtract4() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "-1/2", subtract), "0");
    }

    @org.junit.Test
    public void subtract5() throws Exception {
        assertEquals(create_two_fractions_return_operation("-4/3", "1/3", subtract), "-5/3");
    }

    @org.junit.Test
    public void subtract6() throws Exception {
        assertEquals(create_two_fractions_return_operation("4/3", "-1/3", subtract), "5/3");
    }

    @org.junit.Test
    public void subtract7() throws Exception {
        assertEquals(create_two_fractions_return_operation("3", "-3", subtract), "6");
    }

    @org.junit.Test
    public void subtract8() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", subtract), "19/3");
    }

    @org.junit.Test
    public void subtract9() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", subtract), "11/16");
    }

    @org.junit.Test
    public void subtract10() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", subtract), "19/3");
    }

    @org.junit.Test
    public void subtract11() throws Exception {
        assertEquals(create_two_fractions_return_operation("-12", "-4/1", subtract), "-8");
    }

    @org.junit.Test
    public void subtract12() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/9", subtract), "23/36");
    }

    @org.junit.Test
    public void subtract13() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", subtract), "11/16");
    }




    @org.junit.Test
    public void multiply1() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/3", "1/3", multiply), "1/9");
    }

    @org.junit.Test
    public void multiply2() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/2", "1/2", multiply), "1/4");
    }

    @org.junit.Test
    public void multiply3() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "1/2", multiply), "-1/4");
    }

    @org.junit.Test
    public void multiply4() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "-1/2", multiply), "1/4");
    }

    @org.junit.Test
    public void multiply5() throws Exception {
        assertEquals(create_two_fractions_return_operation("-4/3", "1/3", multiply), "-4/9");
    }

    @org.junit.Test
    public void multiply6() throws Exception {
        assertEquals(create_two_fractions_return_operation("4/3", "-1/3", multiply), "-4/9");
    }

    @org.junit.Test
    public void multiply7() throws Exception {
        assertEquals(create_two_fractions_return_operation("3", "-3", multiply), "-9");
    }

    @org.junit.Test
    public void multiply8() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", multiply), "-2");
    }

    @org.junit.Test
    public void multiply9() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", multiply), "3/64");
    }

    @org.junit.Test
    public void multiply10() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", multiply), "-2");
    }

    @org.junit.Test
    public void multiply11() throws Exception {
        assertEquals(create_two_fractions_return_operation("-12", "-4/1", multiply), "48");
    }

    @org.junit.Test
    public void multiply12() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/9", multiply), "1/12");
    }

    @org.junit.Test
    public void multiply13() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", multiply), "3/64");
    }

    @org.junit.Test
    public void multiply14() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "0", multiply), "0");
    }

    @org.junit.Test
    public void multiply15() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "-0", multiply), "0");
    }




    @org.junit.Test
    public void divide1() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/3", "1/3", divide), "1");
    }

    @org.junit.Test
    public void divide2() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/2", "1/2", divide), "1");
    }


    @org.junit.Test
    public void divide3() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "1/2", divide), "-1");
    }


    @org.junit.Test
    public void divide4() throws Exception {
        assertEquals(create_two_fractions_return_operation("-1/2", "-1/2", divide), "1");
    }


    @org.junit.Test
    public void divide5() throws Exception {
        assertEquals(create_two_fractions_return_operation("-4/3", "1/3", divide), "-4");
    }


    @org.junit.Test
    public void divide6() throws Exception {
        assertEquals(create_two_fractions_return_operation("4/3", "-1/3", divide), "-4");
    }


    @org.junit.Test
    public void divide7() throws Exception {
        assertEquals(create_two_fractions_return_operation("3", "-3", divide), "-1");
    }


    @org.junit.Test
    public void divide8() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", divide), "-18");
    }


    @org.junit.Test
    public void divide9() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", divide), "12");
    }


    @org.junit.Test
    public void divide10() throws Exception {
        assertEquals(create_two_fractions_return_operation("6", "-1/3", divide), "-18");
    }


    @org.junit.Test
    public void divide11() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "-3", divide), "-1/4");
    }


    @org.junit.Test
    public void divide12() throws Exception {
        assertEquals(create_two_fractions_return_operation("-12", "-4/1", divide), "3");
    }


    @org.junit.Test
    public void divide13() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/9", divide), "27/4");
    }


    @org.junit.Test
    public void divide14() throws Exception {
        assertEquals(create_two_fractions_return_operation("3/4", "1/16", divide), "12");
    }







    @Test(expected =  ArithmeticException.class)
    public void testDivideArithmeticExceptionThrown() throws NoSuchFieldException, IllegalAccessException {
        assertEquals(create_two_fractions_return_operation("3/4", "-0", divide), "12");
    }




    @org.junit.Test
    public void abs1() throws Exception {
        assertEquals(create_fraction_test_operation("-3/4", abs), "3/4");
    }

    @org.junit.Test
    public void abs2() throws Exception {
        assertEquals(create_fraction_test_operation("3/-4", abs), "3/4");
    }

    @org.junit.Test
    public void abs3() throws Exception {
        assertEquals(create_fraction_test_operation("-4", abs), "4");
    }

    @org.junit.Test
    public void abs4() throws Exception {
        assertEquals(create_fraction_test_operation("16", abs), "16");
    }

    @org.junit.Test
    public void abs5() throws Exception {
        assertEquals(create_fraction_test_operation("0", abs), "0");
    }

    @org.junit.Test
    public void abs6() throws Exception {
        assertEquals(create_fraction_test_operation("-0", abs), "0");
    }

    @org.junit.Test
    public void abs7() throws Exception {
        assertEquals(create_fraction_test_operation("-150", abs), "150");
    }

    @org.junit.Test
    public void abs8() throws Exception {
        assertEquals(create_fraction_test_operation("-150/1", abs), "150");
    }

    @org.junit.Test
    public void abs9() throws Exception {
        assertEquals(create_fraction_test_operation("-150/2", abs), "75");
    }





    @org.junit.Test
    public void negate1() throws Exception {
        assertEquals(create_fraction_test_operation("12/6", negate), "-2");
    }

    @org.junit.Test
    public void negate2() throws Exception {
        assertEquals(create_fraction_test_operation("-6/18", negate), "1/3");
    }

    @org.junit.Test
    public void negate3() throws Exception {
        assertEquals(create_fraction_test_operation("-0", negate), "0");
    }

    @org.junit.Test
    public void negate4() throws Exception {
        assertEquals(create_fraction_test_operation("-52", negate), "52");
    }

    @org.junit.Test
    public void negate5() throws Exception {
        assertEquals(create_fraction_test_operation("1/6", negate), "-1/6");
    }

    @org.junit.Test
    public void negate6() throws Exception {
        assertEquals(create_fraction_test_operation("-6/2", negate), "3");
    }



    @org.junit.Test
    public void equals1() throws Exception {
        assertEquals(create_two_fractions_return_operation("3", "9/3", equals), "true");
    }

    @org.junit.Test
    public void equals2() throws Exception {
        assertEquals(create_two_fractions_return_operation("9","9", equals), "true");
    }

    @org.junit.Test
    public void equals3() throws Exception {
        assertEquals(create_two_fractions_return_operation("12/60","1/5", equals), "true");
    }

    @org.junit.Test
    public void equals4() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/9","1/9", equals), "true");
    }

    @org.junit.Test
    public void equals5() throws Exception {
        assertEquals(create_two_fractions_return_operation("6/4","3/2", equals), "true");
    }

    @org.junit.Test
    public void equals6() throws Exception {
        assertEquals(create_two_fractions_return_operation("0/5","0/7", equals), "true");
    }

    @org.junit.Test
    public void equals7() throws Exception {
        assertEquals(create_two_fractions_return_operation("3","1", equals), "false");
    }

    @org.junit.Test
    public void equals8() throws Exception {
        assertEquals(create_two_fractions_return_operation("1/7","1/8", equals), "false");
    }

    @org.junit.Test
    public void equals9() throws Exception {
        assertEquals(create_two_fractions_return_operation("14","0", equals), "false");
    }

    @org.junit.Test
    public void equals10() throws Exception {
        assertEquals(create_two_fractions_return_operation("1","0", equals), "false");
    }

    @org.junit.Test
    public void equals11() throws Exception {
        assertEquals(create_two_fractions_return_operation("-6/4","-3/2", equals), "true");
    }

    @org.junit.Test
    public void equals12() throws Exception {
        assertEquals(create_two_fractions_return_operation("-0/5","-0/7", equals), "true");
    }

    @org.junit.Test
    public void equals13() throws Exception {
        assertEquals(create_two_fractions_return_operation("-3","-1", equals), "false");
    }

    @org.junit.Test
    public void equals14() throws Exception {
        assertEquals(create_two_fractions_return_operation("-6/4","3/2", equals), "false");
    }

    @org.junit.Test
    public void equals15() throws Exception {
        assertEquals(create_two_fractions_return_operation("-0/5","0/7", equals), "true");
    }

    @org.junit.Test
    public void equals16() throws Exception {
        assertEquals(create_two_fractions_return_operation("3","-1", equals), "false");
    }




    @Test(expected =  ArithmeticException.class)
    public void testAbsArithmeticExceptionThrown() throws NoSuchFieldException, IllegalAccessException {
        assertEquals(create_two_fractions_return_operation("1/0","1/0", equals), "false");
    }

    @org.junit.Test
    public void inverse1() throws Exception {
        assertEquals(create_fraction_test_operation("1/9", inverse), "9");
    }

    @org.junit.Test
    public void inverse2() throws Exception {
        assertEquals(create_fraction_test_operation("12/2", inverse), "1/6");
    }

    @org.junit.Test
    public void inverse3() throws Exception {
        assertEquals(create_fraction_test_operation("128/2", inverse), "1/64");
    }

    @org.junit.Test
    public void inverse4() throws Exception {
        assertEquals(create_fraction_test_operation("-1/9", inverse), "-9");
    }

    @org.junit.Test
    public void inverse5() throws Exception {
        assertEquals(create_fraction_test_operation("1/-9", inverse), "-9");
    }
/*
    @org.junit.Test
    public void inverse6() throws Exception {
        assertEquals(create_fraction_test_operation("0/9", inverse), "0");
    }

    @org.junit.Test
    public void inverse7() throws Exception {
        assertEquals(create_fraction_test_operation("0/-640", inverse), "0");
    }

    @org.junit.Test
    public void inverse8() throws Exception {
        assertEquals(create_fraction_test_operation("0", inverse), "0");
    }
*/



    @Test(expected =  ArithmeticException.class)
    public void testInverseArithmeticExceptionThrown1(){
        assertEquals(create_fraction_test_operation("0/9", inverse), "0");

    }

    @Test(expected =  ArithmeticException.class)
    public void testInverseArithmeticExceptionThrown2(){
        assertEquals(create_fraction_test_operation("0/-640", inverse), "0");

    }

    @Test(expected =  ArithmeticException.class)
    public void testInverseArithmeticExceptionThrown3(){
        assertEquals(create_fraction_test_operation("0", inverse), "0");

    }

    // deals with all compareTo functions


    @org.junit.Test
    public void compareTo1() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("1", "1", compareto)) == 0);
    }

    @org.junit.Test
    public void compareTo2() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("0", "0", compareto)) == 0);
    }

    @org.junit.Test
    public void compareTo3() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-12", "-12", compareto)) == 0);
    }

    @org.junit.Test
    public void compareTo4() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("3/1", "3", compareto)) == 0);
    }

    @org.junit.Test
    public void compareTo5() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("1/12", "1/12", compareto)) == 0);
    }

    @org.junit.Test
    public void compareTo6() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("12", "11", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo7() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("12", "1", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo8() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("5", "-99999", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo9() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("0", "-1/999", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo10() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("1/12", "1/13", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo11() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("6/12", "1/3", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo12() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-3/9", "-5/9", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo13() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-5", "-9", compareto)) > 0);
    }

    @org.junit.Test
    public void compareTo14() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-4/9", "-3/9", compareto)) < 0);
    }

    @org.junit.Test
    public void compareTo15() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("1/12", "12/1", compareto)) < 0);
    }

    @org.junit.Test
    public void compareTo16() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-1", "-11/12", compareto)) < 0);
    }

    @org.junit.Test
    public void compareTo17() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("-1/12", "1/12", compareto)) < 0);
    }

    @org.junit.Test
    public void compareTo18() throws Exception {
        assertTrue(Integer.parseInt(create_two_fractions_return_operation("0", "1/12", compareto)) < 0);
    }






}

