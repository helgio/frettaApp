package com.trainstation.frettirtest2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Helgi on 23/01/16.
 */
public class ListCellAdapter extends BaseAdapter {

    private Activity activity;
    private static LayoutInflater inflater=null;
    private List<CellData> data;
    Context context;

    public ListCellAdapter(Activity a, List<CellData> data, Context context) {
        this.context = context;
        activity = a;
        this.data = data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {
        View viewCell=convertView;
        if(convertView==null)
            viewCell = inflater.inflate(R.layout.listviewcell, null);
        TextView text = (TextView) viewCell.findViewById(R.id.text);
        text.setText(data.get(position).text);

        String url = data.get(position).imageUrl;
        ImageView imageView = (ImageView) viewCell.findViewById(R.id.image);
        Picasso.with(activity)
                .load(url)
                .into(imageView);

        viewCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, WebViewActivity.class);
                i.putExtra("url", data.get(position).url);
                context.startActivity(i);

            }
        });


        return viewCell;
    }


}
