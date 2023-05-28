package com.example.bloodbank

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodbank.ui.theme.BloodBankTheme

class DashBoard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            dashboard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun dashboard(){

    var dp=DatePickerDialog(LocalContext.current,null,2023,5,28)
    var dte = remember{
        mutableStateOf(String())
    }

    var context= LocalContext.current

    var wronginfo = remember {
        mutableStateOf(false)
    }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(255, 0, 0), Color(255, 255, 255)),
                    // Adjust the value based on your layout height
                )
            )) {
        Card(


            modifier= Modifier
                .width(300.dp)
                .height(500.dp),
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
            border= CardDefaults.outlinedCardBorder(true)) {


            Column(modifier=Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {


//                TextField(
//                    value = uname.value, onValueChange = { uname.value = it },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.White,
//                        textColor = Color.Black, focusedIndicatorColor = Color.Transparent,
//                        cursorColor = Color.Red, unfocusedIndicatorColor = Color.Transparent,
//                    ),
//                    label = { Text("User Name", color = Color.LightGray) },
//                }
                Text(text = "Hello Akash" +"\n"+"Welcome on board", fontSize=32.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight= FontWeight.Bold, color=Color.Red, textAlign=TextAlign.Center
                )





                TextButton(

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    onClick = {
                        dp.show()
                    }

                ){
                    Text("Click here to Select Date\n of " +
                            "appointment", color=Color.LightGray, fontSize = 20.sp, textAlign = TextAlign.Center)
                }

                Button(
                    onClick = {


                              wronginfo.value=true


                    }, colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(5.dp), modifier = Modifier
                        .size(width = 200.dp, height = 65.dp)
                        .border(1.dp, color = Color.White)
                ) {
                    Text("Schedule Donation", color = Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center)
                }
            }


        }

        if(wronginfo.value) {
            Spacer(modifier=Modifier.height(10.dp))
            Text(
                "Your Donation has been scheduled ",
                color = Color.Red,
                fontSize = 12.sp, textAlign = TextAlign.Center
            )

            Toast.makeText(context,"Blood Donation Scheduled Successfully",Toast.LENGTH_LONG).show()
        }

    }
}
