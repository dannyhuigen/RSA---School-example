package com.example.rsa;

public class RSAHelper {

    public static int getPFromN(int n) {
        int p = 2;
        while (n % p > 0 && p <= n){
            p++;
        }
        return p;
    }

    public static int getQFromPandN(int n, int p) {
        return n / p;
    }

    /**
     * Check if given num is prime (simple check)
     * @param num the number
     * @return prime or not
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
