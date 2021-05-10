package com.cacttuseducation2020_2021.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.cacttuseducation2020_2021.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Button btnCalculatorApp, btnFunFactApp, btnWeather, btnDrawerLayout, btnHeroesList, btnPrefsExample,
            btnLoginActivity, btnJsonParser, btnWebView, btnShowAd, btnMultiLanguage,btnAnimations;

    AdView adView;
    private InterstitialAd mInterstitialAd;

    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculatorApp = findViewById(R.id.btnCalculatorApp);
        btnFunFactApp = findViewById(R.id.btnFunFact);
        btnWeather = findViewById(R.id.btnWeather);
        btnDrawerLayout = findViewById(R.id.btnDrawerLayout);
        btnHeroesList = findViewById(R.id.btnHeroesList);
        btnPrefsExample = findViewById(R.id.btnPrefsExample);
        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnJsonParser = findViewById(R.id.btnJsonParserActivity);
        btnWebView = findViewById(R.id.btnWebView);
        btnShowAd = findViewById(R.id.btnShowAd);
        btnMultiLanguage = findViewById(R.id.btnMultiLanguageActivity);
        btnAnimations = findViewById(R.id.btnAnimationActivity);


        btnDrawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
                startActivity(intent);
            }
        });


        btnCalculatorApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });


        btnFunFactApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FunFactsActivity.class);
                startActivity(intent);
            }
        });

        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

        btnHeroesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HeroesListActivity.class);
                startActivity(intent);
            }
        });

        btnPrefsExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrefsExampleActivity.class);
                startActivity(intent);
            }
        });

        btnLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnJsonParser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JsonParserActivity.class);
                startActivity(intent);
            }
        });


        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });

        btnMultiLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MultiLanguageActivity.class);
                startActivity(intent);
            }
        });

        btnAnimations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

//        Toast.makeText(this, "First Toast!!!", Toast.LENGTH_LONG).show();
//        System.out.println("metoda e thirrur eshte onCreate");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);



        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
//                // Load the next interstitial.
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());


                //show rewarded ad
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = MainActivity.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            // Ad closed.
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            // User earned reward.

                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    Toast.makeText(MainActivity.this, "The rewarded ad wasn't loaded yet.", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnShowAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }else {
                    Toast.makeText(MainActivity.this, "Interstitial Ad wasn't loaded yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("metoda e thirrur eshte onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("metoda e thirrur eshte onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("metoda e thirrur eshte onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("metoda e thirrur eshte onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("metoda e thirrur eshte onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("metoda e thirrur eshte onDestroy");
    }

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        //showAlertDialog();
       // showTimePickerDialog();
        showProgressDialog();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("First Dialog");
        alertDialogBuilder.setMessage("A deshironi te mbyllni aplikacionin?");
        alertDialogBuilder.setPositiveButton("Po", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // click i butonit "Po"
            }
        });

        alertDialogBuilder.setNegativeButton("Jo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();// click i butonit "Jo"
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showTimePickerDialog(){
        final int hour, minute;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
                Toast.makeText(MainActivity.this, "Ora qe keni zgjedhur eshte: " + hourOfDay + ":"+minutes, Toast.LENGTH_SHORT).show();
            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    private void showProgressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("First progress dialog");
        progressDialog.setMessage("Loading");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.show();
    }


}