package com.example.bloodbank

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.RoundedCorner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodbank.ui.theme.BloodBankTheme
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import kotlin.math.sign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            scaf()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaf(){
    Scaffold(


    content={
        pd->body(pd)
    })

    }








@Composable
fun body(pd: PaddingValues){
    val context= LocalContext.current
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier= Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(Color(255, 0, 0), Color(255, 255, 255)),
                // Adjust the value based on your layout height
            )
        )){
        Image(painterResource(id = R.drawable.bd
        ), contentDescription = "Blood drop Image",
            modifier=Modifier.size(height=300.dp,width=700.dp))
        Button(onClick = {


            val intent = Intent(context,SignIn_Screen::class.java)
            context.startActivity(intent)

        },colors=ButtonDefaults.buttonColors(Color.White),
            shape= RoundedCornerShape(5.dp), modifier = Modifier.size(width=300.dp,height=50.dp)
        ) {
            Text(text = "Sign In",color=Color.Red, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
        }
        Spacer(modifier=Modifier.height(30.dp))
        Button(onClick = {
                         val intent=Intent(context,CreateAccount::class.java)
            context.startActivity(intent)
        }, colors=ButtonDefaults.buttonColors(Color.Red),
            shape= RoundedCornerShape(5.dp), modifier = Modifier
                .size(width = 300.dp, height = 50.dp)
                .border(1.dp, color = Color.White)){
            Text("Create Account", color=Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
        }
        Row(modifier=Modifier.fillMaxWidth().padding(top=210.dp), horizontalArrangement = Arrangement.SpaceEvenly){
            TextButton(onClick = { Toast.makeText(context,"You can contact us to learn more",Toast.LENGTH_LONG).show() }) {
                Text("Learn More",color=Color.Red)
            }
            TextButton(onClick = {
                Toast.makeText(context,"You cannot skip this process",Toast.LENGTH_LONG).show()
            }) {
                Text("Skip Now", color=Color.Red)
            }
        }


        
    }



}

