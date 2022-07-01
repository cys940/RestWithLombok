package kr.gmtc.resttest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import dagger.hilt.android.AndroidEntryPoint;
import kr.gmtc.resttest.data.Impl.RestRepositoryImpl;
import kr.gmtc.resttest.databinding.ActivityMainBinding;
import kr.gmtc.resttest.ui.RequestAdapter;
import kr.gmtc.resttest.viewmodel.RestViewModel;
import kr.gmtc.resttest.viewmodel.factory.ViewModelFactory;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    private RestViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(new RestRepositoryImpl())).get(RestViewModel.class);

        RequestAdapter adapter = new RequestAdapter(viewModel.getAll().getValue(), item -> viewModel.request(item));
        binding.setAdapter(adapter);
        binding.setViewModel(viewModel);

        viewModel.getAll().observe(this, strings -> adapter.notifyDataSetChanged());
        viewModel.getCurrentLog().observe(this, s -> binding.result.setText(s));
    }
}