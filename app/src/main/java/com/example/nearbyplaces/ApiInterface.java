package com.example.nearbyplaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public interface ApiInterface {

    @GET("place/nearbysearch/json?")
    Call<PlacesPOJO.Root> doPlaces(@Query(value = "type", encoded = true)
                                           String type,
                                   @Query(value = "location", encoded = true)
                                           String location,
                                   @Query(value = "name", encoded = true)
                                           String name,
                                   @Query(value = "opennow", encoded = true)
                                           boolean opennow,
                                   @Query(value = "rankby", encoded = true)
                                           String rankby,
                                   @Query(value = "key", encoded = true)
                                           String key);


    Call<ResultDistanceMatrix> getDistance(@Query("key")
                                                   String key,
                                           @Query("origins")
                                                   String origins,
                                           @Query("destinations")
                                                   String destinations);

}
