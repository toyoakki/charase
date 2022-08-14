package com.example.toyo.charase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toyo.charase.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //MainActivityから受け取った値をそれぞれのtextviewに入れる
        val value1 = intent.getStringExtra("VALUE1")  //STR
        binding.strsu2.text ="${value1}"
        val value2 = intent.getStringExtra("VALUE2")  //SIZ
        binding.sizsu2.text ="${value2}"
        val value3 = intent.getStringExtra("VALUE3")  //APP
        binding.appsu2.text ="${value3}"
        val value4 = intent.getStringExtra("VALUE4")  //DEX
        binding.dexsu2.text ="${value4}"
        val value5 = intent.getStringExtra("VALUE5")  //INT
        binding.intsu2.text ="${value5}"
        val value6 = intent.getStringExtra("VALUE6")  //EDU
        binding.edusu2.text ="${value6}"
        val value7 = intent.getStringExtra("VALUE7")  //POW
        binding.powsu2.text ="${value7}"
        binding.mpsu2.text="${value7}"  //マジックポイント(MP)はPOWの値と同じためそのまま格納
        val value8 = intent.getStringExtra("VALUE8")  //CON
        binding.consu2.text ="${value8}"
        //MainActivityから受け取った値を必要な分だけ数値に変換
        val str2 = value1?.toInt()
        val siz2 = value2?.toInt()
        var int2 = value5?.toInt()
        var edu2 = value6?.toInt()
        val pow2 = value7?.toInt()
        val con2 = value8?.toInt()
        //SAN,現在SAN値,幸運,不定の値を計算しそれぞれ格納
        if (pow2 != null) {
            var pow3 =pow2*5   //３つとも共通
            binding.sansu2.text=pow3.toString()
            binding.sanosu.text=pow3.toString()
            binding.lucsu2.text=pow3.toString()
            pow3-=pow2    //POW×4の代用
            binding.futeisu.text=pow3.toString()
        }
        //アイデアの値を計算し格納
        if (int2 != null) {
            int2 *= 5
            binding.idesu2.text=int2.toString()
        }
        //知識の値を計算し格納
        if (edu2 != null) {
            edu2 *= 5
            binding.legsu2.text=edu2.toString()
        }
        //ダメージボーナス(DB)の値を計算し当てはまるものを格納
        if (str2 != null || siz2 != null ) {
            val db = str2!! +siz2!!     //DB＝STRの値＋SIZの値で計算される
            if (db <= 12) binding.dbchi.text = getString(R.string.db_su1)
            else if (db <= 16) binding.dbchi.text = getString(R.string.db_su2)
            else if (db <= 24) binding.dbchi.text = getString(R.string.db_su3)
            else if (db <= 32) binding.dbchi.text = getString(R.string.db_su4)
            else if (db <= 40) binding.dbchi.text = getString(R.string.db_su5)
            else binding.dbchi.text = getString(R.string.db_su6)
        }
        //体力(HP)の値を計算し格納
        if (siz2 != null || con2 != null ) {
            val hp =(siz2!! + con2!! +1)/2
            binding.hpsu2.text=hp.toString()
        }
        //現在SAN値が増加した時の処理
        binding.sanupBtn.setOnClickListener{
            var san =binding.sanosu.text.toString().toInt()
            val up=binding.henchisu.text.toString().toInt()
            san = san+up
            binding.sanosu.text=san.toString()
        }
        //現在SAN値が減少した時の処理
        binding.sandnBtn.setOnClickListener{
            var san =binding.sanosu.text.toString().toInt()
            val dn=binding.henchisu.text.toString().toInt()
            san = san-dn
            binding.sanosu.text=san.toString()
        }
        //画面を戻す
        binding.bakBtn.setOnClickListener{
            finish()
        }
    }
}