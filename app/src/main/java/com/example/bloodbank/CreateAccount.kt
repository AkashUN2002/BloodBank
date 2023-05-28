package com.example.bloodbank

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodbank.ui.theme.BloodBankTheme

class CreateAccount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createacc()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createacc(){

    var name = remember {
        mutableStateOf(String())
    }

    var uname = remember {
        mutableStateOf(String())
    }

    var bg = remember {
        mutableStateOf(String())
    }

    var age = remember {
        mutableStateOf(String())
    }

    var pass = remember{
        mutableStateOf(String())
    }

    var context= LocalContext.current

    var wronginfo = remember {
        mutableStateOf(false)
    }

    var wronginf = remember {
        mutableStateOf(String())
    }


    var intent=Intent()
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


                TextField(
                    value = name.value, onValueChange = { name.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        textColor = Color.Black, focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Red, unfocusedIndicatorColor = Color.Transparent,
                    ),
                    label = { Text("Enter Your Name", color = Color.LightGray) },
                )

                TextField(
                    value = age.value, onValueChange = { age.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        textColor = Color.Black, focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Red, unfocusedIndicatorColor = Color.Transparent,
                    ),
                    label = { Text("Enter your Age", color = Color.LightGray) },
                )


                TextField(
                    value = bg.value, onValueChange = { bg.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        textColor = Color.Black, focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Red, unfocusedIndicatorColor = Color.Transparent,
                    ),
                    label = { Text("Enter your Blood Group", color = Color.LightGray) },
                )

                Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        onClick = {

                                  wronginf.value="+"
                            bg.value+=wronginf.value


                        }, colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(5.dp), modifier = Modifier
                            .size(width = 100.dp, height = 60.dp)
                            .border(1.dp, color = Color.White)
                    ) {
                        Text("+", color = Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                    }



                    Button(
                        onClick = {

                                  wronginf.value="-"
                            bg.value+=wronginf.value

                        }, colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(5.dp), modifier = Modifier
                            .size(width = 100.dp, height = 60.dp)
                            .border(1.dp, color = Color.White)
                    ) {
                        Text("-", color = Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                    }

                }





                TextField(
                    value = pass.value,
                    onValueChange = { pass.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        textColor = Color.Black, focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Red, unfocusedIndicatorColor = Color.Transparent,
                    ),
                    label = { Text("Enter the Password", color = Color.LightGray) },
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    onClick = {


                        Toast.makeText(context,"Your Account has been created successfully",Toast.LENGTH_LONG).show()
                              intent=Intent(context,SignIn_Screen::class.java)
                        context.startActivity(intent)



                    }, colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(5.dp), modifier = Modifier
                        .size(width = 150.dp, height = 70.dp)
                        .border(1.dp, color = Color.White)
                ) {
                    Text("Create Account", color = Color.White, fontSize = 20.sp, fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center)
                }
            }


        }

    }
}

