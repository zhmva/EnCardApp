package com.example.encard.ui.fragments.onBoard;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.encard.R;
import com.example.encard.data.local.Prefs;
import com.example.encard.databinding.FragmentOnBoardBinding;
import com.example.encard.ui.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OnBoardFragment extends BaseFragment<FragmentOnBoardBinding> {
    @Inject
    public Prefs prefs;

    @Override
    protected FragmentOnBoardBinding bind() {
        return FragmentOnBoardBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initViewPager();
        initPager();
        initBtn();
        initBack();
    }

    @Override
    protected void setupObservers() {
        initTabListener();
        initListenerPager();
    }


    private void initViewPager() {
        BoardAdapter boardAdapter = new BoardAdapter();
        binding.onBoardPager.setAdapter(boardAdapter);
    }

    private void initTabListener() {
        binding.tabBoard.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.on_board_unselected_dot);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.on_board_selected_dot);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initListenerPager() {
        binding.onBoardPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 4) {
                    binding.btnOnBoard.setVisibility(View.VISIBLE);
                    binding.btnOnBoard.setEnabled(true);
                } else {
                    binding.btnOnBoard.setVisibility(View.GONE);
                    binding.btnOnBoard.setEnabled(false);
                }
            }
        });
    }

    private void initPager() {
        new TabLayoutMediator(binding.tabBoard, binding.onBoardPager,
                (tab, position) -> {
                    if (position == 0) tab.setIcon(R.drawable.on_board_indicator);
                    else tab.setIcon(R.drawable.on_board_selected_dot);
                    tab.view.setEnabled(false);
                }).attach();
    }

    private void initBack() {
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();
                    }
                });
    }

    private void initBtn() {
        binding.btnOnBoard.setOnClickListener(view -> {
            prefs.saveState();
            controller.navigateUp();
        });
    }
}