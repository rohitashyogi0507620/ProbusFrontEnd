package `in`.probusinsurance.probusdesign

import android.content.Context
import android.content.Intent

class ProbusDesign {

    companion object {
        fun StartDesignActivity(context: Context) {
            val intent = Intent(context, ProbusDesignMainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}