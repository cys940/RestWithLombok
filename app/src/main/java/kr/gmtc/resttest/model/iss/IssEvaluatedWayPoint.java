package kr.gmtc.resttest.model.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssEvaluatedWayPoint {
    @SerializedName("pathNo")protected Integer pathNo;
    @SerializedName("no") protected Integer no;
    @SerializedName("sog") protected Double sog;
    @SerializedName("distance") protected Double distance;
    @SerializedName("startTime") protected String startTime;
    @SerializedName("arrivalTime") protected String arrivalTime;
}
