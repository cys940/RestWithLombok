package kr.gmtc.resttest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kr.gmtc.resttest.data.Impl.RestRepositoryImpl;
import kr.gmtc.resttest.model.iscs.equip.Device;
import kr.gmtc.resttest.model.iscs.info.config.UserConfig;
import kr.gmtc.resttest.model.iscs.info.favorite.Favorite;
import kr.gmtc.resttest.model.iscs.info.group.Group;
import kr.gmtc.resttest.model.iscs.iss.IssInfo;
import kr.gmtc.resttest.model.iscs.user.User;
import kr.gmtc.resttest.model.iscs.whale.WhaleSafe;


@HiltViewModel
public class RestViewModel extends ViewModel {
    private static final String TAG = "RestViewModel";
    RestRepositoryImpl repositoryImpl;

    @Inject
    public RestViewModel(RestRepositoryImpl repositoryImpl){
        this.repositoryImpl = repositoryImpl;
    }

    private MutableLiveData<List<String>> list;
    public LiveData<List<String>> getAll() {
        if (list == null) {
            list = new MutableLiveData<List<String>>();
            fetch();
        }
        return list;
    }

    private MutableLiveData<String> log = new MutableLiveData<>();
    public LiveData<String> getCurrentLog() {
        if (log == null) {
            log = new MutableLiveData<String>();
        }
        return log;
    }

    private MutableLiveData<List<Device>> devices = new MutableLiveData<>();
    public LiveData<List<Device>> getDevices() {
        if (devices == null) {
            devices = new MutableLiveData<List<Device>>();
        }
        return devices;
    }

    private MutableLiveData<List<Favorite>> _Favorites = new MutableLiveData<>();
    public LiveData<List<Favorite>> getFavorites() {
        if (_Favorites == null) {
            _Favorites = new MutableLiveData<List<Favorite>>();
        }
        return _Favorites;
    }

    private MutableLiveData<List<WhaleSafe>> _whaleSafes = new MutableLiveData<>();
    public LiveData<List<WhaleSafe>> getWhaleSafes() {
        if (_whaleSafes == null) {
            _whaleSafes = new MutableLiveData<List<WhaleSafe>>();
        }
        return _whaleSafes;
    }

    private MutableLiveData<UserConfig> _userConfig = new MutableLiveData<>();
    public LiveData<UserConfig> getUserConfig() {
        if (_userConfig == null) {
            _userConfig = new MutableLiveData<UserConfig>();
        }
        return _userConfig;
    }

    private MutableLiveData<List<Group>> _groups = new MutableLiveData<>();
    public LiveData<List<Group>> getGroups() {
        if (_groups == null) {
            _groups = new MutableLiveData<List<Group>>();
        }
        return _groups;
    }

    private void fetch() {
        List<String> samples = new ArrayList<>();
        samples.add("getAllDevices");
        samples.add("getAllCctvs");
        samples.add("getSystemConfig");
        samples.add("getAllUsers");
        samples.add("getUserByGet");
        samples.add("getUserByPost");
        samples.add("getFavorite");
        samples.add("updateFavorite");
        samples.add("deleteFavorite");
        samples.add("getGroupsByGet");
        samples.add("getGroupsByPost");
        samples.add("deleteGroups");
        samples.add("updateGroups");
        samples.add("getMyInfo");
        samples.add("getWhaleSafeByGet");
        samples.add("getWhaleSafeByPost");
        samples.add("getSchedules");
        samples.add("getUserConfigByGet");
        samples.add("getUserConfigByPost");
        samples.add("getUserAuths");
        samples.add("getCodes");
        samples.add("getAlarms");
        samples.add("getReadAlarms");
        samples.add("getLastInfoByGet");
        samples.add("getLastInfoByPost");
        samples.add("getCartes");
        samples.add("getChannels");
        samples.add("getIssJob");
        samples.add("getIssTankSlosh");
        samples.add("getIssRoute");

        list.setValue(samples);
    }

    public void request(String request) {
        switch (request) {
            case "getAllDevices":
                devices.setValue(repositoryImpl.getAllDevices());
                break;
            case "getAllCctvs":
                repositoryImpl.getAllCctvs();
                break;
            case "getSystemConfig":
                repositoryImpl.getSystemConfig();
                break;
            case "getAllUsers":
                repositoryImpl.getAllUsers();
                break;
            case "getUserByGet":
                repositoryImpl.getUserByGet("003");
                break;
            case "getUserByPost":
                try {
                    repositoryImpl.getUserByPost("003", User.builder()
                            .userId("003")
                            .password("1234")
                            .userName("HT19")
                            .callPriority(5)
                            .cctvPriority(9)
                            .birthday(new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-16"))
                            .nation(null)
                            .admin("1")
                            .address(null)
                            .pinNo("9981")
                            .expireDate(new SimpleDateFormat("yyyy-MM-dd").parse("2099-12-31"))
                            .build());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "getFavorite":
                repositoryImpl.getFavorite("003");
                break;
            case "updateFavorite":
                repositoryImpl.updateFavorite("003", Favorite.builder()
                        .userId("003")
                        .destType(0)
                        .destId("224")
                        .build()
                );
                break;
            case "deleteFavorite":
                repositoryImpl.deleteFavorite("003", 35);
                break;
            case "getGroupsByGet":
                repositoryImpl.getGroupsByGet("003");
                break;
            case "getGroupsByPost":
                repositoryImpl.getGroupsByPost("003", new ArrayList<Group>());
                break;
            case "deleteGroups":
                repositoryImpl.deleteGroups("003", "1096");
                break;
            case "updateGroups":
                repositoryImpl.updateGroups("003", Group.builder().build());
                break;
            case "getMyInfo":
                repositoryImpl.getMyInfo("003");
                break;
            case "getWhaleSafeByGet":
                repositoryImpl.getWhaleSafeByGet();
                break;
            case "getWhaleSafeByPost":
                repositoryImpl.getWhaleSafeByPost(null);
                break;
            case "getSchedules":
                repositoryImpl.getSchedules("003");
                break;
            case "getUserConfigByGet":
                repositoryImpl.getUserConfigByGet("003");
                break;
            case "getUserConfigByPost":
                repositoryImpl.getUserConfigByPost("003", UserConfig.builder()
                        .userId("003")
                        .bright(10)
                        .dateType(0)
                        .timeType(0)
                        .timeZone(1)
                        .mainBackground("Main_1.jpg")
                        .phoneMusic("Ring1.mp3")
                        .wakeupMusic("wakeup1.mp3")
                        .alarmMusic("Alarm1.wav")
                        .notifyMusic("Notify1.wav")
                        .myMenu1(6)
                        .myMenu2(8)
                        .myMenu3(9)
                        .myMenu4(10)
                        .myMenu5(11)
                        .myMenu6(21)
                        .build()
                );
                break;
            case "getUserAuths":
                repositoryImpl.getUserAuths("003");
                break;
            case "getCodes":
                repositoryImpl.getCodes();
                break;
            case "getAlarms":
                repositoryImpl.getAlarms("003", 0, 30);
                break;
            case "getReadAlarms":
                repositoryImpl.getReadAlarms("003");
                break;
            case "getLastInfoByGet":
                repositoryImpl.getLastInfoByGet();
                break;
            case "getLastInfoByPost":
                repositoryImpl.getLastInfoByPost(
                        IssInfo.builder()
                        .id("01-01")
                        .param1("ST.Vessel.Thing")
                        .param2("Nameoftheship")
                        .valueType(2)
                        .valueD(null)
                        .valueC("PRISM DIVERSITY")
                        .valueB(null)
                        .updateDate(new Date())
                        .build()
                );
                break;
            case "getCartes":
                repositoryImpl.getCartes("2022-07-01", "2022-07-31");
                break;
            case "getChannels":
                repositoryImpl.getChannels();
                break;
            case "getIssJob":
                repositoryImpl.getIssJob(3);
                break;
            case "getIssTankSlosh":
                repositoryImpl.getIssTankSlosh();
                break;
            case "getIssRoute":
                repositoryImpl.getIssRoute(3);
                break;
        }
    }
}
