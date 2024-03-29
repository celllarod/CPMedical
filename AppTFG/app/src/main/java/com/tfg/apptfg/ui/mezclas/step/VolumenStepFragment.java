package com.tfg.apptfg.ui.mezclas.step;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tfg.apptfg.R;
import com.tfg.apptfg.databinding.FragmentStepVolumenBinding;
import com.tfg.apptfg.ui.mezclas.MezclasViewModel;


public class VolumenStepFragment extends Fragment {

    private MezclasViewModel mezclasViewModel;
    private VolumenStepViewModel volumenViewModel;
    private FragmentStepVolumenBinding binding;
    private RadioGroup rdGroup;
    private RadioButton rd1;
    private RadioButton rd2;


    @Override
    public void onStop() {
        Log.d("tag_s1", "stop");
        super.onStop();
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("tag_s1", "pause");
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("tag_s1", "createView");
        volumenViewModel = new ViewModelProvider(this).get(VolumenStepViewModel.class);
        mezclasViewModel = new ViewModelProvider(requireParentFragment()).get(MezclasViewModel.class);
        binding = FragmentStepVolumenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rdGroup = binding.radioGroup;
        rd1 = binding.rdVol1;
        rd2 = binding.rdVol2;

        rd1.setOnClickListener(this::onRadioButtonClicked);
        rd2.setOnClickListener(this::onRadioButtonClicked);

        return root;
    }

    @Override
    public void onDestroyView() {
        Log.d("tag_s1", "destroyview");
        super.onDestroyView();
        binding = null;
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        volumenViewModel.setVolumenBomba(((RadioButton) view).getText().toString());
        mezclasViewModel.setVolumenBomba(((RadioButton) view).getText().toString());
        Log.d("DEBUG", "Volumen seleccionado: " + ((RadioButton) view).getText().toString());
        Bundle res = new Bundle();
        res.putString("bundleKey", "result");
        getParentFragmentManager().setFragmentResult("requestKey", res);
//        this.getActivity().getSupportFragmentManager().setFragmentResult("requestKey", res);
    }

    public void resetearVista(){
       rd1.setChecked(false);
       rd2.setChecked(false);
       Log.d("tag_reset", "volumen");
    }
}