class Usuario(val nome: String, val email: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val nivel: String, val duracao: Int = 60, val descricao: String) {
    fun add(conteudo: ConteudoEducacional) {
    }
}

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional){
        conteudo.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à $nome.")
    }

    fun removerConteudo(nomeConteudo: String){
        val conteudoRemovido = conteudos.removeIf {it.nome == nomeConteudo}
        if (conteudoRemovido)
            println("Conteúdo '$nomeConteudo' removido da formação $nome.")
        else
            println("Conteúdo '$nomeConteudo' não encontrado na formação $nome.")
    }

    fun calcularDuraçãoTotal(): Int{
        return conteudos.sumBy { it.duracao }
    }
}

fun main() {
    val usuario1 = Usuario("Alice", "alice@gmail.com", 25)
    val usuario2 = Usuario("Bob", "bob@live.com", 30)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", "Básico",90, "Aprenda os conceitos básicos da linguagem Kotlin.")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", "Intermediario", 120, "Conceitos avançados de OOP em Kotlin.")
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android com Kotlin", "Avancado", 180, "Aprenda a desenvolver aplicativos Android usando Kotlin.")

    val formacao = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.adicionarConteudo(conteudo3)

    println("Duração total da formação: ${formacao.calcularDuraçãoTotal()} minutos.")

}