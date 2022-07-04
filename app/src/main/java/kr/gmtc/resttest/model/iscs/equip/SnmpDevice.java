package kr.gmtc.resttest.model.iscs.equip;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class SnmpDevice extends Device {
    @SerializedName("snmpPort") protected int snmpPort;
    @SerializedName("snmpId") protected String snmpId;
    @SerializedName("snmpPassword") protected String snmpPassword;
}
