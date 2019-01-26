/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if(savedInstanceState==null) {
            Bundle bundle=getIntent().getExtras();
            int headind=bundle.getInt("headIndex");
            int bodyind=bundle.getInt("bodyIndex");
            int legind=bundle.getInt("legIndex");
            bode_part_fragment head = new bode_part_fragment();
            head.setmImagesId(AndroidImageAssets.getHeads());
            head.setmListIndex(headind);
            bode_part_fragment body = new bode_part_fragment();
            body.setmImagesId(AndroidImageAssets.getBodies());
            body.setmListIndex(bodyind);
            bode_part_fragment leg = new bode_part_fragment();
            leg.setmImagesId(AndroidImageAssets.getLegs());
            leg.setmListIndex(legind);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.head_container, head).commit();
            fragmentManager.beginTransaction().add(R.id.Body_container, body).commit();
            fragmentManager.beginTransaction().add(R.id.leg_container, leg).commit();
        }
    }
}
