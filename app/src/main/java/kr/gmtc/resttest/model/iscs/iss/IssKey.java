package kr.gmtc.resttest.model.iscs.iss;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssKey implements Serializable {
    @SerializedName("id") protected String id;
    @SerializedName("param1") protected String param1;
    @SerializedName("param2") protected String param2;
}
