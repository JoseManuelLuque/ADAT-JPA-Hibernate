package Instituto.repository

import Instituto.model.Departamento
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

class DepartamentoRepository {
    /*
    CRUD de Departameento
    Excepciones ? ¿Se puede hacer Rollback?
    EntityManagerFactory creándose muchas veces = ¿Cómo lo solucionarais?
     */

    fun insertDpto(dpto: Departamento) {
        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
        val em: EntityManager = emf.createEntityManager()

        em.transaction.begin()
        em.persist(dpto)
        em.transaction.commit()
        em.close()
    }

    fun deleteDpto(id: Long) {
        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
        val em: EntityManager = emf.createEntityManager()

        val dptoDelete = em.find(Departamento::class.java, id)

        em.transaction.begin()
        em.remove(dptoDelete)
        em.transaction.commit()
        em.close()
    }

    fun readDpto(id: Long): String {
//        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
//        val em: EntityManager = emf.createEntityManager()
//        val FindDpto = em.find(Departamento::class.java, id)
//        em.transaction.begin()
//        FindDpto
//        em.transaction.commit()
//        em.close()
//        return FindDpto.toString()

        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
        val em: EntityManager = emf.createEntityManager()

        return try {
            val findDpto = em.find(Departamento::class.java, id)
            if (findDpto != null) {
                findDpto.toString()
            } else {
                "Departamento no encontrado"
            }
        } catch (e: Exception) {
            "Error: ${e.message}"
        } finally {
            em.close()
            emf.close()
        }
    }

    fun UpdateDpto(id : String) {
        val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("departamento")
        val em: EntityManager = emf.createEntityManager()

        val FindDpto = em.find(Departamento::class.java, id)

        em.transaction.begin()


        em.transaction.commit()
        em.close()
    }
}