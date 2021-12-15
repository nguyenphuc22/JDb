# JDb

Có thể sử dụng JDBC

```kotlin
@Dao
interface AlarmDao {

    @Query("SELECT * FROM ALARM")
    fun getAll() : LiveData<List<Alarm>>

    @Insert
    suspend fun insert(alarm: Alarm)

    @Query("Delete from alarm")
    suspend fun deleteAll()

    @Update
    suspend fun update(alarm: Alarm)

    @Delete
    suspend fun delete(alarm: Alarm)
}
```

Tú

```sql
INSERT INTO Alarm (ID,Hour, Minute)
VALUES( 1,	12 , 24);
```

```kotlin
@Entity
data class Alarm(
    @PrimaryKey(autoGenerate = true) val uid : Int? = null,
    @ColumnInfo var hour : Int,
    @ColumnInfo var minute : Int,
)  {

}
```

| ALARM - Tuyền               |                 |                   |
| --------------------------- | --------------- | ----------------- |
| ID : Interger : PRIMARY KEY | Hour : Interger | Minute : Interger |
|                             |                 |                   |
|                             |                 |                   |



```kotlin
@Database(entities = [Alarm::class],version = 1,exportSchema = false)
abstract class AlarmDatabase : RoomDatabase(){
    abstract fun alarmDao(): AlarmDao

    companion object {
        private var INSTANCE : AlarmDatabase? = null

        fun getInstance(context: Context) : AlarmDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AlarmDatabase::class.java,
                    context.packageName)
                    .build()
            }

            return INSTANCE as AlarmDatabase
        }
    }
}
```