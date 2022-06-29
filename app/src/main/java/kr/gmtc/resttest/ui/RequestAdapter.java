package kr.gmtc.resttest.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.gmtc.resttest.databinding.RequestItemBinding;
import kr.gmtc.resttest.ui.OnRequestListener;

public class RequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list = null;
    private OnRequestListener onRequestListener = null;

    public RequestAdapter(List<String> list, OnRequestListener onRequestListener){
        this.list = list;
        this.onRequestListener = onRequestListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        RequestItemBinding binding =
                RequestItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String request = list.get(position);

        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).bind(request, onRequestListener);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RequestItemBinding binding = null;
        public ViewHolder(RequestItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(String request, OnRequestListener onRequestListener) {
            binding.setText(request);
            binding.setOnRequestListener(onRequestListener);
            binding.executePendingBindings();
        }
    }
}
