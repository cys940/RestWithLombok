package kr.gmtc.resttest.rest;


import java.util.List;

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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestService {
    @GET("iscs/devices")
    Call<List<Device>> getAllDevices();

    @GET("iscs/devices/cctvs")
    Call<List<Cctv>> getAllCctvs();

    @GET("iscs/systemconfig")
    Call<SystemConfig> getSystemConfig();

    @GET("iscs/users")
    Call<List<User>> getAllUsers();

    @GET("iscs/users/{userId}")
    Call<User> getUser(@Path("userId") String userId);

    @GET("iscs/myinfo/{userId}/favorite")
    Call<List<Favorite>> getFavorite(@Path("userId") String userId);

    @PUT("/iscs/myinfo/{userId}/favorite")
    Call<List<Favorite>> updateFavorite(@Path("userId") String userId, @Body List<Favorite> update);

    @DELETE("/iscs/myinfo/{userId}/favorite/{id}")
    Call<List<Favorite>> deleteFavorite(@Path("userId") String userId, @Path("id") int id);

    @GET("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> getGroupsByGet(@Path("userId") String userId);

    @POST("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> getGroupsByPost(@Path("userId") String userId, @Body List<Group> groups);

    @DELETE("/iscs/myinfo/{userId}/groups/{groupId}")
    Call<List<Group>> deleteGroups(@Path("userId") String userId, @Path("groupId") String groupId);

    @PUT("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> updateGroups(@Path("userId") String userId);

    @GET("/iscs/myinfo/{userId}")
    Call<MyInfo> getMyInfo(@Path("userId") String userId);

    @GET("/whale/safe")
    Call<List<WhaleSafe>> getWhaleSafeByGet();

    @POST("/whale/safe")
    Call<List<WhaleSafe>> getWhaleSafeByPost(@Body List<WhaleSafe> body);

    @GET("/iscs/myinfo/{userId}/schedule")
    Call<List<Schedule>> getSchedules(@Path("userId") String userId);

    @GET("/iscs/myinfo/{userId}/config")
    Call<UserConfig> getUserConfigByGet(@Path("userId") String userId);

    @POST("/iscs/myinfo/{userId}/config")
    Call<UserConfig> getUserConfigByPost(@Path("userId") String userId, @Body UserConfig userConfig);

    @GET("/iscs/myinfo/{userId}/auth")
    Call<List<UserAuth>> getUserAuths(@Path("userId") String userId);
}
