package cn.edu.gdmec.s07150836.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et1.findViewById(R.id.url);
        et2.findViewById(R.id.phone);
        tv1.findViewById(R.id.textView);
    }

    public void componentname(View v){
        ComponentName componentName=new ComponentName(this,IntentDemo2.class);
        Intent intent=new Intent();
        intent.setComponent(componentName);
        startActivity(intent);
    }

    public void intentfilter(View v){
        String action="cn.edu.gdmec.kissme";
        Intent intent1=new Intent();
        intent1.setAction(action);
        startActivity(intent1);
    }

    public void view(View v){
        Intent intent2=new Intent();
        intent2.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.parse(et1.getText().toString());
        intent2.setData(uri);
        startActivity(intent2);
    }

    public void dial(View v){
        Intent intent3=new Intent();
        intent3.setAction(Intent.ACTION_DIAL);
        Uri uri=Uri.parse("tel:"+et2.getText().toString());
        intent3.setData(uri);
        startActivity(intent3);
    }

    public void startactivityforresult(){
        Bundle bundle=new Bundle();
        bundle.putString("value",et1.getText().toString());
        Intent intent=new Intent(MainActivity.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 10:
                Bundle bundle=data.getExtras();
                tv1.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
