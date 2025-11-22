package com.mobiverse.launcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobiverse.aikeyboard.R;
import java.util.ArrayList;
import java.util.List;

public class HomeScreenPageFragment extends Fragment {

    private RecyclerView rvAppsGrid;
    private AppGridAdapter adapter;
    private int pageNumber;

    public static HomeScreenPageFragment newInstance(int pageNumber) {
        HomeScreenPageFragment fragment = new HomeScreenPageFragment();
        Bundle args = new Bundle();
        args.putInt("page_number", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pageNumber = getArguments().getInt("page_number", 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, 
                             @Nullable ViewGroup container, 
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        rvAppsGrid = view.findViewById(R.id.rv_apps_grid);
        
        // 4x5 grid (typical Android launcher)
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        rvAppsGrid.setLayoutManager(layoutManager);
        
        // Load apps for this page from cloud/local
        List<AppInfo> apps = loadAppsForPage(pageNumber);
        adapter = new AppGridAdapter(apps);
        rvAppsGrid.setAdapter(adapter);
    }

    private List<AppInfo> loadAppsForPage(int page) {
        // This will be implemented in a future task.
        return new ArrayList<>();
    }
}