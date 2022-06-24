package kr.gmtc.resttest.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.components.SingletonComponent;
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

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    private @interface AuthInterceptorImpl {

    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    private @interface LoggingInterceptorImpl {

    }

    @Provides
    @Singleton
    @Named("runtimeFactoryProvides")
    public static RuntimeTypeAdapterFactory<Device> provideRuntimeFactory() {
        return  RuntimeTypeAdapterFactory.of(Device.class, "equipType")
                .registerSubtype(MainServer.class,  "MainServer")
                .registerSubtype(Ht10.class,  "HT10")
                .registerSubtype(Phone.class, "Phone")
                .registerSubtype(Device.class, "Device")
                .registerSubtype(VideoRecorder.class, "VideoRecorder")
                .registerSubtype(SnmpDevice.class, "SnmpDevice");
    }

    @Provides
    @Singleton
    @Named("gsonProvides")
    public static Gson provideGson(RuntimeTypeAdapterFactory<Device> runtimeTypeAdapterFactory) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create();
    }

    @Provides
    @Singleton
    @AuthInterceptorImpl
    public static HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    @LoggingInterceptorImpl
    public static AuthInterceptor provideAuthInterceptor() {
        return new AuthInterceptor("gmt", "gmtvision");
    }

    @Provides
    @Singleton
    @Named("OkHttpClientProvides")
    public static OkHttpClient provideOkHttp(
            @LoggingInterceptorImpl HttpLoggingInterceptor loggingInterceptor,
            @LoggingInterceptorImpl AuthInterceptor authInterceptor
    ) {
        return new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @Named("RetrofitProvides")
    public static Retrofit provideRetrofit(
            OkHttpClient client,
            Gson gson
    ) {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.12.211:8083")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    @Named("RestServiceProvides")
    public static RestService provideRestService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }
}
