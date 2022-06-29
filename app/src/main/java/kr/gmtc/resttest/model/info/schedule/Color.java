package kr.gmtc.resttest.model.info.schedule;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {
    @SerializedName("id") protected Integer id;
    @SerializedName("red") protected Integer red;
    @SerializedName("blue") protected Integer blue;
    @SerializedName("green") protected Integer green;
    @SerializedName("alpha") protected Integer alpha;
}
