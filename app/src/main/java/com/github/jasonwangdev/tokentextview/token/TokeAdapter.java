package com.github.jasonwangdev.tokentextview.token;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.jasonwangdev.test_tokentextview.FilteredArrayAdapter;
import com.github.jasonwangdev.tokentextview.Person;
import com.github.jasonwangdev.tokentextview.R;

/**
 * Created by Jason on 2017/7/9.
 */

public class TokeAdapter extends FilteredArrayAdapter<Person> {

    public TokeAdapter(Context context, int resource, Person[] objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater l = (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = l.inflate(R.layout.person_layout, parent, false);
        }

        Person p = getItem(position);
        ((TextView)convertView.findViewById(R.id.name)).setText(p.getName());
        ((TextView)convertView.findViewById(R.id.email)).setText(p.getEmail());

        return convertView;
    }

    @Override
    protected boolean keepObject(Person obj, String mask) {
        return false;
    }

}
