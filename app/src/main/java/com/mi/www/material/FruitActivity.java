package com.mi.www.material;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_ID = "fruitId";
    public static final String FRUIT_NAME = "fruitName";
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mFruitImage;
    private TextView mFruitContext;
    private int mFruitId;
    private String mFruitName;

    public static void actionStart(Context context, int pictureId, String fruitName){
        Intent intent = new Intent(context,FruitActivity.class);
        intent.putExtra(FRUIT_ID,pictureId);
        intent.putExtra(FRUIT_NAME,fruitName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent =getIntent();
        mFruitId = intent.getIntExtra(FRUIT_ID,0);
        mFruitName = intent.getStringExtra(FRUIT_NAME);
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        mFruitImage = findViewById(R.id.iv_fruit);
        mFruitContext = findViewById(R.id.tv_fruit_detail);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbarLayout.setTitle(mFruitName);
        Glide.with(this).load(mFruitId).into(mFruitImage);
        String fruitContent = generateFruitContent();
        mFruitContext.setText(fruitContent);
    }

    private String generateFruitContent() {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<500;i++){
            builder.append(mFruitName);
        }
        return builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
