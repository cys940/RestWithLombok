package kr.gmtc.resttest.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected String userId;
    protected String userName;
    protected int callPriority;
    protected int cctvPriority;
    protected Date birthday;
    protected String nation;
    protected String admin;
    protected String address;
    protected Date expireDate;
    protected UserConfig userConfig;
    protected List<UserAuth> userAuths = new ArrayList<>();
}
