package com.example.covidapp.ui.homeFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.covidapp.KeepFit;
import com.example.covidapp.R;
import com.example.covidapp.WellBeing;
import com.example.covidapp.WhatsOpen;
import com.example.covidapp.utils.AlertDialogHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment implements View.OnClickListener {
    Button ImBored, KeepMeFit, WhatsOpen, Wellbeing;
    BottomNavigationView bottomNavigationView;
    Context mcontext=null;
    ImageView expand ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView= view.findViewById(R.id.nav_view);
        ImBored = view.findViewById(R.id.imBored);
        KeepMeFit = view.findViewById(R.id.keepFit);
        WhatsOpen = view.findViewById(R.id.whatsopen);
        Wellbeing = view.findViewById(R.id.wellbeing);
        expand = view.findViewById(R.id.expandinformation);
        expand.setOnClickListener(this);
        ImBored.setOnClickListener(this);
        KeepMeFit.setOnClickListener(this);
        WhatsOpen.setOnClickListener(this);
        Wellbeing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.expandinformation:{
                AlertDialogHandler.showSimpleDialog( getContext(),"1st vaccinations - 23,000,342 \n" +"2nd vaccinations - 23,000,342 \n"  + "New covid cases 2,330\n", "Hands. Face. Space.");
            }
            case R.id.imBored:{
                //navigationToAnother(new Preferences());
            }break;
            case R.id.keepFit:{
                navigationToAnother(new KeepFit());
            }break;
            case R.id.whatsopen:{
                navigationToAnother(new WhatsOpen());
            }break;
            case R.id.wellbeing:{
                navigationToAnother(new WellBeing());
            }break;

        }
    }


    private void  navigationToAnother(Activity activity)
    {
        Intent i = new Intent(getActivity(), activity.getClass());
        startActivity(i);
    }
}