package com.yao.feicui.jsondemo1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int MESSAGE = 1;
    private ListView mListView;
    private List<Person> personList;
    private Button btn_json;
    private String mJsonString;
    private String mPath;
    private static String PATH = "http://192.168.1.147:8080/index2.jsp";
    private static final String TAG = "MainActivity";
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE:
                    JsonAdapter adapter = new JsonAdapter(MainActivity.this, personList);
                    mListView.setAdapter(adapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.lv_show);
        btn_json = (Button) findViewById(R.id.btn_json);
        btn_json.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//                String path=PATH+"? action_flag=person";
                mPath = PATH;
                new Thread() {
                    @Override
                    public void run() {
                        mJsonString = HttpUtils.getJsonContent(mPath);
                        personList = JsonTools.getPerson(mJsonString);
                        mHandler.sendEmptyMessage(MESSAGE);
                    }
                }.start();


            }
        });
    }
}
