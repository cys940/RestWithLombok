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
public class EvaluatedWayPoint {
    @SerializedName("pathNo") protected Integer pathNo;
    @SerializedName("seq") protected Integer seq;
    @SerializedName("sog") protected Double sog;
    @SerializedName("distance") protected Double distance;
    @SerializedName("oldStartDate") protected String oldStartDate;
    @SerializedName("oldArrivalDate") protected String oldArrivalDate;
    @SerializedName("startDate") protected String startDate;
    @SerializedName("arrivalDate") protected String arrivalDate;
}
