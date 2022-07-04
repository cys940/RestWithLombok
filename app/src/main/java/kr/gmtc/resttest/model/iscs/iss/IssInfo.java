package kr.gmtc.resttest.model.iscs.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssInfo {
    @SerializedName("id") protected String id;
    @SerializedName("param1") protected String param1;
    @SerializedName("param2") protected String param2;
    @SerializedName("valueType") protected Integer valueType;
    @SerializedName("valueD") protected Double valueD;
    @SerializedName("valueC") protected String valueC;
    @SerializedName("valueB") protected String valueB;
    @SerializedName("updateDate") protected Date updateDate;
}
