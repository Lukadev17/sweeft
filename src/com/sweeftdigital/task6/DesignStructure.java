package com.sweeftdigital.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DesignStructure {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

    public void add(int x) {
        if (hash.get(x) != null)
            return;
        int s = arr.size();
        arr.add(x);
        hash.put(x, s);
    }

    public void remove(int x){
        Integer index = hash.get(x);
        if (index == null)
            return;
        hash.remove(x);

        int size = arr.size();
        Integer last = arr.get(size - 1);
        Collections.swap(arr, index,size - 1);
        arr.remove(size - 1);
        hash.put(last, index);
    }
}
