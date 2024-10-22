package Instituto

import Instituto.repository.DepartamentoRepository
import Instituto.model.Departamento
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence


fun main() {
    val GestionDepartamentos = DepartamentoRepository()

    //GestionDepartamentos.insertDpto(Departamento("IT", "Departamento de informatica", null, null))

    println(GestionDepartamentos.readDpto(1))

}