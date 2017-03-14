package example.com.mytextanimation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.mytextanimation.R;
import example.com.mytextanimation.utils.SpanStringUtils;

/**
 * Created by 20256473 on 2017/3/13.
 */

public class ListAdapter extends BaseAdapter {

    private Context context;
    private  List<String> mdata;
    private LayoutInflater mInflater;

    public ListAdapter() {
    }
    public ListAdapter(Context context,List<String> mdata ){
        this.context=context;
        this.mdata=mdata;
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    public void addMData(String data) {
        if (null == mdata) {
            mdata = new ArrayList<>();
        }
        mdata.add(data);
        notifyDataSetChanged();
    }


    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            mInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_listview, null);
            holder.info = (TextView)convertView.findViewById(R.id.tv_show);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();

        }
        //  holder.info.setText(mdata.get(position));
        holder.info.setText(SpanStringUtils.getEmotionContent(1,context,holder.info,mdata.get(position)));
        return convertView;
    }

    class ViewHolder
    {
        public TextView info;
    }
    //然后重写getView


}
