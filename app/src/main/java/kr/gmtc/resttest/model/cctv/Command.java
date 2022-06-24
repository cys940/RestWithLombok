package kr.gmtc.resttest.model.cctv;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Command {
     @SerializedName("ptzCode") protected Integer ptzCode;
     @SerializedName("command") protected String command;
}
