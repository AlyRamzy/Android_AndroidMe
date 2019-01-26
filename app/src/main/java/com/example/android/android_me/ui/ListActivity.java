package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class ListActivity extends AppCompatActivity implements master_list_fragment.OnImageClickListener {
    private int headInd;
    private int bodyInd;
    private int legInd;
    private boolean mTwoBane;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_master_list);
        if(findViewById(R.id.android_me_linear_layout)!=null)
        {
            Button next=(Button)findViewById(R.id.next);
            next.setVisibility(View.GONE);
            GridView gridView=(GridView)findViewById(R.id.grid_view);
            gridView.setNumColumns(2);
            mTwoBane=true;
            if(savedInstanceState==null) {
                bode_part_fragment head = new bode_part_fragment();
                head.setmImagesId(AndroidImageAssets.getHeads());
                bode_part_fragment body = new bode_part_fragment();
                body.setmImagesId(AndroidImageAssets.getBodies());
                bode_part_fragment leg = new bode_part_fragment();
                leg.setmImagesId(AndroidImageAssets.getLegs());
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.head_container, head).commit();
                fragmentManager.beginTransaction().add(R.id.Body_container, body).commit();
                fragmentManager.beginTransaction().add(R.id.leg_container, leg).commit();
            }
        }
        else
        {
            mTwoBane=false;
        }

    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position= " + position, Toast.LENGTH_SHORT).show();
        int bodypart = position / 12;
        int listindex = position - 12 * bodypart;
        if (mTwoBane) {
            bode_part_fragment newfragment=new bode_part_fragment();
            switch(bodypart)
            {
                case 0:
                    newfragment.setmImagesId(AndroidImageAssets.getHeads());
                    newfragment.setmListIndex(listindex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.head_container,newfragment).commit();
                    break;
                case 1:
                    newfragment.setmImagesId(AndroidImageAssets.getBodies());
                    newfragment.setmListIndex(listindex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Body_container,newfragment).commit();
                    break;
                case 2:
                    newfragment.setmImagesId(AndroidImageAssets.getLegs());
                    newfragment.setmListIndex(listindex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.leg_container,newfragment).commit();
                    break;
                default: break;

            }


        } else {

            switch (bodypart) {
                case 0:
                    headInd = listindex;
                    break;
                case 1:
                    bodyInd = listindex;
                    break;
                case 2:
                    legInd = listindex;
                    break;
                default:
                    break;
            }
            Bundle b = new Bundle();
            b.putInt("headIndex", headInd);
            b.putInt("bodyIndex", bodyInd);
            b.putInt("legIndex", legInd);
            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(b);
            Button NextButton = (Button) findViewById(R.id.next);
            NextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });

        }
    }
}
