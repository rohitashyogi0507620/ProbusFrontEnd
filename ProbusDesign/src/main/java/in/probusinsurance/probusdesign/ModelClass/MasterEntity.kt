package `in`.probusinsurance.probusdesign.ModelClass

data class MasterEntity(
    var Id: String,
    var Name: String,
){
    override fun toString(): String {
        return Name
    }
}
