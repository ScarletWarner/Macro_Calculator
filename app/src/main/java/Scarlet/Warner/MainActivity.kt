package Scarlet.Warner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

