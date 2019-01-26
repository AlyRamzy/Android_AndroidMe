package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class bode_part_fragment extends Fragment {
    private List<Integer> mImagesId;
    private int  mListIndex;
    private static final String name= bode_part_fragment.class.getName();
    private static final String list_iDs= "List_IDs";
    private static final String ListIndex= "List_Index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_body_part,container,false);
        final ImageView imageView =(ImageView) rootView.findViewById(R.id.body_part_image_view);
        if(savedInstanceState!=null) {
            mImagesId=savedInstanceState.getIntegerArrayList(list_iDs);
            mListIndex=savedInstanceState.getInt(ListIndex);

        }
       if(mImagesId!=null)
           imageView.setImageResource(mImagesId.get(mListIndex));
       else
           Log.v(name,"This List is Null");
       imageView.setOnClickListener(new View.OnClickListener(

       ) {
           @Override
           public void onClick(View view) {
               if(mListIndex<mImagesId.size()-1)
                   mListIndex++;
               else
                   mListIndex=0;
               imageView.setImageResource(mImagesId.get(mListIndex));

           }
       });

        return rootView;
    }
    public void setmImagesId(List<Integer> imagesId)
    {
        mImagesId=imagesId;
    }



    public void setmListIndex(int index)
    {
        mListIndex=index;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(list_iDs,(ArrayList<Integer>)mImagesId);
        outState.putInt(ListIndex,mListIndex);
    }
}
