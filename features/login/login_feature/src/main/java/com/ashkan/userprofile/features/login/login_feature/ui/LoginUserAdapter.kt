package com.ashkan.userprofile.features.login.login_feature.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ashkan.userprofile.common.ui.adapter.BaseAdapter
import com.ashkan.userprofile.common.ui.adapter.BaseVH
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.databinding.AdapterUserItemBinding

class LoginUserAdapter(val callBack: (LoginResponse) -> Unit) : BaseAdapter<LoginResponse, LoginUserAdapter.UserVH>() {

    inner class UserVH(private val binding: AdapterUserItemBinding) :
        BaseVH<LoginResponse>(binding) {

        override fun bindData(item: LoginResponse) {
            binding.root.setOnClickListener {
                callBack(item)
            }
            binding.name.text = item.name
            binding.email.text = item.email
        }
    }

    override fun onAreItemsTheSame(oldItem: LoginResponse, newItem: LoginResponse): Boolean =
        oldItem == newItem

    override fun onAreContentsTheSame(oldItem: LoginResponse, newItem: LoginResponse): Boolean =
        oldItem.id == newItem.id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        DataBindingUtil.inflate<AdapterUserItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_user_item,
            parent,
            false
        ).also { binding ->
            return UserVH(binding)
        }
    }
}