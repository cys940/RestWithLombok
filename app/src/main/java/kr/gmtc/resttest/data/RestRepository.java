package kr.gmtc.resttest.data;


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
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestRepository {
    List<Device> getAllDevices();

    List<Cctv> getAllCctvs();

    SystemConfig getSystemConfig();

    List<User> getAllUsers();

    User getUserByGet(String userId);

    User getUserByPost(String userId, User user);

    List<Favorite> getFavorite(String userId);

    List<Favorite> updateFavorite(String userId, Favorite update);

    List<Favorite> deleteFavorite(String userId, int id);

    List<Group> getGroupsByGet(String userId);

    List<Group> getGroupsByPost(String userId, List<Group> groups);

    List<Group> deleteGroups(String userId, String groupId);

    List<Group> updateGroups(String userId, Group updateGroup);

    MyInfo getMyInfo(String userId);

    List<WhaleSafe> getWhaleSafeByGet();

    List<WhaleSafe> getWhaleSafeByPost(List<WhaleSafe> updateList);

    List<Schedule> getSchedules(String userId);

    UserConfig getUserConfigByGet(String userId);

    UserConfig getUserConfigByPost(String userId, UserConfig userConfig);

    List<UserAuth> getUserAuths(String userId);

    List<Code> getCodes();

    List<Alarm> getAlarms(String userId, int page, int pageSize);

    List<Alarm> getReadAlarms(String userId);

    List<IssInfo> getLastInfoByGet();

    List<IssInfo> getLastInfoByPost(IssInfo updateList);

    List<MealPlan> getCartes(String from, String to);

    List<ChannelEquip> getChannels();

    Job getIssJob(int no);

    TankSlosh getIssTankSlosh();

    IssRoute getIssRoute(int no);
}
