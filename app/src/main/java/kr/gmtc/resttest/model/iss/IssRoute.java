package kr.gmtc.resttest.model.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssRoute {
    @SerializedName("no") protected Integer no;
    @SerializedName("wayPoints") protected List<IssWayPoint> wayPoints = new ArrayList<>();
    @SerializedName("evaluatedWayPoints") protected List<IssEvaluatedWayPoint> evaluatedWayPoints = new ArrayList<>();
}
