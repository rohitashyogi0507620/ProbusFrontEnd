package `in`.probusinsurance.probusdesign

data class MasterEntity(
    var Id: String,
    var Name: String,
) {
    constructor() : this("", "") {
    }

    override fun toString(): String {
        return this.Name!!
    }
}
