package com.finaltest;

public class VariantCollection {
    int currentSize;
    int maxSize = 100;
    CovidVariant[] variants;
    public VariantCollection(){
        currentSize = 0;
        variants = new CovidVariant[maxSize];
    }

    // addVariant method
    public void addVariant(CovidVariant v){
        int left = 0;
        int right = currentSize-1;
        while(left<=right){
            int mid = (right+left)/2;
            if (v.code.compareTo(variants[mid].code) == 0 ){
                return;
            }
            else if (v.code.compareTo(variants[mid].code) > 0){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        currentSize++;
        variants[left] = v;

    }

    // search method: average-case: O(logN)
    public CovidVariant search(String code){
        int left = 0;
        int right = currentSize;

        if (code == null || code.length() == 0){
            return null;
        }
        while (left <= right){
            int mid = (left+right)/2;
            int ans = code.compareTo(variants[mid].code);
            if (ans == 0){
                return variants[mid];
            }
            else if (ans > 0){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return null;
    }

    // find previous variant method
    public CovidVariant previous(String code){
        CovidVariant result = null;
        return result;
    }

    public static void main(String[] args){
        VariantCollection col = new VariantCollection();
        col.addVariant(new CovidVariant("Alpha", "210201A"));
//        col.addVariant(new CovidVariant("Delta", "210311D"));
        col.addVariant(new CovidVariant("Omicron", "211120D"));
        col.addVariant(new CovidVariant("Beta", "210311A"));
        System.out.println(col.variants[0]);
        System.out.println(col.variants[1]);
        System.out.println(col.variants[2]);
        System.out.println(col.search("210311A")); // return the Beta variant
//        col.previous("211120D"); // return the Delta variant
//        for (int i=0; i<col.currentSize;i++){
//            System.out.println("Variant " + i);
//            System.out.println(col.variants[i].name);
//            System.out.println(col.variants[i].code);
//        }
    }
}

class CovidVariant {
    String name;
    String code;
    public CovidVariant(){

    }
    public CovidVariant(String name, String code){
        this.name = name;
        this.code = code;
    }
    public String toString(){
        return "name " + this.name + " code " + this.code;
    }
}