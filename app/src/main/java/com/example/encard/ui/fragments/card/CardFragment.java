package com.example.encard.ui.fragments.card;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.encard.R;
import com.example.encard.databinding.FragmentCardBinding;
import com.example.encard.ui.base.BaseFragment;

public class CardFragment extends BaseFragment<FragmentCardBinding> {

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    protected FragmentCardBinding bind() {
        return FragmentCardBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    protected void setupUI() {
        String cardTitle = "Sunset";
        binding.imageCard.setImageResource(R.drawable.img);
        binding.tvCard.setText(cardTitle);

    }

    @Override
    protected void setupObservers() {

    }
}