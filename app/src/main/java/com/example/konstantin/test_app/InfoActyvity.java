package com.example.konstantin.test_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konstantin.test_app.POJO.Product;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;

public class InfoActyvity extends AppCompatActivity {

    TextView name_product, descr_product, upvotes_product;
    ImageView screenshoot;
    Toolbar myToolbar;
    String RedirectUrl;
    RequestData requestData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        int id_product = getIntent().getIntExtra("post_id", -1);

        name_product = (TextView)findViewById(R.id.name_product);
        descr_product = (TextView)findViewById(R.id.descr_product);
        upvotes_product = (TextView)findViewById(R.id.upvotes_product);

        screenshoot = (ImageView)findViewById(R.id.screenshot);

        requestData = new RequestData(getApplicationContext(), getString(R.string.token));
        try {
            Product product = requestData.getProduct(String.valueOf(id_product));
            myToolbar.setTitle(product.getPost().getName());
            name_product.setText(product.getPost().getName());
            descr_product.setText(product.getPost().getTagline());
            upvotes_product.setText("upvotes: "+String.valueOf(product.getPost().getVotesCount()));
            String screenshot_url = product.getPost().getScreenshotUrl().get300px();
            Picasso.with(getApplicationContext()).load(screenshot_url).into(screenshoot);
            RedirectUrl = product.getPost().getRedirectUrl();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void getIt(View view) {
        Uri address = Uri.parse(RedirectUrl);
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlinkIntent);
    }
}
