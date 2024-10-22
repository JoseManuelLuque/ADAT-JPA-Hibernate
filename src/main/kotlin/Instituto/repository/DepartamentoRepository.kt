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

    // Declaración del EntityManagerFactory como companion objet para ejecutarlo una vez y reutilizarlo
    companion object {
       private val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    }

    fun insertDpto(dpto: Departamento) {
        val em: EntityManager = emf.createEntityManager()

        em.transaction.begin()
        em.persist(dpto)
        em.transaction.commit()
        em.close()
    }

    fun deleteDpto(id: Long) {
        val em: EntityManager = emf.createEntityManager()

        try {
            val dptoDelete = em.find(Departamento::class.java, id)

            if (dptoDelete != null) {
                em.transaction.begin()
                em.remove(dptoDelete)
                em.transaction.commit()
            } else {
                println("Departamento con id $id no encontrado")
            }
        } catch (e: Exception) {
            em.transaction.rollback()
            println("Error al eliminar el departamento: ${e.message}")
        } finally {
            if (em.isOpen) {
                em.close()
            }
        }
    }

    fun readDpto(id: Long): String {
        val em: EntityManager = emf.createEntityManager()

        return try {
            val findDpto = em.find(Departamento::class.java, id)
            if (findDpto != null) {
                findDpto.toString()
            } else {
                "Departamento no encontrado"
            }
        } catch (e: Exception) {
            "Error al leer el departamento: ${e.message}"
        } finally {
            if (em.isOpen) {
                em.close()
            }
        }
    }

    fun updateDpto(id : Long, nuevoNombre: String) {
        val em: EntityManager = emf.createEntityManager()

        try {
            val dpto: Departamento = em.find(Departamento::class.java, id)
            if (dpto != null) {
                em.transaction.begin()
                dpto.nombre = nuevoNombre
                em.merge(dpto)
                em.transaction.commit()
            } else {
                println("Departamento no encontrado")
            }
        } catch (e: Exception) {
            em.transaction.rollback()
            println("Error al actualizar departamento: ${e.message}")
        } finally {
            if (em.isOpen) {
                em.close()
            }
        }
    }
}