package kr.gmtc.resttest.model.whale;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SafeProperty {
    @SerializedName("id") protected Integer id;
    @SerializedName("name") protected String name;
    @SerializedName("value") protected String value;
}
