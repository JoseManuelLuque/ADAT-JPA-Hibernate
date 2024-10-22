package Instituto.model

import jakarta.persistence.*

@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(name = "inspectores")
class Inspector(

    @Column(name = "dni", unique = true, nullable = false)
    val dni: String,

    @Column(name = "nombre")
    val nombre: String,

    @OneToMany(cascade = [CascadeType.ALL])
    val instituto: MutableList<Instituto>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    ) {
}