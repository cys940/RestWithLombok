package kr.gmtc.resttest.data.remote;


import java.util.List;


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
    Call<User> getUserByGet(@Path("userId") String userId);

    @POST("iscs/users/{userId}")
    Call<User> getUserByPost(@Path("userId") String userId, @Body User user);

    @GET("iscs/myinfo/{userId}/favorite")
    Call<List<Favorite>> getFavorite(@Path("userId") String userId);

    @PUT("/iscs/myinfo/{userId}/favorite")
    Call<List<Favorite>> updateFavorite(@Path("userId") String userId, @Body Favorite update);

    @DELETE("/iscs/myinfo/{userId}/favorite/{id}")
    Call<List<Favorite>> deleteFavorite(@Path("userId") String userId, @Path("id") int id);

    @GET("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> getGroupsByGet(@Path("userId") String userId);

    @POST("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> getGroupsByPost(@Path("userId") String userId, @Body List<Group> groups);

    @DELETE("/iscs/myinfo/{userId}/groups/{groupId}")
    Call<List<Group>> deleteGroups(@Path("userId") String userId, @Path("groupId") String groupId);

    @PUT("/iscs/myinfo/{userId}/groups")
    Call<List<Group>> updateGroups(@Path("userId") String userId, @Body Group updateGroup);

    @GET("/iscs/myinfo/{userId}")
    Call<MyInfo> getMyInfo(@Path("userId") String userId);

    @GET("/iscs/whale/safe")
    Call<List<WhaleSafe>> getWhaleSafeByGet();

    @POST("/iscs/whale/safe")
    Call<List<WhaleSafe>> getWhaleSafeByPost(@Body List<WhaleSafe> updateList);

    @GET("/iscs/myinfo/{userId}/schedule")
    Call<List<Schedule>> getSchedules(@Path("userId") String userId);

    @GET("/iscs/myinfo/{userId}/config")
    Call<UserConfig> getUserConfigByGet(@Path("userId") String userId);

    @POST("/iscs/myinfo/{userId}/config")
    Call<UserConfig> getUserConfigByPost(@Path("userId") String userId, @Body UserConfig userConfig);

    @GET("/iscs/myinfo/{userId}/auth")
    Call<List<UserAuth>> getUserAuths(@Path("userId") String userId);

    @GET("/iscs/codes")
    Call<List<Code>> getCodes();

    @GET("/iscs/myinfo/{userId}/alarm/{page}/{pageSize}")
    Call<List<Alarm>> getAlarms(@Path("userId") String userId, @Path("page") int page, @Path("pageSize") int pageSize);

    @GET("/iscs/myinfo/{userId}/alarm/read")
    Call<List<Alarm>> getReadAlarms(@Path("userId") String userId);

    @GET("/iscs/iss/lastinfo")
    Call<List<IssInfo>> getLastInfoByGet();

    @POST("/iscs/iss/lastinfo")
    Call<List<IssInfo>> getLastInfoByPost(@Body IssInfo updateInfos);

    @GET("/iscs/carte/{from}/{to}")
    Call<List<MealPlan>> getCartes(@Path("from") String from, @Path("to") String to);

    @GET("/iscs/channels")
    Call<List<ChannelEquip>> getChannels();

    @GET("/iss/job/{no}")
    Call<Job> getIssJob(@Path("no") int no);

    @GET("/iss/tankslosh")
    Call<TankSlosh> getIssTankSlosh();

    @GET("/iss/route/{no}")
    Call<IssRoute> getIssRoute(@Path("no") int no);
}
