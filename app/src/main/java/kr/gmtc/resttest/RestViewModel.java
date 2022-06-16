package kr.gmtc.resttest;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kr.gmtc.resttest.model.ht08.cctv.Cctv;
import kr.gmtc.resttest.model.ht08.cfg.SystemConfig;
import kr.gmtc.resttest.model.ht08.equip.Device;
import kr.gmtc.resttest.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestViewModel extends ViewModel {
    private MutableLiveData<List<String>> list;
    public LiveData<List<String>> getAll() {
        if (list == null) {
            list = new MutableLiveData<List<String>>();
            fetch();
        }
        return list;
    }

    private MutableLiveData<String> log;
    public LiveData<String> getCurrentLog() {
        if (log == null) {
            log = new MutableLiveData<String>();
        }
        return log;
    }

    private void fetch(){
        List<String> samples = new ArrayList<>();
        samples.add("getAllDevices");
        samples.add("getAllCctvs");
        samples.add("getSystemConfig");

        list.setValue(samples);
    }

    public void request(String request){
        switch (request) {
            case "getAllDevices" : getAllDevices();
            case "getAllCctvs" : getAllCctvs();
            case "getSystemConfig" : getSystemConfig();
        }
    }

    private void getAllDevices(){
        retrofit2.Call<List<Device>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getAllDevices();

        call.enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                if (response.isSuccessful()) {
                    for (Device allDevice : response.body()){
                        log.setValue(allDevice.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                log.setValue(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void getAllCctvs(){
        retrofit2.Call<List<Cctv>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getAllCctvs();

        call.enqueue(new Callback<List<Cctv>>() {
            @Override
            public void onResponse(Call<List<Cctv>> call, Response<List<Cctv>> response) {
                if (response.isSuccessful()) {
                    for (Cctv cctv : response.body()){
                        log.setValue(cctv.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Cctv>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    private void getSystemConfig(){
        retrofit2.Call<SystemConfig> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getSystemConfig();

        call.enqueue(new Callback<SystemConfig>() {
            @Override
            public void onResponse(Call<SystemConfig> call, Response<SystemConfig> response) {
                if (response.isSuccessful()) {
                    log.setValue(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<SystemConfig> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }
}
