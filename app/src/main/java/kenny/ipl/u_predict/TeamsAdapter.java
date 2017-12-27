package kenny.ipl.u_predict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kstanoev on 1/14/2015.
 */
public class TeamsAdapter extends ArrayAdapter<Team> {

    Context context;
    private ArrayList<Team> teams;

    public TeamsAdapter(Context context, int textViewResourceId, ArrayList<Team> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.teams = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.team, null);
        }
        Team o = teams.get(position);
        if (o != null) {
            TextView fields = (TextView) v.findViewById(R.id.fields);
 //           TextView matches = (TextView) v.findViewById(R.id.matches);
            TextView won = (TextView) v.findViewById(R.id.won);
//            TextView mom = (TextView) v.findViewById(R.id.mom);
            TextView ajith = (TextView) v.findViewById(R.id.ajith);
            TextView prasanth = (TextView) v.findViewById(R.id.prasanth);
            TextView hari = (TextView) v.findViewById(R.id.hari);
            TextView siofed = (TextView) v.findViewById(R.id.siofed);
            TextView nikhil = (TextView) v.findViewById(R.id.nikhil);
            TextView pramod = (TextView) v.findViewById(R.id.pramod);
            TextView ratheesh = (TextView) v.findViewById(R.id.ratheesh);
            TextView unni = (TextView) v.findViewById(R.id.unni);
            TextView vaisakh = (TextView) v.findViewById(R.id.vaisakh);
            TextView vishnu = (TextView) v.findViewById(R.id.vishnu);
            TextView vinod = (TextView) v.findViewById(R.id.vinod);
            TextView murali = (TextView) v.findViewById(R.id.murali);
            TextView rohan = (TextView) v.findViewById(R.id.rohan);
            TextView kenny = (TextView) v.findViewById(R.id.kenny);
            TextView ann = (TextView) v.findViewById(R.id.ann);
            TextView george = (TextView) v.findViewById(R.id.george);
            TextView jishnu = (TextView) v.findViewById(R.id.jishnu);
            TextView shibu = (TextView) v.findViewById(R.id.shibu);
            TextView stephania = (TextView) v.findViewById(R.id.stephania);
            TextView deepu = (TextView) v.findViewById(R.id.deepu);

            fields.setText(String.valueOf(o.getfields()));
 //           matches.setText(String.valueOf(o.getmatches()));
            won.setText(String.valueOf(o.getwon()));
 //           mom.setText(String.valueOf(o.getmom()));
            ajith.setText(String.valueOf(o.getajith()));
            prasanth.setText(String.valueOf(o.getprasanth()));
            hari.setText(String.valueOf(o.gethari()));
            siofed.setText(String.valueOf(o.getsiofed()));
            nikhil.setText(String.valueOf(o.getnikhil()));
            pramod.setText(String.valueOf(o.getpramod()));
            ratheesh.setText(String.valueOf(o.getratheesh()));
            unni.setText(String.valueOf(o.getunni()));
            vaisakh.setText(String.valueOf(o.getvaisakh()));
            vishnu.setText(String.valueOf(o.getvishnu()));
            vinod.setText(String.valueOf(o.getvinod()));
            murali.setText(String.valueOf(o.getmurali()));
            rohan.setText(String.valueOf(o.getrohan()));
            kenny.setText(String.valueOf(o.getkenny()));
            ann.setText(String.valueOf(o.getann()));
            george.setText(String.valueOf(o.getgeorge()));
            jishnu.setText(String.valueOf(o.getjishnu()));
            shibu.setText(String.valueOf(o.getshibu()));
            stephania.setText(String.valueOf(o.getstephania()));
            deepu.setText(String.valueOf(o.getdeepu()));



        }
        return v;
    }
}
