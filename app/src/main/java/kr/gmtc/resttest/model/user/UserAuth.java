package kr.gmtc.resttest.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {
    protected Integer authId;
    protected String use;
    protected String name;
    protected Integer menuCode;
    protected String equipId;
    protected Integer functionType;
    protected Integer alarmType;
    protected Integer alarmLevel;
}
