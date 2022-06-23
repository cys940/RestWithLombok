package kr.gmtc.resttest.model.cctv;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cctv {
    protected String id;
    protected String userId;
    protected String password;
    protected Integer cctvType;
    protected Integer commandType;
    protected String rtsp;
    protected Integer speedP;
    protected Integer speedT;
    protected Integer speedZ;
    protected Integer maxSession;
    protected String recorderId;
    protected List<Command> commands = new ArrayList<>();
}
