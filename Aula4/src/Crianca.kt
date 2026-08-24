class Crianca: Pessoa(), SerVivo {

    var dentesDeLeite: String = ""
    var reuPrimario: Boolean = true
    override var tamCoracao: Boolean = true
    override var categoria: String = "Onivoro"
    override var habitat: String = "End City"

    override fun andar(){
//        super.andar
        println("Engatinhando...")
    }

    override fun som() {
        println("Birra, chora, sorri, brinca...")
    }

    override fun mover() {
        println("Andando (Depois que se aprende)")
    }

    override fun respirar() {
        println("Respirando...")
    }

}