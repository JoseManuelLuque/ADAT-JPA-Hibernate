package Empleados

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(name="Empleados")
class Empleado(

    @Id
    val id: String? = null,

    @Column(name="Nombre")
    val nombre: String,

    @Column
    val edad: Int,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_dpto")
    val dpto: Departamento

) {

}