package com.example.sky.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sky.test.R;
import com.example.sky.test.dialog.FragmentDialog;

public class EditTextActivity extends AppCompatActivity {


    private EditText mEditText;
    private Button mDialog;
    private String mMaxString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mEditText = (EditText) findViewById(R.id.editext);
        mDialog = (Button) findViewById(R.id.btn_dialog);
        mEditText.addTextChangedListener(new TextWatcher() {

            private CharSequence temp;
            private int editStart ;
            private int editEnd ;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                temp = s;
                Log.d("EditTextActivity","beforeTextChanged s="+s +" s.length="+s.length());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                Log.d("EditTextActivity","onTextChanged s="+s +" s.length="+s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                editStart = mEditText.getSelectionStart();
                editEnd = mEditText.getSelectionEnd();
                if (temp.length() > 10) {
                   Log.d("EditTextActivity","Toast");
                    Toast.makeText(EditTextActivity.this,"已超出字数限制",Toast.LENGTH_SHORT).show();
                    s.delete(editStart-1, editEnd);
                    mEditText.setText(s);
                    mEditText.setSelection(s.length());
                }
                Log.d("EditTextActivity","afterTextChanged s="+s +" s.length="+s.length());
            }
        });


        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FragmentDialog().show(getSupportFragmentManager(),"");
            }
        });
    }
}
