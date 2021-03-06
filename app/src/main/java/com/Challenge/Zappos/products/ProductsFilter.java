package com.Challenge.Zappos.products;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by jiwanbhandari on 1/31/17.
 */

public class ProductsFilter {

    private static final String TAG= "ProductsFilter";

    public HashMap<String,String> filterList;

    /**
     * If add "key", and "..." pair by default to the filter.
     */
    private ProductsFilter() {
        filterList = new HashMap<String,String>();
        filterName ="key";
        filterValue="b743e26728e16b81da139182bb2094357c31d331";
        filterList.put(filterName,filterValue);
    }

    private final String filterName;

    private final String filterValue;

    /**
     * Called to make a filter, with aribitary key value pairs.
     * @param filters key value pairs
     * @return Filter that will be ultimately supplied to retrofit.
     */

    public static ProductsFilter createNewFilter(String...filters){

        ProductsFilter productsFilter= new ProductsFilter();
        int i =1;
        String prev="";
        for(String s : filters) {
            if (i++ % 2 == 0)
                productsFilter.filterList.put(prev, s);
            prev=s;
        }
        return productsFilter;
    }


}
