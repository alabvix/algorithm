package br.com.alabvix.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 *
 * For example, there are n==7 socks with colors ar=[1,2,1,2,1,3,2].
 * There is one pair of color 1 and one of color 2.
 * There are three od   d socks left, one of each color.
 * The number of pairs is 2.
 *
 * Constraints:
 * 1 <= n <= 100
 * 1 <= ar[i] <= 100 where 0 <= i < n
 *
 */
public class SalesByMatch {

    public static void main(String[] args) {

        int[] arr = {10,20,20,10,10,30,50,10,20};
        int n = 9;

        int r = sockMerchant_v1(n,arr);
        if (r==3) {
            System.out.println("sucesso " + r);
        } else {
            System.out.println("fracasso " + r);
        }
    }

    static int sockMerchant_v1(int n, int[] ar) {
        long start = System.currentTimeMillis();

        Map<Integer,Integer> mapa = new HashMap<>();

        int pairs = 0;
        for (int i=0; i<n; i++) {
            int count=0;
            for (int j=0; j<n; j++) {
                if (ar[i]==ar[j]) {
                    count ++;
                }
            }
            mapa.put(ar[i], count);
        }
        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ":" + entry.getValue());
            if (entry.getValue() >=2) {
                int t = entry.getValue()/2;
                pairs += t;
            }
        }
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F; System.out.println(sec + " seconds");

        return pairs;
    }

    static int sockMerchant_v2(int n, int[] ar) {

        return 0;
    }


}
