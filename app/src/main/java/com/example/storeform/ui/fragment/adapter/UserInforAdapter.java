package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.ItemProfileInfoBinding;
import com.example.storeform.model.UserInfor;
import com.example.storeform.DetailUserInforActivity;

import java.util.ArrayList;
import java.util.List;

public class UserInforAdapter extends RecyclerView.Adapter<UserInforAdapter.ProfileInforVH> {

    private List<UserInfor> listProfileInfor = new ArrayList<>();
    private Context context;

    public UserInforAdapter(List<UserInfor> listProfileInfor, Context context) {
        this.listProfileInfor = listProfileInfor;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileInforVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProfileInfoBinding itemProfileInforBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_profile_info, parent, false);
        return new ProfileInforVH(itemProfileInforBinding.getRoot(), itemProfileInforBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileInforVH holder, int position) {
        ((ProfileInforVH) holder).setData(position);
    }

    @Override
    public int getItemCount() {
        if (listProfileInfor != null)
            return listProfileInfor.size();
        else return 0;
    }

    public class ProfileInforVH extends RecyclerView.ViewHolder {
        ItemProfileInfoBinding binding;
        String title;
        int imgId;

        public ProfileInforVH(View root, ItemProfileInfoBinding itemProfileInforBinding) {
            super(root);
            binding = itemProfileInforBinding;
        }

        public void setData(int position) {
            if (listProfileInfor.get(position) == null) return;
            title = listProfileInfor.get(position).getTitle();
            imgId = listProfileInfor.get(position).getIconResouce();
            binding.tvItemProlife.setText(title);
            binding.ivIcon.setImageResource(imgId);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailUserInforActivity.start(context, title);
                }
            });

        }
    }
}
