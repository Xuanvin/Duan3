package com.example.apduantotnghiep;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

import com.example.apduantotnghiep.Fragment1.Fragment2.DienThoai;
import com.example.apduantotnghiep.Fragment1.Fragment2.DongHo;
import com.example.apduantotnghiep.Fragment1.Fragment2.Laptop;
import com.example.apduantotnghiep.Fragment1.Fragment2.MayTinhBan;
import com.example.apduantotnghiep.Fragment1.Fragment2.NoiBat;
import com.example.apduantotnghiep.Fragment1.Fragment2.ViTri;
import com.example.apduantotnghiep.Fragment1.GioHang;
import com.example.apduantotnghiep.Fragment1.LichSuGiaoDich;
import com.example.apduantotnghiep.Fragment1.MaQR;
import com.example.apduantotnghiep.Fragment1.TaiKhoan;
import com.example.apduantotnghiep.Fragment1.Tintuc;
import com.example.apduantotnghiep.Fragment1.TrangChu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MangHinhTrangChu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String diag = "";
    private TrangChu trangChu;
    private Tintuc tintuc;
    private TaiKhoan taiKhoan;
    private LichSuGiaoDich lichSuGiaoDich;
    private GioHang gioHang;
    private NoiBat noiBat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mang_hinh_trang_chu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        trangChu = new TrangChu();
        tintuc = new Tintuc();
        taiKhoan = new TaiKhoan();
        lichSuGiaoDich = new LichSuGiaoDich();
        gioHang = new GioHang();
        noiBat=new NoiBat();
        setFragment(trangChu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MaQR.class);
                intent.putExtra("name", result.getContents());
                startActivity(intent);


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(trangChu);
                    return true;
                case R.id.tintuc:
                    setFragment(tintuc);
                    return true;
                case R.id.lichsugiaodich:
                    setFragment(lichSuGiaoDich);
                    return true;
                case R.id.giohang:
                    setFragment(gioHang);
                    return true;
                case R.id.nguoidung:
                    setFragment(taiKhoan);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setFragment(Fragment fragmentHome) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frament, fragmentHome);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mang_hinh_trang_chu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            final IntentIntegrator intentIntegrator = new IntentIntegrator(this);
//            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
//            intentIntegrator.setPrompt("Scan a barcode");
//            intentIntegrator.setCameraId(0);  // Use a specific camera of the device
//            intentIntegrator.setBeepEnabled(false);
//            intentIntegrator.setBarcodeImageEnabled(true);
            intentIntegrator.initiateScan();
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();
        if (id == R.id.nav_all) {
            fragment = new TrangChu();
        }else if (id == R.id.nav_phone) {
            fragment = new DienThoai();
        } else if (id == R.id.nav_laptop) {
            fragment=new Laptop();
        } else if (id == R.id.nav_table) {
            fragment=new MayTinhBan();
        } else if (id == R.id.nav_watch) {
            fragment=new DongHo();
        } else if (id == R.id.nav_map) {
            fragment=new ViTri();
        } else if (id == R.id.nav_baohanh) {

        } else if (id == R.id.nav_email) {

        } else if (id == R.id.nav_hotro) {
            String phoneNo = "1800.1060";
            if (!TextUtils.isEmpty(phoneNo)) {
                String dial = "tel:" + phoneNo;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            } else {
                Toast.makeText(getBaseContext(), "Enter a phone number", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_khieunai) {
            String phoneNo = "1800.1062";
            if (!TextUtils.isEmpty(phoneNo)) {
                String dial = "tel:" + phoneNo;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            } else {
                Toast.makeText(getBaseContext(), "Enter a phone number", Toast.LENGTH_SHORT).show();
            }
        }
        if (fragment !=null){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frament,fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
