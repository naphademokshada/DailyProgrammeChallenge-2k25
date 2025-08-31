import java.util.*;

public class Day17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long n = sc.nextLong();
        List<Long> factors = primeFactors(n);
        System.out.println(formatList(factors));
    }

    // Returns the prime factorization with multiplicity
    static List<Long> primeFactors(long n) {
        List<Long> res = new ArrayList<>();
        // Extract factor 2
        while (n % 2 == 0) {
            res.add(2L);
            n /= 2;
        }
        // Extract odd factors up to sqrt(n)
        for (long f = 3; f * f <= n; f += 2) {
            while (n % f == 0) {
                res.add(f);
                n /= f;
            }
        }
        // If remainder is > 1, it's prime
        if (n > 1) res.add(n);
        return res;
    }

    // Formats list like [2, 3, 3]
    static String formatList(List<Long> list) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(list.get(i));
        }
        sb.append(']');
        return sb.toString();
    }
}
