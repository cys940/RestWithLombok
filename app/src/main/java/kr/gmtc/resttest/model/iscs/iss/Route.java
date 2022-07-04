package kr.gmtc.resttest.model.iscs.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    @SerializedName("pathNo") protected Integer pathNo;
    @SerializedName("wayPoints") protected List<WayPoint> wayPoints = new ArrayList<>();
    @SerializedName("evaluatedWayPoints") protected List<EvaluatedWayPoint> evaluatedWayPoints = new ArrayList<>();
}
