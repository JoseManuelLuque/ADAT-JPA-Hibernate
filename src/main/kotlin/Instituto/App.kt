package Instituto

import Instituto.model.Departamento
import Instituto.repository.DepartamentoRepository


fun main() {
    val GestionDepartamentos = DepartamentoRepository()

    GestionDepartamentos.insertDpto(Departamento("IT", "Departamento de informatica", null, null))
    GestionDepartamentos.insertDpto(Departamento("PMDM", "Departamento de Mobiles", null, null))
    GestionDepartamentos.insertDpto(Departamento("EIE", "Departamento de Empresas", null, null))
    GestionDepartamentos.insertDpto(Departamento("ADAT", "Departamento de Datos", null, null))

    println(GestionDepartamentos.readDpto(1))

    GestionDepartamentos.updateDpto(1, "Informatica")

    GestionDepartamentos.deleteDpto(2)
}