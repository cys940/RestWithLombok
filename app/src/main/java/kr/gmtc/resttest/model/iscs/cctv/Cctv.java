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
    /** CCTV 연결 방식 (IP, Serial)
    @SerializedName("cctvType") protected Integer cctvType;
    /** 명령 프로토콜 (REST, Pelco-D, etc)**/
    @SerializedName("commandType") protected Integer commandType;
    @SerializedName("channel") protected int channel;
    @SerializedName("rtsp") protected String rtsp;
    @SerializedName("speedP") protected Integer speedP;
    @SerializedName("speedT") protected Integer speedT;
    @SerializedName("speedZ") protected Integer speedZ;
    @SerializedName("maxSession") protected Integer maxSession;
    @SerializedName("recorderId") protected String recorderId;
    @SerializedName("commands") protected List<Command> commands = new ArrayList<>();
}
