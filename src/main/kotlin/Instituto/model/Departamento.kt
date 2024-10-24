package Instituto.model

import jakarta.persistence.*

@Suppress("JpaObjectClassSignatureInspection")

@Entity
@Table(name = "departamentos")
class Departamento(

    @Column(name = "nombre", nullable = false, length = 50)
    var nombre: String,

    @Column(name = "descripcion")
    var descripcion: String?,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_instituto")
    val instituto: Instituto?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?

) {
}