package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import kotlinx.android.synthetic.main.activity_preferences.*
import kotlinx.android.synthetic.main.activity_preferences.view.*
import android.content.SharedPreferences
import android.text.TextUtils

class Preferences : AppCompatActivity() {

    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)}


        fun go2Home (view: View){
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        fun go2Ranges (view: View){
            var intent=Intent(this,Ranges::class.java)
            startActivity(intent)
        }

        fun go2Pref (view: View){
            var intent=Intent(this,Preferences::class.java)
            startActivity(intent)
        }
        fun go2Help (view: View){
            var intent=Intent(this,Help::class.java)
            startActivity(intent)
        }

    fun onApplyBtnClicked (view:View){
        var fatPref: Int=0
        var protPref: Int=0
        var carbPref: Int=0

        when {
            fatGroup.fatLow.isChecked -> fatPref = 1
            fatGroup.fatDef.isChecked -> fatPref = 2
            fatGroup.fatHi.isChecked -> fatPref = 3
        }
        when {
            proteinGroup.proDef.isChecked -> protPref = 2
            proteinGroup.proHi.isChecked -> protPref = 3
        }

        when {
            carbGroup.carbLo.isChecked -> carbPref = 1
            carbGroup.carbDef.isChecked -> carbPref = 2
            carbGroup.carbHi.isChecked -> carbPref = 3
        }

        myPref = getPreferences(MODE_PRIVATE)

        var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

        editor.putInt("fat", fatPref)
        editor.commit()
        editor.putInt("prot",protPref)
        editor.commit()
        editor.putInt("carb",carbPref)
        editor.commit()

    }




}
