package info.metadude.android.eventfahrplan.database.extensions

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

fun SQLiteDatabase.insert(tableName: String, values: ContentValues): Long =
        insert(tableName, null, values)

fun SQLiteDatabase.read(
        tableName: String,
        columns: Array<String>? = null,
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        groupBy: String? = null,
        having: String? = null,
        orderBy: String? = null,
        limit: String? = null

): Cursor = query(
        tableName,
        columns,
        selection,
        selectionArgs,
        groupBy,
        having,
        orderBy,
        limit
)

fun SQLiteDatabase.delete(tableName: String, columnName: String? = null, columnValue: String? = null): Int {
    val whereClause = if (columnName == null) null else "$columnName=?"
    val whereArgs = if (columnValue == null) null else arrayOf(columnValue)
    return delete(tableName, whereClause, whereArgs)
}
