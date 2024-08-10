package com.example.aicloset

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productPrice = intent.getStringExtra("PRODUCT_PRICE")
        val productImageResId = intent.getIntExtra("PRODUCT_IMAGE", 0)

        val productNameTextView: TextView = findViewById(R.id.product_detail_name)
        val productPriceTextView: TextView = findViewById(R.id.product_detail_price)
        val productImageView: ImageView = findViewById(R.id.product_detail_image)

        productNameTextView.text = productName
        productPriceTextView.text = productPrice
        productImageView.setImageResource(productImageResId)
    }
}
