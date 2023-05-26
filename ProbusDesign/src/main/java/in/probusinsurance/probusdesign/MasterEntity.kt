package `in`.probusinsurance.probusdesign

import androidx.annotation.Keep

@Keep
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
