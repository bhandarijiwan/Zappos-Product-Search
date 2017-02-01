/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Challenge.Zappos.products;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.Challenge.Zappos.R;


/**
 * Demonstration of the implementation of a custom Loader.
 */
public class ProductListActivity extends AppCompatActivity {

    private final static String TAG = "ProductListActivity";

    private ProductsPresenter mProductsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ProductListFragment productListFragment= (ProductListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(productListFragment==null){
            Log.e(TAG,"Fragment Recreated!!!!");
            productListFragment = new ProductListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame,productListFragment).commit();
        }
        mProductsPresenter = new ProductsPresenter(getSupportLoaderManager(),productListFragment,this);

    }
}