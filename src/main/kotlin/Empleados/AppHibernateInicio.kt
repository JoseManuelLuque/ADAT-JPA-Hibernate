package Empleados

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import java.time.Instant
import java.util.Date

fun main() {

    // Cargar la configuración que queramos
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    // Abre la conexion con la base de datos
    var em: EntityManager = emf.createEntityManager()

    // Si queremos empezar una transacción
    em.transaction.begin()

    val fecha = Date.from(Instant.now())
    var dpto = Departamento("IT", fecha, null)
    val e: Empleado = Empleado("1230", "Pepe", 39, dpto)
    em.persist(e) // .persist() persiste el objeto en un PwrsistenceContext

    // Empujamos los cambios a la base de datos
    em.transaction.commit()

    // Cerrar la conexion a la base de datos
    em.close()

    // Añadir otro empleado
/*    em = emf.createEntityManager()
    em.transaction.begin()
    val emp: Empleado = Empleado("124", "Manolo", 39, dpto)
    em.persist(emp)
    em.transaction.commit()
    em.close()*/
}