package com.Ako.tinnews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.Ako.tinnews.ui.home.HomeViewModel;
import com.Ako.tinnews.ui.search.SearchViewModel;

import org.jetbrains.annotations.NotNull;

public class NewsViewModelFactory implements ViewModelProvider.Factory {
    private final NewsRepository repository;

    public NewsViewModelFactory(NewsRepository repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(HomeViewModel.class)){
            return (T) new HomeViewModel(repository);
        }else if(modelClass.isAssignableFrom(SearchViewModel.class)){
            return (T) new SearchViewModel(repository);
        }else{
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}