package kr.gmtc.resttest.model.iscs.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WayPoint {
    @SerializedName("pathNo") protected Integer pathNo;
    @SerializedName("lon") protected Double lon;
    @SerializedName("lat") protected Double lat;
}
