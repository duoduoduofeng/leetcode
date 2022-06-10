package leetcodeproblems.LC_001_100;

import java.util.Arrays;

//https://leetcode.com/problems/multiply-strings/
public class S_043_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] rs = new char[num1.length() + num2.length()];
        char invalidStart = '0';
        int i, j;
        for(i = 0; i < rs.length; i++) {
            rs[i] = invalidStart;
        }

        int carry, sum;
        for(j = num2.length() - 1; j >= 0; j--) {
            carry = 0;
            for(i = num1.length() -1; i >= 0; i--) {
                sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + (rs[i + j + 1] - '0') + carry;
                rs[i + j + 1] = (char)(sum % 10 + 48); // '0' is 48
                carry = sum / 10;
            }
            if(carry > 0) {
                rs[j] = (char) (carry + 48);
            }
        }

        int realStart = 0;
        while(rs[realStart] == invalidStart) {
            realStart++;
        }

        rs = Arrays.copyOfRange(rs, realStart, rs.length);

        return String.valueOf(rs);
    }

    public static void main(String[] args) {
        S_043_MultiplyStrings ex = new S_043_MultiplyStrings();
        String num1 = "9";
        String num2 = "9";

        String rs = ex.multiply(num1, num2);
        System.out.println(rs);
    }
}
