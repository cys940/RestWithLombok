package kr.gmtc.resttest.model.iscs.channel;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Channel {
    @SerializedName("seq") protected Integer seq;
    @SerializedName("value") protected String value;
    @SerializedName("frequency") protected String frequency;
    @SerializedName("tag") protected String tag;
    @SerializedName("dual") protected String dual;
    @SerializedName("triple") protected String triple;
    @SerializedName("scan") protected String scan;
    @SerializedName("equip") protected ChannelEquip equip;
}
