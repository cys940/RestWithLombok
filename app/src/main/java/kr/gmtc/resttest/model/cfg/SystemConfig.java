package kr.gmtc.resttest.model.cfg;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfig {
    @SerializedName("seq")  protected Integer seq;
    @SerializedName("callWaitSec")  protected Integer callWaitSec;
    @SerializedName("sleepSec")  protected Integer sleepSec;
    @SerializedName("switchAccountSec")  protected Integer switchAccountSec;
    @SerializedName("primaryIp")  protected String primaryIp;
    @SerializedName("secondryIp")  protected String secondryIp;
    @SerializedName("restServerPort")  protected Integer restServerPort;
    @SerializedName("dataPort")  protected Integer dataPort;
    @SerializedName("licensePort")  protected Integer licensePort;
    @SerializedName("voipPort")  protected Integer voipPort;
    @SerializedName("voipDomain")  protected String voipDomain;
    @SerializedName("ftpPort")  protected Integer ftpPort;
    @SerializedName("ftpUser")  protected String ftpUser;
    @SerializedName("ftpPassword")  protected String ftpPassword;
    @SerializedName("ftpRoot")  protected String ftpRoot;
    @SerializedName("ssl")  protected String ssl;
    @SerializedName("encrypt")  protected String encrypt;
    @SerializedName("updateAction")  protected Integer updateAction;
    @SerializedName("ht10AndroidKey")  protected String ht10AndroidKey;
    @SerializedName("ht10WindowKey")  protected String ht10WindowKey;
    @SerializedName("hg08AndroidKey")  protected String hg08AndroidKey;
    @SerializedName("hg08WindowKey")  protected String hg08WindowKey;
    @SerializedName("ht01AndroidKey")  protected String ht01AndroidKey;
    @SerializedName("wirelessSmsUrl")  protected String wirelessSmsUrl;
    @SerializedName("iot_url")  protected String iot_url;
    @SerializedName("roomMaxSession")  protected Integer roomMaxSession;
}

