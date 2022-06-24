package kr.gmtc.resttest.model.info;

import com.google.gson.annotations.SerializedName;

import kr.gmtc.resttest.model.info.favorite.Favorite;
import kr.gmtc.resttest.model.info.group.Group;
import kr.gmtc.resttest.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyInfo {
    @SerializedName("user") protected User user;
    @SerializedName("groups") protected List<Group> groups = new ArrayList<>();
    @SerializedName("favorites") protected List<Favorite> favorites = new ArrayList<>();
}
