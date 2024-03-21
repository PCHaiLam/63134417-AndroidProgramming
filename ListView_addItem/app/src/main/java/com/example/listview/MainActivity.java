package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listMonAn;
    ArrayAdapter<String> MonAn_Adapter;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên listview
        //B1: chuẩn bị dữ liệu (tạo sẵn, lấy từ tệp, csdl)
        listMonAn = new ArrayList<String>();
        listMonAn.add("Bún đậu mắm tôm");
        listMonAn.add("Bún bò");
        listMonAn.add("Bánh căn");
        listMonAn.add("Bánh canh tôm hùm");

        //B2: Tìm tham chiếu đến ListView
        ListView listViewMonAn = (ListView) findViewById(R.id.lvDoAn);
        //B3: tạo adapter (bộ chuyển đổi)
        MonAn_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMonAn);

        //B4: Nạp dữ liệu nguồn vào listView
        listViewMonAn.setAdapter(MonAn_Adapter);

        //Tham chiếu tới ImageView
        imageView = findViewById(R.id.imageView);

        //Xử lí sự kiện khi click vào item
        listViewMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tenMonAn = MonAn_Adapter.getItem(position);
                //xử lí dữ liệu
                int imageID = getResources().getIdentifier(removeAccents(tenMonAn).toLowerCase(), "drawable", getPackageName());
//                if(imageID != 0) {
//                    imageView.setImageResource(imageID);
//                    imageView.setVisibility(View.VISIBLE);
//                }
//                else
                    Toast.makeText(MainActivity.this,tenMonAn, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void AddFood(View v) {
        //tạo biến lấy giá trị đã nhập vào edt
        EditText edt = (EditText) findViewById(R.id.addFood);
        String tenMonMoi = edt.getText().toString();
        //thêm dữ liệu vào Array
        listMonAn.add(tenMonMoi);
        //cập nhật lại list
        MonAn_Adapter.notifyDataSetChanged();
        edt.setHint("Thêm món ... ");
    }
    public static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

}