package uz.itschool.myapplication11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.support.v4.os.IResultReceiver.Default
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import java.io.FileReader
import kotlin.properties.Delegates

class SecondActivity : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var btnBack: ImageView
    private lateinit var btnForward: ImageView

    private var index = 0

    private var list: MutableList<Int> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        loadViews()
        loadList()

        index = intent.getIntExtra("picture", 3)

        for (i in 0 until list.size) {
            if (index == i) {
                img.setImageResource(list[i])
            }
        }

        btnBack.setOnClickListener {
            if (index == 0)
                index = list.size
            index--
            img.setImageResource(list[index])
        }

        btnForward.setOnClickListener {
            if (index < list.size - 1) {
                index++
            } else {
                index = 0
            }
            img.setImageResource(list[index])
        }


    }

    private fun loadViews() {
        img = findViewById(R.id.extended)
        btnBack = findViewById(R.id.back)
        btnForward = findViewById(R.id.forward)
    }

    private fun loadList() {
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
        list.add(R.drawable.img4)
        list.add(R.drawable.img5)
        list.add(R.drawable.img6)
    }
}