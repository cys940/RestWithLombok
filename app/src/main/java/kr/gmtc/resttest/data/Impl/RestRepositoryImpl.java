package kr.gmtc.resttest.data.Impl;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;
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
import kr.gmtc.resttest.model.whale.WhaleSafe;
import kr.gmtc.resttest.rest.RestClient;
import kr.gmtc.resttest.rest.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestRepositoryImpl implements RestRepository {
    private static final String TAG = "RestRepository";

    private RestService service;

    public RestRepositoryImpl() {
        service = RestClient.getInstance()
                .setUrl("http://192.168.12.211", 8083)
                .setAuthId("gmt")
                .setAuthPw("gmtvision")
                .setReadTimeout(3)
                .setWriteTimeout(3)
                .setRetryConnect(true)
                .setRetrofit().getService();
    }

    @Override
    public LiveData<List<Device>> getAllDevices() {
        retrofit2.Call<List<Device>> call = service.getAllDevices();

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
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<Cctv>> getAllCctvs() {
        retrofit2.Call<List<Cctv>> call = service.getAllCctvs();

        call.enqueue(new Callback<List<Cctv>>() {
            @Override
            public void onResponse(Call<List<Cctv>> call, Response<List<Cctv>> response) {
                if (response.isSuccessful()) {
                    for (Cctv cctv : response.body()) {
                        Log.d(TAG, cctv.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Cctv>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<SystemConfig> getSystemConfig() {
        retrofit2.Call<SystemConfig> call = service.getSystemConfig();

        call.enqueue(new Callback<SystemConfig>() {
            @Override
            public void onResponse(Call<SystemConfig> call, Response<SystemConfig> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<SystemConfig> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<User>> getAllUsers() {
        retrofit2.Call<List<User>> call = service.getAllUsers();

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
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<User> getUser(String userId) {
        retrofit2.Call<User> call = service.getUser(userId);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<Favorite>> getFavorite(String userId) {
        retrofit2.Call<List<Favorite>> call = service.getFavorite(userId);

        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if (response.isSuccessful()) {
                    for (Favorite favorite : response.body()) {
                        Log.d(TAG, favorite.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<Favorite>> updateFavorite(String userId, List<Favorite> update) {
        return null;
    }

    @Override
    public LiveData<List<Favorite>> deleteFavorite(String userId, int id) {
        retrofit2.Call<List<Favorite>> call = service.deleteFavorite(userId, id);

        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if (response.isSuccessful()) {
                    for (Favorite favorite : response.body()) {
                        Log.d(TAG, favorite.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public LiveData<List<Group>> getGroupsByGet(String userId) {
        retrofit2.Call<List<Group>> call = service.getGroupsByGet(userId);

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
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public LiveData<List<Group>> getGroupsByPost(String userId, List<Group> groups) {
        retrofit2.Call<List<Group>> call = service.getGroupsByPost(userId, groups);

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
                Log.d(TAG, t.getMessage());
            }
        });


        return null;
    }

    @Override
    public LiveData<List<Group>> deleteGroups(String userId, String groupId) {
        retrofit2.Call<List<Group>> call = service.deleteGroups(userId, groupId);

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
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public LiveData<List<Group>> updateGroups(String userId) {
        retrofit2.Call<List<Group>> call = service.updateGroups(userId);

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
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<MyInfo> getMyInfo(String userId) {
        retrofit2.Call<MyInfo> call = service.getMyInfo(userId);

        call.enqueue(new Callback<MyInfo>() {
            @Override
            public void onResponse(Call<MyInfo> call, Response<MyInfo> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MyInfo> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<WhaleSafe>> getWhaleSafeByGet() {
        retrofit2.Call<List<WhaleSafe>> call = service.getWhaleSafeByGet();

        call.enqueue(new Callback<List<WhaleSafe>>() {
            @Override
            public void onResponse(Call<List<WhaleSafe>> call, Response<List<WhaleSafe>> response) {
                if (response.isSuccessful()) {
                    for (WhaleSafe whaleSafe : response.body()) {
                        Log.d(TAG, whaleSafe.toString());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<WhaleSafe>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<WhaleSafe>> getWhaleSafeByPost(List<WhaleSafe> body) {
        retrofit2.Call<List<WhaleSafe>> call = service.getWhaleSafeByPost(body);

        call.enqueue(new Callback<List<WhaleSafe>>() {
            @Override
            public void onResponse(Call<List<WhaleSafe>> call, Response<List<WhaleSafe>> response) {
                if (response.isSuccessful()) {
                    for (WhaleSafe whaleSafe : response.body())
                        Log.d(TAG, whaleSafe.toString());
                }
            }

            @Override
            public void onFailure(Call<List<WhaleSafe>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }

    @Override
    public LiveData<List<Schedule>> getSchedules(String userId) {
        retrofit2.Call<List<Schedule>> call = service.getSchedules(userId);

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
                Log.d(TAG, t.toString());
            }
        });
        return null;
    }

    @Override
    public LiveData<UserConfig> getUserConfigByGet(String userId) {
        retrofit2.Call<UserConfig> call = service.getUserConfigByGet(userId);

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
        return null;
    }

    @Override
    public LiveData<UserConfig> getUserConfigByPost(String userId, UserConfig userConfig) {
        retrofit2.Call<UserConfig> call = service.getUserConfigByPost(userId, userConfig);

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
        return null;
    }

    @Override
    public LiveData<List<UserAuth>> getUserAuths(String userId) {
        retrofit2.Call<List<UserAuth>> call = service.getUserAuths(userId);

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
        return null;
    }
}
