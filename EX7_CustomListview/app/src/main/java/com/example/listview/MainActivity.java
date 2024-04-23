package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ArrayList<Food> listMonAn;
    ListFoodAdapter MonAn_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chuẩn bị dữ liệu mẫu
        listMonAn = new ArrayList<>();
        listMonAn.add(new Food("Bún đậu mắm tôm", "bun_dau_mam_tom", 72.000));
        listMonAn.add(new Food("Bún bò", "bun_bo", 35.000));
        listMonAn.add(new Food("Bánh căn", "banh_can", 2.000));
        listMonAn.add(new Food("Bánh canh tôm hùm", "banh_canh_tom_hum", 300.000));

        // Tìm tham chiếu đến ListView
        ListView listViewMonAn = findViewById(R.id.lvDoAn);

        // Tạo adapter và nạp dữ liệu nguồn vào ListView
        MonAn_Adapter = new ListFoodAdapter(this, listMonAn);
        listViewMonAn.setAdapter(MonAn_Adapter);

        // Xử lý sự kiện khi click vào item
        listViewMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedFood = listMonAn.get(position);
                String tenMonAn = selectedFood.getFoodName();
                // Xử lý dữ liệu
                Toast.makeText(MainActivity.this, tenMonAn, Toast.LENGTH_LONG).show();
            }
        });
    }
//        public void AddFood(View v) {
//        //tạo biến lấy giá trị đã nhập vào edt
//        EditText edt = (EditText) findViewById(R.id.addFood);
//        String tenMonMoi = edt.getText().toString();
//        //thêm dữ liệu vào Array
//        listMonAn.add(tenMonMoi);
//        //cập nhật lại list
//        MonAn_Adapter.notifyDataSetChanged();
//        edt.setHint("Thêm món ... ");
//    }
}
