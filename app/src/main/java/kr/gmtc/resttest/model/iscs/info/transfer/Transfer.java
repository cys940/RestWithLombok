package kr.gmtc.resttest.model.iscs.info.transfer;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transfer {
    @SerializedName("id") protected Integer id;
    @SerializedName("userId") protected String userId;
    @SerializedName("equipId") protected String equipId;
}
