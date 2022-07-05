package kr.gmtc.resttest.data.Impl;

import android.util.Log;


import java.util.List;

import kr.gmtc.resttest.data.RestRepository;
import kr.gmtc.resttest.model.iscs.carte.MealPlan;
import kr.gmtc.resttest.model.iscs.cctv.Cctv;
import kr.gmtc.resttest.model.iscs.cfg.SystemConfig;
import kr.gmtc.resttest.model.iscs.channel.ChannelEquip;
import kr.gmtc.resttest.model.iscs.code.Code;
import kr.gmtc.resttest.model.iscs.equip.Device;
import kr.gmtc.resttest.model.iscs.info.MyInfo;
import kr.gmtc.resttest.model.iscs.info.alarm.Alarm;
import kr.gmtc.resttest.model.iscs.info.auth.UserAuth;
import kr.gmtc.resttest.model.iscs.info.config.UserConfig;
import kr.gmtc.resttest.model.iscs.info.favorite.Favorite;
import kr.gmtc.resttest.model.iscs.info.group.Group;
import kr.gmtc.resttest.model.iscs.info.schedule.Schedule;
import kr.gmtc.resttest.model.iscs.iss.IssInfo;
import kr.gmtc.resttest.model.iscs.user.User;
import kr.gmtc.resttest.model.iscs.whale.WhaleSafe;
import kr.gmtc.resttest.model.iss.IssRoute;
import kr.gmtc.resttest.model.iss.Job;
import kr.gmtc.resttest.model.iss.TankSlosh;
import kr.gmtc.resttest.data.remote.RestClient;
import kr.gmtc.resttest.data.remote.RestService;
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
                .setRetrofit()
                .getService();
    }

    @Override
    public List<Device> getAllDevices() {
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
    public List<Cctv> getAllCctvs() {
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
    public SystemConfig getSystemConfig() {
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
    public List<User> getAllUsers() {
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
    public User getUserByGet(String userId) {
        retrofit2.Call<User> call = service.getUserByGet(userId);

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
    public User getUserByPost(String userId, User user) {
        retrofit2.Call<User> call = service.getUserByPost(userId, user);

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
    public List<Favorite> getFavorite(String userId) {
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
    public List<Favorite> updateFavorite(String userId, Favorite update) {
        retrofit2.Call<List<Favorite>> call = service.updateFavorite(userId, update);

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
    public List<Favorite> deleteFavorite(String userId, int id) {
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
    public List<Group> getGroupsByGet(String userId) {
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
    public List<Group> getGroupsByPost(String userId, List<Group> groups) {
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
    public List<Group> deleteGroups(String userId, String groupId) {
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
    public List<Group> updateGroups(String userId, Group updateGroup) {
        retrofit2.Call<List<Group>> call = service.updateGroups(userId, updateGroup);

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
    public MyInfo getMyInfo(String userId) {
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
    public List<WhaleSafe> getWhaleSafeByGet() {
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
    public List<WhaleSafe> getWhaleSafeByPost(List<WhaleSafe> updateList) {
        retrofit2.Call<List<WhaleSafe>> call = service.getWhaleSafeByPost(updateList);

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
    public List<Schedule> getSchedules(String userId) {
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
    public UserConfig getUserConfigByGet(String userId) {
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
    public UserConfig getUserConfigByPost(String userId, UserConfig userConfig) {
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
    public List<UserAuth> getUserAuths(String userId) {
        retrofit2.Call<List<UserAuth>> call = service.getUserAuths(userId);

        call.enqueue(new Callback<List<UserAuth>>() {
            @Override
            public void onResponse(Call<List<UserAuth>> call, Response<List<UserAuth>> response) {
                if (response.isSuccessful()) {
                    for (UserAuth auth : response.body()) {
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

    @Override
    public List<Code> getCodes() {
        retrofit2.Call<List<Code>> call = service.getCodes();

        call.enqueue(new Callback<List<Code>>() {
            @Override
            public void onResponse(Call<List<Code>> call, Response<List<Code>> response) {
                if (response.isSuccessful()) {
                    for (Code code : response.body()) {
                        Log.d(TAG, code.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Code>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<Alarm> getAlarms(String userId, int page, int pageSize) {
        retrofit2.Call<List<Alarm>> call = service.getAlarms(userId, page, pageSize);

        call.enqueue(new Callback<List<Alarm>>() {
            @Override
            public void onResponse(Call<List<Alarm>> call, Response<List<Alarm>> response) {
                if (response.isSuccessful()) {
                    for (Alarm alarm : response.body()) {
                        Log.d(TAG, alarm.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Alarm>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<Alarm> getReadAlarms(String userId) {
        retrofit2.Call<List<Alarm>> call = service.getReadAlarms(userId);

        call.enqueue(new Callback<List<Alarm>>() {
            @Override
            public void onResponse(Call<List<Alarm>> call, Response<List<Alarm>> response) {
                if (response.isSuccessful()) {
                    for (Alarm alarm : response.body()) {
                        Log.d(TAG, alarm.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Alarm>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<IssInfo> getLastInfoByGet() {
        retrofit2.Call<List<IssInfo>> call = service.getLastInfoByGet();

        call.enqueue(new Callback<List<IssInfo>>() {
            @Override
            public void onResponse(Call<List<IssInfo>> call, Response<List<IssInfo>> response) {
                if (response.isSuccessful()) {
                    for (IssInfo issInfo : response.body()) {
                        Log.d(TAG, issInfo.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<IssInfo>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<IssInfo> getLastInfoByPost(IssInfo updateList) {
        retrofit2.Call<List<IssInfo>> call = service.getLastInfoByPost(updateList);

        call.enqueue(new Callback<List<IssInfo>>() {
            @Override
            public void onResponse(Call<List<IssInfo>> call, Response<List<IssInfo>> response) {
                if (response.isSuccessful()) {
                    for (IssInfo issInfo : response.body()) {
                        Log.d(TAG, issInfo.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<IssInfo>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<MealPlan> getCartes(String from, String to) {
        retrofit2.Call<List<MealPlan>> call = service.getCartes(from, to);

        call.enqueue(new Callback<List<MealPlan>>() {
            @Override
            public void onResponse(Call<List<MealPlan>> call, Response<List<MealPlan>> response) {
                if (response.isSuccessful()) {
                    for (MealPlan mealPlan : response.body()) {
                        Log.d(TAG, mealPlan.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MealPlan>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public List<ChannelEquip> getChannels() {
        retrofit2.Call<List<ChannelEquip>> call = service.getChannels();

        call.enqueue(new Callback<List<ChannelEquip>>() {
            @Override
            public void onResponse(Call<List<ChannelEquip>> call, Response<List<ChannelEquip>> response) {
                if (response.isSuccessful()) {
                    for (ChannelEquip channelEquip : response.body()) {
                        Log.d(TAG, channelEquip.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ChannelEquip>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public Job getIssJob(int no) {
        retrofit2.Call<Job> call = service.getIssJob(no);

        call.enqueue(new Callback<Job>() {
            @Override
            public void onResponse(Call<Job> call, Response<Job> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Job> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public TankSlosh getIssTankSlosh() {
        retrofit2.Call<TankSlosh> call = service.getIssTankSlosh();

        call.enqueue(new Callback<TankSlosh>() {
            @Override
            public void onResponse(Call<TankSlosh> call, Response<TankSlosh> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<TankSlosh> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return null;
    }

    @Override
    public IssRoute getIssRoute(int no) {
        retrofit2.Call<IssRoute> call = service.getIssRoute(no);

        call.enqueue(new Callback<IssRoute>() {
            @Override
            public void onResponse(Call<IssRoute> call, Response<IssRoute> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<IssRoute> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

        return null;
    }
}
