package kr.gmtc.resttest.model.iscs.info;

import com.google.gson.annotations.SerializedName;

import kr.gmtc.resttest.model.iscs.info.alarm.NotifyAlarm;
import kr.gmtc.resttest.model.iscs.info.auth.UserAuth;
import kr.gmtc.resttest.model.iscs.info.config.UserConfig;
import kr.gmtc.resttest.model.iscs.info.favorite.Favorite;
import kr.gmtc.resttest.model.iscs.info.group.Group;
import kr.gmtc.resttest.model.iscs.info.schedule.Schedule;
import kr.gmtc.resttest.model.iscs.info.transfer.Transfer;
import kr.gmtc.resttest.model.iscs.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyInfo {
    @SerializedName("user")protected User user;
    @SerializedName("userConfig") protected UserConfig userConfig;
    @SerializedName("groups") protected List<Group> groups = new ArrayList<>();
    @SerializedName("favorites") protected List<Favorite> favorites = new ArrayList<>();
    @SerializedName("transfers") protected List<Transfer> transfers = new ArrayList<>();
    @SerializedName("schedules") protected List<Schedule> schedules = new ArrayList<>();
    @SerializedName("userAuths") protected List<UserAuth> userAuths = new ArrayList<>();
    @SerializedName("alarms") protected List<NotifyAlarm> alarms = new ArrayList<>();
}
