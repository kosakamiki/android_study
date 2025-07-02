package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.d("WebViewActivity", " WebViewActivity onCreate★")
        setContentView(R.layout.web_view_screen)

        val webViewButton: Button = findViewById(R.id.webViewBtn)
        // タッチする前のViewの位置を常に持っておきたいため、TouchListener外でインスタンス化
        var oldPositionX = 0
        var oldPositionY = 0
        webViewButton.setOnTouchListener { view, event ->

            val newPositionX = event.rawX.toInt()
            val newPositionY = event.rawY.toInt()

            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    // 移動後のViewの4辺の位置を取得
                    val viewLeftPosition: Int = view.left + (newPositionX - oldPositionX)
                    val viewRightPoint: Int = viewLeftPosition + view.width
                    val viewTopPosition: Int = view.top + (newPositionY - oldPositionY)
                    val viewUnderPoint: Int = viewTopPosition + view.height

                    // 画像の位置を設定する
                    view.layout(viewLeftPosition, viewTopPosition, viewRightPoint, viewUnderPoint)
                }

                else -> {}
            }

            // タッチした位置を古い位置とする
            oldPositionX = newPositionX
            oldPositionY = newPositionY

            return@setOnTouchListener true
        }

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