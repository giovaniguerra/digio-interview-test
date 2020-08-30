package br.com.gbguerra.digio.interview.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_compute.setOnClickListener {
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }
    }
}
