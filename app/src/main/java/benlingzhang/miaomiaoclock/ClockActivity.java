package benlingzhang.miaomiaoclock;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class ClockActivity extends Activity {
    //Number of seconds displayed on the stopwatch.
    private int seconds = 0;
    //Is the stopwatch running?
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        runTimer();
    }

    //Start the stopwatch running when the Start button is clicked.
    public void onClickStartWork(View view) {
        running = true;
        seconds = 1500;
    }

    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStartBreak(View view) {
        running = true;
        seconds = 300;
    }

    public void onClickStartLongBreak(View view) {
        running = true;
        seconds = 1200;
    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    //Sets the number of seconds on the timer.
    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%02d:%02d", minutes, secs);
                timeView.setText(time);
                if (running&&(seconds>0)) {
                    seconds--;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}