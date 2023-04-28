package com.example.matchu;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<College> likedList;
    LayoutInflater inflater;
    LinearLayout parent;


    public CustomBaseAdapter(Context context, List<College> likedList){
        this.context = context;
        this.likedList = likedList;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return likedList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Log.d("TAG", "in the getview");
        //all of the text displaying in the listView
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = (TextView)convertView.findViewById(R.id.textView);
        txtView.setText(likedList.get(i).getCollegeName());
        TextView hi = (TextView)convertView.findViewById(R.id.state);
        hi.setText(likedList.get(i).getState());
        TextView budget = (TextView)convertView.findViewById(R.id.budget);
        String tuition=String.valueOf(likedList.get(i).getTuition());
        budget.setText("$" + tuition + "/yr");

        Button openPop = (Button) convertView.findViewById(R.id.heart);
        openPop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("TAG", "got to onclick");
                View ok = View.inflate(context, R.layout.popup_layout, null);
                Button close = ok.findViewById(R.id.close);
                TextView body = ok.findViewById(R.id.state4);
                Log.d("TAG", "close is defined");

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;


                TextView state = (TextView)ok.findViewById(R.id.state4);
                state.setText("State: " + String.valueOf(likedList.get(i).getState()));

                TextView city = (TextView)ok.findViewById(R.id.city);
                city.setText("City: " + String.valueOf(likedList.get(i).getCity()));

                TextView sat = (TextView)ok.findViewById(R.id.sat);
                sat.setText("SAT: " + String.valueOf(likedList.get(i).getSAT()));

                TextView act = (TextView)ok.findViewById(R.id.act);
                act.setText("ACT: " + String.valueOf(likedList.get(i).getACT()));

                TextView aidPercent = (TextView)ok.findViewById(R.id.aidPercent);
                aidPercent.setText("Aid percent: " + String.valueOf(likedList.get(i).getAidPercent()));

                TextView costAfterAid = (TextView)ok.findViewById(R.id.costAfterAid);
                costAfterAid.setText("Cost after aid" + String.valueOf(likedList.get(i).getCostAfterAid()));




                PopupWindow popupWindow = new PopupWindow(ok, width, height, false);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0,0);

                body.setText(R.string.message);
                close.setOnClickListener(view -> {
                    popupWindow.dismiss();

                });
            }



          });
        return convertView;
}





}
