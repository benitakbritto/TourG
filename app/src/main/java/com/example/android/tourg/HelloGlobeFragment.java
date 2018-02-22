package com.example.android.tourg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mousebird.maply.ComponentObject;
import com.mousebird.maply.GlobeController;
import com.mousebird.maply.GlobeMapFragment;
import com.mousebird.maply.MaplyBaseController;
import com.mousebird.maply.MarkerInfo;
import com.mousebird.maply.Point2d;
import com.mousebird.maply.QuadImageTileLayer;
import com.mousebird.maply.RemoteTileInfo;
import com.mousebird.maply.RemoteTileSource;
import com.mousebird.maply.ScreenMarker;
import com.mousebird.maply.SelectedObject;
import com.mousebird.maply.SphericalMercatorCoordSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HelloGlobeFragment extends GlobeMapFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle inState) {
        super.onCreateView(inflater, container, inState);

        // Do app specific setup logic.

        return baseControl.getContentView();
    }
    public void userDidSelect(GlobeController mapControl, SelectedObject[] selObjs,
                              Point2d loc, Point2d screenLoc) {

        /*FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ScreenSlidePageFragment llf = new ScreenSlidePageFragment();
        ft.replace(R.id.fragment1, llf);
        ft.commit();
*/

       Intent i = new Intent(getActivity(), Main2Activity.class);
        startActivity(i);

    }


    @Override
    protected MapDisplayType chooseDisplayType() {
        return MapDisplayType.Globe;
    }

    @Override
    protected void controlHasStarted() {
        // setup base layer tiles
        String cacheDirName = "stamen_watercolor";
        File cacheDir = new File(getActivity().getCacheDir(), cacheDirName);
        cacheDir.mkdir();
        RemoteTileSource remoteTileSource = new RemoteTileSource(new RemoteTileInfo("http://tile.stamen.com/watercolor/", "png", 0, 18));
        remoteTileSource.setCacheDir(cacheDir);
        SphericalMercatorCoordSystem coordSystem = new SphericalMercatorCoordSystem();

        // globeControl is the controller when using MapDisplayType.Globe
        // mapControl is the controller when using MapDisplayType.Map
        QuadImageTileLayer baseLayer = new QuadImageTileLayer(globeControl, coordSystem, remoteTileSource);
        baseLayer.setImageDepth(1);
        baseLayer.setSingleLevelLoading(false);
        baseLayer.setUseTargetZoomLevel(false);
        baseLayer.setCoverPoles(true);
        baseLayer.setHandleEdges(true);

        // add layer and position
        globeControl.addLayer(baseLayer);
        globeControl.animatePositionGeo(-3.6704803, 40.5023056, 5, 1.0);
        insertMarkers();
        globeControl.gestureDelegate = this;
    }
    private void insertMarkers() {
        List<ScreenMarker> markers = new ArrayList<>();

        MarkerInfo markerInfo = new MarkerInfo();
        Bitmap icon = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_city);
        Point2d markerSize = new Point2d(144, 144);

        // Moskow - Москва
        ScreenMarker moskow = new ScreenMarker();
        moskow.loc = Point2d.FromDegrees(37.616667, 55.75); // Longitude, Latitude
        moskow.image = icon;
        moskow.size = markerSize;
        moskow.selectable = true;
        markers.add(moskow);

        //Maui, Hawaii
        ScreenMarker maui = new ScreenMarker();
        maui.loc = Point2d.FromDegrees(20.7984, 156.3319); // Longitude, Latitude
        maui.image = icon;
        maui.size = markerSize;
        maui.selectable = true;
        markers.add(maui);

        //  Saint Petersburg - Санкт-Петербург
        ScreenMarker stPetersburg = new ScreenMarker();
        stPetersburg.loc = Point2d.FromDegrees(30.3, 59.95);
        stPetersburg.image = icon;
        stPetersburg.size = markerSize;
        stPetersburg.selectable = true;
        markers.add(stPetersburg);

        // Novosibirsk - Новосибирск
        ScreenMarker novosibirsk = new ScreenMarker();
        novosibirsk.loc = Point2d.FromDegrees(82.95, 55.05);
        novosibirsk.image = icon;
        novosibirsk.size = markerSize;
        novosibirsk.selectable = true;
        markers.add(novosibirsk);

        // Yekaterinburg - Екатеринбург
        ScreenMarker yekaterinburg = new ScreenMarker();
        yekaterinburg.loc = Point2d.FromDegrees(60.583333, 56.833333);
        yekaterinburg.image = icon;
        yekaterinburg.size = markerSize;
        yekaterinburg.selectable = true;
        markers.add(yekaterinburg);

        // Nizhny Novgorod - Нижний Новгород
        ScreenMarker nizhnyNovgorod = new ScreenMarker();
        nizhnyNovgorod.loc = Point2d.FromDegrees(44.0075, 56.326944);
        nizhnyNovgorod.image = icon;
        nizhnyNovgorod.size = markerSize;
        nizhnyNovgorod.rotation = Math.PI;
        nizhnyNovgorod.selectable = true;
        markers.add(nizhnyNovgorod);

        // Add your markers to the map controller.
        ComponentObject markersComponentObject = globeControl.addScreenMarkers(markers, markerInfo, MaplyBaseController.ThreadMode.ThreadAny);
    }


}
