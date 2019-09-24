package com.example.apduantotnghiep.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.apduantotnghiep.R;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class Home extends AppCompatActivity {
    FlipperLayout flipperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        flipperLayout=findViewById(R.id.slide);
        int url[] = {R.drawable.sale, R.drawable.sale2, R.drawable.sale3, R.drawable.sale4, R.drawable.sale5

        };
        int num_of_pages = 4;
        for (int i = 0; i < num_of_pages; i++) {
            FlipperView view = new FlipperView(this);

            final int finalI1 = i;
            view.setImageDrawable(url[i])
                    // Use one of setImageUrl() or setImageDrawable() functions, otherwise IllegalStateException will be thrown
                    .setImageScaleType(ImageView.ScaleType.FIT_XY) //You can use any ScaleType
                    .setDescription("")
                    .setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                        @Override
                        public void onFlipperClick(FlipperView flipperView) {

//                            int item = finalI;
//                            switch (item) {
//                                case 0:
//                                    startActivity(new Intent(getContext(), Dulich.class));


                        }

                    });
            flipperLayout.setScrollTimeInSec(5); //setting up scroll time, by default it's 3 seconds
            flipperLayout.getScrollTimeInSec(); //returns the scroll time toi sec
            //returns the current position of pager
            flipperLayout.addFlipperView(view);
        }
    }
}
