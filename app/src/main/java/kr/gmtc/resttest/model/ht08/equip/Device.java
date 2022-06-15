package kr.gmtc.resttest.model.ht08.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    protected String id;
    protected Integer type;
    protected String equipType;
    protected String name;
    protected String ip;
    protected String location;
    protected String modelName;
    protected String remark;
    protected String companyName;
    //protected Integer maxSession;
    protected Integer authType;
    protected String authValue;
    protected String firmwareVersion;
}
