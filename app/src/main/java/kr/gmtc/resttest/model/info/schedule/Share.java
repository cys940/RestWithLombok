package kr.gmtc.resttest.model.info.schedule;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Share {
    @SerializedName("id") protected Integer id;
    @SerializedName("userId") protected String userId;
    @SerializedName("schedule") protected Schedule schedule;

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;

        if (!schedule.getShares().contains(this))
            schedule.getShares().add(this);
    }
}
