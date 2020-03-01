package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeform.R;
import com.example.storeform.base.ChannelUsers;
import com.example.storeform.data.Message.Message;
import com.example.storeform.data.Message.MessageReceived;
import com.example.storeform.data.Message.MessageSent;
import com.example.storeform.databinding.SmsFragmentBinding;
import com.example.storeform.ui.fragment.adapter.MessageListAdapter;

public class SmsFragment extends Fragment {
    private static SmsFragment instance;
    private SmsFragmentBinding binding;
    private ChannelUsers targetContact;
    private MessageListAdapter messageListAdapter;

    public static SmsFragment newInstance(String s, String s1) {
        if (instance == null)
            instance = new SmsFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sms_fragment, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        messageListAdapter = new MessageListAdapter(getContext());
        binding.messageList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.messageList.setAdapter(messageListAdapter);

        addCustomMes();
        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = binding.messageInput.getText().toString();
                Message message = new MessageSent(1111, messageText);
                addMessageItem(message);
                binding.messageInput.setText("");
            }
        });
    }

    private void addCustomMes() {

        Message message;
        message = new MessageSent(1111, "Hi Quan");
        addMessageItem(message);

        message = new MessageSent(1111, "Hi Quan");
        addMessageItem(message);

        message = new MessageReceived(1111, "", "Hi Quan");
        addMessageItem(message);

        message = new MessageSent(1111, "Hi Quan");
        addMessageItem(message);

        message = new MessageReceived(1111, "", "Hi Quan ABC");
        addMessageItem(message);

        message = new MessageSent(1111, "Hi Quan XYZ");
        addMessageItem(message);

        message = new MessageSent(1111, "Hi Quan MNB");
        addMessageItem(message);
    }

    private void addMessage(MessageReceived message) {
        if (message.getChannelId() != targetContact.getChannelId())
            return;
        addMessageItem(message);
    }


    private void addMessageItem(Message message) {
        messageListAdapter.addItem(message);
        messageListAdapter.notifyDataSetChanged();
        binding.messageList.smoothScrollToPosition(messageListAdapter.getItemCount());
    }

}
