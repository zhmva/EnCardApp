package com.example.encard.ui.fragments.onBoard;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encard.R;
import com.example.encard.databinding.ItemBoardPagerBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private final int[] animate = {R.raw.theone, R.raw.two, R.raw.three, R.raw.four,R.raw.five};
    private final String[] titles = {"Категории", "Слова", "Изучение", "Личный кабинет",
            "Давайте начнём !"};
    private final String[] descriptions = {"Создавайте собственные категории для слов"
            , "Создавайте слова на английском и \nкликайте на карточку чтобы увидеть его \n" +
            "перевод и картинку для ассоциации" ,
            "Свайпайте карточку вправо если вы \n запомнили,влево если пока ещё не уверены",
            "Следите за своими ачивками и \n количеством очков опыта",""};

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardPagerBinding binding = ItemBoardPagerBinding.inflate(LayoutInflater
                .from(parent.getContext()),parent,false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBind(animate[position],titles[position],descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return animate.length;
    }

    public static class BoardViewHolder extends RecyclerView.ViewHolder {
        final ItemBoardPagerBinding binding;

        public BoardViewHolder(@NonNull ItemBoardPagerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(int i, String title, String description) {
            binding.lottieItem.setAnimation(i);
            binding.tvTitle.setText(title);
            binding.tvDesc.setText(description);
        }
    }
}

