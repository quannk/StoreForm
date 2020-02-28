package com.example.storeform;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.storeform.mvc.IController;
import com.example.storeform.mvc.Mvc;
import com.example.storeform.socket.SocketClientProxy;
import com.example.storeform.ui.fragment.CartFragment;
import com.example.storeform.ui.fragment.HomeFragment;
import com.example.storeform.ui.fragment.ProfileFragment;
import com.example.storeform.ui.fragment.SmsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {
    private final String TAG = this.getClass().getName();
    private IController loginController;
    private IController connectionController;

    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

        //
        getDeviceInfor();
        initSocket();
    }

        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                openFragment(HomeFragment.newInstance("", ""));
                                return true;
                            case R.id.navigation_sms:
                                openFragment(SmsFragment.newInstance("", ""));
                                return true;
                            case R.id.navigation_cart:
                                openFragment(CartFragment.newInstance("", ""));
                                return true;
                            case R.id.navigation_profile:
                                openFragment(ProfileFragment.newInstance("", ""));
                                return true;
                        }
                        return false;
                    }
                };


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void getDeviceInfor() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void login() {
        String address = "";
        String port = "";
        if (!preferenceUtil.getLoginSuccess()) {
            // thong bao dang nhap that bai
        } else initSocket();
    }

    private void initComponents() {
        Mvc mvc = Mvc.getInstance();
        loginController = mvc.getController("login");
        connectionController = mvc.getController("connection");
    }

    private void initSocket() {
        SocketClientProxy clientProxy = SocketClientProxy.getInstance();
        clientProxy.connect();
    }

}
