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
public class Ht10 extends Terminal {
    @SerializedName("wifi") protected String wifi;
    @SerializedName("ent") protected String ent;
}
