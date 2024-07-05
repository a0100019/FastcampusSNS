package com.example.practice

import android.app.Application
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.FastcampusSNSTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    val TAG = MainActivity::class.java.simpleName
//    Log.e(TAG, "태그 이렇게 하면 태그가 mainactivity가 됨")

    @Inject
    lateinit var foo:Foo

    @Inject
    lateinit var  bar: Bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assert(this::foo.isInitialized)
        assert(this::bar.isInitialized)

        //assert는 조건이 참인지 확인하는 코드로 거짓이면 assertionError 발생
//        assert(foo.bar!=null)

        setContent {
            FastcampusSNSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("hello")
                }
            }
        }
    }

    @Inject
    fun injectFoo(foo:Foo) {

        Log.e(TAG, "injectFoo : ${foo.toString()}")
        this.foo = foo
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
    FastcampusSNSTheme {
        Greeting("Android")
    }
}