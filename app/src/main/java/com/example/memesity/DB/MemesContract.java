package com.example.memesity.DB;

import android.provider.BaseColumns;

public class MemesContract { //declaration of all table variables
    private MemesContract(){}
    public static class MemesEntry implements BaseColumns {
        public static final String TABLE_NAME ="posts";
        public static final String ID_PUBLICACIO = "id_publicacio";
        public static final String ID_FOTO_USUARI = "id_foto_usuari"; //foto_usuari is not used
        public static final String COLUMN_NAME_DESCRIPTION = "descripcio";
        public static final String COLUMN_NAME_NOM_USUARI = "nom_usuari";
    }
}
