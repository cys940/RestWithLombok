package kr.gmtc.resttest.model.iscs.info.alarm;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alarm {
    @SerializedName("id") protected Integer id;
    @SerializedName("userId") protected String userId;
    @SerializedName("equipId") protected String equipId;
    @SerializedName("read") protected String read;
    @SerializedName("readDate") protected Date readDate;
    @SerializedName("information") protected Information information;
}
