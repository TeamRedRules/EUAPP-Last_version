package de.bbs_donnersbergkreis.www.schoolapp.Czech;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import de.bbs_donnersbergkreis.www.schoolapp.R;

public class History_school extends AppCompatActivity {

    TextView view;
    String theStringYouEncoded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cze_history);

        try {
            new JSONObjectRequestWrapper(this)
                    .create("RedTeam", "test2")
                    .add("id", "CZE")
                    .send(listener, fail);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        view=(TextView)findViewById(R.id.czech_history_id);
    }




    private Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.w("AAAA", response.toString());
            try {
                theStringYouEncoded = response.getString( "text" );
            } catch (JSONException e) {
                e.printStackTrace();
            }
            view.setText(theStringYouEncoded);
        }
    };

    private Response.ErrorListener fail = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
           Log.v("Faild to send message", error.getMessage());

        }
    };
}
