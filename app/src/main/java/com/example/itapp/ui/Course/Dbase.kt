package com.example.itapp.ui.Course

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class Dbase(context: Context) {

    var dbName = "Courses"
    var dbTable = "CourseTable"
    var colID = "ID"
    var colCode = "Code"
    var colName = "Name"
    var colCredits = "Credits"
    var colPreRequisites = "PreRequisites"
    var colDes = "Description"
    var dbVersion = 1

    val sqlCreateTable =
        "CREATE TABLE IF NOT EXISTS $dbTable ($colID INTEGER PRIMARY KEY, $colCode INTEGER NOT NULL, $colName TEXT," +
                "$colCredits INTEGER NOT NULL, $colPreRequisites TEXT, $colDes TEXT)"

    private var sqlDB: SQLiteDatabase? = null

    init {
        var db = DatabaseHelper(context)
        sqlDB = db.writableDatabase
    }

    inner class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, dbName, null, dbVersion) {
        var context: Context? = context

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context, "database created", Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("Drop table if Exists$dbTable")
        }
    }

    fun query(
        projection: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        sorOrder: String
    ): Cursor {
        val qb = SQLiteQueryBuilder()
        qb.tables = dbTable
        return qb.query(sqlDB, projection, selection, selectionArgs, null, null, sorOrder)
    }

    fun delete(selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.delete(dbTable, selection, selectionArgs)
    }

    fun update(values: ContentValues, selection: String ,selectionArgs: Array<String>): Int{
        return sqlDB!!.update(dbTable, values, selection, selectionArgs)
    }
}