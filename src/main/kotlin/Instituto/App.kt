package Instituto

import Instituto.model.Instituto
import Instituto.repository.DepartamentoRepository
import Instituto.model.Departamento
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence


fun main() {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    var em: EntityManager = emf.createEntityManager()

    val GestionDepartamentos = DepartamentoRepository()

    GestionDepartamentos.insertDpto(Departamento("IT", "Departamento de informatica", null, null))

    //GestionDepartamentos.deleteDpto(1)

    println(GestionDepartamentos.readDpto(1))

}