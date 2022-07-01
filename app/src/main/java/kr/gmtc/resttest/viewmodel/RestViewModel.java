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
    RestRepositoryImpl repository;

    @Inject
    public RestViewModel(RestRepositoryImpl repository){
        this.repository = repository;
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
                repository.getAllDevices();
                break;
            case "getAllCctvs":
                repository.getAllCctvs();
                break;
            case "getSystemConfig":
                repository.getSystemConfig();
                break;
            case "getAllUsers":
                repository.getAllUsers();
                break;
            case "getUser":
                repository.getUser("003");
                break;
            case "getFavorite":
                repository.getFavorite("003");
                break;
            case "updateFavorite":
                repository.updateFavorite("003", null);
                break;
            case "deleteFavorite":
                repository.deleteFavorite("003", 18);
                break;
            case "getGroupsByGet":
                repository.getGroupsByGet("003");
                break;
            case "getGroupsByPost":
                repository.getGroupsByPost("003", null);
                break;
            case "deleteGroups":
                repository.deleteGroups("003", "1093");
                break;
            case "updateGroups":
                repository.updateGroups("003");
                break;
            case "getMyInfo":
                repository.getMyInfo("003");
                break;
            case "getWhaleSafeByGet":
                repository.getWhaleSafeByGet();
                break;
            case "getWhaleSafeByPost":
                repository.getWhaleSafeByPost(null);
                break;
            case "getSchedules":
                repository.getSchedules("003");
                break;
            case "getUserConfigByGet":
                repository.getUserConfigByGet("003");
                break;
            case "getUserConfigByPost":
                repository.getUserConfigByPost("003", null);
                break;
            case "getUserAuths":
                repository.getUserAuths("003");
                break;
        }
    }
}
