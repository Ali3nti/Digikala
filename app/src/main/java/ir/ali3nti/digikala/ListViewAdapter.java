package ir.ali3nti.digikala;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter {

  public int resurceId;
  public Activity activity;
  public ArrayList<MenuItemStracture> menuItem;

  public ListViewAdapter(@NonNull Activity activity, int resource, @NonNull ArrayList menuItem) {
    super(activity, resource, menuItem);

    this.resurceId=resource;
    this.activity=activity;
    this.menuItem=menuItem;
  }



  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = convertView;
    view=this.activity.getLayoutInflater().inflate(this.resurceId,null);

    ImageView img_item = (ImageView) view.findViewById(R.id.img_itemMenu);
    TextView txt_item = (TextView) view.findViewById(R.id.txt_itemMenu);

    MenuItemStracture menuItemStracture = menuItem.get(position);
    txt_item.setText(menuItemStracture.title);
    if (menuItemStracture.img != 0) {
      img_item.setImageResource(menuItemStracture.img);
    }
    return view;
  }



}