package com.example.android.miwok;

public class Word {
    //stores word in default language
    private String mDefaultTranslation;

    //stores miwok translation of word
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
          * Create a new Word object.
          *
          * @param defaultTranslation is the word in a language that the user is already familiar with
          *                           (such as English)
          * @param miwokTranslation is the word in the Miwok language
          */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation =  defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /*
        method that returns the default language translation of a word
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /*
        method that returns the miwok word
     */

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getAudioResourceId(){ return mAudioResourceId; }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
