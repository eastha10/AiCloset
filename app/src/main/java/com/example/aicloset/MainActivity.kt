package com.example.aicloset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aicloset.ui.theme.AiClosetTheme
import com.example.myapp.Product

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        setContent {
            AiClosetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        // RecyclerView 인스턴스 가져오기
        val recyclerView: RecyclerView = findViewById(R.id.product_list)

        // LayoutManager 설정 (여기서는 LinearLayoutManager 사용)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Adapter에 들어갈 데이터 리스트 생성
        val productList = listOf(
            Product("Product 1", "$10.00", R.drawable.ic_product_placeholder),
            Product("Product 2", "$15.00", R.drawable.ic_product_placeholder),
            Product("Product 3", "$20.00", R.drawable.ic_product_placeholder)
        )

        // 어댑터 설정
        val adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AiClosetTheme {
        Greeting("Android")
    }
}
