package kr.gmtc.resttest.model.equip;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class Phone extends Device {
    @SerializedName("dialNo") protected String dialNo;
    @SerializedName("lineNo") protected Integer lineNo;
    @SerializedName("roomNo") protected String roomNo;
    @SerializedName("pbxId") protected String pbxId;
}
