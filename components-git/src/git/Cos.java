package git;

public class Cos {

    // Version 1.0.2
    public static double cosineA(int degree, int n) {
        double value = 1.0;
        double radians = degree * Math.PI/180;

        for (int term = 2, j = 1 ; term <= n*2; term += 2,j++)
        {
            value += Math.pow(-1.0, j) * Math.pow(radians,term)/factorial(term);
        }
        return value;
    }


    public static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        cosTest();
    }
    
    private static void cosTest() {
        test(0.9063077871054811, Cos.cosineA(25, 4));
        test(1, Cos.cosineA(0, 4));
        test(0.6427876798657339, Cos.cosineA(50, 4));
        System.out.println("Test passed");
    }
    
    private static void test(double expected, double actual) {
        if (Double.compare(expected, actual) != 0) {
            System.err.println("Cos test failed. Expected: " + expected + ", but got " + actual);
            System.exit(1);
        }
    }
}
