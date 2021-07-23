package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.content.Intent

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)


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
        }}
}