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
public class Terminal extends Phone {
    @SerializedName("pagaZone") protected int pagaZone;
}
