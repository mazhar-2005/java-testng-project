package org.trianz.eagleaccess.tests.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class collections {
    public static void main(String args[])
    {
        /*Map<Integer,String> m = new HashMap<Integer,String>();
            m.put(1,"John");
            m.put(2,"Jaani");
            m.put(3,"Janaardhan");
            for(Map.Entry map:m.entrySet()){
                System.out.println(map.getKey()+"-"+map.getValue());
            }*/
        //Array List
        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        System.out.println("ArrayList: " +fruits);
        //Hashmap
        HashMap <String,String> fruitsWeight =new HashMap<String,String>();
        fruitsWeight.put("Apples","20Kg");
        fruitsWeight.put("Oranges","10Kg");
        System.out.println("HasMap: " +fruitsWeight);
        System.out.println("HasMap get(): " +fruitsWeight.get("Apples"));
        HashMap<String,String> fruitsPrice = new HashMap<String,String>();
        fruitsPrice.put("Apples","100rs");
        fruitsPrice.put("Oranges","200rs");
        //List Map
        List<HashMap> fruitsInfo = new ArrayList<HashMap>();
        fruitsInfo.add(fruitsWeight);
        fruitsInfo.add(fruitsPrice);
        System.out.println("List Map: "+fruitsInfo);
        //
    }
}
