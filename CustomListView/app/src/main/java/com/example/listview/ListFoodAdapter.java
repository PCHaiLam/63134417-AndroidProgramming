package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFoodAdapter extends BaseAdapter {
    private List<Food> listData; // Lưu dữ liệu được nạp từ DataSource cho Adapter
    private LayoutInflater layoutlnflater; // Chuyển đổi Layout XML thành View java
    private Context context;
    public ListFoodAdapter(Context aContext, List<Food> listData) {
        this.context = aContext;
        this. listData = listData;
        layoutlnflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutlnflater.inflate(R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.foodName = (TextView) convertView.findViewById(R.id.foodName);
            holder.foodFrice = (TextView) convertView.findViewById(R.id.foodPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            Food food = this.listData.get(position);
            holder.foodName.setText(food.getFoodName());
            holder.foodFrice.setText("Giá: " + food.getFoodPrice());
            int imageID = this.getMipmapResidByName(food.getFoodImage());
            holder.imageView.setImageResource(imageID);
        return convertView;
    }
    public int getMipmapResidByName(String resName) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
        public static class ViewHolder {
        ImageView imageView;
        TextView foodName;
        TextView foodFrice;
    }
        @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
