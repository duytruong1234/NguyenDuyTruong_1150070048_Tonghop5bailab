package com.example.lab4duytruong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StoryListFragment extends Fragment {

    private RecyclerView recyclerView;
    private StoryAdapter adapter;
    private List<StoryItem> storyItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);

        recyclerView = view.findViewById(R.id.storyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        storyItems = new ArrayList<>();

        storyItems.add(new StoryItem(
                "Học sinh lém lĩnh",
                "Cô giáo: Em nào giải được bài toán này cô cho 10 điểm!\n\n" +
                "Học sinh: (nhìn chằm chằm vào bảng một lúc rồi giơ tay) Thưa cô, em biết ai sẽ giải được ạ.\n\n" +
                "Cô giáo: Ai vậy em?\n\n" +
                "Học sinh: Là bạn giỏi nhất lớp chứ ai!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Giấc mơ kỳ lạ",
                "Thầy giáo: Hôm qua em nào nằm mơ thấy đi học?\n\n" +
                "Học sinh: (giơ tay) Thưa thầy, em ạ!\n\n" +
                "Thầy giáo: Em mơ thấy gì?\n\n" +
                "Học sinh: Thưa thầy, em mơ thấy ngày hôm đó… được nghỉ học!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Kiểm tra đầu giờ",
                "Thầy giáo: Em nào không làm bài tập thì đứng lên!\n\n" +
                "(Cả lớp im lặng, nhưng một học sinh từ từ đứng dậy.)\n\n" +
                "Thầy giáo: Em không làm bài à?\n\n" +
                "Học sinh: Không, thưa thầy. Nhưng em không muốn thấy thầy đứng một mình.",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Trí thông minh đột xuất",
                "Cô giáo: Ai biết trả lời thì giơ tay! Tại sao nước biển lại mặn?\n\n" +
                "Học sinh: Thưa cô, vì cá khóc quá nhiều khi thấy bạn mình bị bắt!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Tên gọi độc lạ",
                "Cô giáo: Nếu em nuôi một chú chó, em sẽ đặt tên nó là gì?\n\n" +
                "Học sinh: Dạ, em sẽ đặt tên là \"Ngồi Xuống\"!\n\n" +
                "Cô giáo: Sao lại đặt vậy?\n\n" +
                "Học sinh: Để khi em gọi \"Ngồi Xuống!\" mà nó ngồi xuống, ai cũng nghĩ em dạy nó giỏi ạ!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Câu trả lời thực tế",
                "Cô giáo: Em hãy cho ví dụ về câu nói dùng để xin phép.\n\n" +
                "Học sinh: Dạ, \"Cô ơi, cho em đi vệ sinh ạ!\"",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Toán học kỳ diệu",
                "Thầy giáo: Nếu có 5 quả táo trên bàn, em ăn mất 2 quả, thì còn lại mấy quả?\n\n" +
                "Học sinh: Thưa thầy, còn lại… 3 quả trên bàn và 2 quả trong bụng em ạ!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Bạn học hài hước",
                "Cô giáo: Em nào biết chữ \"người mẫu\" nghĩa là gì?\n\n" +
                "Học sinh: Dạ, là người đứng… chờ lâu!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Sự sáng tạo",
                "Cô giáo: Em hãy đặt một câu với từ \"bút chì\".\n\n" +
                "Học sinh: Dạ, em có bút chì, còn bạn em… có gôm!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Văn mẫu",
                "Thầy giáo: Em nào giải thích được ý nghĩa của câu \"Lá lành đùm lá rách\"?\n\n" +
                "Học sinh: Thưa thầy, nghĩa là khi áo mưa rách, mình lấy cái khác đắp lên ạ!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Nhà toán học nhí tuổi",
                "Thầy giáo: Nếu thầy cho em 1000 đồng và mỗi ngày em tiết kiệm 200 đồng, em sẽ có bao nhiêu sau một tuần?\n\n" +
                "Học sinh: Dạ, thưa thầy… em sẽ có 0 đồng vì em tiêu hết rồi!",
                R.drawable.cuoi5
        ));

        storyItems.add(new StoryItem(
                "Trạng thái đặc biệt",
                "Cô giáo: Khi lạnh quá, cơ thể người sẽ thế nào?\n\n" +
                "Học sinh: Thưa cô, cơ thể sẽ run rẩy và… kêu \"trời ơi lạnh quá\"!",
                R.drawable.cuoi5
        ));

        adapter = new StoryAdapter(storyItems, new StoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(StoryItem item) {
                StoryDetailFragment detailFragment = StoryDetailFragment.newInstance(
                        item.getTitle(),
                        item.getContent()
                );

                if (getActivity() != null) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.fragmentContainer, detailFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        recyclerView.setAdapter(adapter);

        View btnBack = view.findViewById(R.id.btnBackList);
        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null) getActivity().getSupportFragmentManager().popBackStack();
                }
            });
        }

        return view;
    }
}
