package org.brenomachado.notekeeper;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    public static final String ORIGINAL_NOTE_COURSE_ID = "org.brenomachado.notekeeper.ORIGINAL_NOTE_COURSE_ID";
    public static final String ORIGINAL_NOTE_TITLE = "org.brenomachado.notekeeper.ORIGINAL_NOTE_TITLE";
    public static final String ORIGINAL_NOTE_TEXT = "org.brenomachado.notekeeper.ORIGINAL_NOTE_TEXT ";

    public String mOriginalNoteCourseId;
    public String mOriginalNoteTitle;
    public String mOriginalNoteText;
    public boolean mIsNewlyCreated = true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_COURSE_ID, mOriginalNoteCourseId);
        outState.putString(ORIGINAL_NOTE_TITLE, mOriginalNoteTitle);
        outState.putString(ORIGINAL_NOTE_TEXT, mOriginalNoteText);
    }

    public void restoreState(Bundle outState) {
        mOriginalNoteCourseId = outState.getString(ORIGINAL_NOTE_COURSE_ID);
        mOriginalNoteTitle = outState.getString(ORIGINAL_NOTE_TITLE);
        mOriginalNoteText = outState.getString(ORIGINAL_NOTE_TEXT);
    }
}
