package com.myapp.lexicon.aboutapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.myapp.lexicon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutAppFragment extends Fragment
{
    View fragment_view = null;

    public AboutAppFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (fragment_view == null)
        {
            fragment_view = inflater.inflate(R.layout.fragment_about_app, container, false);
        }

        Button buttonEvaluate = (Button) fragment_view.findViewById(R.id.btn_evaluate);
        buttonEvaluate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.app_link)));
                startActivity(intent);
            }
        });

        return fragment_view;
    }

}