package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)// setContentView()は画面に表示するビューを設定する
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.morningBtn.setOnClickListener {
            binding.geneetingText.text = getString(R.string.good_morning_text)
        }
        binding.afternoonBtn.setOnClickListener {
            binding.geneetingText.text = getString(R.string.good_afternoon_text)
        }
        binding.eveningBtn.setOnClickListener {
            binding.geneetingText.text = getString(R.string.good_evening_text)
        }
        binding.webViewBtn.setOnClickListener {
            // WebView表示ページへ遷移
            val intent =
                Intent(this, WebViewActivity::class.java)    //intentインスタンスの生成(第二引数は遷移先のktファイル名)
            startActivity(intent)
            android.util.Log.d("MainActivity", " WebViewActivity start★")
        }
    }
}