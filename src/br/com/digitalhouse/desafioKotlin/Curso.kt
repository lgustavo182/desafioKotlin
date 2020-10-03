package br.com.digitalhouse.desafioKotlin

class Curso(val nome:String?=null,val codigoCurso:Int?=null,var qtdMaximaAlunos:Int?=null){
    var listaAlunosMatriculados = mutableListOf<Aluno>()
    var prof:profTitular? = null
    var profAdjunto: profAdjunto? = null


    override fun equals(other: Any?): Boolean {
        other as Curso
        return  this.codigoCurso == other.codigoCurso
    }

    fun adicionarUmAluno(umAluno:Aluno):Boolean {
        if(this.listaAlunosMatriculados.size < qtdMaximaAlunos!!){
            this.listaAlunosMatriculados.add(umAluno)
            return true
        }else{
            return false
        }
    }

    fun excluirAluno(umAluno: Aluno){
        listaAlunosMatriculados!!.remove(umAluno)

    }
}