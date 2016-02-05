package com.example.davidsun.phree6;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton, mButton2;
    private TextView mTextView;
    private List<EditText> allEds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        allEds = new ArrayList<EditText>();
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(onClick());
        mTextView = (TextView) findViewById(R.id.textView);
        TextView textView = new TextView(this);
        textView.setText("New text");
        mButton = (Button) findViewById(R.id.buttons);
        mButton.setOnClickListener(onClick2());
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mLayout = (LinearLayout) findViewById(R.id.linearLayoutl);
                mEditText = (EditText) findViewById(R.id.editText);
                if(((LinearLayout) mLayout).getChildCount() > 0)
                    ((LinearLayout) mLayout).removeAllViews();
                String[] chrs = getVars(mEditText.getText().toString());
                mTextView = (TextView) findViewById(R.id.textView);
                mTextView.setText(java.util.Arrays.toString(chrs).replaceAll("\\[|\\]", ""));
                for(int l=1; l<=chrs.length; l++){
                    //mLayout.addView(createNewTextView(mEditText.getText().toString()));
                    mLayout.addView(createNewTextView(chrs[l-1]));
                }
                mLayout = (LinearLayout) findViewById(R.id.linearLayoutr);
                if(((LinearLayout) mLayout).getChildCount() > 0)
                    ((LinearLayout) mLayout).removeAllViews();
                //int chrs = hwmny();
                List<EditText> allEds = new ArrayList<EditText>();
                for(int l=1; l<=chrs.length; l++){
                    EditText temp = createNewEditText(l+"");
                    mLayout.addView(temp);
                    allEds.add(temp);
                }
                //mLayout.addView(createNewTextView(mEditText.getText().toString()));
            }
        };
    }
    private View.OnClickListener onClick2() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTextView = (TextView) findViewById(R.id.textView);
                double a = 0;
                for(int i=0; i<allEds.size();i++){
                    EditText temp = allEds.get(i);
                    a += Double.parseDouble(temp.getText().toString());
                }
                mTextView.setText(a + "");
                //mLayout.addView(createNewTextView(mEditText.getText().toString()));
            }
        };
    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setTextSize(20);
        textView.setHeight(124);
        textView.setText(text + ":");
        return textView;
    }
    private EditText createNewEditText(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        final EditText editText = new EditText(this);
        editText.setLayoutParams(lparams);
        editText.setText("");
        return editText;
    }
    public static String[] getVars(String s){
        String LEFT = "({[<";
        String RIGHT = ")}]>";
        String OPER = "+-/*=";
        String prelim="";
        for(int j=0;j<s.length();j++){
            if(RIGHT.contains(s.substring(j,j+1)) || LEFT.contains(s.substring(j,j+1))){
                //remove parens
            }else{
                prelim+=s.substring(j,j+1);
            }
        }
        String ans="";
        for(int i=0;i<prelim.length();i++){
            if(OPER.contains(prelim.substring(i,i+1))){
                ans+=",";
            } else {
                ans+=prelim.substring(i,i+1);
            }
        }
        String[] finAns = ans.split(",");
        return finAns;
    }
//    private String int hwmny(String a){
//        String[] exclude=["+","-","/","*"];
//        ArrayList<int> indices = new ArrayList<int>();
//        int j = 0;
//        indices.add(j);
//        ArrayList<String> vars = new ArrayList<String>();
//        for(int i =0; i<exclude.length;i++){
//            indices.add(a.indexOf(exclude[i]));
//        }
//        for(int k=0;k<indices.size();k++){
//            vars.add(a.substring(indices[k]+1, indices[k+1]));
//        }
//    }
}

