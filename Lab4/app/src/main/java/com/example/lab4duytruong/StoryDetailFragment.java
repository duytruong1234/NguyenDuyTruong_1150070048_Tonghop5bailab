package com.example.lab4duytruong;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class StoryDetailFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";

    private String title;
    private String content;
    public static StoryDetailFragment newInstance(String title, String content) {
        StoryDetailFragment fragment = new StoryDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);

        TextView tvTitle = view.findViewById(R.id.storyDetailTitle);
        TextView tvContent = view.findViewById(R.id.storyDetailContent);

        if (title != null) {
            tvTitle.setText(title);
        }

        if (content != null) {
            tvContent.setText(content);
        }
        View btnBack = view.findViewById(R.id.btnBackDetail);
        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null) getActivity().getSupportFragmentManager().popBackStack();
                }
            });
        }
        TextView header = view.findViewById(R.id.headerTitleDetail);
        if (header != null) header.setText("Học sinh");
        return view;
    }
}
