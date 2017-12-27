
package kenny.ipl.u_predict;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends ActionBarActivity {
    private static final String DEBUG_TAG = "HttpExample";
    ArrayList<Team> teams = new ArrayList<Team>();
    ListView listview;
    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        listview = (ListView) findViewById(R.id.listview);
        Button Teamselection = (Button) findViewById(R.id.btnDownload);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Teamselection.setEnabled(true);
            new DownloadWebpageTask(new AsyncResult() {
                @Override
                public void onResult(JSONObject object) {
                    processJson(object);
                }
            }).execute("https://spreadsheets.google.com/tq?key=1VhP78kovmfKaIdkkvwkZE12CaOWZNBY22XdThXT8mvI");
        } else {
            Toast.makeText(getApplicationContext(), "no internet", Toast.LENGTH_LONG).show();
//            btnDownload.setEnabled(false);
        }
    }


    public void buttonClickHandler(View v)
    {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");
/*
                int position = columns.getJSONObject(0).getInt("v");
                String name = columns.getJSONObject(1).getString("v");
                int wins = columns.getJSONObject(3).getInt("v");
                int draws = columns.getJSONObject(4).getInt("v");
                int losses = columns.getJSONObject(5).getInt("v");
                int points = columns.getJSONObject(19).getInt("v");
                int matches = columns.getJSONObject(2).getInt("v");
                Team team = new Team(position, name, wins, draws, losses, points, matches);
                teams.add(team);
*/
                String fields = columns.getJSONObject(0).getString("v");
             //   String matches = columns.getJSONObject(1).getString("v");
                String won = columns.getJSONObject(1).getString("v");
//                String mom = columns.getJSONObject(2).getString("v");
                String ajith = columns.getJSONObject(2).getString("v");
                String prasanth = columns.getJSONObject(3).getString("v");
                String hari = columns.getJSONObject(6).getString("v");
                String siofed = columns.getJSONObject(14).getString("v");
                String nikhil = columns.getJSONObject(9).getString("v");
                String pramod = columns.getJSONObject(11).getString("v");
                String ratheesh = columns.getJSONObject(12).getString("v");
                String unni = columns.getJSONObject(17).getString("v");
                String vaisakh = columns.getJSONObject(18).getString("v");
                String vishnu = columns.getJSONObject(20).getString("v");
                String deepu  = columns.getJSONObject(21).getString("v");
                String vinod = columns.getJSONObject(19).getString("v");
                String murali = columns.getJSONObject(10).getString("v");
                String rohan = columns.getJSONObject(13).getString("v");
                String kenny = columns.getJSONObject(8).getString("v");
                String ann = columns.getJSONObject(4).getString("v");
                String george = columns.getJSONObject(5).getString("v");
                String jishnu = columns.getJSONObject(7).getString("v");
                String shibu = columns.getJSONObject(15).getString("v");
                String stephania = columns.getJSONObject(16).getString("v");
                Team team = new Team(fields, won, ajith, prasanth, hari, siofed, nikhil, pramod, ratheesh, unni, vaisakh, vishnu, vinod, murali, rohan, kenny, ann, george, jishnu, shibu, stephania,deepu);
                teams.add(team);
            }

            final TeamsAdapter adapter = new TeamsAdapter(this, R.layout.team, teams);
            listview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}



