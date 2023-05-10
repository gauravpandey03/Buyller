package com.example.buyller;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recmargin extends RecyclerView.ItemDecoration  {
    private final int verticalspacing;

    public recmargin(int vertspacing){
        this.verticalspacing = vertspacing;
    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = verticalspacing;
//        outRect.top = 19;
//        outRect.left = 5;
//        outRect.right = 5;

        super.getItemOffsets(outRect, view, parent, state);
    }
}
