package kr.gmtc.resttest.model.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class Ht10 extends Terminal {
    protected String wifi;
    protected String ent;
}
