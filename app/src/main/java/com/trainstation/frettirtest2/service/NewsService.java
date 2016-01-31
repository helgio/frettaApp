package com.trainstation.frettirtest2.service;

import com.trainstation.frettirtest2.responses.NewsResponse;

import retrofit.http.GET;
import rx.Observable;


/**
 * Created by Helgi on 23/01/16.
 */
public interface NewsService
{
    @GET("/search?term=beyonce&entity=musicVideo")
    Observable<NewsResponse> getNewsData();
}
