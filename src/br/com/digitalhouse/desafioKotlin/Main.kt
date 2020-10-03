package br.com.digitalhouse.desafioKotlin

import br.com.digitalhouse.desafioKotlin.digitalHouseManager
fun main() {

    val digitalhouse = digitalHouseManager()

    // Registrando alunos
    println(" *********************** Registro de Alunos *********************** ")
    digitalhouse.registrarAluno("João","Santos",1)
    digitalhouse.registrarAluno("Carlos","Almeida",2)
    digitalhouse.registrarAluno("Maria","Silva",3)
    digitalhouse.registrarAluno("André","Marques",4)
    digitalhouse.registrarAluno("Glória","Maria",5)


    // Registrando Professores

     /// Adjuntos
    println("*********************** Registro de Professores ***********************")
    digitalhouse.registrarprofAdjunto("Luis","Almeida",1,10)
    digitalhouse.registrarprofAdjunto("Gustavo","Monteiro",2,20)

    // Titulares
    digitalhouse.registrarprofTitular("José","Santos",3,"BACKEND")
    digitalhouse.registrarprofTitular("Maria","Silva", 4,"FRONTEND")


   // Registrando Cursos
    println("*********************** Registro de Cursos ***********************")
    digitalhouse.registrarCurso("Curso Full Stack",2001,3)
    digitalhouse.registrarCurso("Curso Android",2002,2)

    // Alocando um professor titular e um adjunto para cada curso.

    println("*********************** Alocação de Professores ***********************")
    digitalhouse.alocarProfessores("Luis",2001,1, 3)
    digitalhouse.alocarProfessores("Maria", 2002 , 2, 4)


    // Matriculando dois alunos no curso de Full Stack.
    println("*********************** Matricular aluno ***********************")
    digitalhouse.matricularAluno(1,2001)
    digitalhouse.matricularAluno(2,2001)


    // Matriculando 3 alunos no curso de Android.
    digitalhouse.matricularAluno(3,2002)
    digitalhouse.matricularAluno(4,2002)
    digitalhouse.matricularAluno(5,2002)


    // Realizando a consulta de um aluno.
    println("*********************** Consultar Alunos ***********************")
    digitalhouse.consultarCursoCadastrado(2)




}