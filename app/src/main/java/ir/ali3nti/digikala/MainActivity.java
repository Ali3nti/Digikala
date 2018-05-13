package ir.ali3nti.digikala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

  LinearLayout btn_showAllProduct;
  SliderLayout sliderShow;
  HashMap<String,String> urlPic;
  String drawerMenuList;
  ListView listView;
  ListView listView2;
  DrawerLayout drawerLayout;
  ImageView menu;
  ArrayList<MenuItemStracture> menuItems;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    menu = (ImageView) findViewById(R.id.menu);
    drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);


    listView = (ListView) findViewById(R.id.list_item);
    menuItems = new ArrayList<>();
    menuItems.add(new MenuItemStracture("خانه",R.drawable.ic_home_black_24dp));
    menuItems.add(new MenuItemStracture("لیست محصولات",R.drawable.ic_list_white_24dp));
    menuItems.add(new MenuItemStracture("سبد خرید",R.drawable.ic_local_grocery_store_white_24dp));
    menuItems.add(new MenuItemStracture("لیست مورد علاقه",R.drawable.ic_favorite_black_24dp));
    menuItems.add(new MenuItemStracture("پیشنهاد های ویژه دیجی کالا",R.drawable.ic_whatshot_black_24dp));
    menuItems.add(new MenuItemStracture("پیام ها",R.drawable.ic_mail_black_24dp));
    menuItems.add(new MenuItemStracture("سوابق سفارش",R.drawable.ic_assignment_black_24dp));
    menuItems.add(new MenuItemStracture("تنظیمات",R.drawable.ic_settings_black_24dp));
    menuItems.add(new MenuItemStracture("سوالات متداول",R.drawable.ic_help_black_24dp));
    menuItems.add(new MenuItemStracture("درباره ما",R.drawable.ic_info_black_24dp));
    listView.setAdapter(new ListViewAdapter(MainActivity.this,R.layout.menu_list,menuItems));


    menu.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {

                                drawerLayout.openDrawer(Gravity.RIGHT);
                              }
                            });



    sliderShow = (SliderLayout) findViewById(R.id.slider);
    urlPic = new HashMap<>();

    urlPic.put("C1","https://dkms.digikala.com//image/e6b53be2-5021-11e8-9e4d-6dd56f9890d52_11_1_103-1x1.jpeg?0.979765948465019");
    urlPic.put("C2","https://dkms.digikala.com//image/1d550860-505e-11e8-bee5-01d89af6ef370_11_1_103-1x1.jpeg?0.8075585225383097");
    urlPic.put("C3","https://dkms.digikala.com//image/5f0de261-52af-11e8-bad3-b5edcd9217711_11_1_103-1x1.jpeg?0.25377796359676985");
    urlPic.put("C4","https://dkms.digikala.com//image/431fd576-5022-11e8-9e4d-6dd56f9890d56_11_1_103-1x1.jpeg?0.25977396185239354");
    for (String name : urlPic.keySet()){

      TextSliderView textSliderView = new TextSliderView(this);
      textSliderView
        .image(urlPic.get(name))
        .description("  پیشنهاد "+name)
        .setScaleType(BaseSliderView.ScaleType.Fit)
        .setOnSliderClickListener(this);

      textSliderView.bundle(new Bundle());
      textSliderView.getBundle().putString("extra",name);



      sliderShow.setDuration(70000);
      sliderShow.addSlider(textSliderView);
    }


    btn_showAllProduct = (LinearLayout) findViewById(R.id.btn_showallproduct);
    btn_showAllProduct.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"Categories",Toast.LENGTH_SHORT).show();
      }
    });



    TextView txt_login = (TextView) findViewById(R.id.txt_header);
    ImageView img_login = (ImageView) findViewById(R.id.img_header);

    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
      }
    };

    txt_login.setOnClickListener(listener);
    img_login.setOnClickListener(listener);



  }

  @Override
  public void onSliderClick(BaseSliderView slider) {

    Toast.makeText(getApplicationContext(),slider.getBundle().get("extra") + " Cliked",Toast.LENGTH_SHORT).show();

  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

  }

  @Override
  public void onPageSelected(int position) {

  }

  @Override
  public void onPageScrollStateChanged(int state) {

  }
}
