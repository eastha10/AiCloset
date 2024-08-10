package com.example.aicloset

import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<com.example.myapp.Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder 클래스 정의
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageButton: ImageButton = itemView.findViewById(R.id.product_image_button)
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productPrice: TextView = itemView.findViewById(R.id.product_price)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    // ViewHolder에 데이터 바인딩
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
        holder.productPrice.text = product.price
        holder.productImageButton.setImageResource(product.imageResId)

        // 이미지 버튼 클릭 시 상세 정보 페이지로 이동
        holder.productImageButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT_NAME", product.name)
            intent.putExtra("PRODUCT_PRICE", product.price)
            intent.putExtra("PRODUCT_IMAGE", product.imageResId)
            context.startActivity(intent)
        }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return productList.size
    }
}