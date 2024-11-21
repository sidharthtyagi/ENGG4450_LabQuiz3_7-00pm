package Mathematics;

import java.util.ArrayList;
import java.util.Collections;

import Mathematics.Complex;

public class Multiplication {

    public static final long multiplication(int a, int b) {
        long result = ((long) a) * ((long) b);
        // Fix: Return result even if a or b is zero, multiplication by zero should return zero.
        return result;
    }

    public static final long multiplyUsingLoop(int a, int b) {
        int absB = Math.abs(b); // Handle negative 'b'
        long result = 0; // Initialize result as 0

        // Multiply using the loop
        for (int i = 0; i < absB; i++) {
            result += a;
        }

        // If b is negative, make the result negative
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingRecursion(int a, int b) {
        // Base case: If b is 0, return 0
        if (b == 0) return 0;

        // If b is negative, make the multiplication positive and then negate the result
        int absB = Math.abs(b);
        long result = a;

        // Base case for recursion: If b is 1
        if (absB == 1) return result;

        // Recursively add 'a' for |b| times
        result += multiplyUsingRecursion(a, absB - 1);

        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingShift(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        long result = 0L;
        while (absA > 0) {
            if ((absA & 1) > 0)
                result += absB; // Is odd
            absA >>= 1;
            absB <<= 1;
        }

        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static final long multiplyUsingLogs(int a, int b) {
        long absA = Math.abs(a);
        long absB = Math.abs(b);
        long result = Math.round(Math.pow(10, (Math.log10(absA) + Math.log10(absB))));
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static String multiplyUsingFFT(String a, String b) {
        if (a.equals("0") || b.equals("0")) {
            return "0";
        }
        boolean negative = false;
        if ((a.charAt(0) == '-' && b.charAt(0) != '-') || (a.charAt(0) != '-' && b.charAt(0) == '-')) {
            negative = true;
        }
        if (a.charAt(0) == '-') {
            a = a.substring(1);
        }
        if (b.charAt(0) == '-') {
            b = b.substring(1);
        }
        int size = 1;
        while (size < (a.length() + b.length())) {
            size *= 2;
        }
        Complex[] aCoefficients = new Complex[size];
        Complex[] bCoefficients = new Complex[size];
        for (int i = 0; i < size; i++) {
            aCoefficients[i] = new Complex();
            bCoefficients[i] = new Complex();
        }
        for (int i = 0; i < a.length(); i++) {
            aCoefficients[i] = new Complex((double) (Character.getNumericValue(a.charAt(a.length() - i - 1))), 0.0);
        }
        for (int i = 0; i < b.length(); i++) {
            bCoefficients[i] = new Complex((double) (Character.getNumericValue(b.charAt(b.length() - i - 1))), 0.0);
        }

        FastFourierTransform.cooleyTukeyFFT(aCoefficients);
        FastFourierTransform.cooleyTukeyFFT(bCoefficients);

        for (int i = 0; i < size; i++) {
            aCoefficients[i] = aCoefficients[i].multiply(bCoefficients[i]);
        }
        for (int i = 0; i < size / 2; i++) {
            Complex temp = aCoefficients[i];
            aCoefficients[i] = aCoefficients[size - i - 1];
            aCoefficients[size - i - 1] = temp;
        }
        FastFourierTransform.cooleyTukeyFFT(aCoefficients);

        ArrayList<Integer> res = new ArrayList<Integer>();
        int pass = 0;
        for (int i = 0; i < size; i++) {
            res.add((int) (pass + Math.floor((aCoefficients[i].abs() + 1) / size)));
            if (res.get(i) >= 10) {
                pass = res.get(i) / 10;
                res.set(i, res.get(i) % 10);
            } else {
                pass = 0;
            }
        }
        Collections.reverse(res);
        StringBuilder result = new StringBuilder();
        if (negative) {
            result.append('-');
        }
        boolean startPrinting = false;
        for (Integer x : res) {
            if (x != 0) {
                startPrinting = true;
            }
            if (startPrinting) {
                result.append(x);
            }
        }
        return result.toString();
    }

    public static String multiplyUsingLoopWithStringInput(String a, String b) {
        // Handle empty inputs
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            return "0";
        }

        // Determine if the result will be negative
        boolean aIsNegative = a.charAt(0) == '-';
        boolean bIsNegative = b.charAt(0) == '-';

        // Remove negative signs for easier multiplication
        if (aIsNegative) a = a.substring(1);
        if (bIsNegative) b = b.substring(1);

        int lenA = a.length();
        int lenB = b.length();

        // Array to hold the multiplication result
        int[] result = new int[lenA + lenB];

        // Multiply each digit and accumulate the result
        for (int i = lenA - 1; i >= 0; i--) {
            for (int j = lenB - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // Convert the result array into a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        // If the result is empty, return "0"
        if (sb.length() == 0) {
            return "0";
        }

        // Add the negative sign if the result should be negative
        if (aIsNegative ^ bIsNegative) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }

    public static int multiplyUsingLoopWithIntegerInput(int a, int b) {
        boolean aIsNegative = a<0;
        boolean bIsNegative = b<0;
        a = Math.abs(a);
        b = Math.abs(b);

        // Find the largest multiple of ten which is larger than 'a'
        int largerMultipleA=1;
        int numberOfDigitsInA=0;
        while (largerMultipleA<a){
            largerMultipleA *= 10;
            numberOfDigitsInA++;
        }

        // Find the largest multiple of ten which is larger than 'b'
        int largerMultipleB = 1;
        int numberOfDigitsInB=0;
        while (largerMultipleB<b){
            largerMultipleB *= 10;
            numberOfDigitsInB++;
        }

        // Store the results
        int[] res = new int[numberOfDigitsInA+numberOfDigitsInB];

        // Reduce the digits to the first digit on the left
        largerMultipleA /= 10;
        numberOfDigitsInA--;
        largerMultipleB /= 10;
        numberOfDigitsInB--;

        // Store original 'q' and 'b', to reset
        int originalMultipleB = largerMultipleB;
        int originalB = b;

        int carry=0,rem,flag=0,mul;
        for (int i=numberOfDigitsInA; i>=0; i--) {
            int k=numberOfDigitsInA-i;
            // reset
            largerMultipleB = originalMultipleB;
            b = originalB;
            for (int j=numberOfDigitsInB; j>=0; j--) {
                int f = a/largerMultipleA;
                int s = b/largerMultipleB;

                b %= largerMultipleB;
                largerMultipleB /= 10;

                mul=f*s;
                res[k] = res[k]+(mul/10);
                k++;
                res[k] = res[k]+(mul%10);
            }
            a %= largerMultipleA;
            largerMultipleA /= 10;
        }

        for (int i=(numberOfDigitsInA+numberOfDigitsInB)+1; i>=0; i--) {
            if (flag==1){
                res[i] = res[i]+carry;
                flag=0;
            }

            if (res[i] >=10 && i!=0) {
                rem = res[i]%10;
                carry = res[i] /10;
                res[i] = rem;
                flag++;
            }
        }

        int result = 0;
        int m = 1;
        for (int idx=res.length-1; idx>=0; idx--) {
            int s = res[idx];
            result += s*m;
            m *= 10;
        }
        // adjust for negatives
        if (aIsNegative ^ bIsNegative)
            result *= -1;
        return result;
    }
}

