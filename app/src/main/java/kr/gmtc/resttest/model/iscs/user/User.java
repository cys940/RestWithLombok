package kr.gmtc.resttest.model.iscs.user;

import com.google.gson.annotations.SerializedName;

import kr.gmtc.resttest.model.iscs.info.auth.UserAuth;
import kr.gmtc.resttest.model.iscs.info.config.UserConfig;
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
     @SerializedName("password") protected String password;
     @SerializedName("userName") protected String userName;
     @SerializedName("callPriority") protected int callPriority;
     @SerializedName("cctvPriority") protected int cctvPriority;
     @SerializedName("birthday") protected Date birthday;
     @SerializedName("nation") protected String nation;
     @SerializedName("admin") protected String admin;
     @SerializedName("address") protected String address;
     @SerializedName("pinNo") protected String pinNo;
     @SerializedName("expireDate") protected Date expireDate;
     @SerializedName("updateId") protected String updateId;
     @SerializedName("updateDate") protected Date updateDate;
}
