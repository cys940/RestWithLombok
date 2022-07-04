package kr.gmtc.resttest.model.iscs.ga;

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
public class GaImage {
    @SerializedName("image") protected Integer id;
    @SerializedName("name") protected String name;
    @SerializedName("equips") protected List<GaEquip> equips = new ArrayList<>();
}
