package com.example.myfirstgraphqlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myfirstgraphqlapp.presentation.CountriesAction
import com.example.myfirstgraphqlapp.presentation.CountriesScreen
import com.example.myfirstgraphqlapp.presentation.CountriesViewModel
import com.example.myfirstgraphqlapp.ui.theme.MyFirstGraphQlAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstGraphQlAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val viewModel : CountriesViewModel = hiltViewModel()
                    val countriesState = viewModel.state.collectAsState()
                    CountriesScreen(
                        state = countriesState.value,
                        onSelectCountry = { code ->
                            viewModel.onAction(CountriesAction.SelectCountry(code))
                        },
                        onDismissDialog = {
                            viewModel.onAction(CountriesAction.DismissCountryDialog)
                        }
                    )
                }
            }
        }
    }
}