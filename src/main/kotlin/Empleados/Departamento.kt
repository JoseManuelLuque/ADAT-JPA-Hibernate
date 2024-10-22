package Empleados

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(name = "departamentos")
class Departamento(
    @Column(name = "nombre", nullable = false, unique = false)
    val nombre: String,

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    val fechaCreacion: Date,

    @OneToOne(mappedBy = "dpto")
    val empleado: Empleado?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val numDpto: Long? = null
) {

}