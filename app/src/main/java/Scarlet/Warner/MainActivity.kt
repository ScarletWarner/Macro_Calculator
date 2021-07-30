package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {
<<<<<<< Updated upstream
=======

    val PREF_Name = "myPrefs"
    var myPref: SharedPreferences? = null

>>>>>>> Stashed changes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

<<<<<<< Updated upstream
        fun go2Help (view: View){
            var intent=Intent(this,Help::class.java)
            startActivity(intent)
        }

        /*fun onCalculateButtonClicked (view:View) {

            var height=enterHeight.number
            var age=enterAge.number
            var weight=enterWeight.number

            var cals: arrayOf(0,0,0)
            var protein: arrayOf(0,0,0)
            var carbs: arrayOf(0,0,0)
            var fat: arrayOf(0,0,0)

            when {
                genderGroup.female.isChecked {
                    female()
                }
                    genderGroup.male.isChecked ->
                }
            }
            }
        fun female{

        }
        fun male{

        }
        }*/
}
}
=======
    fun onCalculateBtnClicked(view: View) {
        var gender: String? = null
        when {
            groupGender.radioFemale.isChecked -> gender = "female"
            groupGender.radioMale.isChecked -> gender = "male"
        }

        //bio variables
        var age: Int = inputAge.text.toString().toInt()
        var height: Int = inputHeight.text.toString().toInt()
        var weight: Int = inputWeight.text.toString().toInt()

        //set activity
        var activity: Double = 1.5
        when {
            groupActivity.radioBMR.isChecked -> activity = 1.0
            groupActivity.radioSed.isChecked -> activity = 1.2
            groupActivity.radioMod.isChecked -> activity = 1.4
            groupActivity.radioActive.isChecked -> activity = 1.6
            groupActivity.radioVActive.isChecked -> activity = 1.8
            groupActivity.radioEActive.isChecked -> activity = 1.9
        }

        //set goal
        var goal: Int = 0
        when {
            groupGoal.radioELoss.isChecked -> goal = -1000
            groupGoal.radioLoss.isChecked -> goal = -500
            groupGoal.radioMildLoss.isChecked -> goal = -250
            groupGoal.radioMaintain.isChecked -> goal = 0
            groupGoal.radioMildGain.isChecked -> goal = 250
            groupGoal.radioGain.isChecked -> goal = 500
            groupGoal.radioEGain.isChecked -> goal = 1000
        }

        //perform imperial to metric conversions
        var kg: Double = (weight / 2.205)
        var cm: Double = (height * 2.54)

        //perfrom st jeor equation to find calories
        var cals: Int = 0
        if (gender == "female")
            cals = Math.ceil(((655.1+(9.563*kg)+(1.85*cm)-(4.676*age))+goal)*activity).toInt()

        if (gender == "male")
            cals = Math.ceil(((66.47+(13.75*kg)+(5.003*cm)-(6.755*age))+goal)*activity).toInt()

        myPref = getSharedPreferences(PREF_Name, 0)
        var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

        editor.putInt("cals", cals)
        editor.commit()

            var intent = Intent(this, Ranges::class.java)
            startActivity(intent)

    }


    fun go2Home(view: View) {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun go2Ranges(view: View) {
        var intent = Intent(this, Ranges::class.java)
        startActivity(intent)
    }

    fun go2Pref(view: View) {
        var intent = Intent(this, Preferences::class.java)
        startActivity(intent)
    }

    fun go2Help(view: View) {
        var intent = Intent(this, Help::class.java)
        startActivity(intent)
    }
}




>>>>>>> Stashed changes

