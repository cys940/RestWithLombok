package kr.gmtc.resttest.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kr.gmtc.resttest.di.component.ApiComponent;
import kr.gmtc.resttest.model.equip.Device;
import kr.gmtc.resttest.model.equip.Ht10;
import kr.gmtc.resttest.model.equip.MainServer;
import kr.gmtc.resttest.model.equip.Phone;
import kr.gmtc.resttest.model.equip.SnmpDevice;
import kr.gmtc.resttest.model.equip.VideoRecorder;
import kr.gmtc.resttest.rest.AuthInterceptor;
import kr.gmtc.resttest.rest.RestService;
import kr.gmtc.resttest.rest.RuntimeTypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(subcomponents = ApiComponent.class)
public class ApiModule {
    String url;
    int connectTimeout = 2;
    int readTimeout = 3;
    int writeTimeout = 3;
    boolean retryConnect = true;
    String authId = "gmt";
    String authPw = "gmtvision";

    public ApiModule(String url, int connectTimeout, int readTimeout, int writeTimeout, boolean retryConnect, String authId, String authPw) {
        this.url = url;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.retryConnect = retryConnect;
        this.authId = authId;
        this.authPw = authPw;
    }

    @Provides
    @Singleton
    RuntimeTypeAdapterFactory<Device> provideRuntimeTypeAdapterFactory(){
        return RuntimeTypeAdapterFactory.of(Device.class, "equipType")
                .registerSubtype(MainServer.class,  "MainServer")
                .registerSubtype(Ht10.class,  "HT10")
                .registerSubtype(Phone.class, "Phone")
                .registerSubtype(Device.class, "Device")
                .registerSubtype(VideoRecorder.class, "VideoRecorder")
                .registerSubtype(SnmpDevice.class, "SnmpDevice");
    }

    @Provides
    @Singleton
    Gson provideGson(RuntimeTypeAdapterFactory<Device> factory) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyyMMdd HH:mm:ss")
                .registerTypeAdapterFactory(factory);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(authId, authPw))
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(retryConnect)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS);

        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    RestService provideService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }
}
