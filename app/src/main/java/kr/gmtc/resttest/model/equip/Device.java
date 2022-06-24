package kr.gmtc.resttest.model.equip;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @SerializedName("id")  protected String id;
    @SerializedName("type")  protected Integer type;
    @SerializedName("equipType")  protected String equipType;
    @SerializedName("name")  protected String name;
    @SerializedName("ip")  protected String ip;
    @SerializedName("location")  protected String location;
    @SerializedName("modelName")  protected String modelName;
    @SerializedName("remark")  protected String remark;
    @SerializedName("companyName")  protected String companyName;
    //protected Integer maxSession;
    @SerializedName("authType")  protected Integer authType;
    @SerializedName("authValue")  protected String authValue;
    @SerializedName("firmwareVersion")  protected String firmwareVersion;
}
