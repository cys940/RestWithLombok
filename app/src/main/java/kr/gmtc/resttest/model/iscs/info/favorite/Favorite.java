package kr.gmtc.resttest.model.iscs.info.favorite;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favorite {
    @SerializedName("id") protected Integer id;
    @SerializedName("userId") protected String userId;
    @SerializedName("destType") protected Integer destType;
    @SerializedName("destId") protected String destId;
}

