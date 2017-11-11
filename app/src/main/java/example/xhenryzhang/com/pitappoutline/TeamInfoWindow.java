package example.xhenryzhang.com.pitappoutline;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeamInfoWindow extends AppCompatActivity {

    String information;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info_window);

        Resources res = getResources();

        goBack = (Button) findViewById(R.id.backButton);

        information = res.getString(R.string.teamInfo);
        TextView informationText = (TextView) findViewById(R.id.teamInfoTextView);
        informationText.setText(information);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
