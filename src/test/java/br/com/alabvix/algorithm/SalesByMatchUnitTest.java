package br.com.alabvix.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Logger;

public class SalesByMatchUnitTest {

    private SalesByMatch salesByMatch;

    Logger LOG = Logger.getLogger(SalesByMatchUnitTest.class.getName());

    @Before
    public void before() {
        this.salesByMatch = new SalesByMatch();
    }

    @Test
    public void findNumberOfPairs1_pairs2_socks8() {

        // given
        int[] socks = {1, 2, 1, 4, 3, 5, 7, 3};

        // when
        int pairs = salesByMatch.findNumberOfPairs1(socks.length, socks);

        // then
        Assert.assertEquals(2, pairs);
    }

    @Test
    public void findNumberOfPairs1_pairs3_socks16() {

        // given
        int[] socks = {10, 2, 10, 4, 3, 15, 7, 3, 9, 130, 18, 12, 4, 11, 315, 14};

        // when
        int pairs = salesByMatch.findNumberOfPairs1(socks.length, socks);

        // then
        Assert.assertEquals(3, pairs);
    }

    @Test
    public void findNumberOfPairs2_pairs2_socks8() {

        // given
        int[] socks = {1, 2, 1, 4, 3, 5, 7, 3};

        // when
        int pairs = salesByMatch.findNumberOfPairs2(socks.length, socks);

        // then
        Assert.assertEquals(2, pairs);
    }

    @Test
    public void findNumberOfPairs2_pairs3_socks16() {

        // given
        int[] socks = {10, 2, 10, 4, 3, 15, 7, 3, 9, 130, 18, 12, 4, 11, 315, 14};

        // when
        int pairs = salesByMatch.findNumberOfPairs2(socks.length, socks);

        // then
        Assert.assertEquals(3, pairs);
    }

    @Test
    public void timeMeasureTest() {

        int[] arr = generateLargeArray();

        long start = System.currentTimeMillis();
        salesByMatch.findNumberOfPairs1(arr.length, arr);
        long end = System.currentTimeMillis();
        float v1Time = (end - start) / 10000F;

        start = System.currentTimeMillis();
        salesByMatch.findNumberOfPairs2(arr.length, arr);
        end = System.currentTimeMillis();
        float v2Time = (end - start) / 10000F;

        DecimalFormat df = new DecimalFormat("#.##########");

        LOG.info("version1 time " + df.format(v1Time));
        LOG.info("version2 time " + df.format(v2Time));

        Assert.assertTrue(v2Time < v1Time);
    }

    private int[] generateLargeArray() {
        int[] array = new int[32000];

        Random rd = new Random();
        for (int i=0; i<32000; i++) {
            array[i] = rd.nextInt();
        }

        return array;
    }

}
