package com.chardev.outdino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chardev.outdino.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent =  Intent(this, SubActivity::class.java)
        intent.putExtra("from1", "Test intent")
        intent.putExtra("from2", 1)

        binding.btnStart.setOnClickListener { startActivityForResult(intent, 99) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            when(requestCode){
               99 ->{
                   val message = data?.getStringExtra("returnValue")
                   Toast.makeText(this,message,Toast.LENGTH_LONG).show()
               }
            }
        }

    }
}