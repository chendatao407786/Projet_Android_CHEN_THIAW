package android.mbds.fr.appct.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.mbds.fr.appct.R;
import android.mbds.fr.appct.fragments.ContactListFragment;
import android.mbds.fr.appct.fragments.MessagerieFragment;
import android.mbds.fr.appct.utils.PreferencesManager;
import android.mbds.fr.appct.utils.iCallable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements iCallable{

    // addontouchlistener -> pour gerer le click sur les items
    FrameLayout flc;
    FrameLayout fm;
    ContactListFragment clf = new ContactListFragment();;
    MessagerieFragment mf = new MessagerieFragment();;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flc = (FrameLayout)findViewById(R.id.fragment_contact_list);
        fm = (FrameLayout)findViewById(R.id.fragment_message_item);

        FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();


        if(!(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)){
            ft.replace(flc.getId(), clf);
            ft.replace(fm.getId(), mf);
        }
        else{
            String val;
            Intent i = this.getIntent();
            val = i.getStringExtra("username");

            if(val!=null){
                mf.setRecipientMessage(val);
                ft.replace(fm.getId(), mf);
            }
            else {
                ft.replace(flc.getId(), clf);
                String pbRsa = PreferencesManager.getInstance(getApplicationContext()).loadRsaPublic();
                //String userTest = PreferencesManager.getInstance(this).loadKPContact("user").trim();
                //String copyRest = PreferencesManager.getInstance(this).decryptString()
                //String token = PreferencesManager.getInstance(this).loadAccessToken().trim();
                Toast.makeText(this, "PK userTest : "+pbRsa, Toast.LENGTH_SHORT).show();
            }
        }

        ft.commit();
    }

    @Override
    public void sendContact(String username) {
        /*Bundle tmp = new Bundle();
        tmp.putString("username", username);
        mf.setArguments(tmp);*/

        mf.setRecipientMessage(username);
    }
}


