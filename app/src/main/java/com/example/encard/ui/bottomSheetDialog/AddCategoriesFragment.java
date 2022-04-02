package com.example.encard.ui.bottomSheetDialog;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.encard.databinding.FragmentAddCategoriesBinding;
import com.example.encard.ui.base.BaseBottomSheetDialogFragment;
import com.example.encard.ui.fragments.category.CategoryFragment;

public class AddCategoriesFragment extends BaseBottomSheetDialogFragment<FragmentAddCategoriesBinding> {
    private final Result result;

    @Override
    protected FragmentAddCategoriesBinding bind() {
        return FragmentAddCategoriesBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBtn();
    }

    private void initBtn() {
        binding.categoryBtn.setOnClickListener(view -> {
            String word = binding.editCategory.getText().toString();
            if (!word.isEmpty()) {
                result.transaction(word);
                dismiss();
            }
        });
    }

    public interface Result {
        void transaction(String word);
    }
}