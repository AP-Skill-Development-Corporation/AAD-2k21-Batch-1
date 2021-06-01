package com.example.covid19reports;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Retrofit_API_Instance {
    /*home->https://api.covid19api.com/
    end point url-->dayone/country/IN*/

    public static final String BASE_URL="https://api.covid19api.com/dayone/country/IN";
static Retrofit retrofit;
public Retrofit getInstance(){
    if (retrofit==null){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
    return  retrofit;
}
}
