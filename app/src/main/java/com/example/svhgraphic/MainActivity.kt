package com.example.svhgraphic

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var myWebView: WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.myWebView)

        val etURL: EditText = findViewById(R.id.etUrl)
        val btnGo: ImageButton = findViewById(R.id.btnGo)
        val backBtn: ImageButton = findViewById(R.id.backbtn)
        val forwardBtn: ImageButton = findViewById(R.id.forwardBtn)

        myWebView.webViewClient= WebViewClient()




        forwardBtn.setOnClickListener {
            myWebView.goForward()

        }


        backBtn.setOnClickListener {
            if(myWebView.canGoBack())
            {
                myWebView.goBack()
            }
            else
            {
                super.onBackPressed()
            }

        }


        btnGo.setOnClickListener {
            val siteUrl: String = etURL.text.toString()

            if(URLUtil.isValidUrl(siteUrl))
            {
                myWebView.loadUrl(siteUrl)
            }
            else
            {
                myWebView.loadUrl("https://www.google.com/search?q=$siteUrl")
            }
        }

        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.safeBrowsingEnabled=true

    }


}