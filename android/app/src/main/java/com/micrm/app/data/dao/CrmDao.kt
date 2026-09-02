package com.micrm.app.data.dao

import androidx.room.*
import com.micrm.app.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CrmDao {
    // --- Contacts ---
    @Query("SELECT * FROM contacts ORDER BY fechaCreacion DESC")
    fun getAllContacts(): Flow<List<ContactEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: ContactEntity)

    @Update
    suspend fun updateContact(contact: ContactEntity)

    @Delete
    suspend fun deleteContact(contact: ContactEntity)

    // --- Deals ---
    @Query("SELECT * FROM deals WHERE contactId = :contactId")
    fun getDealsForContact(contactId: Long): Flow<List<DealEntity>>

    @Query("SELECT * FROM deals ORDER BY fechaCreacion DESC")
    fun getAllDeals(): Flow<List<DealEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeal(deal: DealEntity)

    @Update
    suspend fun updateDeal(deal: DealEntity)

    // --- Activities ---
    @Query("SELECT * FROM activities WHERE contactId = :contactId ORDER BY fechaHora DESC")
    fun getActivitiesForContact(contactId: Long): Flow<List<ActivityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: ActivityEntity)

    // --- Tasks ---
    @Query("SELECT * FROM tasks WHERE completada = 0 ORDER BY fechaVencimiento ASC")
    fun getPendingTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)
}
