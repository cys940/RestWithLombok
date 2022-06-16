package kr.gmtc.resttest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import kr.gmtc.resttest.databinding.ActivityMainBinding;
import kr.gmtc.resttest.model.ht08.cctv.Cctv;
import kr.gmtc.resttest.model.ht08.cfg.SystemConfig;
import kr.gmtc.resttest.model.ht08.equip.Device;
import kr.gmtc.resttest.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    private RestViewModel viewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(RestViewModel.class);

        viewModel.getCurrentLog().observe(this, s -> binding.result.setText(s));
    }
}