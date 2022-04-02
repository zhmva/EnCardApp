package com.example.encard.ui.fragments.words;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.encard.data.common.KeywordSended;
import com.example.encard.ui.base.BaseFragment;
import com.example.encard.databinding.FragmentWordsBinding;
import com.example.encard.ui.fragments.addWordsFragment.AddWordsFragment;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> implements KeywordSended {
    private AddWordsFragment addWordsFragment;
    private WordsAdapter adapter;
    private WordsViewModel viewModel;

    @Override
    protected FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        adapter = new WordsAdapter();
        binding.recycler.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(WordsViewModel.class);
    }

    @Override
    protected void setupObservers() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.FABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addWordsFragment = new AddWordsFragment();
//
            }
        });
    }

    @Override
    public void sendWord(String word) {

    }
}