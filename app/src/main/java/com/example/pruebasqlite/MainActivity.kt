package com.example.pruebasqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var texto:TextView
    private lateinit var boton1:Button
    private lateinit var boton2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txv1)
        boton1 = findViewById(R.id.button)
        boton2 = findViewById(R.id.button2)

        val dbHelper = DatabaseHelper(this)
    }
}





class DatabaseHelper(mainActivity: MainActivity):
    SQLiteOpenHelper(mainActivity,DATABASE,null,DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION=1
        private const val DATABASE="Articulos.db"
        private const val TABLA_ARTICULOS = "articulos"
        private const val KEY_ID = "_id"
        private const val COLUMN_TIPO_ARTICULO = "tipoArticulo"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_PESO = "peso"
        private const val COLUMN_PRECIO= "precio"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_ARTICULOS($KEY_ID INTEGER PRIMARY KEY,$COLUMN_TIPO_ARTICULO TEXT, $COLUMN_NOMBRE TEXT, $COLUMN_PESO INTEGER, $COLUMN_PRECIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_ARTICULOS")
        onCreate(db)
    }


    fun consultaLecturaBBDD(consulta:String):String{
        val db = this.readableDatabase
        return db.execSQL(consulta).toString()
    }

    fun consultaEscrituraBBDD(consulta:String):String{
        val db = this.writableDatabase
        return db.execSQL(consulta).toString()
    }
}
























