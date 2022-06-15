package kr.gmtc.resttest.model.ht08.equip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class VideoRecorder extends Device {
    protected String userId;
    protected String password;
    protected Integer recorderPort;
    protected Integer recorderType;
    protected Integer maxSession;
}
