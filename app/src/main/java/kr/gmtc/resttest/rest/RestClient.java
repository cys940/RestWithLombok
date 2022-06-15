package kr.gmtc.resttest.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.concurrent.TimeUnit;

import kr.gmtc.resttest.model.ht08.equip.Device;
import kr.gmtc.resttest.model.ht08.equip.Ht10;
import kr.gmtc.resttest.model.ht08.equip.MainServer;
import kr.gmtc.resttest.model.ht08.equip.Pbx;
import kr.gmtc.resttest.model.ht08.equip.Phone;
import kr.gmtc.resttest.model.ht08.equip.SnmpDevice;
import kr.gmtc.resttest.model.ht08.equip.VideoRecorder;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static RestClient instance = null;
    private static RestService service = null;
    private String url = "";
    private Retrofit retrofit = null;
    private int connectTimeout = 2;
    private int readTimeout = 3;
    private int writeTimeout = 3;
    private boolean retryConnect = true;
    private String authId = "gmt";
    private String authPw = "gmtvision";

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public RestClient setUrl(String url, int port){
        this.url = url + ":" + port;

        this.url.trim();

        return this;
    }

    public RestClient setReadTimeout(int readTimeout){
        this.readTimeout = readTimeout;

        return this;
    }

    public RestClient setWriteTimeout(int writeTimeout){
        this.writeTimeout = writeTimeout;

        return this;
    }

    public RestClient setRetryConnect(boolean retryConnect){
        this.retryConnect = retryConnect;

        return this;
    }

    public RestClient setAuthId(String authId) {
        this.authId = authId;

        return this;
    }

    public RestClient setAuthPw(String authPw) {
        this.authPw = authPw;

        return this;
    }

    public RestClient setRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        RuntimeTypeAdapterFactory<Device> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(Device.class, "equipType")
                .registerSubtype(MainServer.class,  "MainServer")
                .registerSubtype(Ht10.class,  "HT10")
                .registerSubtype(Phone.class, "Phone")
                .registerSubtype(Device.class, "Device")
                .registerSubtype(VideoRecorder.class, "VideoRecorder")
                .registerSubtype(SnmpDevice.class, "SnmpDevice");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(authId, authPw))
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(retryConnect)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(RestService.class);

        return this;
    }

    public RestService getService() {
        if (service == null)
            return  service = retrofit.create(RestService.class);

        return service;
    }
}
