package com.example.encard.ui.fragments.category;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encard.data.model.entity.CategoryEntity;
import com.example.encard.databinding.FragmentCategoryBinding;
import com.example.encard.ui.base.BaseFragment;
import com.example.encard.ui.bottomSheetDialog.AddCategoriesFragment;
import com.example.encard.ui.fragments.category.functions.DeleteBySwipe;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryFragment extends BaseFragment<FragmentCategoryBinding>
        implements AddCategoriesFragment.Result, CatAdapter.Result {
    private CatAdapter categoryAdapter;
    @Inject
    public CategoryViewModel categoryViewModel;
    private DeleteBySwipe deleteBySwipe;

    @Override
    protected FragmentCategoryBinding bind() {
        return  FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        initAdapter();
        initBtn();
    }

    @Override
    protected void setupObservers() {
        initListener();
        initSwipeListener();
        initTouchHelperListener();
    }

    private void initBtn() {
        binding.btnAddCategory.setOnClickListener(v ->
                new AddCategoriesFragment(this).show(requireActivity()
                                .getSupportFragmentManager(), "crush"));
    }

    private void initAdapter() {
        categoryAdapter = new CatAdapter(this);
        binding.rvCategory.setAdapter(categoryAdapter);
    }

    private void initListener() {
        categoryViewModel.getList().observe(getViewLifecycleOwner(), categories ->
                categoryAdapter.setList(categories));
    }

    @Override
    public void transaction(String word) {
        categoryViewModel.createCategory(word);
    }


    private void initSwipeListener() {
        deleteBySwipe = new DeleteBySwipe(requireContext()) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int post = viewHolder.getAdapterPosition();
                final CategoryEntity category = categoryAdapter.getList().get(post);
                categoryViewModel.deleteCategory(category);
            }
        };
    }

    private void initTouchHelperListener() {
        ItemTouchHelper itemTouchHelper =
                new ItemTouchHelper(deleteBySwipe);
        itemTouchHelper.attachToRecyclerView(binding.rvCategory);
    }

    @Override
    public void addTag(String categoryTag) {
        NavDirections action =
                Fragment
    }
}