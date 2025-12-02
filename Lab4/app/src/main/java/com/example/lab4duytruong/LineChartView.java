package com.example.lab4duytruong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;

public class LineChartView extends View {
    private Paint paint;
    private Paint textPaint;
    private Paint titlePaint;
    private int[] dataValues = {3, 6, 8, 7, 2, 3};

    public LineChartView(Context context) {
        super(context);
        init();
    }
    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(0, 150, 255));
        paint.setStrokeWidth(8);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(40);
        textPaint.setTextAlign(Paint.Align.CENTER);
        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(30, 30, 30));
        int width = getWidth();
        int height = getHeight();
        int topMargin = 200;
        int bottomMargin = 100;
        int leftMargin = 80;
        int rightMargin = 80;
        int chartHeight = height - topMargin - bottomMargin;
        int chartWidth = width - leftMargin - rightMargin;
        int barWidth = chartWidth / dataValues.length;
        titlePaint.setColor(Color.rgb(0, 200, 255));
        titlePaint.setTextSize(80);
        canvas.drawText("250W", 50, 150, titlePaint);
        titlePaint.setTextSize(40);
        titlePaint.setColor(Color.rgb(0, 150, 200));
        canvas.drawText("USE TODAY: 0.5 kWh", 50, 200, titlePaint);
        titlePaint.setTextSize(35);
        canvas.drawText("kWh", 50, 260, titlePaint);
        titlePaint.setColor(Color.WHITE);
        titlePaint.setTextSize(50);
        titlePaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("POWER NOW:", width / 2f, 120, titlePaint);
        titlePaint.setTextAlign(Paint.Align.LEFT);
        int maxValue = 8;
        for (int i = 0; i < dataValues.length; i++) {
            int barHeight = (dataValues[i] * chartHeight) / (maxValue + 2);
            int left = leftMargin + i * barWidth + barWidth / 4;
            int right = left + barWidth / 2;
            int top = height - bottomMargin - barHeight;
            int bottom = height - bottomMargin;
            canvas.drawRect(left, top, right, bottom, paint);
            canvas.drawText(String.valueOf(dataValues[i]), left + barWidth / 4f, top - 20, textPaint);
        }
        textPaint.setTextSize(30);
        for (int i = 0; i < dataValues.length; i++) {
            canvas.drawText(String.valueOf(i + 1), leftMargin + i * barWidth + barWidth / 2f, height - bottomMargin + 40, textPaint);
        }
    }
}
