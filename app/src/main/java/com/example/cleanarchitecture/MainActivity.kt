package com.example.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cleanarchitecture.presentation.MainScreen
import com.example.cleanarchitecture.ui.theme.CleanArchitectureTheme

/**
 * Clean Architecture + MVVM 구현
 *
 *    <기능 요구 조건>
 *
 *    - Product 리스트를 로드하여 화면에 출력
 *
 *    - 새로운 Product를 추가할 수 있어야 함
 *
 *    - 마지막 Product를 삭제할 수 있어야 함
 *
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
