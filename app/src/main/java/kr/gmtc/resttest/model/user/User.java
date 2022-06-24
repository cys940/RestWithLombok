package kr.gmtc.resttest.model.user;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @SerializedName("userId") protected String userId;
    @SerializedName("userName") protected String userName;
    @SerializedName("callPriority") protected int callPriority;
    @SerializedName("cctvPriority") protected int cctvPriority;
    @SerializedName("birthday") protected Date birthday;
    @SerializedName("nation") protected String nation;
    @SerializedName("admin") protected String admin;
    @SerializedName("address") protected String address;
    @SerializedName("expireDate") protected Date expireDate;
    @SerializedName("userConfig") protected UserConfig userConfig;
    @SerializedName("userAuths") protected List<UserAuth> userAuths = new ArrayList<>();
}
