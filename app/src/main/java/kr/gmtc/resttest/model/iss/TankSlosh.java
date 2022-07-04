package kr.gmtc.resttest.model.iss;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TankSlosh {
    @SerializedName("date") Date date;
    @SerializedName("tk1x") Double[] tk1x;
    @SerializedName("tk1y") Double[] tk1y;
    @SerializedName("tk2x") Double[] tk2x;
    @SerializedName("tk2y") Double[] tk2y;
    @SerializedName("tk3x") Double[] tk3x;
    @SerializedName("tk3y") Double[] tk3y;
    @SerializedName("tk4x") Double[] tk4x;
    @SerializedName("tk4y") Double[] tk4y;
    @SerializedName("tk1SloshingCount") Double tk1SloshingCount;
    @SerializedName("tk2SloshingCount") Double tk2SloshingCount;
    @SerializedName("tk3SloshingCount") Double tk3SloshingCount;
    @SerializedName("tk4SloshingCount") Double tk4SloshingCount;
    @SerializedName("tk1DangerLevel") Double tk1DangerLevel;
    @SerializedName("tk2DangerLevel") Float tk2DangerLevel;
    @SerializedName("tk3DangerLevel") Double tk3DangerLevel;
    @SerializedName("tk4DangerLevel") Double tk4DangerLevel;
}
