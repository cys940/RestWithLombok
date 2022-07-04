package kr.gmtc.resttest.model.iscs.whale;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoordinateId implements Serializable {
    @SerializedName("whaleId") protected Integer whaleId;
    @SerializedName("seq") protected Integer seq;
}
