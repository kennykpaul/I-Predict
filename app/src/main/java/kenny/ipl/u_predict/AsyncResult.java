package kenny.ipl.u_predict;

import org.json.JSONObject;

/**
 * Created by kstanoev on 1/14/2015.
 */
interface AsyncResult
{
    void onResult(JSONObject object);
}