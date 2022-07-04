package kr.gmtc.resttest.model.iscs.ga;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GaEquip {
    @SerializedName("id") protected Integer id;
    @SerializedName("equipId") protected String equipId;
    @SerializedName("x") protected Integer x;
    @SerializedName("y") protected Integer y;
    @SerializedName("textAlign") protected Integer textAlign;
    @SerializedName("image") protected GaImage image;
}
