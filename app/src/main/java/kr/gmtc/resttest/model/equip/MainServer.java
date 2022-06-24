package kr.gmtc.resttest.model.equip;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class MainServer extends Device {
    @SerializedName("autoDelete") protected String autoDelete;
    @SerializedName("remainDays") protected int remainDays;
    @SerializedName("autoBackupType") protected String autoBackupType;
    @SerializedName("backupCycle") protected int backupCycle;
    @SerializedName("backupHour") protected int backupHour;
    @SerializedName("limitCapacity") protected int limitCapacity;
}
