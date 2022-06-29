package com.tigersoft.shootingsoldiers


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var score = 0
    var imageArray  = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //resimleri ekleme
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)
        imageArray.add(imageView17)
        imageArray.add(imageView18)

        hideImages()



        object : CountDownTimer(25200,1000){
            override fun onTick(p0: Long) {
                timeText.text = "Time: " + p0/1000
            }

            override fun onFinish() {
                timeText.text = "TIME IS OVER !!!"

                handler.removeCallbacks(runnable)

                for (i in imageArray) {
                    i.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Do you want play again ?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    val intent = intent
                    finish() //destroy
                    startActivity(intent)
                }

                alert.setNegativeButton("No") {dialog, which ->

                }

                alert.show()

            }

        }.start()

    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for (i in imageArray){
                    i.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomsecenek=random.nextInt(9)
                imageArray[randomsecenek].visibility = View.VISIBLE

                handler.postDelayed(runnable,600)
            }

        }

        handler.post(runnable)


    }

fun skorarttir(view : View) {
    score++
    scoreText.text = "Score: ${score}"

    /*
    imageView.setOnClickListener {
        imageView10.visibility = View.VISIBLE
    }
    imageView2.setOnClickListener {
        imageView11.visibility = View.VISIBLE
    }
    imageView3.setOnClickListener {
        imageView12.visibility = View.VISIBLE
    }
    imageView4.setOnClickListener {
        imageView13.visibility = View.VISIBLE
    }
    imageView5.setOnClickListener {
        imageView14.visibility = View.VISIBLE
    }
    imageView6.setOnClickListener {
        imageView15.visibility = View.VISIBLE
    }
    imageView7.setOnClickListener {
        imageView16.visibility = View.VISIBLE
    }
    imageView8.setOnClickListener {
        imageView17.visibility = View.VISIBLE
    }
    imageView9.setOnClickListener {
        imageView18.visibility = View.VISIBLE
    } */


}
}