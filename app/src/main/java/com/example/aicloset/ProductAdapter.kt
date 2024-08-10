package com.example.myapp.com.example.aicloset

import com.example.aicloset.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<com.example.myapp.Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder 클래스 정의
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.product_image)
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
        // 이미지를 설정할 때는 Glide 또는 Picasso 같은 라이브러리 사용
        // holder.productImage.setImageResource(product.imageResId)
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return productList.size
    }
}