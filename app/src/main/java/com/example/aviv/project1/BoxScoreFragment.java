package com.example.aviv.project1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 07/03/2018.
 */

public class BoxScoreFragment extends Fragment {
    TextView TV;
    View rootView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       rootView= inflater.inflate(R.layout.activity_chatactivity2, container, false);
        Downlode();
        return rootView;




    }

    private void Downlode() {
        TV = (TextView)rootView.findViewById(R.id.tv1);
        new DownloadText(TV).execute("");

    }


    }
}
