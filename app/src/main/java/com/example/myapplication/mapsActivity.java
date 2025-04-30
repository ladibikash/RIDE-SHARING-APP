package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.zip.Inflater;

public class mapsActivity extends Activity {
    public static class mapsactivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private MapActivity.ActivityMapsBinding binding;
        private Inflater ActivitymapsBinding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            View ActivityMapsBinding;
            binding = ActivitymapsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }

    public static class StartActivity extends AppCompatActivity {
        private Button register;
        private Button login;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_start);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.start_log), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            register = findViewById(R.id.register);
            login = findViewById(R.id.login);

            //configuring the views register button
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(StartActivity.this, UserRegistration.class));
                    finish();
                }
            });

            //configuring the views login button
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(StartActivity.this, UserLogin.class));
                    finish();
                }
            });
        }
    }

    public static class UserLogin extends AppCompatActivity {

        private EditText email;
        private EditText password;
        private Button login;
        private Button signupredirect;

        private FirebaseAuth auth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_user_login);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.users_login), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            login = findViewById(R.id.login);
            signupredirect = findViewById(R.id.signupredirect);

            auth = FirebaseAuth.getInstance();
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txt_email = email.getText().toString();
                    String txt_password = password.getText().toString();
                    loginUser(txt_email, txt_password);
                }
            });

            signupredirect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UserLogin.this, UserRegistration.class);
                    startActivity(intent);
                }
            });
        }

        private void loginUser(String email, String password) {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(UserLogin.this, "Login was Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserLogin.this, mapsactivity.class));
                    finish();
                }
            });
        }
    }
}
