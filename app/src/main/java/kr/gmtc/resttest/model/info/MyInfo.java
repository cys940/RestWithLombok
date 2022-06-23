package kr.gmtc.resttest.model.info;

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
    protected User user;
    protected List<Group> groups = new ArrayList<>();
    protected List<Favorite> favorites = new ArrayList<>();
}
