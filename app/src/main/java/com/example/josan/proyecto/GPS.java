package com.example.josan.proyecto;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class GPS {/*extends AppCompatActivity
        implements ConnectionCallbacks, OnConnectionFailedListener, android.location.LocationListener {

   /* private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private boolean iniciarActualizaciones;

    Button iniciarActualizacionesButton, detenerActualizacionesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizando_ubicacion);

        iniciarActualizacionesButton = (Button) findViewById(R.id.iniciarButton);
        detenerActualizacionesButton = (Button) findViewById(R.id.detenerButton);

        // Se cambiará a true cuando el usuario pulse sobre el botón iniciarActualizaciones
        iniciarActualizaciones = false;

        // Se crea un objeto de la API cliente de Google Play Services
        crearGoogleApiClient();
        crearLocationRequest();
    }

    // Método asociado el evento onClick del botón iniciarActualizaciones
    public void iniciarActualizacionesButton(View view){
        if (!iniciarActualizaciones && googleApiClient.isConnected()) {
            iniciarActualizaciones = true;
            detenerActualizacionesButton.setEnabled(true);
            iniciarActualizacionesButton.setEnabled(false);
            iniciarActualizaciones();
        }
    }

    // Método asociado el evento onClick del botón detenerActualizaciones
    public void detenerActualizacionesButton(View view){
        if (iniciarActualizaciones) {
            iniciarActualizaciones = false;
            detenerActualizacionesButton.setEnabled(false);
            iniciarActualizacionesButton.setEnabled(true);
            detenerActualizaciones();

        }
    }

    private void iniciarActualizaciones(){
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) this);
    }

    private void detenerActualizaciones(){
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);
    }

    // Se crea un objeto de la clase GoogleApiClient
    private void crearGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API) //Se añade la API de los servicios de localización
                .build();
    }

    // Se crea un objeto de la clase LocationRequest
    private void crearLocationRequest(){
        locationRequest = new LocationRequest();
        // Se establece el intervalo para recibir las actualizaciones de ubicación (en milisegundos)
        locationRequest.setInterval(8000);

        // Se establece el ritmo más rápido al que se recibirán actualizaciones
        locationRequest.setFastestInterval(4000);

        // Se establece la prioridad de la petición
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onConnected(Bundle bundle) {
        iniciarActualizacionesButton.setEnabled(true);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        String UbicacionString;
        TextView ubicacionText = (TextView) findViewById(R.id.ubicaciontextView);
        double longitud, latitud;

        if (location != null) {
            longitud = location.getLongitude();
            latitud = location.getLatitude();
            UbicacionString = "Tu ubicación actual es:\n"
                    + "Latitud: " + latitud + "\n"
                    + "Longitud: " + longitud;
            ubicacionText.setText(UbicacionString);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (googleApiClient.isConnected() && iniciarActualizaciones) {
            iniciarActualizaciones();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Se detienen las actualizaciones para ahorrar batería,
        // pero no se realiza la desconexión de GoogleApiClient
        if (googleApiClient.isConnected()) {
            detenerActualizaciones();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }*/
}
