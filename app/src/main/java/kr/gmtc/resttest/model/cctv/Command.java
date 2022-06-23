package kr.gmtc.resttest.model.cctv;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command {
    protected Integer ptzCode;
    protected String command;
}
