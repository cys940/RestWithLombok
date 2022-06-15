package kr.gmtc.resttest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import kr.gmtc.resttest.model.ht08.cctv.Cctv;
import kr.gmtc.resttest.model.ht08.cfg.SystemConfig;
import kr.gmtc.resttest.model.ht08.equip.Device;
import kr.gmtc.resttest.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestClient client = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit();

        getAllDevices(client);
    }

    private void getAllDevices(RestClient client){
        retrofit2.Call<List<Device>> call = client.getService().getAllDevices();

        call.enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                if (response.isSuccessful()) {
                    for (Device allDevice : response.body()){
                        Log.d("TAG", allDevice.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getAllCctvs(RestClient client){
        retrofit2.Call<List<Cctv>> call = client.getService().getAllCctvs();

        call.enqueue(new Callback<List<Cctv>>() {
            @Override
            public void onResponse(Call<List<Cctv>> call, Response<List<Cctv>> response) {
                if (response.isSuccessful()) {
                    for (Cctv cctv : response.body()){
                        Log.d("TAG", cctv.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Cctv>> call, Throwable t) {

            }
        });
    }

    private void getSystemConfig(RestClient client){
        retrofit2.Call<SystemConfig> call = client.getService().getSystemConfig();

        call.enqueue(new Callback<SystemConfig>() {
            @Override
            public void onResponse(Call<SystemConfig> call, Response<SystemConfig> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<SystemConfig> call, Throwable t) {

            }
        });
    }
}