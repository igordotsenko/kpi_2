package git;

public class Cos {

    // Version 1.0.1
    public static double cosine(int degree, int n) {
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
        System.out.println(Cos.cosine(25, 4));
    }
}
