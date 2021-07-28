package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.view.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
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

        //pull data from screen
        fun getdata (view: View){

            //set gender
            var gender: String?=null
                when {
                    groupGender.radioFemale.isChecked -> gender = "female"
                    groupGender.radioMale.isChecked -> gender = "male"
                }

            //bio variables
            var age=inputAge.text
            var height=inputHeight.text
            var weight=inputWeight.text

            //set activity
            var activity: Double?=null
                when {
                    groupActivity.radioBMR.isChecked -> activity = 1.0
                    groupActivity.radioSed.isChecked -> activity = 1.2
                    groupActivity.radioMod.isChecked -> activity = 1.4
                    groupActivity.radioActive.isChecked -> activity = 1.6
                    groupActivity.radioVActive.isChecked -> activity = 1.8
                    groupActivity.radioEActive.isChecked -> activity = 1.9
                }

            //set goal
            var goal: Int?=null
                when {
                    groupGoal.radioELoss.isChecked -> goal = -1000
                    groupGoal.radioLoss.isChecked -> goal = -500
                    groupGoal.radioMildLoss.isChecked -> goal = -250
                    groupGoal.radioMaintain.isChecked -> goal = 0
                    groupGoal.radioMildGain.isChecked -> goal = 250
                    groupGoal.radioGain.isChecked -> goal = 500
                    groupGoal.radioEGain.isChecked -> goal = 1000
                }
        }

        //perform imperial to metric conversions
        fun conversions (weight:Int, height:Int){
            var kg :Double = weight/2.205
            var cm :Double = height*2.54
        }

        //perfrom st jeor equation to find calories
        fun stjeor(kg:Double,cm:Double,gender:String,age:Int,goal:Int) {
            
            var cals: Double=0.0
            if (gender== "female") {
                cals = (10*kg) +(6.25*cm)-(5*age)-161+goal
            }
            if (gender== "male") {
                cals = (10*kg) +(6.25*cm)-(5*age)+5+goal
            }
        }

        //on button click send to ranges to display data
        fun calculateRanges (view:View,cals:Double){                                                                                                                                                                                                                                                                                                                                                                               8
            var intent=Intent(this,Ranges::class.java)
            intent.putExtra("cals", cals)
            startActivity(intent)
        }
}


