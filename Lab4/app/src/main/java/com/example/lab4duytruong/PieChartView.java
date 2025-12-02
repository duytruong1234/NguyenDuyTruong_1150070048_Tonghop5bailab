package com.example.lab4duytruong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;

public class PieChartView extends View {
    private Paint paint;
    private Paint textPaint;
    private final float[] values = {450.0f, 1230.0f, 200.0f, 400.0f};
    private final int[] colors = {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
    public PieChartView(Context context) {
        super(context);
        init();
    }
    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(35);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(230, 230, 230));
        int width = getWidth();
        int height = getHeight();
        float total = 0;
        for (float value : values) total += value;
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 3;
        RectF rectF = new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        float startAngle = 0;
        for (int i = 0; i < values.length; i++) {
            paint.setColor(colors[i]);
            float sweepAngle = (values[i] / total) * 360;
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
            startAngle += sweepAngle;
        }
        int legendY = height - 100;
        int legendItemWidth = width / values.length;
        Paint legendPaint = new Paint();
        legendPaint.setAntiAlias(true);
        legendPaint.setTextSize(30);
        legendPaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i < values.length; i++) {
            paint.setColor(colors[i]);
            int boxSize = 40;
            int x = i * legendItemWidth + legendItemWidth / 2;
            canvas.drawRect(x - boxSize / 2f, legendY - boxSize / 2f, x + boxSize / 2f, legendY + boxSize / 2f, paint);
            legendPaint.setColor(Color.BLACK);
            canvas.drawText(String.valueOf((int)values[i]), x, legendY + 60, legendPaint);
        }
        textPaint.setTextSize(32);
        canvas.drawText("Pie chart key generated via onDrawFinished()", width / 2f, height - 30, textPaint);
    }
}
