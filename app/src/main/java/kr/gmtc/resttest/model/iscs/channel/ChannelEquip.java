package kr.gmtc.resttest.model.iscs.channel;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelEquip {
    @SerializedName("id") protected String id;
    @SerializedName("channels") protected List<Channel> channels = new ArrayList<>();
}
