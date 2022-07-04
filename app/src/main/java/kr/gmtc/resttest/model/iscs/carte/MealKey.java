package kr.gmtc.resttest.model.iscs.carte;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealKey implements Serializable {
    @SerializedName("planDate") protected Date planDate;
    @SerializedName("mealType") protected Integer mealType;
}
