package kr.gmtc.resttest.model.iscs.info.alarm;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NotifyAlarm {
    @SerializedName("id") protected Integer id;
    @SerializedName("userId") protected String userId;
    @SerializedName("information") protected Information information;
}
