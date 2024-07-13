package com.melihekinci.renktahminoyunu

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.melihekinci.renktahminoyunu.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var renklist = arrayListOf<String>("mavi","kirmizi","yesil","mor","turuncu","kahverengi","pembe")
        var tutulanrenk : String = ""


            var randomnums : Int = Random.nextInt(0,6)
             tutulanrenk = renklist[randomnums]



        binding.btncheck.setOnClickListener {
            var girilenrenk: String = binding.txtgirilen.text.toString()
            if (girilenrenk == tutulanrenk){
                binding.txtsonuc.text = "Doğru tahmin ettiniz. Tebriklerr "
                binding.txtsonuc.visibility = View.VISIBLE
                binding.btncheck.isEnabled = false
                binding.txttutulan.text = tutulanrenk
                binding.txtsonuc.setTextColor(Color.GREEN)
                binding.txtgirilen.text.clear()

            }
            else {
                binding.txtsonuc.visibility = View.VISIBLE
                binding.txtsonuc.text = "Hatalı tahmin ettiniz. Yeniden deneyin"
                binding.txtsonuc.setTextColor(Color.RED)
            }

        }
        binding.btnsifirla.setOnClickListener {
            binding.txtsonuc.visibility = View.INVISIBLE
            binding.txttutulan.text = " ? "
            binding.txtgirilen.text.clear()
            binding.btncheck.isEnabled = true
            tutulanrenk = ""
            var randomnums : Int = Random.nextInt(0,6)
            tutulanrenk = renklist[randomnums]
        }
    }
}