package kr.gmtc.resttest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kr.gmtc.resttest.data.Impl.RestRepositoryImpl;
import kr.gmtc.resttest.model.equip.Device;
import kr.gmtc.resttest.model.info.config.UserConfig;
import kr.gmtc.resttest.model.info.favorite.Favorite;
import kr.gmtc.resttest.model.info.group.Group;
import kr.gmtc.resttest.model.whale.WhaleSafe;


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
        samples.add("getUser");
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
            case "getUser":
                repositoryImpl.getUser("003");
                break;
            case "getFavorite":
                repositoryImpl.getFavorite("003");
                break;
            case "updateFavorite":
                repositoryImpl.updateFavorite("003", null);
                break;
            case "deleteFavorite":
                repositoryImpl.deleteFavorite("003", 18);
                break;
            case "getGroupsByGet":
                repositoryImpl.getGroupsByGet("003");
                break;
            case "getGroupsByPost":
                repositoryImpl.getGroupsByPost("003", null);
                break;
            case "deleteGroups":
                repositoryImpl.deleteGroups("003", "1093");
                break;
            case "updateGroups":
                repositoryImpl.updateGroups("003");
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
                repositoryImpl.getUserConfigByPost("003", null);
                break;
            case "getUserAuths":
                repositoryImpl.getUserAuths("003");
                break;
        }
    }
}
