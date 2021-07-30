package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class Ranges : AppCompatActivity() {
<<<<<<< Updated upstream
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranges)
    }
}
=======

    val PREF_Name="myPrefs"
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranges)

        //ini variables
        var cals: Int = 0
        var fat: Int = 0
        var lowFat: Int = 0
        var hiFat: Int = 0
        var prot: Int = 0
        var defProt: Int = 0
        var hiProt: Int = 0
        var carb: Int = 0
        var lowCarb: Int = 0
        var hiCarb: Int = 0

        //pull data from shared preferences (set in preferences.kt)
        var databack: SharedPreferences = getSharedPreferences(PREF_Name,0)
        databack = getSharedPreferences(PREF_Name, 0)
        if (databack.contains("cals"))
            cals = databack.getInt("cals", cals)

        if (databack.contains("fatPref"))
            fat = databack.getInt("fatPref", fat)
        else fat = 2

        if (databack.contains("protPref"))
            prot = databack.getInt("protPref", prot)
        else prot = 2

        if (databack.contains("carbPref"))
            carb = databack.getInt("carbPref", carb)
        else carb = 2

        //set fat range
        when (fat) {
            1 -> lowFat = Math.ceil((.15 * cals) / 9).toInt()
            2 -> lowFat = Math.ceil((.25 * cals) / 9).toInt()
            3 -> lowFat = Math.ceil((.30 * cals) / 9).toInt()
        }

        when (fat) {
            1 -> hiFat = Math.ceil((.25 * cals) / 9).toInt()
            2 -> hiFat = Math.ceil((.35 * cals) / 9).toInt()
            3 -> hiFat = Math.ceil((.40 * cals) / 9).toInt()
        }


        //set protein range
        when (prot) {
            2 -> defProt = Math.ceil((.25 * cals) / 4).toInt()
            3 -> defProt = Math.ceil((.40 * cals) / 4).toInt()
        }

        when (prot) {
            2 -> hiProt = Math.ceil((.35 * cals) / 4).toInt()
            3 -> hiProt = Math.ceil((.50 * cals) / 4).toInt()
        }
        // set carb range
        when (carb) {
            1 -> lowCarb = Math.ceil((.1 * cals) / 4).toInt()
            2 -> lowCarb = Math.ceil((.3 * cals) / 4).toInt()
            3 -> lowCarb = Math.ceil((.4 * cals) / 4).toInt()

        }

        when (carb) {
            1 -> hiCarb = Math.ceil((.3 * cals) / 4).toInt()
            2 -> hiCarb = Math.ceil((.5 * cals) / 4).toInt()
            3 -> hiCarb = Math.ceil((.6 * cals) / 4).toInt()
        }

        // apply text results
        calorieRange.text = cals.toString()
        proteinRange.text = ("${defProt} - ${hiProt}")
        fatRange.text = ("${lowFat} - ${hiFat}")
        carbRange.text = ("${lowCarb} - ${hiCarb}")
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
