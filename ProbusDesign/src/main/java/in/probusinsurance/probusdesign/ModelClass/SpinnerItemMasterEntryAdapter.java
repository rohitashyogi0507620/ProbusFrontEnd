package in.probusinsurance.probusdesign.ModelClass;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import in.probusinsurance.probusdesign.MasterEntity;
import in.probusinsurance.probusdesign.R;


public class SpinnerItemMasterEntryAdapter extends ArrayAdapter<MasterEntity> {

    private Context context;
    List<MasterEntity> list;
    LayoutInflater layoutInflater;


    public SpinnerItemMasterEntryAdapter(Activity context, int resouceId, int textviewId, List<MasterEntity> list) {
        super(context, resouceId, textviewId, list);
        this.context = context;
        layoutInflater = context.getLayoutInflater();
        this.list = list;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String rowItem="";
        if (list != null) {
            rowItem = list.get(position).getName();
        }
        View rowview = layoutInflater.inflate(R.layout.spinner_item, null, true);
        TextView txtTitle = rowview.findViewById(R.id.item_text);
        txtTitle.setText(rowItem);

        return rowview;
    }


    public void setError(View v, CharSequence s) {
        TextView name = (TextView) v.findViewById(R.id.item_text);
        if (name!=null) {
            name.setTextColor(context.getResources().getColor(R.color.color_inputlayout_error));
            name.setError(s);
        }
    }


}
