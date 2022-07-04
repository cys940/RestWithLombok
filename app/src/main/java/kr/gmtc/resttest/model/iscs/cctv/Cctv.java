package kr.gmtc.resttest.model.iscs.cctv;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cctv {
    @SerializedName("id") protected String id;
    @SerializedName("userId") protected String userId;
    @SerializedName("password") protected String password;
    @SerializedName("cctvType") protected Integer cctvType;
    @SerializedName("commandType") protected Integer commandType;
    @SerializedName("rtsp") protected String rtsp;
    @SerializedName("speedP") protected Integer speedP;
    @SerializedName("speedT") protected Integer speedT;
    @SerializedName("speedZ") protected Integer speedZ;
    @SerializedName("maxSession") protected Integer maxSession;
    @SerializedName("recorderId") protected String recorderId;
    @SerializedName("commands") protected List<Command> commands = new ArrayList<>();
}
