package kr.gmtc.resttest.model.iscs.info.alarm;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @SerializedName("id") protected Integer id;
    @SerializedName("AlarmType") protected Integer AlarmType;
    @SerializedName("equipId") protected String equipId;
    @SerializedName("alarmDate") protected Date alarmDate;
    @SerializedName("alarmText") protected String alarmText;
    @SerializedName("mmsi") protected String mmsi;
    @SerializedName("longitude") protected Double longitude;
    @SerializedName("latitude") protected Double latitude;
}
