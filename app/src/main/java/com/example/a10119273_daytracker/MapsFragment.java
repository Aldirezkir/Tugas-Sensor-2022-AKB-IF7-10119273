package com.example.a10119273_daytracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

/** * 10119273
 * ALDI REZEKI RAMDANI
 * IF-7 **/
public class MapsFragment extends Fragment {
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    FusedLocationProviderClient client;
    public ArrayList<LatLng> locationArrayList;

        private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         client = LocationServices.getFusedLocationProviderClient(getActivity());
         mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
//            mapFragment.getMapAsync(callback);
            getCureentLocation();

        }
    }

    private void getCureentLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                    if (location != null){
                        mapFragment.getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(@NonNull GoogleMap googleMap) {
                                LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
                                MarkerOptions options = new MarkerOptions().position(latLng).title("Lokasi saat ini");
                                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                                googleMap.addMarker(options);
                                LatLng lembang = new LatLng(-6.817467606758021, 107.62715244556708);
                                LatLng lembang2 = new LatLng(-6.818447679562847, 107.62565040860629);
                                LatLng lembang3 = new LatLng(-6.819939090854398, 107.62410545630378);
                                LatLng lembang4 = new LatLng(-6.8169136516774005, 107.62198114688783);
                                LatLng lembang5 = new LatLng(-6.819172079912852, 107.62277508070994);
                                locationArrayList = new ArrayList<>();
                                locationArrayList.add(lembang);
                                locationArrayList.add(lembang2);
                                locationArrayList.add(lembang3);
                                locationArrayList.add(lembang4);
                                locationArrayList.add(lembang5);
                                for (int i = 0; i < locationArrayList.size(); i++) {
                                    // below line is use to add marker to each location of our array list.
                                    googleMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Tempat Makan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                                }


                            }
                        });
                    }
            }
        });
    }

}

