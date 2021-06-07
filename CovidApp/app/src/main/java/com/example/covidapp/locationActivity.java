package com.example.covidapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;



//implements GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener

    public class locationActivity extends AppCompatActivity implements OnMapReadyCallback, RoutingListener {
        //Initialise variable
        SupportMapFragment mapFrag;
        FusedLocationProviderClient client;
        private GoogleMap map;
        Button directionsBtn;
        TextView results;
        private List<Polyline> polylines;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.find_location);

            //acquiring directions button
            directionsBtn = findViewById(R.id.directionsBtn);


            //Initialise fused location
            client = LocationServices.getFusedLocationProviderClient(this);

            //Assign variable
            mapFrag = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.google_map);
            mapFrag.getMapAsync(this);


            if (ActivityCompat.checkSelfPermission(locationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //when granted

                getLocation();
            } else {
                //when denied
                ActivityCompat.requestPermissions(locationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        44);

            }

        }

        private void getLocation() {
            Task<Location> task =
                    client.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    //When success
                    if (location != null) {
                        mapFrag.getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(@NonNull GoogleMap googleMap) {
                                //
                                LatLng latLngStart = new LatLng(location.getLatitude(), location.getLongitude());
                                LatLng latLngEnd = new LatLng(50.790, -1.073);
                                //create marker options
                                MarkerOptions homeMarker = new MarkerOptions().position(latLngStart).title("start");
                                MarkerOptions secondMarker = new MarkerOptions().position(latLngEnd).title("destination");

                                //zoom map
                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngStart, 15));

                                //Add marker
                                googleMap.addMarker(homeMarker);
                                googleMap.addMarker(secondMarker);

                                //String url = getUrl(homeMarker.getPosition(), secondMarker.getPosition(), "walking");
                                //results.setText(url);
                                createRoute(latLngStart, latLngEnd);

                            }
                        });
                    }

                }
            });

        }

        private void createRoute(LatLng start, LatLng end) {
            Routing route= new Routing.Builder()
                    .travelMode(AbstractRouting.TravelMode.WALKING)
                    .withListener(this)
                    .alternativeRoutes(false)
                    .waypoints(start,end)
                    .build();
            route.execute();
        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            this.map = googleMap;
            // this.map.setOnMapClickListener(this);
            // this.map.setOnMapLongClickListener(this);
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //map.setTrafficEnabled(true);
        }

//        @Override
//        public void onMapLongClick (LatLng point){
//
//            //GoogleMap.OnMapLongClickListener
//           // MarkerOptions options = new MarkerOptions().position(point).title("new marker");
//            //map.addMarker(options);
//
//
//            Context context = getApplicationContext();
//            CharSequence text = "marker should show!";
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }
//
//        @Override
//        public void onMapClick (LatLng point){
//            Context context = getApplicationContext();
//            CharSequence text = "click";
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 44) {
                if (grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                }
            }
        }


//    private String getUrl(LatLng start, LatLng destination, String modeOfTrnsprt){
//        //set start and destination
//        String strStart = "start" + start.latitude + "," + start.longitude;
//        String strDestination = "destination" + destination.latitude + "," + destination.longitude;
//
//        String mode = "mode" + modeOfTrnsprt;
//        String params = strStart + "&" + strDestination + "&" + mode;
//
//        String output = "json";
//        //building url string
//        String url ="https://maps..googleapis.com/maps/api/directions" + "?" + params + "&Key=" + getString(R.string.google_maps_key);
//
//        return url;
//    }


        @Override
        public void onRoutingFailure(RouteException e) {
            Toast.makeText(this, "This is an error on routing failure", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onRoutingStart() {

        }

        @Override
        public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {
            final int[] colour = new int[] {R.color.design_default_color_secondary};
            if (polylines.size() > 0) {
                for (Polyline poly : polylines) {
                    poly.remove();
                }
            }

            polylines = new ArrayList<>();
            //add route(s) to the map.
            for (int i = 0; i < route.size(); i++) {

                PolylineOptions polyOptions = new PolylineOptions();
                polyOptions.color(getResources().getColor(colour[0]));
                polyOptions.width(10 + i * 3);
                polyOptions.addAll(route.get(i).getPoints());
                Polyline polyline = map.addPolyline(polyOptions);
                polylines.add(polyline);

                Toast.makeText(getApplicationContext(), "Route " + (i + 1) + ": distance - " + route.get(i).getDistanceValue() + ": duration - " + route.get(i).getDurationValue(), Toast.LENGTH_SHORT).show();

            }
        }

        @Override
        public void onRoutingCancelled() {

        }
        private void removeLines(){
            for (Polyline line : polylines){
                line.remove();
            }
            polylines.clear();
        }
    }
}

