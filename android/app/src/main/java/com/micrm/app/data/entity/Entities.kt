package com.micrm.app.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

enum class EtapaPipeline {
    NUEVO, CONTACTADO, CALIFICADO, PROPUESTA_ENVIADA, NEGOCIACION, GANADO, PERDIDO
}

enum class TipoActividad { LLAMADA, EMAIL, REUNION, NOTA, TAREA }

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val empresa: String,
    val telefono: String,
    val email: String,
    val fuente: String,
    val fechaCreacion: LocalDateTime = LocalDateTime.now(),
    val notas: String? = null
)

@Entity(
    tableName = "deals",
    foreignKeys = [
        ForeignKey(
            entity = ContactEntity::class,
            parentColumns = ["id"],
            childColumns = ["contactId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("contactId")]
)
data class DealEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val contactId: Long,
    val titulo: String,
    val valorUSD: BigDecimal,
    val etapa: EtapaPipeline,
    val probabilidadCierre: Int, // 0-100
    val fechaCreacion: LocalDateTime = LocalDateTime.now(),
    val fechaCierreEstimada: LocalDate? = null,
    val fechaCierreReal: LocalDate? = null,
    val motivoPerdida: String? = null
)

@Entity(
    tableName = "activities",
    foreignKeys = [
        ForeignKey(
            entity = ContactEntity::class,
            parentColumns = ["id"],
            childColumns = ["contactId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DealEntity::class,
            parentColumns = ["id"],
            childColumns = ["dealId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("contactId"), Index("dealId")]
)
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val contactId: Long,
    val dealId: Long? = null,
    val tipo: TipoActividad,
    val descripcion: String,
    val fechaHora: LocalDateTime = LocalDateTime.now()
)

@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = ContactEntity::class,
            parentColumns = ["id"],
            childColumns = ["contactId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = DealEntity::class,
            parentColumns = ["id"],
            childColumns = ["dealId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("contactId"), Index("dealId")]
)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val contactId: Long? = null,
    val dealId: Long? = null,
    val titulo: String,
    val fechaVencimiento: LocalDateTime,
    val completada: Boolean = false
)
