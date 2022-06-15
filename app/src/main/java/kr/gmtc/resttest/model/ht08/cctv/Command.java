package kr.gmtc.resttest.model.ht08.cctv;


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
