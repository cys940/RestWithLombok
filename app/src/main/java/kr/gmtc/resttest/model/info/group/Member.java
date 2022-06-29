package kr.gmtc.resttest.model.info.group;

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
public class Member implements Serializable {
    @SerializedName("id") protected Integer id;
    @SerializedName("joinType") protected Integer joinType;
    @SerializedName("joinId") protected String joinId;
}
