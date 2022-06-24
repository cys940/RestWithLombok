package kr.gmtc.resttest.model.info.group;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group  {
    @SerializedName("id") protected Integer id;
    @SerializedName("name") protected String name;
    @SerializedName("userId") protected String userId;
    @SerializedName("members") protected List<Member> members = new ArrayList<>();
}
