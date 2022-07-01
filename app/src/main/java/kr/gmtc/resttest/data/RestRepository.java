package kr.gmtc.resttest.data;

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

public interface RestRepository {
    List<Device> getAllDevices();
    List<Cctv> getAllCctvs();
    SystemConfig getSystemConfig();
    List<User> getAllUsers();
    User getUser(String userId);
    List<Favorite> getFavorite(String userId);
    List<Favorite> updateFavorite(String userId,List<Favorite> update);
    List<Favorite> deleteFavorite(String userId, int id);
    List<Group> getGroupsByGet(String userId);
    List<Group> getGroupsByPost(String userId, List<Group> groups);
    List<Group> deleteGroups(String userId, String groupId);
    List<Group> updateGroups(String userId);
    MyInfo getMyInfo(String userId);
    List<WhaleSafe> getWhaleSafeByGet();
    List<WhaleSafe> getWhaleSafeByPost(List<WhaleSafe> body);
    List<Schedule> getSchedules(String userId);
    UserConfig getUserConfigByGet(String userId);
    UserConfig getUserConfigByPost(String userId, UserConfig userConfig);
    List<UserAuth> getUserAuths(String userId);
}
