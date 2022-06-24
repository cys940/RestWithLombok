package kr.gmtc.resttest.rest;


import java.util.List;

import kr.gmtc.resttest.model.cctv.Cctv;
import kr.gmtc.resttest.model.cfg.SystemConfig;
import kr.gmtc.resttest.model.equip.Device;
import kr.gmtc.resttest.model.info.MyInfo;
import kr.gmtc.resttest.model.info.favorite.Favorite;
import kr.gmtc.resttest.model.info.group.Group;
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
    Call<Favorite> getFavorite(@Path("userId") String userId);

    @PUT("/iscs/myinfo/{userId}/favorite")
    Call<Favorite> updateFavorite(@Path("userId") String userId, @Body Favorite update);

    @DELETE("/iscs/myinfo/{userId}/favorite/{id}")
    Call<Favorite> deleteFavorite(@Path("userId") String userId, @Path("id") int id);

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
}
