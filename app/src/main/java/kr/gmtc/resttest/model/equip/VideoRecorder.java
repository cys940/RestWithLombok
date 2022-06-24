package kr.gmtc.resttest.model.equip;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class VideoRecorder extends Device {
    @SerializedName("userId") protected String userId;
    @SerializedName("password") protected String password;
    @SerializedName("recorderPort") protected Integer recorderPort;
    @SerializedName("recorderType") protected Integer recorderType;
    @SerializedName("maxSession") protected Integer maxSession;
}
