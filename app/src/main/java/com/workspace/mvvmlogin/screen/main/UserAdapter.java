package com.workspace.mvvmlogin.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.workspace.mvvmlogin.R;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.databinding.ItemUserBinding;
import com.workspace.mvvmlogin.screen.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemUserViewHolder> {
    private List<User> mUsers;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;
    private Context mContext;

    public UserAdapter(List<User> users, Context context) {
        mContext = context;
        mUsers = new ArrayList<>();
        if (users == null) {
            return;
        }
        mUsers.addAll(users);
    }

    @Override
    public ItemUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_user, parent, false);
        return new ItemUserViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemUserViewHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    public void setItemClickListener(BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    static class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;

        public ItemUserViewHolder(ItemUserBinding binding,
                BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bind(User user) {
            mBinding.setViewModel(new ItemUserViewModel(user, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
