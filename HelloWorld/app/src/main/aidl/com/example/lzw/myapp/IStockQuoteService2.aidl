// IStockQuoteService2.aidl
package com.example.lzw.myapp;
import com.example.lzw.myapp.Person;
// Declare any non-default types here with import statements

interface IStockQuoteService2 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String getQuote(in String ticker,in Person requester);
}
