package com.epicodus.confluence.models;

import com.epicodus.confluence.R;

import java.util.ArrayList;

/**
 * Created by lesliepoole on 10/29/15.
 */
public class ProjectSiteLib {

    private ArrayList<ProjectSite> mProjectSites;

    public ProjectSiteLib() { setSites(); }

    public ArrayList<ProjectSite> getProjectSites() {
        return mProjectSites;
    }

    private void setSites() {
        mProjectSites = new ArrayList<>();

        mProjectSites.add(new ProjectSite(
                "Vancouver Land Bridge",
                "European and Native American cultures once converged at this Columbia River site, where the Hudson's Bay Company stood as the first European trading post in the Pacific Northwest. Lewis and Clark camped here, and Fort Vancouver was built here 20 years later. Today, the site features an earth-covered pedestrian bridge that arcs over State Route 14, reconnecting historic Fort Vancouver with the Columbia River, which helped extend the fort's influence from Mexico to Alaska and across the Pacific Ocean.",
                R.drawable.land_10
        ));
    }
}
