package Spring.Framework;



import Arrays.CyclicSort.SortAnArray;
import Arrays.SengmentTree.BasicST;
import Arrays.SengmentTree.RangeSumWithLazyUpdates;
import Arrays.SengmentTree.STLCM;
import Arrays.SengmentTree.WhatInIdx;
import Arrays.SparseTable.RangeSum;
import Arrays.SparseTable.minSum;
import Graphs.printBridges;
import JavaPractice.LeanStrings;

import java.util.*;



public class Main {

    public static void main(String args[]) {
        int[] arr = {8,11,19,22};
        RangeSumWithLazyUpdates rs = new RangeSumWithLazyUpdates(arr);
        rs.update(0,3,1);
        rs.update(2,3,2);
        var x =rs.RangeSum(0,1);

    }



   
    }














