import java.math.BigInteger;

/**
 * A class that computes the sum of self-powers, i.e. 1^1 + 2^2 + 3^3, etc...
 */
public class SelfPower {

    /**
     * This method returns the last digits of the number, specified with amount. E.g. 3413 with an amount of 3, would
     * return 413
     *
     * @param n      the number to get the digits from
     * @param amount the number of digits to get
     * @return a string of the amount of digits specified from the number
     */
    private static String lastDigits(BigInteger n, int amount) {

        StringBuilder digits = new StringBuilder();

        if (n.toString().length() <= amount) return n.toString();
        else {

            for (int x = 0; x < amount; x++) {
                digits.append(n.mod(BigInteger.TEN));
                n = n.divide(BigInteger.TEN);
            }

            return digits.reverse().toString();
        }

    }

    /**
     * This method calculates the sum of the self-powers, e.g. 1^1 + 2^2 + 3^3 + 4^4 + 5^5 = 3413
     *
     * @param limit the amount of self-powers to calculate
     * @return the sum
     */
    private static BigInteger sum(int limit) {

        BigInteger sum = BigInteger.ZERO;
        BigInteger x;

        for (x = BigInteger.ONE; x.compareTo(BigInteger.valueOf(limit)) <= 0; x = x.add(BigInteger.ONE)) {
            sum = sum.add(x.pow(x.intValue()));
        }

        return sum;
    }

    /**
     * The main method, parses the args and outputs the result.
     *
     * @param args limit:  the amount of self-powers to calculate (default 1000)
     *             amount: the amount of digits to output at the end
     */
    public static void main(String[] args) {

        int limit;
        int amount;

        switch (args.length) {
            case 1:
                limit = Integer.valueOf(args[0]);
                amount = 10;
                break;
            case 2:
                limit = Integer.valueOf(args[0]);
                amount = Integer.valueOf(args[1]);
                break;
            default:
                limit = 1000;
                amount = 10;

        }

        System.out.println(lastDigits(sum(limit), amount));
    }

}
