package com.mumu.easyemoji;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * Created by MuMu on 2016/11/12/0012.
 */

public class EditWatcher implements TextWatcher {

    private View view;
    private EditText editText;

    public EditWatcher(View view, EditText editText) {
        this.view = view;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (count > 0 || s.length() > 0){
            view.setVisibility(View.VISIBLE);
        }else {
            view.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
//        int editStart = editText.getSelectionStart();
//        int editEnd = editText.getSelectionEnd();
//        if (editEnd - editStart > 0) {
//            view.setVisibility(View.VISIBLE);
//        } else {
//            view.setVisibility(View.GONE);
//        }
    }
}
