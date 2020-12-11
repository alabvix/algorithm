package br.com.alabvix.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 *
 * For example, there are n==7 socks with colors ar=[1,2,1,2,1,3,2].
 * There is one pair of color 1 and one of color 2.
 * There are three odd socks left, one of each color.
 * The number of pairs is 2.
 *
 * Constraints:
 * 1 <= n <= 100
 * 1 <= ar[i] <= 100 where 0 <= i < n
 *
 */
public class SalesByMatch {

   public int findNumberOfPairs1(int n, int[] ar) {

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
            //System.out.println("Key = " + entry.getKey() + ":" + entry.getValue());
            if (entry.getValue() >=2) {
                int t = entry.getValue()/2;
                pairs += t;
            }
        }

        return pairs;
    }

    public int findNumberOfPairs2(int n, int[] ar) {

       HashSet<Integer> buffer = new HashSet<>();
       int totalPairs = 0;

       for (int i=0; i<n; i++) {
           Integer sock = ar[i];

           if (buffer.contains(sock)) {
               totalPairs++;
           } else {
               buffer.add(sock);
           }
       }

       return totalPairs;
    }

}
