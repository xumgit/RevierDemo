package com.xum.reviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xum.weather.Weather;
import com.xum.weather.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button showTextBtn;
    private TextView showTextView;
    private ListView listView;
    private static List<Weather> weatherList = new ArrayList<>();
    private String[] data = {"Sunny","Cloudy","Few Clouds","Partly Cloudy","Overcast","Windy","Calm","Light Breeze",
            "Moderate","Fresh Breeze","Strong Breeze","High Wind","Gale","Strong Gale","Storm","Violent Storm","Hurricane",
            "Tornado","Tropical Storm","Shower Rain","Heavy Shower Rain","Thundershower","Heavy Thunderstorm","Thundershower with hail",
            "Light Rain","Moderate Rain","Heavy Rain","Extreme Rain","Drizzle Rain","Storm","Heavy Storm","Severe Storm","Freezing Rain",
            "Light to moderate rain","Moderate to heavy rain","Heavy rain to storm","Storm to heavy storm","Heavy to severe storm",
            "Rain","Light Snow","Moderate Snow","Heavy Snow","Snowstorm","Sleet","Rain And Snow","Shower Snow","Snow Flurry",
            "Light to moderate snow","Moderate to heavy snow","Heavy snow to snowstorm","Snow","Mist","Foggy","Haze","Sand","Dust",
            "Duststorm","Sandstorm","Dense fog","Strong fog","Moderate haze","Heavy haze","Severe haze","Heavy fog","Extra heavy fog",
            "Hot","Cold","Unknown"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showTextBtn = this.findViewById(R.id.showTextBtn);
        showTextView = this.findViewById(R.id.showTextView);
        listView = this.findViewById(R.id.listView);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);*/
        initWeather();
        WeatherAdapter adapter = new WeatherAdapter(MainActivity.this, R.layout.weather_item, weatherList);
        listView.setAdapter(adapter);
        showTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnText = showTextBtn.getText().toString();
                Log.d(TAG, btnText);
                if (btnText.equalsIgnoreCase(getApplication().getString(R.string.showText))) {
                    showTextView.setText(getApplication().getString(R.string.textView_change_value));
                    showTextView.setTextColor(getApplication().getColor(R.color.colorRed));
                    showTextBtn.setText(getApplication().getString(R.string.showTextChangeBack));
                    showTextBtn.setTextColor(getApplication().getColor(R.color.colorRed));
                } else {
                    showTextView.setText(getApplication().getString(R.string.textView_default_value));
                    showTextView.setTextColor(getApplication().getColor(R.color.colorGray));
                    showTextBtn.setText(getApplication().getString(R.string.showText));
                    showTextBtn.setTextColor(getApplication().getColor(R.color.colorGray));
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weather weather = weatherList.get(position);
                Toast.makeText(MainActivity.this, weather.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWeather(){
        Weather i_denmark = new Weather("Denmark", R.mipmap.ic_denmark);
        weatherList.add(i_denmark);
        Weather i_portual = new Weather("Portugal", R.mipmap.ic_portugal);
        weatherList.add(i_portual);
        Weather i_spain = new Weather("Spain", R.mipmap.ic_spain);
        weatherList.add(i_spain);

        Weather i_denmark_1 = new Weather("Denmark_1", R.mipmap.ic_denmark);
        weatherList.add(i_denmark_1);
        Weather i_portual_1 = new Weather("Portugal_1", R.mipmap.ic_portugal);
        weatherList.add(i_portual_1);
        Weather i_spain_1 = new Weather("Spain_1", R.mipmap.ic_spain);
        weatherList.add(i_spain_1);

        Weather i_denmark_2 = new Weather("Denmark_2", R.mipmap.ic_denmark);
        weatherList.add(i_denmark_2);
        Weather i_portual_2 = new Weather("Portugal_2", R.mipmap.ic_portugal);
        weatherList.add(i_portual_2);
        Weather i_spain_2 = new Weather("Spain_2", R.mipmap.ic_spain);
        weatherList.add(i_spain_2);

        Weather i_denmark_3 = new Weather("Denmark_3", R.mipmap.ic_denmark);
        weatherList.add(i_denmark_3);
        Weather i_portual_3 = new Weather("Portugal_3", R.mipmap.ic_portugal);
        weatherList.add(i_portual_3);
        Weather i_spain_3 = new Weather("Spain_3", R.mipmap.ic_spain);
        weatherList.add(i_spain_3);
    }
}
