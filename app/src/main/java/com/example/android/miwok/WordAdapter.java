package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    /* Resource ID for the background color for this list of words */
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //find current position for the word
        Word currentWord = getItem(position);

        //find the TextView with the id miwok_word
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_word);
        //set text of current word
        miwokWord.setText(currentWord.getMiwokTranslation());

        //find TextView with the id default_word
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_word);
        //set text for default word in view
        defaultWord.setText(currentWord.getDefaultTranslation());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()){
            image.setImageResource(currentWord.getImageResourceId());

            image.setVisibility(View.VISIBLE);
        }else{
            image.setVisibility(View.GONE);
        }


        return listItemView;
    }
}
