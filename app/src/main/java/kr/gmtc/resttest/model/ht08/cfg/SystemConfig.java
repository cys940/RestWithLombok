package kr.gmtc.resttest.model.ht08.cfg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfig {
    protected Integer seq;
    protected Integer callWaitSec;
    protected Integer sleepSec;
    protected Integer switchAccountSec;
    protected String primaryIp;
    protected String secondryIp;
    protected Integer restServerPort;
    protected Integer dataPort;
    protected Integer licensePort;
    protected Integer voipPort;
    protected String voipDomain;
    protected Integer ftpPort;
    protected String ftpUser;
    protected String ftpPassword;
    protected String ftpRoot;
    protected String ssl;
    protected String encrypt;
    protected Integer updateAction;
    protected String ht10AndroidKey;
    protected String ht10WindowKey;
    protected String hg08AndroidKey;
    protected String hg08WindowKey;
    protected String ht01AndroidKey;
    protected String wirelessSmsUrl;
    protected String iot_url;
    protected Integer roomMaxSession;
}

