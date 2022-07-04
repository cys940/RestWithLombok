package kr.gmtc.resttest.model.iscs.carte;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {
    @SerializedName("planDate") protected Date planDate;
    @SerializedName("mealType") protected Integer mealType;
    @SerializedName("calorie") protected Integer calorie;
    @SerializedName("menus") protected List<MealMenu> menus = new ArrayList<>();
}
