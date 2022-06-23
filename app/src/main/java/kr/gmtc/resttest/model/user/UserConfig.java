package kr.gmtc.resttest.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConfig {
    protected String userId;
    protected Integer bright;
    protected Integer dateType;
    protected Integer timeType;
    protected Integer timeZone;
    protected String mainBackground;
    protected String phoneMusic;
    protected String wakeupMusic;
    protected String alarmMusic;
    protected String notifyMusic;
    protected Integer myMenu1;
    protected Integer myMenu2;
    protected Integer myMenu3;
    protected Integer myMenu4;
    protected Integer myMenu5;
    protected Integer myMenu6;
}
