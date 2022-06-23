package kr.gmtc.resttest.model.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class MainServer extends Device {
    protected String autoDelete;
    protected int remainDays;
    protected String autoBackupType;
    protected int backupCycle;
    protected int backupHour;
    protected int limitCapacity;
}
