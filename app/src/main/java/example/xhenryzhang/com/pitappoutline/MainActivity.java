package example.xhenryzhang.com.pitappoutline;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    ListView mainMenu;
    String[] entries; // array holding the menu entry names (team info, robot model, etc.)
    String[] descriptions; // array holding descriptions for each menu entry name
    Intent openInfoMenu;
    Intent open3DModel;
    Intent openStatistics;
    VideoView mainMenuVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources(); // contains all the additional information I put in res
        mainMenu = (ListView) findViewById(R.id.toolsList);
        mainMenuVideo = (VideoView) findViewById(R.id.menuVideo);

        // make arrays containing text information from the res folder
        entries = res.getStringArray(R.array.options);
        descriptions = res.getStringArray(R.array.descriptions);

        /** set up the video (download video file from robotics drive and put it in a new res folder named 'raw'
        // if you want to run this code)
        // Uri videoPlayer = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.calgames);

        // play the video
        mainMenuVideo.setVideoURI(videoPlayer);
        mainMenuVideo.start();**/

        // adapt custom layout to our list
        EntriesAdapter menuLayout = new EntriesAdapter(this, entries, descriptions);
        mainMenu.setAdapter(menuLayout);

        // determines what happens when you click on a menu button
        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int menuIndex, long l){
                System.out.println(menuIndex);
                if (menuIndex == 0) {
                    openInfoMenu = new Intent(getApplicationContext(), TeamInfoWindow.class);
                    startActivity(openInfoMenu);
                }else if(menuIndex == 1){
                    open3DModel = new Intent(getApplicationContext(), RobotModelWindow.class);
                    startActivity(open3DModel);
                }else if(menuIndex == 2){
                    // add more
                    openStatistics = new Intent(getApplicationContext(), StatisticsWindow.class);
                    startActivity(openStatistics);
                }else{
                    // add more
                }
            }
        });
    }
}
