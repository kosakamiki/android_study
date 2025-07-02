package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.d("WebViewActivity", " WebViewActivity onCreate★")
        setContentView(R.layout.web_view_screen)

        val webViewButton: Button = findViewById(R.id.webViewBtn)
        webViewButton.setOnClickListener {
            // 多言語で挨拶画面に遷移
            val intent = Intent(this, MainActivity::class.java)  //intentインスタンスの生成(第二引数は遷移先のktファイル名)
            startActivity(intent)
        }

        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://x.com")

    }
}