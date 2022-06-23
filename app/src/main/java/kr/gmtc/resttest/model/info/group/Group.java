package kr.gmtc.resttest.model.info.group;

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
    protected Integer id;
    protected String name;
    protected String userId;
    protected List<Member> members = new ArrayList<>();
}
