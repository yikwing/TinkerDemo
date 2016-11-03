package demo.com.tinkerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv.setText("你好哦啊，你好!!!");
    }

    public void content(View view) {
        tv.setTextColor(Color.RED);
        tv.setTextSize(20);
 //       tv.setText("你好，你好，嘿嘿嘿");
        tv.setText("改了，改了，哈哈哈");
    }

    public void patch(View view) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tinkersample/patch_signed_7zip.apk";
        File file = new File(path);
        if (file.exists()){
            Toast.makeText(this,"补丁存在", Toast.LENGTH_SHORT).show();
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
        }else{
            Toast.makeText(this,"补丁不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
