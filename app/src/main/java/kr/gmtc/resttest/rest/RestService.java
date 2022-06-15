package kr.gmtc.resttest.rest;


import java.util.List;

import kr.gmtc.resttest.model.ht08.cctv.Cctv;
import kr.gmtc.resttest.model.ht08.cfg.SystemConfig;
import kr.gmtc.resttest.model.ht08.equip.Device;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {
    @GET("iscs/devices")
    Call<List<Device>> getAllDevices();

    @GET("iscs/devices/cctvs")
    Call<List<Cctv>> getAllCctvs();

    @GET("iscs/systemconfig")
    Call<SystemConfig> getSystemConfig();
}
