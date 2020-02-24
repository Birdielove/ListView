package com.birdicomputers.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    List<String> adapterSongNameList = new ArrayList<String>();
    List<Integer> adapterSongPicList = new ArrayList<Integer>();
    int currentPlayId;
    boolean playstatus;

    public int getCurrentPlayId() {
        return currentPlayId;
    }

    public void setCurrentPlayId(int currentPlayId) {
        this.currentPlayId = currentPlayId;
        notifyDataSetChanged();
    }

    public boolean isPlaystatus() {
        notifyDataSetChanged();
        return playstatus;
    }

    public void setPlaystatus(boolean playstatus) {
        this.playstatus = playstatus;
        notifyDataSetChanged();
    }

    public MyCustomAdapter(List<String> adapterSongNameList, List<Integer> adapterSongPicList){
        this.adapterSongNameList = adapterSongNameList;
        this.adapterSongPicList = adapterSongPicList;
        currentPlayId = -1;
        playstatus = false;
    }

    public int getCount() {
        return adapterSongNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterSongNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater myLayoutInflater = LayoutInflater.from(parent.getContext());
            convertView = myLayoutInflater.inflate(R.layout.list_data,parent,false);
        }
        ImageView songPic = convertView.findViewById(R.id.imageView);
        TextView songName = convertView.findViewById(R.id.textView);
        ImageView playpuase = convertView.findViewById(R.id.imageView2);
        songName.setText(adapterSongNameList.get(position));
        songPic.setImageResource(adapterSongPicList.get(position));
        if(position == currentPlayId && playstatus){
            playpuase.setImageResource(R.drawable.pause);
        }
        else{
            playpuase.setImageResource(R.drawable.play);
        }
        return convertView;
    }
}
