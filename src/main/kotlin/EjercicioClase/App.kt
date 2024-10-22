package EjercicioClase

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence


fun main() {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    var em: EntityManager = emf.createEntityManager()

    em.transaction.begin()

    val user = Usuario("Josema", "1234")

    em.persist(user)
    em.transaction.commit()
    em.close()

}