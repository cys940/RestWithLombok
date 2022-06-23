package kr.gmtc.resttest.model.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class Phone extends Device {
    protected String dialNo;
    protected Integer lineNo;
    protected String roomNo;
    protected String pbxId;
}
