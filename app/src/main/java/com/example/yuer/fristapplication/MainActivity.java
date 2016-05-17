package com.example.yuer.fristapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.*;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    MyAdapter myAdapter;
    myOnItemClickListener myOnItemClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gv);
        gridView.setAdapter(myAdapter = new MyAdapter());

        gridView.setOnItemClickListener(myOnItemClickListener =  new myOnItemClickListener());
    }
    class myOnItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(MainActivity.this, ImageDetailsActivity.class);
            intent.putExtra("image_position", i);
            MainActivity.this.startActivity(intent);
        }
    }

    class MyAdapter extends BaseAdapter{

            @Override
            public int getCount() {
                return Images.imageUrls.length;
            }

            @Override
            public Object getItem(int i) {
                return Images.imageUrls[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
                if(view == null){
                holder = new ViewHolder();
                    view = getLayoutInflater().inflate(R.layout.item_grideview_image,null);
                    holder.iv = (ImageView) view.findViewById(R.id.iv_item);
                    view.setTag(holder);
                }else{
                    holder = (ViewHolder) view.getTag();
                }
                com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(Images.imageUrls[i],holder.iv);
//                holder.iv.setBackgroundResource(R.drawable.empty_photo);

                return view;
            }

            class ViewHolder{
                ImageView iv ;
            }


        }



}
