package kr.gmtc.resttest.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kr.gmtc.resttest.data.RestRepository;
import kr.gmtc.resttest.model.cctv.Cctv;
import kr.gmtc.resttest.model.cfg.SystemConfig;
import kr.gmtc.resttest.model.equip.Device;
import kr.gmtc.resttest.model.info.MyInfo;
import kr.gmtc.resttest.model.info.auth.UserAuth;
import kr.gmtc.resttest.model.info.config.UserConfig;
import kr.gmtc.resttest.model.info.favorite.Favorite;
import kr.gmtc.resttest.model.info.group.Group;
import kr.gmtc.resttest.model.info.schedule.Schedule;
import kr.gmtc.resttest.model.user.User;
import kr.gmtc.resttest.model.whale.SafeProperty;
import kr.gmtc.resttest.model.whale.WhaleSafe;
import kr.gmtc.resttest.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@HiltViewModel
public class RestViewModel extends ViewModel {
    private static final String TAG = "RestViewModel";
    @Inject RestRepository repository;

    @Inject
    public RestViewModel(){

    }

    private MutableLiveData<List<String>> list;
    public LiveData<List<String>> getAll() {
        if (list == null) {
            list = new MutableLiveData<List<String>>();
            fetch();
        }
        return list;
    }

    private MutableLiveData<String> log = new MutableLiveData<>();
    public LiveData<String> getCurrentLog() {
        if (log == null) {
            log = new MutableLiveData<String>();
        }
        return log;
    }

    private MutableLiveData<List<Device>> devices = new MutableLiveData<>();
    public LiveData<List<Device>> getDevices() {
        if (devices == null) {
            devices = new MutableLiveData<List<Device>>();
        }
        return devices;
    }

    private MutableLiveData<List<Favorite>> _Favorites = new MutableLiveData<>();
    public LiveData<List<Favorite>> getFavorites() {
        if (_Favorites == null) {
            _Favorites = new MutableLiveData<List<Favorite>>();
        }
        return _Favorites;
    }

    private MutableLiveData<List<WhaleSafe>> _whaleSafes = new MutableLiveData<>();
    public LiveData<List<WhaleSafe>> getWhaleSafes() {
        if (_whaleSafes == null) {
            _whaleSafes = new MutableLiveData<List<WhaleSafe>>();
        }
        return _whaleSafes;
    }

    private MutableLiveData<UserConfig> _userConfig = new MutableLiveData<>();
    public LiveData<UserConfig> getUserConfig() {
        if (_userConfig == null) {
            _userConfig = new MutableLiveData<UserConfig>();
        }
        return _userConfig;
    }

    private MutableLiveData<List<Group>> _groups = new MutableLiveData<>();
    public LiveData<List<Group>> getGroups() {
        if (_groups == null) {
            _groups = new MutableLiveData<List<Group>>();
        }
        return _groups;
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
        samples.add("getGroupsByGet");
        samples.add("getGroupsByPost");
        samples.add("deleteGroups");
        samples.add("updateGroups");
        samples.add("getMyInfo");
        samples.add("getWhaleSafeByGet");
        samples.add("getWhaleSafeByPost");
        samples.add("getSchedules");
        samples.add("getUserConfigByGet");
        samples.add("getUserConfigByPost");
        samples.add("getUserAuths");

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
                        .id(null)
                        .userId("003")
                        .destType(0)
                        .destId("219")
                        .build());
                break;
            case "deleteFavorite":
                deleteFavorite("003", 18);
                break;
            case "getGroupsByGet":
                getGroupsByGet("003");
                break;
            case "getGroupsByPost":
                getGroupsByPost("003", null);
                break;
            case "deleteGroups":
                deleteGroups("003", "1093");
                break;
            case "updateGroups":
                updateGroups("003");
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
            case "getSchedules":
                getSchedules("003");
                break;
            case "getUserConfigByGet":
                getUserConfigByGet("003");
                break;
            case "getUserConfigByPost":
                getUserConfigByPost("003", null);
                break;
            case "getUserAuths":
                getUserAuths("003");
                break;
        }
    }

    private void getUserAuths(String userId) {
        retrofit2.Call<List<UserAuth>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getUserAuths(userId);

        call.enqueue(new Callback<List<UserAuth>>() {
            @Override
            public void onResponse(Call<List<UserAuth>> call, Response<List<UserAuth>> response) {
                if (response.isSuccessful()) {
                    for (UserAuth auth : response.body()){
                        Log.d(TAG, auth.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserAuth>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    private void getUserConfigByGet(String userId) {
        retrofit2.Call<UserConfig> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getUserConfigByGet(userId);

        call.enqueue(new Callback<UserConfig>() {
            @Override
            public void onResponse(Call<UserConfig> call, Response<UserConfig> response) {
                if (response.isSuccessful()) {
                    _userConfig.setValue( response.body());
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<UserConfig> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    private void getUserConfigByPost(String userId, UserConfig userConfig) {
        UserConfig _userConfig = getUserConfig().getValue();
        _userConfig.setDateType(0);

        retrofit2.Call<UserConfig> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getUserConfigByPost(userId, _userConfig);

        call.enqueue(new Callback<UserConfig>() {
            @Override
            public void onResponse(Call<UserConfig> call, Response<UserConfig> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<UserConfig> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    private void getSchedules(String userId) {
        retrofit2.Call<List<Schedule>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getSchedules(userId);

        call.enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                if (response.isSuccessful()) {
                    for (Schedule schedule : response.body())
                        Log.d(TAG, schedule.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    private void updateGroups(String userId) {
        retrofit2.Call<List<Group>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .updateGroups(userId);

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

    private void deleteGroups(String userId, String groupId) {
        retrofit2.Call<List<Group>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .deleteGroups(userId, groupId);

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

    private void getGroupsByPost(String userId, List<Group> groups) {
        List<Group> list = getGroups().getValue();

        retrofit2.Call<List<Group>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getGroupsByPost(userId, list);

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
        retrofit2.Call<List<Favorite>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getFavorite(userId);

        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());

                    _Favorites.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void updateFavorite(String userId, Favorite update) {
        List<Favorite> favorites = getFavorites().getValue();
        favorites.add(update);

        retrofit2.Call<List<Favorite>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .updateFavorite(userId, favorites);

        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void deleteFavorite(String userId, int id) {
        retrofit2.Call<List<Favorite>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .deleteFavorite(userId, id);

        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                log.setValue(t.getMessage());
            }
        });
    }

    public void getGroupsByGet(String userId) {
        retrofit2.Call<List<Group>> call = RestClient.getInstance()
                .setUrl("http://192.168.12.10", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit()
                .getService()
                .getGroupsByGet(userId);

        call.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                if (response.isSuccessful()) {
                    _groups.setValue(response.body());

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
                .setUrl("http://192.168.12.10", 8083)
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
