package com.finaltest;

public class VariantCollection {
    int currentSize;
    int maxSize = 100;
    CovidVariant[] variants;
    public VariantCollection(){
        currentSize = 0;
        variants = new CovidVariant[maxSize];
    }

    public int findIdx(String code){
        int left = 0;
        int right = currentSize-1;
        while(left<=right){
            int mid = (right+left)/2;
            if (code.compareTo(variants[mid].code) == 0 ){
                return mid;
            }
            else if (code.compareTo(variants[mid].code) > 0){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }

    // addVariant method: insertion sort O(nlogn) for worst case -> O(logn) for average case
    public void addVariant(CovidVariant v){
        int idx = findIdx(v.code);
        for (int i = currentSize-1; i>=idx; i--){
            variants[i+1] = variants[i];
        }
        currentSize++;
        variants[idx] = v;
    }

    // search method: average-case: O(logN)
    public CovidVariant search(String code){
        int left = 0;
        int right = currentSize-1;

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
        int idx = findIdx(code);
//        System.out.println(idx);
        return variants[idx-1];
    }

    private void display(){
        for (int i=0; i<currentSize;i++){
            System.out.println("Variant " + i);
            System.out.println(variants[i].name);
            System.out.println(variants[i].code);
        }
    }

    public static void main(String[] args){
        VariantCollection col = new VariantCollection();
        col.addVariant(new CovidVariant("Alpha", "210201A"));
        col.addVariant(new CovidVariant("Delta", "210311D"));
        col.addVariant(new CovidVariant("Omicron", "211120D"));
        col.addVariant(new CovidVariant("Beta", "210311A"));
        col.addVariant(new CovidVariant("Gamma", "210511A"));
        col.display();
        System.out.println("Result found: "+col.search("211120D")); // return the Beta variant
        System.out.println(col.previous("211120D")); // return the Delta variant

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