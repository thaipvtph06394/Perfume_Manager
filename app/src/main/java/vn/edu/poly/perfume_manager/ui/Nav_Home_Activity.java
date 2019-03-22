package vn.edu.poly.perfume_manager.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import vn.edu.poly.perfume_manager.R;
import vn.edu.poly.perfume_manager.ui.fragment.BillActivity;
import vn.edu.poly.perfume_manager.ui.fragment.FragmentHomeActivity;
import vn.edu.poly.perfume_manager.ui.fragment.ProductActivity;

public class Nav_Home_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentHomeActivity menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__home_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setTitle("Home");
//        toolbar.setNavigationIcon(R.drawable.ic_search_white_24dp);
        menuFragment = new FragmentHomeActivity();
        showFragmentMenu();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }






    private void showFragmentMenu() {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            if (menuFragment.isAdded()) {
                ft.show(menuFragment);
            } else {
                ft.add(R.id.container1, menuFragment);
            }

            ft.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.nav__home_, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user) {

        }else if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_home) {
            Toast.makeText(this, "Chuyen Sang Man Hinh Gioi Thieu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Nav_Home_Activity.class));
        }
        else if (id == R.id.nav_product) {
            Toast.makeText(this, "Chuyen Sang Man Hinh Gioi Thieu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), ProductActivity.class));
        }
        else if (id == R.id.nav_bill) {
            Toast.makeText(this, "Chuyen Sang Man Hinh Gioi Thieu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), BillActivity.class));
        } else if (id == R.id.nav_flag) {
            Toast.makeText(this, "Chuyen Sang Man Hinh Gioi Thieu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),OverViewAppActivity.class));
        } else if (id == R.id.nav_log_out) {
            finish();

        }else if (id == R.id.nav_out_door) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Bạn có muốn thoát không?");
            alertDialogBuilder
                    .setMessage("Click để thoát!")
                    .setCancelable(false)
                    .setPositiveButton("Có",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onSearch(View view) {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_search, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        ImageView imgSearch = dialogView.findViewById(R.id.imgSearch);
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Nav_Home_Activity.class));
            }
        });
    }
}
