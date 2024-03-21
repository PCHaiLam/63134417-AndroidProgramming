package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên listview
        //B1: chuẩn bị dữ liệu (tạo sẵn, lấy từ tệp, csdl)
        ArrayList<String> dl = new ArrayList<String>();
        dl.add("Bún đậu mắm tôm");
        dl.add("Phở bòa");
        dl.add("Bún bòa");
        dl.add("Bánh căn");

        //B2: Tìm tham chiếu đến ListView
        ListView lv = (ListView) findViewById(R.id.lvDoAn);
        //B3: tạo adapter (bộ chuyển đổi)
        ArrayAdapter<String> DoAn_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dl);

        //B4: Nạp dữ liệu nguồn vào listView
        lv.setAdapter(DoAn_Adapter);

        //Xử lí sự kiện khi click vào item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = DoAn_Adapter.getItem(position);
                // đã lấy dữ liệu
                //xử lí dữ liệu
                Toast.makeText(MainActivity.this,value, Toast.LENGTH_LONG).show();
            }
        });
    }

}