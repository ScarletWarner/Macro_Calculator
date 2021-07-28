package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import kotlinx.android.synthetic.main.activity_ranges.*
import kotlinx.android.synthetic.main.activity_ranges.view.*
import kotlinx.android.synthetic.main.activity_preferences.*
import android.content.SharedPreferences

class Ranges : AppCompatActivity() {
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranges)}

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

        fun calculateRanges(view:View) {

            //ini variables
            var cals = intent.getDoubleExtra("cals", 0.0)

            var fat : Int=0
            var lowFat : Int=0
            var hiFat : Int=0
            var prot : Int=0
            var defProt : Int=0
            var hiProt : Int=0
            var carb : Int=0
            var lowCarb : Int=0
            var hiCarb : Int=0

            //pull data from shared preferences (set in preferences.kt)
            myPref = getPreferences(MODE_PRIVATE)
            var databack: SharedPreferences? = null
            databack = getPreferences(0)

            if (databack.contains("fatPref"))
                fat = databack.getInt("fatPref")
            else fat = 2

            if (databack.contains("protPref"))
                prot = databack.getInt("protPref")
            else prot = 2

            if (databack.contains("carbPref"))
                carb = databack.getInt("carbPref")
            else carb = 2

            //set fat range
            when (fat) {
                1-> lowFat = ((.15 * cals) / 9)
                1-> hiFat = Math.ceil((.25 * cals) / 9)

                2-> lowFat = Math.ceil((.25 * cals) / 9)
                2-> hiFat = Math.ceil((.35 * cals) / 9)

                3-> lowFat = Math.ceil((.30 * cals) / 9)
                3-> hiFat = Math.ceil((.40 * cals) / 9)
                }


            //set protein range
            when (prot) {
                2-> defProt = Math.ceil((.25 * cals)/4)
                3-> defProt = Math.ceil((.40 * cals)/4)
                }

            when (prot) {
                2-> hiProt = Math.ceil((.35 * cals)/4)
                3-> hiProt = Math.ceil((.50 * cals)/4)
            }
            // set carb range
            when (carb) {
                1-> lowCarb = Math.ceil((.1 * cals)/4)
                1-> hiCarb = Math.ceil((.3 * cals)/4)
                2-> lowCarb = Math.ceil((.3 * cals)/4)
                2-> hiCarb = Math.ceil((.5 * cals)/4)
                3-> lowCarb = Math.ceil((.4 * cals)/4)
                3-> hiCarb = Math.ceil((.6 * cals)/4)
                }

            // apply text results
            calorieText.setText("${cals}")
            proteinRange.setText("${defProt}-${hiProt}")
            fatRange.setText("${lowFat} - ${hiFat}")
            carbRange.setText("${lowCarb} - ${hiCarb}")
            }

    }
