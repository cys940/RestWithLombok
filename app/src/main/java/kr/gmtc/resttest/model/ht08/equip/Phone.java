package kr.gmtc.resttest.model.ht08.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
