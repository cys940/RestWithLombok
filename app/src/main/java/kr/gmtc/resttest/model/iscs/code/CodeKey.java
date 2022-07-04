package kr.gmtc.resttest.model.iscs.code;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodeKey implements Serializable {
    @SerializedName("type") protected Integer type;
    @SerializedName("id") protected Integer id;
}
