package kr.gmtc.resttest.model.iscs.whale;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhaleSafe {
    @SerializedName("id") protected Integer id;
    @SerializedName("vsrDate") protected Date vsrDate;
    @SerializedName("channelName") protected String channelName;
    @SerializedName("coordType") protected Integer coordType;
    @SerializedName("geoType") protected Integer geoType;
    @SerializedName("contents") protected String contents;
    @SerializedName("detectionCount") protected Integer detectionCount;
    @SerializedName("mandatory") protected Integer mandatory;
    @SerializedName("shipSize") protected String shipSize;
    @SerializedName("speed") protected Double speed;
    @SerializedName("vsr") protected Integer vsr;
    @SerializedName("wpr") protected Integer wpr;
    @SerializedName("wprImage") protected String wprImage;
    @SerializedName("properties") protected List<SafeProperty> properties = new ArrayList<>();
    @SerializedName("coordinates") protected List<SafeCoordinate> coordinates = new ArrayList<>();
}
