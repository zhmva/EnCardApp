package com.example.encard.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.example.encard.R;
import com.example.encard.databinding.FragmentAddCategoriesBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public abstract class BaseBottomSheetDialogFragment<VB extends ViewBinding>
        extends BottomSheetDialogFragment {

    protected FragmentAddCategoriesBinding binding;

    protected abstract FragmentAddCategoriesBinding bind();

    protected NavController controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.nav_host);
        return binding.getRoot();
    }
}
