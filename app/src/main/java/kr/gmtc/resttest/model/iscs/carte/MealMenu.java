package kr.gmtc.resttest.model.iscs.carte;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealMenu {
    @SerializedName("seq") protected Integer seq;
    @SerializedName("menuName") protected String menuName;
    @SerializedName("mealPlan") protected MealPlan mealPlan;
}
