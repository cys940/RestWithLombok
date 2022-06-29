package kr.gmtc.resttest.model.info.auth;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuth {
    @SerializedName("userId") protected String userId;
    @SerializedName("authId") protected Integer authId;
    @SerializedName("use") protected String use;
    @SerializedName("name") protected String name;
    @SerializedName("menuCode") protected Integer menuCode;
    @SerializedName("equipId") protected String equipId;
    @SerializedName("functionType") protected Integer functionType;
    @SerializedName("alarmType") protected Integer alarmType;
    @SerializedName("alarmLevel") protected Integer alarmLevel;
}
