package com.maars12.pipebendcalc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import androidx.navigation.NavController;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pipebendcalc.R;
import com.example.pipebendcalc.ActivityMainBinding;
import com.example.pipebendcalc.ActivityNavigationBinding;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    WebView webHtmlCss;
    private InterstitialAd mInterstitialAd;
    private AppBarConfiguration appBarConfig;
    private NavController navController;
    private ActivityNavigationBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadWebview(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarLayout.toolbar);
//        LoadAdds();

    }

//    private void LoadAdds() {
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//
//        mInterstitialAd = new InterstitialAd(this);
////        mInterstitialAd.setAdUnitId("ca-app-pub-1107828251118687/1696937891");
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//        mInterstitialAd.loadAd(new Builder().build());
//    }

    private void loadWebview(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webHtmlCss = (WebView) findViewById(R.id.webView);

        WebSettings ws = webHtmlCss.getSettings();
        ws.setJavaScriptEnabled(true);

        webHtmlCss.loadUrl("file:///android_asset/index.html");
        webHtmlCss.getSettings().setJavaScriptEnabled(true);
        webHtmlCss.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("").
                        setMessage(message).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                            }
                        }).create();
                dialog.show();
                result.confirm();
                return true;
            } });
    }

    private void setupNavigation() {
        appBarConfig = new Builder(R.id.navigation_calc, R.id.navigation_right_calc)
            .setDrawerLayout(binding.drawerLayout)
            .build();
        //noinspection ConstantConditions
        navController = ((NavHostFragment) getSupportFragmentManager()
            .findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfig)
            || super.onSupportNavigateUp();
    }
}