package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.DetailOrderManagerActivity;
import com.example.storeform.R;
import com.example.storeform.databinding.ItemProfileManagerBinding;

import java.util.ArrayList;
import java.util.List;

public class ProfileManagerAdapter extends RecyclerView.Adapter<ProfileManagerAdapter.ProfileManagerVH> {

    private List<String> listProfileManager = new ArrayList<>();
    private Context context;

    public ProfileManagerAdapter(List<String> listProfileManager, Context context) {
        this.listProfileManager = listProfileManager;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileManagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProfileManagerBinding itemProfileManagerBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_profile_manager, parent, false);
        return new ProfileManagerVH(itemProfileManagerBinding.getRoot(), itemProfileManagerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileManagerVH holder, int position) {
        ((ProfileManagerVH) holder).setData(position);
    }

    @Override
    public int getItemCount() {
        if (listProfileManager != null)
            return listProfileManager.size();
        else return 0;
    }

    public class ProfileManagerVH extends RecyclerView.ViewHolder {
        ItemProfileManagerBinding binding;

        public ProfileManagerVH(View root, ItemProfileManagerBinding itemProfileManagerBinding) {
            super(root);
            binding = itemProfileManagerBinding;
        }

        public void setData(int position) {
            if (listProfileManager.get(position) == null) return;
            final String title = listProfileManager.get(position);
            binding.tvItemProlife.setText(title);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailOrderManagerActivity.start(context, title);
                }
            });

        }
    }
}
