class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        
        int[] result = new int[n + m];
        
        // Reverse strings for easier indexing
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        
        // Multiply digit by digit
        for (int i = 0; i < n; i++) {
            int digit1 = sb1.charAt(i) - '0';
            for (int j = 0; j < m; j++) {
                int digit2 = sb2.charAt(j) - '0';
                result[i + j] += digit1 * digit2;
            }
        }
        
        // Handle carry
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        
        // Remove leading zeros
        int i = result.length - 1;
        while (i > 0 && result[i] == 0) {
            i--;
        }
        
        // Build final string
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            ans.append(result[i]);
            i--;
        }
        
        return ans.toString();
    }
}