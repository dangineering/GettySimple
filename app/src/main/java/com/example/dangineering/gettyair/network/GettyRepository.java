package com.example.dangineering.gettyair.network;

import com.example.dangineering.gettyair.network.respmodel.Resp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GettyRepository {

    public interface ApiService {

        @GET("search/images")
        Call<Resp> search(@Query("phrase") String food);

    }

    // create retrofit object with intercepter
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.gettyimages.com/v3/")
            .client(new OkHttpClient().newBuilder()
                    .addInterceptor(new LoggingInterceptor())
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();

                            Request.Builder requestBuilder = original.newBuilder()
                                    .header("Api-Key", "");

                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                    })
                    .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    /**
     * Schema to pojo settings:
     *
     * JSON
     * GSON
     *
     * double
     * getters and setters
     * constructors
     * additional properties
     */


}
