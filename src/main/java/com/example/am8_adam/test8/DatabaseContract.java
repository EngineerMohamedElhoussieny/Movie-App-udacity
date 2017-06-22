package com.example.am8_adam.test8;

import android.provider.BaseColumns;

/**
 * Created by Am8_Adam on 6/3/2017.
 */

public class DatabaseContract {

    class MovieEntry implements BaseColumns {
        public static final String TABLE_NAME="Movies" ;
        public static final String COLUMN_ID="COLUMN_ID";
        public static final String COLUMN_TITLE="NAME";
        public static final String COLUMN_DESCRIPTION="SURNAME";
        public static final String COLUMN_RATE="MARKS";
        public static final String COLUMN_DATE="Date";
        public static final String COLUMN_POSTER="Poster" ;
    }


}
