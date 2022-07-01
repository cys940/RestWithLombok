package kr.gmtc.resttest.data;

import androidx.lifecycle.LiveData;

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
    LiveData<List<Device>> getAllDevices();
    LiveData<List<Cctv>> getAllCctvs();
    LiveData<SystemConfig> getSystemConfig();
    LiveData<List<User>> getAllUsers();
    LiveData<User> getUser(String userId);
    LiveData<List<Favorite>> getFavorite(String userId);
    LiveData<List<Favorite>> updateFavorite(String userId,List<Favorite> update);
    LiveData<List<Favorite>> deleteFavorite(String userId, int id);
    LiveData<List<Group>> getGroupsByGet(String userId);
    LiveData<List<Group>> getGroupsByPost(String userId, List<Group> groups);
    LiveData<List<Group>> deleteGroups(String userId, String groupId);
    LiveData<List<Group>> updateGroups(String userId);
    LiveData<MyInfo> getMyInfo(String userId);
    LiveData<List<WhaleSafe>> getWhaleSafeByGet();
    LiveData<List<WhaleSafe>> getWhaleSafeByPost(List<WhaleSafe> body);
    LiveData<List<Schedule>> getSchedules(String userId);
    LiveData<UserConfig> getUserConfigByGet(String userId);
    LiveData<UserConfig> getUserConfigByPost(String userId, UserConfig userConfig);
    LiveData<List<UserAuth>> getUserAuths(String userId);
}
