package com.epicodus.confluence.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.confluence.R;
import com.epicodus.confluence.models.ProjectSite;
import com.epicodus.confluence.models.ProjectSiteLib;

public class LandBridgeActivity extends AppCompatActivity {

    private TextView mNameLabel;
    private TextView mDescriptionLabel;
    private ImageView mProjectSiteImage;

    private ProjectSiteLib mProjectSiteLib;
    private ProjectSite mCurrentProjectSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_bridge);

        mNameLabel = (TextView) findViewById(R.id.nameLabel);
        mDescriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        mProjectSiteImage = (ImageView) findViewById(R.id.projectSiteImage);
        mProjectSiteLib = new ProjectSiteLib();
        mCurrentProjectSite = mProjectSiteLib.getProjectSites().get(0);

        setLayoutContent();
    }

    private void setLayoutContent() {
        mNameLabel.setText(mCurrentProjectSite.getName());
        mDescriptionLabel.setText(mCurrentProjectSite.getDescription());
        mProjectSiteImage.setImageResource(mCurrentProjectSite.getImage());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_land_bridge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
