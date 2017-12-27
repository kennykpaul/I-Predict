package kenny.ipl.u_predict;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;

import java.util.ArrayList;


import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.widget.Toast;


import java.net.URLEncoder;


public class MainActivity extends Activity {
    private static final String DEBUG_TAG = "Prediction";
//    int Result = 0;
    //ListView listview;

 //   Button[] teambutton = new Button[4];
    String match1;
    String match2;
    //    String strDate;
    String teamsett1;
    String teamsett2;
    String possibleEmail;
    String fullUrl = "https://docs.google.com/forms/d/1ViAHasxtXFgq9rUEjZeqCgANuFgBiWyEqTUrURtIm40/formResponse";
    TextView matchselection1;
    TextView matchselection2;
    TextView manofmatch1;
    TextView manofmatch2;
    ArrayList<String> spinner_1 = new ArrayList<String>();
    ArrayList<String> spinner_2 = new ArrayList<String>();
    ArrayList<String> spinner_3 = new ArrayList<String>();
    ArrayList<String> spinner_4 = new ArrayList<String>();
    MaterialBetterSpinner betterSpinner1;
    MaterialBetterSpinner betterSpinner2;
    MaterialBetterSpinner betterSpinner3;
    MaterialBetterSpinner betterSpinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  listview = (ListView) findViewById(R.id.listview);
        //      btnDownload = (Button) findViewById(R.id.btnDownload);
       // teambutton[0] = (Button) findViewById(R.id.match1team1);
       // teambutton[1] = (Button) findViewById(R.id.match1team2);
        //   teambutton[2] = (Button) findViewById(R.id.match1team3);
       // teambutton[2] = (Button) findViewById(R.id.match2team1);
       // teambutton[3] = (Button) findViewById(R.id.match2team2);
        Button scoresheet = (Button) findViewById(R.id.button2);
        Button Entered = (Button) findViewById(R.id.button3);
        matchselection1 = (TextView) findViewById(R.id.textView3);
        matchselection2 = (TextView) findViewById(R.id.textView4);
        manofmatch1 = (TextView) findViewById(R.id.textView5);
        manofmatch2 = (TextView) findViewById(R.id.textView6);
        //  teambutton[5] = (Button) findViewById(R.id.match2team3);
        //  teambutton[6] = (Button) findViewById(R.id.match3team1);
        //  teambutton[7] = (Button) findViewById(R.id.match3team2);
        //  teambutton[8] = (Button) findViewById(R.id.match3team3);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");


        betterSpinner1 = (MaterialBetterSpinner) findViewById(R.id.spinner_1);
        betterSpinner2 = (MaterialBetterSpinner) findViewById(R.id.spinner_2);
        betterSpinner3 = (MaterialBetterSpinner) findViewById(R.id.spinner_3);
        betterSpinner4 = (MaterialBetterSpinner) findViewById(R.id.spinner_4);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_2);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_3);
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_4);
        betterSpinner2.setAdapter(arrayAdapter2);
        betterSpinner1.setAdapter(arrayAdapter1);
        betterSpinner3.setAdapter(arrayAdapter3);
        betterSpinner4.setAdapter(arrayAdapter4);


        if (networkInfo != null && networkInfo.isConnected()) {
            //           btnDownload.setEnabled(true);
            betterSpinner3.setEnabled(false);
            betterSpinner4.setEnabled(false);
            betterSpinner2.setEnabled(false);
            betterSpinner1.setEnabled(false);
            scoresheet.setEnabled(true);
            Entered.setEnabled(true);
            matchselection1.setVisibility(View.GONE);
            matchselection2.setVisibility(View.GONE);
            manofmatch1.setVisibility(View.GONE);
            manofmatch2.setVisibility(View.GONE);
            possibleEmail = accounts[0].name;
/*
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
            strDate = mdformat.format(calendar.getTime());
*/

            new DownloadWebpageTask(new AsyncResult() {
                @Override
                public void onResult(JSONObject object) {
                    processJson(object);
                }
            }).execute("https://spreadsheets.google.com/tq?key=11o0E00pd6PSE90d1YiE1XJ7uQmRo0yk7-b1YnwYAkZQ");

        } else {

            Toast.makeText(getApplicationContext(), "no internet", Toast.LENGTH_LONG).show();

            scoresheet.setEnabled(false);
            Entered.setEnabled(false);
            matchselection1.setVisibility(View.GONE);
            matchselection2.setVisibility(View.GONE);
            manofmatch1.setVisibility(View.GONE);
            manofmatch2.setVisibility(View.GONE);

        }


    }
/*
    public void match1ClickHandler(View view) {
        Button b = (Button) view;
        match1 = b.getText().toString();
        Toast.makeText(MainActivity.this,match1,Toast.LENGTH_SHORT).show();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest mReq = new HttpRequest();
                //      HttpRequest memail = new HttpRequest();

                String data = "entry_249488235=" + URLEncoder.encode(match1) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);

                String response = mReq.sendPost(fullUrl, data);

                //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                //       response = memail.sendPost(fullUrl, email);
            }
        });
        t.start();

    }

    public void match2ClickHandler(View view) {
        Button b = (Button) view;
        match2 = b.getText().toString();
        Toast.makeText(MainActivity.this,match2,Toast.LENGTH_SHORT).show();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest mReq = new HttpRequest();
                HttpRequest memail = new HttpRequest();

                String data = "entry_62230594=" + URLEncoder.encode(match2) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);

                String response = mReq.sendPost(fullUrl, data);

                //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                //       response = memail.sendPost(fullUrl, email);
            }
        });
        t.start();
    }

*/
    public void ScoresheetClickHandler(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void EnteredClickHandler(View v) {
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }


       /*
    public void match3ClickHandler(View view) {
        Button b = (Button)view;
        match3 = b.getText().toString();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
        HttpRequest mReq = new HttpRequest();
        HttpRequest memail = new HttpRequest();

        String data = "entry_433941407=" + URLEncoder.encode(match3)+'&'+"entry_2143837812=" + URLEncoder.encode(possibleEmail);

        String response = mReq.sendPost(fullUrl, data);

  //      String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

   //     response = memail.sendPost(fullUrl, email);
            }
        });
        t.start();
    }
*/
    private void processJson(JSONObject object) {

        try {
            String[] team = new String[200];
            //       String[] team2 = new String[2];
            String[] date = new String[200];
            String[] teamset = new String[200];
            JSONArray rows = object.getJSONArray("rows");
            JSONObject row, emailmatch;
            int b = 0;
            int y;

            emailmatch = rows.getJSONObject(0);
            JSONArray column = emailmatch.getJSONArray("c");
            for (y = 0; y < column.length(); ++y) {
                String z = column.getJSONObject(y).getString("v");
                if (column.getJSONObject(y).getString("v").equals(possibleEmail))
                    break;
            }
            for (int r = 0; r < rows.length(); ++r) {

                row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");
                date[r] = columns.getJSONObject(0).getString("v");
                team[r] = columns.getJSONObject(2).getString("v");
                teamset[r] = columns.getJSONObject(y).getString("v");

                if (date[r].equals("Y") || date[r].equals("P")) {
                    if (b == 0) {
                        teamsett1 = teamset[r];
                        matchselection1.setVisibility(View.VISIBLE);
                        matchselection1.setText("You have selected " + teamsett1);
                    }
                    if (b == 2) {
                        teamsett2 = teamset[r];
                        matchselection2.setVisibility(View.VISIBLE);
                        matchselection2.setText("You have selected " + teamsett2);
                    }
                    if (b == 1) {
                        teamsett1 = teamset[r];
                        manofmatch1.setVisibility(View.VISIBLE);
                        manofmatch1.setText("You have selected " + teamsett1);
                    }
                    if (b == 3) {
                        teamsett2 = teamset[r];
                        manofmatch2.setVisibility(View.VISIBLE);
                        manofmatch2.setText("You have selected " + teamsett2);
                    }

                    if (date[r].equals("Y")) {
                        if(b==0 || b==1) {
                            betterSpinner3.setEnabled(true);
                            betterSpinner1.setEnabled(true);
                            spinner_3.add(team[r]);
                            spinner_3.add(team[r]+"(D)");
                            JSONObject teamrow = rows.getJSONObject(0);
                            JSONArray teamcolumn = teamrow.getJSONArray("c");
                            int g;
                            for (g = 0; g < teamcolumn.length(); ++g) {
                                if (teamcolumn.getJSONObject(g).getString("v").equals(team[r]))
                                    break;
                            }
                            for (int l = 1; l < rows.length(); ++l) {
                                teamrow = rows.getJSONObject(l);
                                teamcolumn = teamrow.getJSONArray("c");
                                if (!(teamcolumn.getJSONObject(g).getString("v").equals("-")))
                                    spinner_1.add(teamcolumn.getJSONObject(g).getString("v"));

                            }
                        }
                        if(b==2 || b==3) {
                            betterSpinner4.setEnabled(true);
                            betterSpinner2.setEnabled(true);
                            spinner_4.add(team[r]);
                            spinner_4.add(team[r] + "(D)");
                            JSONObject teamrow = rows.getJSONObject(0);
                            JSONArray teamcolumn = teamrow.getJSONArray("c");
                            int g;
                            for (g = 0; g < teamcolumn.length(); ++g) {
                                if (teamcolumn.getJSONObject(g).getString("v").equals(team[r]))
                                    break;
                            }
                            for (int l = 1; l < rows.length(); ++l) {
                                teamrow = rows.getJSONObject(l);
                                teamcolumn = teamrow.getJSONArray("c");
                                if (!(teamcolumn.getJSONObject(g).getString("v").equals("-")))
                                    spinner_2.add(teamcolumn.getJSONObject(g).getString("v"));
                            }
                        }

                    }
                    if (date[r].equals("P")) {
                        betterSpinner3.setEnabled(false);
                        betterSpinner4.setEnabled(false);
                        betterSpinner1.setEnabled(false);
                        betterSpinner2.setEnabled(false);
                    }
                    b = b + 1;
                }

  /*              int position = columns.getJSONObject(0).getInt("v");
                String name = columns.getJSONObject(1).getString("v");
                int wins = columns.getJSONObject(3).getInt("v");
                int draws = columns.getJSONObject(4).getInt("v");
                int losses = columns.getJSONObject(5).getInt("v");
                int points = columns.getJSONObject(19).getInt("v");
                Team team = new Team(position, name, wins, draws, losses, points);
                teams.add(team);*/

            }

            //          final TeamsAdapter adapter = new TeamsAdapter(this, R.layout.team, teams);
            //          listview.setAdapter(adapter);
            ;

            if (b == 2) {

                Toast.makeText(MainActivity.this, "Only One match today", Toast.LENGTH_LONG).show();
            }
            if (b == 0) {
                Toast.makeText(MainActivity.this, "No match today", Toast.LENGTH_LONG).show();
            }
            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_1);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_2);
            betterSpinner2.setAdapter(arrayAdapter2);
            betterSpinner1.setAdapter(arrayAdapter1);
            ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_3);
            ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner_4);
            betterSpinner3.setAdapter(arrayAdapter3);
            betterSpinner4.setAdapter(arrayAdapter4);
            AdapterView.OnItemClickListener listener1 = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
                    final String player=parent.getAdapter().getItem(position).toString();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpRequest mReq = new HttpRequest();
                            HttpRequest memail = new HttpRequest();

                            String data = "entry_433941407=" + URLEncoder.encode(player) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);

                            String response = mReq.sendPost(fullUrl, data);

                            //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                            //       response = memail.sendPost(fullUrl, email);
                        }
                    });
                    t.start();
                }
            };

            AdapterView.OnItemClickListener listener2 = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
                    final String player=parent.getAdapter().getItem(position).toString();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpRequest mReq = new HttpRequest();
                            HttpRequest memail = new HttpRequest();

                            String data = "entry_1041929758=" + URLEncoder.encode(player) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);

                            String response = mReq.sendPost(fullUrl, data);

                            //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                            //       response = memail.sendPost(fullUrl, email);
                        }
                    });
                    t.start();
                }
            };
            AdapterView.OnItemClickListener listener3 = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
                    final String match=parent.getAdapter().getItem(position).toString();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpRequest mReq = new HttpRequest();
                            HttpRequest memail = new HttpRequest();

                            String data = "entry_249488235=" + URLEncoder.encode(match) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);
                            String response = mReq.sendPost(fullUrl, data);

                            //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                            //       response = memail.sendPost(fullUrl, email);
                        }
                    });
                    t.start();
                }
            };
            AdapterView.OnItemClickListener listener4 = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
                    final String match=parent.getAdapter().getItem(position).toString();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpRequest mReq = new HttpRequest();
                            HttpRequest memail = new HttpRequest();

                            String data = "entry_62230594=" + URLEncoder.encode(match) + '&' + "entry_2143837812=" + URLEncoder.encode(possibleEmail);
                            String response = mReq.sendPost(fullUrl, data);

                            //       String email = "entry_1445374091=" + URLEncoder.encode(possibleEmail);

                            //       response = memail.sendPost(fullUrl, email);
                        }
                    });
                    t.start();
                }
            };
            betterSpinner1.setOnItemClickListener(listener1);
            betterSpinner2.setOnItemClickListener(listener2);
            betterSpinner3.setOnItemClickListener(listener3);
            betterSpinner4.setOnItemClickListener(listener4);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}


