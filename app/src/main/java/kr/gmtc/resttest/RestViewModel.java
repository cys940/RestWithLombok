package kr.gmtc.resttest;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import kr.gmtc.resttest.model.cctv.Cctv;
import kr.gmtc.resttest.model.cfg.SystemConfig;
import kr.gmtc.resttest.model.equip.Device;
import kr.gmtc.resttest.model.info.MyInfo;
import kr.gmtc.resttest.model.info.favorite.Favorite;
import kr.gmtc.resttest.model.info.group.Group;
import kr.gmtc.resttest.model.user.User;
import kr.gmtc.resttest.model.whale.SafeProperty;
import kr.gmtc.resttest.model.whale.WhaleSafe;
import kr.gmtc.resttest.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
public class RestViewModel extends ViewModel {
    private static final String TAG = "RestViewModel";

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

    private MutableLiveData<List<Device>> devices;
    public LiveData<List<Device>> getDevices() {
        if (devices == null) {
            devices = new MutableLiveData<List<Device>>();
        }
        return devices;
    }

    private MutableLiveData<List<WhaleSafe>> _whaleSafes = new MutableLiveData<>();
    public LiveData<List<WhaleSafe>> getWhaleSafes() {
        if (_whaleSafes == null) {
            _whaleSafes = new MutableLiveData<List<WhaleSafe>>();
        }
        return _whaleSafes;
    }

    private void fetch() {
        List<String> samples = new ArrayList<>();
        samples.add("getAllDevices");
        samples.add("getAllCctvs");
        samples.add("getSystemConfig");
        samples.add("getAllUsers");
        samples.add("getUser");
        samples.add("getFavorite");
        samples.add("updateFavorite");
        samples.add("deleteFavorite");
        samples.add("getAllGroups");
        samples.add("getMyInfo");
        samples.add("getWhaleSafeByGet");
        samples.add("getWhaleSafeByPost");

        list.setValue(samples);
    }

    public void request(String request) {
        switch (request) {
            case "getAllDevices":
                getAllDevices();
                break;
            case "getAllCctvs":
                getAllCctvs();
                break;
            case "getSystemConfig":
                getSystemConfig();
                break;
            case "getAllUsers":
                getAllUsers();
                break;
            case "getUser":
                getUser("003");
                break;
            case "getFavorite":
                getFavorite("003");
                break;
            case "updateFavorite":
                updateFavorite("003", Favorite.builder()
                        .id(11)
                        .userId("003")
                        .destType(0)
                        .destId("218")
                        .build());
                break;
            case "deleteFavorite":
                deleteFavorite("003", 1);
                break;
            case "getAllGroups":
                getAllGroups("003");
                break;
            case "getMyInfo":
                getMyInfo("003");
                break;
            case "getWhaleSafeByGet":
                getWhaleSafeByGet();
                break;
            case "getWhaleSafeByPost":
                getWhaleSafeByPost();
                break;
        }
    }

    private void getAllDevices() {
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
                    for (Device allDevice : response.body()) {
                        Log.d(TAG, allDevice.toString());
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

    private void getAllCctvs() {
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
                    for (Cctv cctv : response.body()) {
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

    private void getSystemConfig() {
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

    public void getAllUsers() {
        retrofit2.Call<List<User>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getAllUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    for (User user : response.body()) {
                        Log.d(TAG, user.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getUser(String userId) {
        retrofit2.Call<User> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getUser(userId);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getFavorite(String userId) {
        retrofit2.Call<Favorite> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getFavorite(userId);

        call.enqueue(new Callback<Favorite>() {
            @Override
            public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Favorite> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void updateFavorite(String userId, Favorite update) {
        retrofit2.Call<Favorite> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .updateFavorite(userId, update);

        call.enqueue(new Callback<Favorite>() {
            @Override
            public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Favorite> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void deleteFavorite(String userId, int id) {
        retrofit2.Call<Favorite> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .deleteFavorite(userId, id);

        call.enqueue(new Callback<Favorite>() {
            @Override
            public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Favorite> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getAllGroups(String userId) {
        retrofit2.Call<List<Group>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getAllGroups(userId);

        call.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                if (response.isSuccessful()) {
                   for (Group group : response.body())
                       Log.d(TAG, group.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getMyInfo(String userId) {
        retrofit2.Call<MyInfo> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getMyInfo(userId);

        call.enqueue(new Callback<MyInfo>() {
            @Override
            public void onResponse(Call<MyInfo> call, Response<MyInfo> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MyInfo> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getWhaleSafeByGet() {
        retrofit2.Call<List<WhaleSafe>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getWhaleSafeByGet();

        call.enqueue(new Callback<List<WhaleSafe>>() {
            @Override
            public void onResponse(Call<List<WhaleSafe>> call, Response<List<WhaleSafe>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                    _whaleSafes.setValue(response.body());
                } else {
                    Log.d(TAG, "failed");
                }
            }

            @Override
            public void onFailure(Call<List<WhaleSafe>> call, Throwable t) {
                log.setValue(t.getMessage());
                Log.d(TAG, "faild : " + t.getMessage());
            }
        });
    }

    public void getWhaleSafeByPost() {
        List<WhaleSafe> list = _whaleSafes.getValue();

        if (list == null)
            return;

        for (WhaleSafe whaleSafe : list) {
            whaleSafe.setId(null);
            for (SafeProperty property: whaleSafe.getProperties()) {
                property.setId(null);
            }
        }

        retrofit2.Call<List<WhaleSafe>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getWhaleSafeByPost(list);

        call.enqueue(new Callback<List<WhaleSafe>>() {
            @Override
            public void onResponse(Call<List<WhaleSafe>> call, Response<List<WhaleSafe>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<WhaleSafe>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }
}
