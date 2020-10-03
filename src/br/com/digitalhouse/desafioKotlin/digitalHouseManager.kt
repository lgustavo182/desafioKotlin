package br.com.digitalhouse.desafioKotlin


import java.util.*
import javax.xml.crypto.Data
import kotlin.collections.contains as contains


class  digitalHouseManager() {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<Professor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatriculas = mutableListOf<Matricula>()

    // Registrando Curso //

    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaximaDeAlunos: Int) {
        var curso = Curso(nome, codigoCurso, qtdMaximaDeAlunos)
        listaCursos.add(curso)
        println("Registro de Curso concluido")
    }
    // Excluindo um Curso //
    fun excluirCurso(codigoCurso: Int) {
        for (curso in listaCursos) {
            if (curso.codigoCurso == codigoCurso) {
                listaCursos.remove(curso)
            }
        }
        println("O curso escolhido foi excluído com sucesso. ")
    }

    // Registrando Professor Titular
    fun registrarprofTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val prof = profTitular(especialidade, nome, sobrenome, 0, codigoProfessor)
        listaProfessores.add(profTitular(especialidade, nome, sobrenome, 0, codigoProfessor))
        println("O professor titular ${nome} ${sobrenome} foi registrado com sucesso" )

    }
    // Registrando Professor Adjunto
    fun registrarprofAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, qtdDeHoras: Int) {
        val adjunto1 = profAdjunto(qtdDeHoras, nome, sobrenome, 0, codigoProfessor)
        listaProfessores.add(adjunto1)
        println("O professor adjunto ${nome} ${sobrenome} foi registrado com sucesso. ")
    }

    // Excluindo um professor.

    fun excluirProfessor(codigoProfessor: Int) {
        for (professor in listaProfessores) {
            if (professor.codigoProfessor == codigoProfessor) {
                listaProfessores.remove(professor)
            }
        }
        println("O professor ${codigoProfessor} foi excluido com sucesso. ")
    }

    // Registrando um aluno

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno1 = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(aluno1)
        println("Registro de aluno concluido")
    }

    // Matriculando um aluno

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int, ){
        var aluno1 = Aluno(codigoAluno = codigoAluno)
        var curso1 = Curso(codigoCurso = codigoCurso)


        for (curso in listaCursos) {
            if (curso.codigoCurso == codigoCurso) {
                curso1 = curso
                println("Curso de codigo: $codigoCurso encontrado!")
            }
        }
        for (aluno in listaAlunos) {
            if (aluno.codigoAluno == codigoAluno) {
                aluno1 = aluno
                println("Aluno de codigo: $codigoAluno encontrado!")
            }
        }
        if (curso1.adicionarUmAluno(aluno1)) {
            var matricula1 = Matricula(aluno1, curso1, Date())
            listaMatriculas.add(matricula1)
            println("Matrícula realizada com sucesso. ")
        }else{
            println("Não há vagas. Sua matrícula não pôde ser efetuada. ")
        }

    }
    // Alocando Professores

    fun alocarProfessores(nome: String, codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {

        for (professor in listaProfessores) {
            if (professor.codigoProfessor == codigoProfessorTitular) {
                for (curso in listaCursos) {
                    if (curso.codigoCurso == codigoCurso) {
                        professor as profTitular
                        curso.prof = professor
                        println("O professor titular ${nome} foi alocado. ")
                    }
                }
            } else if (professor.codigoProfessor == codigoProfessorAdjunto) {
                for (curso in listaCursos) {
                    if (curso.codigoCurso == codigoCurso) {
                        professor as profAdjunto
                        curso.profAdjunto = professor
                        println("O professor adjunto ${codigoProfessorAdjunto}) foi alocado. " )
                    }
                }
            }
        }
    }



        // Consultando qual curso o aluno está matriculado

    fun consultarCursoCadastrado(codigoAluno: Int) {
        var aluno1 = Aluno(codigoAluno = codigoAluno)
        var curso1 = Curso()

        for (aluno in listaAlunos) {
            if (aluno.codigoAluno == codigoAluno) {
                aluno1 = aluno
                for (curso in listaCursos) {
                    if (curso.listaAlunosMatriculados.contains(aluno1)) {
                        curso1 = curso
                        println("Aluno de codigo: $codigoAluno encontrado na lista de alunos do curso: ${curso1.nome}!")
                    }
                }

            }
        }
    }


}




