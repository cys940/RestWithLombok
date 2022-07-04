package kr.gmtc.resttest.model.iscs.info.schedule;

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
}
