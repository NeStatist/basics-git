package com.artemchep.basics_git.database;

import androidx.annotation.NonNull;

import com.artemchep.basics_git.domain.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Store implementation that does absolutely
 * nothing.
 */
public class StoreStub implements Store {
    private static ArrayList<Post> data = new ArrayList<Post>();

    @Override
    public void insert(@NonNull Post post) {
        data.add(post);
    }

    @NonNull
    @Override
    public List<Post> select() {
        return data;
    }
}