package kr.gmtc.resttest.model.user;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConfig {
    @SerializedName("userId") protected String userId;
    @SerializedName("bright") protected Integer bright;
    @SerializedName("dateType") protected Integer dateType;
    @SerializedName("timeType") protected Integer timeType;
    @SerializedName("timeZone") protected Integer timeZone;
    @SerializedName("mainBackground") protected String mainBackground;
    @SerializedName("phoneMusic") protected String phoneMusic;
    @SerializedName("wakeupMusic") protected String wakeupMusic;
    @SerializedName("alarmMusic") protected String alarmMusic;
    @SerializedName("notifyMusic") protected String notifyMusic;
    @SerializedName("myMenu1") protected Integer myMenu1;
    @SerializedName("myMenu2") protected Integer myMenu2;
    @SerializedName("myMenu3") protected Integer myMenu3;
    @SerializedName("myMenu4") protected Integer myMenu4;
    @SerializedName("myMenu5") protected Integer myMenu5;
    @SerializedName("myMenu6") protected Integer myMenu6;
}
