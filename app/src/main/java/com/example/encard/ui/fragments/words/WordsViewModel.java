package com.example.encard.ui.fragments.words;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.encard.App;
import com.example.encard.data.common.Resource;
import com.example.encard.data.model.entity.PixabayResponse;

public class WordsViewModel extends ViewModel {

    protected LiveData<Resource<PixabayResponse>> liveData = new MutableLiveData<>();

    protected void getImageByWord(String keyWord) {
        liveData = App.repository.getImageLiveData(keyWord);
    }
}

