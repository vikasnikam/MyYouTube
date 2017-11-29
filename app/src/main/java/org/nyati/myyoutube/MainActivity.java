package org.nyati.myyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
//Enter your Api key
    public static final String API_KEY = "AIzaSyCZvpVTqRrP-KnbcQjxyeeQiwDS4q_lfAg";

    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String VIDEO_ID = "-m3V8w_7vhk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);
    }
@Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(null== player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }



}
