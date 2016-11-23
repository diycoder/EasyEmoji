package com.mumu.easyemoji;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MultiEmotionActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mInputContainer;
    private Context mContext;
    private EmotionInputDetector mDetector;
    private ListView mChatContent;

    private int currentIndex = 0;
    private int position = 0;


    private RadioButton mWeiBoEmoJi;
    private RadioButton mQQEmoJi;
    private RadioButton mLanXiaoHuaEmoji;
    private TextView mAddView;
    private CheckBox mSmileView;
    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_emotion);
        mContext = this;

        initView();
    }

    private void initView() {
        mChatContent = (ListView) findViewById(R.id.listView_Content);
        mSmileView = (CheckBox) findViewById(R.id.cb_smile);
        mSendButton = (Button) findViewById(R.id.btn_send);
        mInputContainer = (EditText) findViewById(R.id.et_input_container);
        LinearLayout  mEmoJiContainer = (LinearLayout) findViewById(R.id.ll_face_container);

        mWeiBoEmoJi = (RadioButton) findViewById(R.id.rb_weibo_emoji);
        mQQEmoJi = (RadioButton) findViewById(R.id.rb_emoji);
        mLanXiaoHuaEmoji = (RadioButton) findViewById(R.id.rb_lanxiaohua);
        mAddView = (TextView) findViewById(R.id.tv_add);
        mAddView.setOnClickListener(this);

        mDetector = EmotionInputDetector.with(this)
                .bindSendButton(mSendButton)
                .bindToEditText(mInputContainer)
                .setEmotionView(mEmoJiContainer)
                .bindToContent(mChatContent)
                .bindToEmotionButton(mSmileView);

        initPageView();
    }


    private void initPageView() {
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        EmoJiFragment emoJiFragment = new EmoJiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("EmoJiType", currentIndex);
        emoJiFragment.setArguments(bundle);
        trx.replace(R.id.fl_emoji_contanier, emoJiFragment).commitAllowingStateLoss();
    }

    public void clickFace(View view) {
        switch (view.getId()) {
            case R.id.rb_weibo_emoji:
                position = 0;
                break;
            case R.id.rb_lanxiaohua:
                position = 1;
                break;
            case R.id.rb_emoji:
                position = 2;
                break;

        }
        switchEmoJiBg(position);
    }

    private void switchEmoJiBg(int position) {
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        EmoJiFragment emoJiFragment = new EmoJiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("EmoJiType", position);
        emoJiFragment.setArguments(bundle);
        trx.replace(R.id.fl_emoji_contanier, emoJiFragment).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (!mDetector.interceptBackPress()) {
            super.onBackPressed();
        }
    }

    public EditText getEt_input_container() {
        return mInputContainer;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add:
                Toast.makeText(mContext, "add", Toast.LENGTH_SHORT).show();
                position = 0;
                break;
        }
    }
}
