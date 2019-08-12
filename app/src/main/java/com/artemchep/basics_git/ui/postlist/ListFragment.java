package com.artemchep.basics_git.ui.postlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.artemchep.basics_git.App;
import com.artemchep.basics_git.AddData;
import com.artemchep.basics_git.OnOpen;
import com.artemchep.basics_git.R;
import com.artemchep.basics_git.database.Store;

public class ListFragment extends Fragment implements AddData {

    private PostListAdapter mAdapter;
    private OnOpen callback;

    public ListFragment(OnOpen callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new PostListAdapter();

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(mAdapter);
        view.findViewById(R.id.buttonAdd)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.onOpenFrag();
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        final Store store = App.getStore(requireContext());
        mAdapter.submitList(store.select());
    }

    @Override
    public void onAddDataPost() {
        final Store store = App.getStore(requireContext());
        mAdapter.submitList(store.select());
    }
}