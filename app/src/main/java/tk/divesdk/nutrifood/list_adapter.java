package tk.divesdk.nutrifood;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class list_adapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] itemdesc;

    public list_adapter(Activity context, String[] itemname, Integer[] imgid, String[] itemdesc) {
        super(context, R.layout.list_modelo, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.itemdesc = itemdesc;
    }


    public View getView(int position,View view,ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_modelo, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(itemdesc[position]);
        return rowView;

    };
}