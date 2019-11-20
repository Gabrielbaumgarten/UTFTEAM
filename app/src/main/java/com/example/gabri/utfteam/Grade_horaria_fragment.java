package com.example.gabri.utfteam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Grade_horaria_fragment extends Fragment {
//
//    private GradeHorariaFragmentViewModel mViewModel;

    public static Grade_horaria_fragment newInstance() {
        return new Grade_horaria_fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grade_horaria, container, false);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(GradeHorariaFragmentViewModel.class);
//        // TODO: Use the ViewModel
//    }

}
