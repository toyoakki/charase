package com.example.toyo.charase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toyo.charase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //strBtnを押すことでSTRの値が入力される
        binding.strBtn.setOnClickListener {
            val str = (3..18).random()
            binding.strsu.text= str.toString()
        }
        //sizBtnを押すことでSIZの値が入力される
        binding.sizBtn.setOnClickListener {
            val siz = (2..12).random() + 6
            binding.sizsu.text = siz.toString()
        }
        //appBtnを押すことでAPPの値が入力される
        binding.appBtn.setOnClickListener {
            val app = (3..18).random()
            binding.appsu.text = app.toString()
        }
        //dexBtnを押すことでDEXの値が入力される
        binding.dexBtn.setOnClickListener {
            val dex = (3..18).random()
            binding.dexsu.text = dex.toString()
        }
        //intBtnを押すことでINTの値が入力される
        binding.intBtn.setOnClickListener {
            val int = (2..12).random() + 6
            binding.intsu.text = int.toString()
        }
        //eduBtnを押すことでEDUの値が入力される
        binding.eduBtn.setOnClickListener {
            val edu = (3..18).random() + 3
            binding.edusu.text = edu.toString()
        }
        //powBtnを押すことでPOWの値が入力される
        binding.powBtn.setOnClickListener {
            val pow = (3..18).random()
            binding.powsu.text = pow.toString()
        }
        //conBtnを押すことでCONの値が入力される
        binding.conBtn.setOnClickListener {
            val con = (3..18).random()
            binding.consu.text = con.toString()
        }
        //allBtnを押すことでSTR,SIZ,APP,DEX,INT,EDU,POW,CONの全て値が一度に入力される
        binding.allBtn.setOnClickListener {
            val str = (3..18).random()  //STR
            binding.strsu.text = str.toString()
            val siz = (2..12).random() + 6  //SIZ
            binding.sizsu.text = siz.toString()
            val app = (3..18).random()  //APP
            binding.appsu.text = app.toString()
            val dex = (3..18).random()  //DEX
            binding.dexsu.text = dex.toString()
            val int = (2..12).random() + 6  //INT
            binding.intsu.text = int.toString()
            val edu = (3..18).random() + 3  //EDU
            binding.edusu.text = edu.toString()
            val pow = (3..18).random()  //POW
            binding.powsu.text = pow.toString()
            val con = (3..18).random()  //CON
            binding.consu.text = con.toString()
        }
        //exBtnを押すことでSubActivityにそれぞれの値が受け渡され、画面遷移する
        binding.exBtn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("VALUE1", binding.strsu.text.toString())  //STR
            intent.putExtra("VALUE2", binding.sizsu.text.toString())  //SIZ
            intent.putExtra("VALUE3", binding.appsu.text.toString())  //APP
            intent.putExtra("VALUE4", binding.dexsu.text.toString())  //DEX
            intent.putExtra("VALUE5", binding.intsu.text.toString())  //INT
            intent.putExtra("VALUE6", binding.edusu.text.toString())  //EDU
            intent.putExtra("VALUE7", binding.powsu.text.toString())  //POW
            intent.putExtra("VALUE8", binding.consu.text.toString())  //CON
            startActivity(intent)
        }
    }
}