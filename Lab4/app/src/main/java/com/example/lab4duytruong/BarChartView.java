package com.example.lab4duytruong;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class BarChartView extends View {
    private Paint paint;
    private int[] barHeights = {2, 5, 3, 4, 5, 6};
    private int[] barColors = {
            Color.rgb(150, 100, 200),
            Color.rgb(0, 200, 250),
            Color.GRAY,
            Color.rgb(50, 150, 50),
            Color.rgb(0, 200, 250),
            Color.YELLOW
    };
    public BarChartView(Context context) {
        super(context);
        init();
    }
    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / 8;
        int spacing = barWidth / 4;
        int bottomMargin = 50;
        int topMargin = 80;
        int chartHeight = height - bottomMargin - topMargin;
        int maxValue = 0;
        for (int value : barHeights) {
            if (value > maxValue) maxValue = value;
        }
        for (int i = 0; i < barHeights.length; i++) {
            paint.setColor(barColors[i]);
            int left = spacing + i * (barWidth + spacing);
            int barHeight = (int) ((float) barHeights[i] / maxValue * chartHeight);
            int top = height - bottomMargin - barHeight;
            int right = left + barWidth;
            int bottom = height - bottomMargin;
            canvas.drawRect(left, top, right, bottom, paint);
        }
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        canvas.drawLine(0, height - bottomMargin, width, height - bottomMargin, paint);
    }
}
