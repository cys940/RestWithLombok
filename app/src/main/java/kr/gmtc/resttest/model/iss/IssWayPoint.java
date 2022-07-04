package kr.gmtc.resttest.model.iss;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssWayPoint {
    @SerializedName("pathNo") protected Integer pathNo;
    @SerializedName("id") protected Integer id;
    @SerializedName("lon") protected Double lon;
    @SerializedName("lat") protected Double lat;
}
