package kr.gmtc.resttest.model.iscs.code;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Code {
    @SerializedName("type") protected Integer type;
    @SerializedName("id") protected Integer id;
    @SerializedName("name") protected String name;
    @SerializedName("order") protected Integer order;
    @SerializedName("remark") protected String remark;
}
