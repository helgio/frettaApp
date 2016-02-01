package com.trainstation.frettirtest2.service;

import com.trainstation.frettirtest2.responses.NewsResponse;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


/**
 * Created by Helgi on 23/01/16.
 */
public interface NewsService
{
    @GET("/search")
    Observable<NewsResponse> getNewsData(@Query("term") String termSearch,
                                         @Query("entity") String entitySearch);
}
