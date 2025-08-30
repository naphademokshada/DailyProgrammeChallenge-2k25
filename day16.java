import java.util.*;

public class day16 {
    // Function to compute GCD using Euclid's algorithm
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    // Function to compute LCM using the relation lcm(a,b) = (a/gcd)*b
    static long lcm(long a, long b) {
        long g = gcd(a, b);
        return (a / g) * b;  // safer than (a*b)/g to avoid overflow
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        System.out.println(lcm(N, M));
        sc.close();
    }
}
