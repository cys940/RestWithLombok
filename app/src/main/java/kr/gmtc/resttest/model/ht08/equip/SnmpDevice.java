package kr.gmtc.resttest.model.ht08.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class SnmpDevice extends Device {
    protected int snmpPort;
    protected String snmpId;
    protected String snmpPassword;
}
