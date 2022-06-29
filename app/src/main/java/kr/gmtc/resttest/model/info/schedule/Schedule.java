package kr.gmtc.resttest.model.info.schedule;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @SerializedName("id") protected Integer id;
    @SerializedName("title") protected String title;
    @SerializedName("timeZone") protected Integer timeZone;
    @SerializedName("startDate") protected Date startDate;
    @SerializedName("finishDate") protected Date finishDate;
    @SerializedName("allDay") protected String allDay;
    @SerializedName("reminderMin") protected Integer reminderMin;
    @SerializedName("repeat") protected String repeat;
    @SerializedName("share") protected String share;
    @SerializedName("note") protected String note;
    @SerializedName("colorId") protected Integer colorId;
    @SerializedName("userId") protected String userId;
    @SerializedName("updateId") protected String updateId;
    @SerializedName("updateDate") protected Date updateDate;
    @SerializedName("shares") protected List<Share> shares;
}
